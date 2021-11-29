package com.pro.domain;

public class Test {
    private int order;
    private String status;
    private String youAns;
    private String teacherAns;
    private Double avgScore;
    private int finishNum;
    private Double truePercent;
    private int wrongNum;
    private int ansA;
    private int ansB;
    private int ansC;
    private int ansD;
    private int ansNull;
    private int ansRight;

    public int getAnsNull() {
        return ansNull;
    }

    public void setAnsNull(int ansNull) {
        this.ansNull = ansNull;
    }

    public int getAnsA() {
        return ansA;
    }

    public void setAnsA(int ansA) {
        this.ansA = ansA;
    }

    public int getAnsB() {
        return ansB;
    }

    public void setAnsB(int ansB) {
        this.ansB = ansB;
    }

    public int getAnsC() {
        return ansC;
    }

    public void setAnsC(int ansC) {
        this.ansC = ansC;
    }

    public int getAnsD() {
        return ansD;
    }

    public void setAnsD(int ansD) {
        this.ansD = ansD;
    }

    public int getAnsRight() {
        return ansRight;
    }

    public void setAnsRight(int ansRight) {
        this.ansRight = ansRight;
    }

    public Double getTruePercent() {
        return truePercent;
    }

    public void setTruePercent(Double truePercent) {
        this.truePercent = truePercent;
    }

    public int getWrongNum() {
        return wrongNum;
    }

    public void setWrongNum(int wrongNum) {
        this.wrongNum = wrongNum;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getYouAns() {
        return youAns;
    }

    public void setYouAns(String youAns) {
        this.youAns = youAns;
    }

    public String getTeacherAns() {
        return teacherAns;
    }

    public void setTeacherAns(String teacherAns) {
        this.teacherAns = teacherAns;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    public int getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(int finishNum) {
        this.finishNum = finishNum;
    }

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "order=" + order +
                ", status='" + status + '\'' +
                ", youAns='" + youAns + '\'' +
                ", teacherAns='" + teacherAns + '\'' +
                '}';
    }
}
