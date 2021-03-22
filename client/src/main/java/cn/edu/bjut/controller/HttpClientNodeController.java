package cn.edu.bjut.controller;

import cn.edu.bjut.entity.HttpClientResult;
import cn.edu.bjut.entity.NormalResponse;
import cn.edu.bjut.service.ClientNodeService;
import cn.edu.bjut.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ztq
 */
@RestController
@RequestMapping(value = "/http")
public class HttpClientNodeController {
    private Logger logger = LoggerFactory.getLogger(HttpClientNodeController.class.getName());

    @GetMapping(value = "/testHttpGetRequest")
    public void testHttpGetRequest() {
        try {
            HttpClientResult httpGetResult = HttpClientUtils.doGet("http://127.0.0.1:8080/http/httpGetRequest");
            logger.info("Client请求Server节点，Http-GET方式成功");
            System.out.println(httpGetResult.toString());
        } catch (Exception e) {
            System.out.println("Client请求Server节点，Http-GET方式失败：" + e.getMessage());
            logger.error("Client请求Server节点，Http-GET方式失败：" + e.getMessage());
        }

        try {
            HttpClientResult httpPostResult = HttpClientUtils.doPost("http://127.0.0.1:8080/http/httpPostRequest");
            System.out.println(httpPostResult.toString());
        } catch (Exception e) {
            System.out.println("Client请求Server节点，POST失败：" + e.getMessage());
            logger.error("Client请求Server节点，Http-POST方式失败：" + e.getMessage());
        }
        logger.info("Client并行请求Server节点成功");
    }

    @GetMapping(value = "/testHttpPostRequest")
    public void testHttpPostRequest() {
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
