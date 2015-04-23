package org.codetrip.common.enumerate;

/**
 * Created by RuFeng on 2015/4/21.
 */
public enum ContestStatus {
    RUNNING(0), DONE(1), NOT_START(-1);

    private Integer value;
    private ContestStatus(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
