package com.dis.tmpdb.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ErrorResponse {
    @NotNull
    private int code;
    @NotNull
    private String message;
    private Object content;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(int code, String message, Object content) {
        this(code, message);
        this.content = content;
    }
}
