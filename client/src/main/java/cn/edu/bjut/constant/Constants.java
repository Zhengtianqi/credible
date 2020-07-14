package cn.edu.bjut.constant;

/**
 * @author ztq
 */
public enum Constants {
    // 提示
    SUCCESS(0, "成功"),
    ERROR(1, "失败");

    public final static String REMOTE_SERVER = "credibleServer";
    public final static int STATUS = 100500;

    private int code;
    private String message;

    Constants(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        for (Constants s : Constants.values()) {
            if (s.code == code) {
                return s.message;
            }
        }
        return null;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
