package cn.edu.bjut.entity;

import java.io.Serializable;

/**
 * @author ztq
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
