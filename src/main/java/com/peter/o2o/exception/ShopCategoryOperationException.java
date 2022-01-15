package com.peter.o2o.exception;

/**
 * @author tyronchen
 * @Description: 店铺类别操作异常
 * @date 2018年11月29日
 */
public class ShopCategoryOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ShopCategoryOperationException(String msg) {
        super(msg);
    }
}
