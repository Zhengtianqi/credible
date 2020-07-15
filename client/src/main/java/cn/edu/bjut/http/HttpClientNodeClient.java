package cn.edu.bjut.http;

import cn.edu.bjut.entity.HttpClientResult;
import cn.edu.bjut.utils.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ztq
 */
public class HttpClientNodeClient {
    public static void main(String[] args) {

        try {
            HttpClientResult httpGetResult = HttpClientUtils.doGet("http://127.0.0.1:8080/http/httpGetRequest");
            System.out.println(httpGetResult.toString());
        } catch (Exception e) {
            System.out.println("请求服务节点，GET方式失败：" + e.getMessage());
        }

        try {
            HttpClientResult httpPostResult = HttpClientUtils.doPost("http://127.0.0.1:8080/http/httpPostRequest");
            System.out.println(httpPostResult.toString());
        } catch (Exception e) {
            System.out.println("请求服务节点，POST失败：" + e.getMessage());
        }

        try {
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Cookie", "NLSDHFJHSALDBULSDMADSLINF");
            headers.put("Connection", "keep-alive");
            headers.put("Accept", "application/json");
            headers.put("Accept-Language", "zh-CN,zh;q=0.9");
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            HttpClientResult httpPostResult = HttpClientUtils.doPost("http://127.0.0.1:8080/http/httpPostRequest", headers, null);
            System.out.println(httpPostResult.toString());
        } catch (Exception e) {
            System.out.println("请求服务节点，POST失败：" + e.getMessage());
        }
    }
}
