package cn.edu.bjut.service.impl;

import cn.edu.bjut.entity.NormalResponse;
import cn.edu.bjut.feign.RemoteClient;
import cn.edu.bjut.service.ClientNodeService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author ztq
 */
@Service
public class ClientNodeServiceImpl implements ClientNodeService {
    @Autowired
    private RemoteClient remoteClient;

    @Override
    public NormalResponse testRpcGetRequest() {
        ResponseEntity<String> entity = remoteClient.testRpcGetRequest();
        JSONObject jsonObject = JSONObject.parseObject(entity.getBody());
        NormalResponse normalResponse = JSONObject.toJavaObject(jsonObject, NormalResponse.class);
        System.out.println(normalResponse.getMessage());
        return normalResponse;
    }

    @Override
    public NormalResponse testRpcPostRequest() {
        ResponseEntity<String> entity = remoteClient.testRpcPostRequest();
        JSONObject jsonObject = JSONObject.parseObject(entity.getBody());
        NormalResponse normalResponse = JSONObject.toJavaObject(jsonObject, NormalResponse.class);
        System.out.println(normalResponse.getMessage());
        return normalResponse;
    }
}
