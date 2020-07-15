package cn.edu.bjut.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ztq
 */
public class NormalResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private int status;
    private String message;
    private Map<String, Object> body = new HashMap<>();

    private NormalResponse() {
    }

    public static NormalResponse create() {
        return new NormalResponse();
    }

    public NormalResponse message(String message) {
        this.message = message;
        return this;
    }

    public NormalResponse state(int state) {
        this.setStatus(state);
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public NormalResponse put(String key, Object value) {
        this.body.put(key, value);
        return this;
    }

    public NormalResponse remove(String key) {
        this.body.remove(key);
        return this;
    }
}