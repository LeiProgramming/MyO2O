package com.peter.o2o.exception;

/**
 * @author tyronchen
 * @Description: 区域操作异常
 * @date 2018年12月15日
 */
public class AreaOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AreaOperationException(String msg) {
        super(msg);
    }
}
