package cn.edu.bjut.feign;

import cn.edu.bjut.constant.Constants;
import cn.edu.bjut.exception.HystrixClientFallbackFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author ztq
 */
@FeignClient(name = Constants.REMOTE_SERVER, fallbackFactory = HystrixClientFallbackFactory.class)
public interface RemoteClient {
    /**
     * 调用/rpc/rpcGetRequest接口
     *
     * @return 返回值
     */
    @LoadBalanced
    @GetMapping(value = "/rpc/rpcGetRequest")
    ResponseEntity<String> testRpcGetRequest();

    /**
     * 调用/rpc/rpcPostRequest接口
     *
     * @return 返回值
     */
    @LoadBalanced
    @GetMapping(value = "/rpc/rpcPostRequest")
    ResponseEntity<String> testRpcPostRequest();
}
