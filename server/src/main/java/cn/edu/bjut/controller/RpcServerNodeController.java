package cn.edu.bjut.controller;

import cn.edu.bjut.entity.NormalResponse;
import org.springframework.web.bind.annotation.*;

/**
 * @author ztq
 */
@RestController
@RequestMapping(value = "/rpc")
public class RpcServerNodeController {

    @GetMapping(value = "/rpcGetRequest")
    public NormalResponse rpcGetRequest() {
        return NormalResponse.create().message("请求服务节点，RPC GET调用").state(200);
    }

    @PostMapping(value = "/rpcPostRequest")
    public NormalResponse rpcPostRequest() {
        return NormalResponse.create().message("请求服务节点，RPC POST调用").state(200);
    }
}
