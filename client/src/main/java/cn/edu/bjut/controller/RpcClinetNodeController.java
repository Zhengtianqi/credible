package cn.edu.bjut.controller;

import cn.edu.bjut.entity.NormalResponse;
import cn.edu.bjut.service.ClientNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ztq
 */
@RestController
@RequestMapping(value = "/rpc")
public class RpcClinetNodeController {
    @Autowired
    private ClientNodeService clientNodeService;

    @GetMapping(value = "/testRpcGetRequest")
    public NormalResponse testRpcGetRequest() {
        NormalResponse normalResponse = clientNodeService.testRpcGetRequest();
        return normalResponse;
    }

    @GetMapping(value = "/testRpcPostRequest")
    public NormalResponse testRpcPostRequest() {
        NormalResponse normalResponse = clientNodeService.testRpcPostRequest();
        return normalResponse;
    }

}
