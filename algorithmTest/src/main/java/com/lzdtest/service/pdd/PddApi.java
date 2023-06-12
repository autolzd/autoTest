package com.lzdtest.service.pdd;

import com.lzdtest.service.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PddApi {
    private static final String CLIENT_ID = "your_client_id";
    private static final String CLIENT_SECRET = "your_client_secret";
    private static final String ACCESS_TOKEN = "your_access_token";
    private static final String API_URL = "https://gw-api.pinduoduo.com/api/router";


    public static void main(String[] args) {
        // 构造请求参数
        Map<String, String> params = new HashMap<>();
        params.put("type", "pdd.ddk.goods.detail");
        params.put("goods_id_list", "123456,789012");
        params.put("access_token", ACCESS_TOKEN);
        params.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("client_id", CLIENT_ID);
        params.put("data_type", "JSON");

        // 计算签名
        String sign = signTopRequest(params, CLIENT_SECRET);
        params.put("sign", sign);

        // 发送请求
        String response = HttpUtils.post(API_URL, params);
        System.out.println(response);
    }

    /**
     * 计算签名
     */
    private static String signTopRequest(Map<String, String> params, String secret) {
        String sign = "";
        try {
            // 将参数按照字典序升序排序
            StringBuilder sortedParams = new StringBuilder();
            params.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> sortedParams.append(entry.getKey()).append(entry.getValue()));
            // 将appSecret拼接在排序后的参数后面
            String signString = secret + sortedParams.toString() + secret;
            // 计算MD5哈希值，并进行Base64编码
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = messageDigest.digest(signString.getBytes());
            sign = Base64.getEncoder().encodeToString(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sign;
    }
}
