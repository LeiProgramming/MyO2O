package com.peter.o2o.exception;

/**
 * @author tyronchen
 * @Description: 店铺操作异常
 * @date 2018年4月15日
 */
public class ShopOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ShopOperationException(String msg) {
        super(msg);
    }
}
