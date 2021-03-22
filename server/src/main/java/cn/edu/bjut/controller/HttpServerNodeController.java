package cn.edu.bjut.controller;

import cn.edu.bjut.entity.NormalResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ztq
 */
@RestController
@RequestMapping(value = "/http")
public class HttpServerNodeController {
    private Logger logger = LoggerFactory.getLogger(HttpServerNodeController.class.getName());

    @GetMapping(value = "/httpGetRequest")
    public NormalResponse httpGetRequest() {
        logger.info("Server节点接收到请求");
        return NormalResponse.create().message("测试HTTP GET调用").state(200);
    }

    @PostMapping(value = "/httpPostRequest")
    public NormalResponse httpPostRequest() {
        logger.info("Server节点接收到请求");
        return NormalResponse.create().message("测试HTTP POST调用").state(200);
    }
}
