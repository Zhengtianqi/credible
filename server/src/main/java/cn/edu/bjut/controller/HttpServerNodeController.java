package cn.edu.bjut.controller;

import cn.edu.bjut.entity.NormalResponse;
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
    @GetMapping(value = "/httpGetRequest")
    public NormalResponse httpGetRequest() {
        return NormalResponse.create().message("测试HTTP GET调用").state(200);
    }

    @PostMapping(value = "/httpPostRequest")
    public NormalResponse httpPostRequest() {
        return NormalResponse.create().message("测试HTTP POST调用").state(200);
    }
}
