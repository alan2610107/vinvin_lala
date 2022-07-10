package com.kuang.handler;

public abstract class ConfirmAbstractHandler {
    /**
     * 下一關用當前抽象淚來接收
     */
    protected ConfirmAbstractHandler next;
    protected String logID;

    public void setNext(ConfirmAbstractHandler next) {
        this.next = next;
    }
    public void setLogID(String logID){
        this.logID = logID;
    }

    /**
     * @return Map(String, If_NoPass)
     */
    public abstract String handler();
}
