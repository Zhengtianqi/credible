package cn.edu.bjut.service.impl;

import cn.edu.bjut.entity.NormalResponse;
import cn.edu.bjut.feign.RemoteClient;
import cn.edu.bjut.service.ClientNodeService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author ztq
 */
@Service
public class ClientNodeServiceImpl implements ClientNodeService {
    private Logger logger = LoggerFactory.getLogger(ClientNodeService.class.getName());
    @Autowired
    private RemoteClient remoteClient;

    @Override
    public NormalResponse testRpcGetRequest() {
        ResponseEntity<String> entity = remoteClient.testRpcGetRequest();
        JSONObject jsonObject = JSONObject.parseObject(entity.getBody());
        NormalResponse normalResponse = JSONObject.toJavaObject(jsonObject, NormalResponse.class);
        System.out.println(normalResponse.getMessage());
        logger.info("Client节点调用成功，正在Rpc-Get方式调用Server");
        return normalResponse;
    }

    @Override
    public NormalResponse testRpcPostRequest() {
        ResponseEntity<String> entity = remoteClient.testRpcPostRequest();
        JSONObject jsonObject = JSONObject.parseObject(entity.getBody());
        NormalResponse normalResponse = JSONObject.toJavaObject(jsonObject, NormalResponse.class);
        System.out.println(normalResponse.getMessage());
        logger.info("Client节点调用成功，正在Rpc-Post方式调用Server");
        return normalResponse;
    }
}
