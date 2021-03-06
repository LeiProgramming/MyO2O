package com.peter.o2o.enums;

/**
 * @Description: 店铺类别
 * @author: tyron
 * @date: 2018年11月29日
 */

public enum ShopCategoryStateEnum {

    EDIT_ERROR(-2001, "店铺编辑失败"), NULL_SHOP_CATEGORY(-2002, "shopCategory信息为空");

    private int state;
    private String stateInfo;

    /**
     * @param state
     * @param stateInfo
     * @Description:构造函数
     */
    private ShopCategoryStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    /**
     * @param index
     * @Description: 通过state获取shopCategoryStateEnum, 从而可以调用ShopCategoryStateEnum
     * #getStateInfo()获取stateInfo
     */
    public static ShopCategoryStateEnum stateOf(int index) {
        for (ShopCategoryStateEnum shopCategoryStateEnum : values()) {
            if (shopCategoryStateEnum.getState() == index) {
                return shopCategoryStateEnum;
            }
        }
        return null;
    }
}
