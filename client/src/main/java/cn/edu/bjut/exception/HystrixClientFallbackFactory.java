package cn.edu.bjut.exception;

import cn.edu.bjut.constant.Constants;
import cn.edu.bjut.entity.NormalResponse;
import com.alibaba.fastjson.JSON;
import feign.hystrix.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author ztq
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<ResponseEntity<String>> {
    private Logger logger = Logger.getLogger("HystrixClientFallbackFactory");

    @Override
    public ResponseEntity<String> create(Throwable cause) {
        // 打印日志
        logger.severe("调用远程接口失败 =" + cause.getMessage());
        return ResponseEntity.status(Constants.STATUS).body(
                JSON.toJSONString(NormalResponse.create()
                        .state(Constants.ERROR.getCode())
                        .message(Constants.ERROR.getMessage()))
        );
    }
}