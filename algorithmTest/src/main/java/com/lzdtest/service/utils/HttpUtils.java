package com.lzdtest.service.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtils {

    /**
     * 发送HTTP POST请求
     *
     * @param url    请求的URL地址
     * @param params 请求的参数
     * @return 请求响应的字符串
     */
    public static String post(String url, Map<String, String> params) {
        HttpURLConnection connection = null;
        try {
            // 创建连接
            URL requestUrl = new URL(url);
            connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // 设置请求头
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

            // 构造请求参数
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            String paramStr = stringBuilder.toString();
            if (paramStr.endsWith("&")) {
                paramStr = paramStr.substring(0, paramStr.length() - 1);
            }

            // 发送请求
            connection.getOutputStream().write(paramStr.getBytes());

            // 获取响应结果
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}

