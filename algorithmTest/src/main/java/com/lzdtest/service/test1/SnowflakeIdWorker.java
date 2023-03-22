package com.lzdtest.service.test1;

public class SnowflakeIdWorker {
    // 定义起始的时间戳，这里使用的是当前时间戳减去一个固定值
    private static final long START_TIMESTAMP = 1609459200000L; // 2021-01-01 00:00:00

    // 定义各部分占用的位数
    private static final long SEQUENCE_BIT = 12; // 序列号占用的位数
    private static final long MACHINE_BIT = 10; // 机器 ID 占用的位数
    private static final long TIMESTAMP_BIT = 41; // 时间戳占用的位数

    // 定义各部分的最大值
    private static final long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT); // 序列号的最大值
    private static final long MAX_MACHINE = -1L ^ (-1L << MACHINE_BIT); // 机器 ID 的最大值

    // 定义各部分的偏移量
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BIT + MACHINE_BIT; // 时间戳向左移动的位数
    private static final long MACHINE_LEFT_SHIFT = SEQUENCE_BIT; // 机器 ID 向左移动的位数

    private long sequence = 0L; // 序列号
    private long lastTimestamp = -1L; // 上一次生成 ID 的时间戳
    private long machineId; // 机器 ID

    public SnowflakeIdWorker(long machineId) {
        if (machineId < 0 || machineId > MAX_MACHINE) {
            throw new IllegalArgumentException(String.format("Machine ID must be between %d and %d", 0, MAX_MACHINE));
        }
        this.machineId = machineId;
    }

    /**
     * 生成一个新的唯一 ID
     * @return ID
     */
    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate ID for %d milliseconds.", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                // 序列号已达到最大值，需要等待下一个毫秒
                timestamp = waitUntilNextMillis(lastTimestamp);
            }
        } else {
            // 时间戳改变，重置序列号
            sequence = 0L;
        }

        lastTimestamp = timestamp;
        return ((timestamp - START_TIMESTAMP) << TIMESTAMP_LEFT_SHIFT) | (machineId << MACHINE_LEFT_SHIFT) | sequence;
    }

    /**
     * 等待下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp 上一次生成 ID 的时间戳
     * @return 新的时间戳
     */
    private long waitUntilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1); // 创建一个 Snowflake ID 生成器，使用机器 ID 为 1
        // 生成 10 个唯一 ID，并输出到控制台
        for (int i = 0; i < 10; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }
    }
}

