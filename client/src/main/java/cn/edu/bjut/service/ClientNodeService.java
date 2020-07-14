package cn.edu.bjut.service;

import cn.edu.bjut.entity.NormalResponse;

/**
 * @author ztq
 */
public interface ClientNodeService {
    NormalResponse testRpcGetRequest();

    NormalResponse testRpcPostRequest();
}
