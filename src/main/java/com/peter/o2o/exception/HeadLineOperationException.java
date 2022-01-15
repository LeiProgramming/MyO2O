package com.peter.o2o.exception;

/**
 * @author tyronchen
 * @Description: 头条操作异常
 * @date 2019年1月24日
 */
public class HeadLineOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HeadLineOperationException(String msg) {
        super(msg);
    }

}
