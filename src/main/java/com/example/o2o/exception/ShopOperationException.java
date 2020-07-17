package com.example.o2o.exception;

import com.example.o2o.enums.ResultEnum;

public class ShopOperationException extends RuntimeException{
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    private Integer code;

    /**
     * 传枚举
     * @param resultEnum
     */
    public ShopOperationException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    /**
     * 传自定义错误,不通过枚举
     * @param msg
     * @param code
     */
    public ShopOperationException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }
}
