package com.zhuguang.zhou.consont;

public class AppliCationExceport extends RuntimeException {

    private JavaCode javaCode;

    public AppliCationExceport(JavaCode javaCode) {
        this.javaCode = javaCode;
    }

    public AppliCationExceport() {
        super();
    }

    public AppliCationExceport(String message) {
        super(message);
    }

    public AppliCationExceport(String message, Throwable cause) {
        super(message, cause);
    }
}
