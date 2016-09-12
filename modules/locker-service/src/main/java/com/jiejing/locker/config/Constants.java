package com.jiejing.locker.config;

/**
 * Created by Bogle on 2016/9/8.
 */
public interface Constants {

    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SYSTEM_ACCOUNT = "system";

    enum ObjectType {
        GZ("柜子"), XZ("箱子");
        private String value;

        ObjectType(String value) {
            this.value = value;
        }
    }

    enum Result {
        Y("成功"), N("失败");
        private String value;

        Result(String value) {
            this.value = value;
        }
    }

    enum Status {
        ENABLE("启用"), DISENABLE("禁用"), ERROR("异常");
        private String value;

        Status(String value) {
            this.value = value;
        }
    }

    enum ChargeType {
        TIME_HOUR("时间节点"), TIME_CYCLE("时间段收费");
        private String value;

        ChargeType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum GateLockState {
        OPEN("打开"), CLOSE("禁用"), ERROR("异常");
        private String value;

        GateLockState(String value) {
            this.value = value;
        }
    }

    enum DepositState {
        Y("有存物"), N("无存物"), ERROR("异常"), ZY("占用");;
        private String value;

        DepositState(String value) {
            this.value = value;
        }
    }

    enum BoxState {
        DQ("待取"), YQ("已取"), ZY("占用"),WY("未用");
        private String value;

        BoxState(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum OrderState {
        DZF("待支付"), YZF("已支付"), YQX("已取消"), YWC("已完成"), YGB("已关闭");
        private String value;

        OrderState(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum CreateType {
        CREATE_ORDER("租箱下单"), RETREAT_ORDER("取箱补单");
        private String value;

        CreateType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
