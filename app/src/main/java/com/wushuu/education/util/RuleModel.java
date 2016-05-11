package com.wushuu.education.util;

/**
 * Created by wushuu on 2016/5/11.
 */
public class RuleModel {
    private int begin;
    private int end;
    private int limit;

    public RuleModel(int begin, int end, int limit){
        this.begin = begin;
        this.end = end;
        this.limit = limit;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
