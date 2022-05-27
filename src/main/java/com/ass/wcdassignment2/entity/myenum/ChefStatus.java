package com.ass.wcdassignment2.entity.myenum;

public enum ChefStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINE(-2);

    private int value;

    ChefStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ChefStatus of(int value) {
        for (ChefStatus status :
                ChefStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return ChefStatus.UNDEFINE;
    }
}
