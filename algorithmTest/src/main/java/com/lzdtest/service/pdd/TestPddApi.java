//package com.lzdtest.service.pdd;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class TestPddApi {
//
//    public static void main(String[] args) {
//        // 设置拼多多 API 的 appkey 和 appsecret
//        String appKey = "your_app_key";
//        String appSecret = "your_app_secret";
//
//        // 创建 PddApi 实例
//        PddApi api = new PddApi(appKey, appSecret);
//
//        // 构造 API 请求参数
//        Map<String, Object> params = new HashMap<>();
//        params.put("type", "pdd.goods.detail.get");
//        params.put("goods_id_list", "[123456]");
//
//        // 调用 API 接口
//        String response = api.post(params);
//
//        // 打印返回结果
//        System.out.println(response);
//    }
//
//}
//
