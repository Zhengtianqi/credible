package cn.edu.bjut.metric.support;

import java.io.Serializable;

/**
 * APP方法相关参数类
 *
 * @author zhengtianqi
 * @date 2019/9/2
 */
public class MethodTag implements Serializable {

    private static final long serialVersionUID = -6722657763029805248L;

    private final String className;

    private final String methodName;

    private final String methodParamDesc;

    private final String description;


    private MethodTag(String className, String methodName, String methodParamDesc) {
        this.className = className;
        this.methodName = methodName;
        this.methodParamDesc = methodParamDesc;
        this.description = className + "." + methodName + methodParamDesc;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getMethodParamDesc() {
        return methodParamDesc;
    }

    public String getSimpleDesc() {
        return description;
    }


    @Override
    public String toString() {
        return "MethodTag{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodParamDesc='" + methodParamDesc + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static MethodTag getInstance(String className, String methodName, String methodParamDesc) {
        return new MethodTag(className, methodName, methodParamDesc);
    }
}
