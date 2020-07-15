package cn.edu.bjut.http;

import cn.edu.bjut.entity.HttpClientResult;
import cn.edu.bjut.utils.HttpClientUtils;

/**
 * @author ztq
 */
public class HttpClientNodeClient {
    public static void main(String[] args) {

        try {
            HttpClientResult httpGetResult = HttpClientUtils.doGet("http://127.0.0.1:8080/http/httpGetRequest");
            System.out.println("------------------------");
            System.out.println(httpGetResult.toString());
            System.out.println("------------------------");
        } catch (Exception e) {
            System.out.println("请求服务节点，GET方式失败：" + e.getMessage());
        }

        try {
            HttpClientResult httpPostResult = HttpClientUtils.doPost("http://127.0.0.1:8080/http/httpPostRequest");
            System.out.println("------------------------");
            System.out.println(httpPostResult.toString());
            System.out.println("------------------------");
        } catch (Exception e) {
            System.out.println("请求服务节点，POST失败：" + e.getMessage());
        }


    }
}
