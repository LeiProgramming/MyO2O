package com.peter.o2o.dto;

import com.peter.o2o.entity.LocalAuth;
import com.peter.o2o.enums.LocalAuthStateEnum;
import com.peter.o2o.enums.OperationStatusEnum;

import java.util.List;

/**
 * @author peterchen
 * @Description: 本地账号返回信息
 * @date 2019年5月20日
 */
public class LocalAuthExecution {
    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    private int count;

    private LocalAuth localAuth;

    private List<LocalAuth> localAuthList;

    public LocalAuthExecution() {
    }

    // 失败的构造器
    public LocalAuthExecution(LocalAuthStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 成功的构造器
    public LocalAuthExecution(OperationStatusEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 成功的构造器
    public LocalAuthExecution(OperationStatusEnum stateEnum, LocalAuth localAuth) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.localAuth = localAuth;
    }

    // 成功的构造器
    public LocalAuthExecution(OperationStatusEnum stateEnum, List<LocalAuth> localAuthList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.localAuthList = localAuthList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalAuth getLocalAuth() {
        return localAuth;
    }

    public void setLocalAuth(LocalAuth localAuth) {
        this.localAuth = localAuth;
    }

    public List<LocalAuth> getLocalAuthList() {
        return localAuthList;
    }

    public void setLocalAuthList(List<LocalAuth> localAuthList) {
        this.localAuthList = localAuthList;
    }

}
