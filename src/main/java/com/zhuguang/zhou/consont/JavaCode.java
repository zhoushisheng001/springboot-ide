package com.zhuguang.zhou.consont;

public enum JavaCode {
    SUCCLE("7681", "成功");

    private String Code;

    private String msg;

    JavaCode(String code, String msg) {
        Code = code;
        this.msg = msg;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
