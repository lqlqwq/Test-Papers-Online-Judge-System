package com.pro.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("teachertest")
public class TeacherTest {
    @TableId(type = IdType.AUTO)            //优化写法见StuTest
    private Long test_id;
    private Long user_id;
    private String test_name;
    private String createtime;
    private String endtime;
    private int status;    //记录当前考试状态  1为正在进行
    private int ans_num;
    private String original_ans;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String ans5;
    private String ans6;
    private String ans7;
    private String ans8;
    private String ans9;
    private String ans10;
    private String ans11;
    private String ans12;
    private String ans13;
    private String ans14;
    private String ans15;
    private String ans16;
    private String ans17;
    private String ans18;
    private String ans19;
    private String ans20;
    private String ans21;
    private String ans22;
    private String ans23;
    private String ans24;
    private String ans25;
    private String ans26;
    private String ans27;
    private String ans28;
    private String ans29;
    private String ans30;
    private String ans31;
    private String ans32;
    private String ans33;
    private String ans34;
    private String ans35;
    private String ans36;
    private String ans37;
    private String ans38;
    private String ans39;
    private String ans40;
    public TeacherTest() {
    }

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getCreatetime() {
        return createtime;
    }

    public String getOriginal_ans() {
        return original_ans;
    }

    public void setOriginal_ans(String original_ans) {
        this.original_ans = original_ans;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public void setAns5(String ans5) {
        this.ans5 = ans5;
    }

    public void setAns6(String ans6) {
        this.ans6 = ans6;
    }

    public void setAns7(String ans7) {
        this.ans7 = ans7;
    }

    public void setAns8(String ans8) {
        this.ans8 = ans8;
    }

    public void setAns9(String ans9) {
        this.ans9 = ans9;
    }

    public void setAns10(String ans10) {
        this.ans10 = ans10;
    }

    public void setAns11(String ans11) {
        this.ans11 = ans11;
    }

    public void setAns12(String ans12) {
        this.ans12 = ans12;
    }

    public void setAns13(String ans13) {
        this.ans13 = ans13;
    }

    public void setAns14(String ans14) {
        this.ans14 = ans14;
    }

    public void setAns15(String ans15) {
        this.ans15 = ans15;
    }

    public void setAns16(String ans16) {
        this.ans16 = ans16;
    }

    public void setAns17(String ans17) {
        this.ans17 = ans17;
    }

    public void setAns18(String ans18) {
        this.ans18 = ans18;
    }

    public void setAns19(String ans19) {
        this.ans19 = ans19;
    }

    public void setAns20(String ans20) {
        this.ans20 = ans20;
    }

    public void setAns21(String ans21) {
        this.ans21 = ans21;
    }

    public void setAns22(String ans22) {
        this.ans22 = ans22;
    }

    public void setAns23(String ans23) {
        this.ans23 = ans23;
    }

    public void setAns24(String ans24) {
        this.ans24 = ans24;
    }

    public void setAns25(String ans25) {
        this.ans25 = ans25;
    }

    public void setAns26(String ans26) {
        this.ans26 = ans26;
    }

    public void setAns27(String ans27) {
        this.ans27 = ans27;
    }

    public void setAns28(String ans28) {
        this.ans28 = ans28;
    }

    public void setAns29(String ans29) {
        this.ans29 = ans29;
    }

    public void setAns30(String ans30) {
        this.ans30 = ans30;
    }

    public void setAns31(String ans31) {
        this.ans31 = ans31;
    }

    public void setAns32(String ans32) {
        this.ans32 = ans32;
    }

    public void setAns33(String ans33) {
        this.ans33 = ans33;
    }

    public void setAns34(String ans34) {
        this.ans34 = ans34;
    }

    public void setAns35(String ans35) {
        this.ans35 = ans35;
    }

    public void setAns36(String ans36) {
        this.ans36 = ans36;
    }

    public void setAns37(String ans37) {
        this.ans37 = ans37;
    }

    public void setAns38(String ans38) {
        this.ans38 = ans38;
    }

    public void setAns39(String ans39) {
        this.ans39 = ans39;
    }

    public void setAns40(String ans40) {
        this.ans40 = ans40;
    }

    public String getAns1() {
        return ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public String getAns5() {
        return ans5;
    }

    public String getAns6() {
        return ans6;
    }

    public String getAns7() {
        return ans7;
    }

    public String getAns8() {
        return ans8;
    }

    public String getAns9() {
        return ans9;
    }

    public String getAns10() {
        return ans10;
    }

    public String getAns11() {
        return ans11;
    }

    public String getAns12() {
        return ans12;
    }

    public String getAns13() {
        return ans13;
    }

    public String getAns14() {
        return ans14;
    }

    public String getAns15() {
        return ans15;
    }

    public String getAns16() {
        return ans16;
    }

    public String getAns17() {
        return ans17;
    }

    public String getAns18() {
        return ans18;
    }

    public String getAns19() {
        return ans19;
    }

    public String getAns20() {
        return ans20;
    }

    public String getAns21() {
        return ans21;
    }

    public String getAns22() {
        return ans22;
    }

    public String getAns23() {
        return ans23;
    }

    public String getAns24() {
        return ans24;
    }

    public String getAns25() {
        return ans25;
    }

    public String getAns26() {
        return ans26;
    }

    public String getAns27() {
        return ans27;
    }

    public String getAns28() {
        return ans28;
    }

    public String getAns29() {
        return ans29;
    }

    public String getAns30() {
        return ans30;
    }

    public String getAns31() {
        return ans31;
    }

    public String getAns32() {
        return ans32;
    }

    public String getAns33() {
        return ans33;
    }

    public String getAns34() {
        return ans34;
    }

    public String getAns35() {
        return ans35;
    }

    public String getAns36() {
        return ans36;
    }

    public String getAns37() {
        return ans37;
    }

    public String getAns38() {
        return ans38;
    }

    public String getAns39() {
        return ans39;
    }

    public String getAns40() {
        return ans40;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAns_num() {
        return ans_num;
    }

    public void setAns_num(int ans_num) {
        this.ans_num = ans_num;
    }

    @Override
    public String toString() {
        return "TeacherTest{" +
                "test_id=" + test_id +
                ", user_id=" + user_id +
                ", test_name='" + test_name + '\'' +
                ", createtime='" + createtime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", status=" + status +
                ", ans_num=" + ans_num +
                ", original_ans='" + original_ans + '\'' +
                ", ans1='" + ans1 + '\'' +
                ", ans2='" + ans2 + '\'' +
                ", ans3='" + ans3 + '\'' +
                ", ans4='" + ans4 + '\'' +
                ", ans5='" + ans5 + '\'' +
                ", ans6='" + ans6 + '\'' +
                ", ans7='" + ans7 + '\'' +
                ", ans8='" + ans8 + '\'' +
                ", ans9='" + ans9 + '\'' +
                ", ans10='" + ans10 + '\'' +
                ", ans11='" + ans11 + '\'' +
                ", ans12='" + ans12 + '\'' +
                ", ans13='" + ans13 + '\'' +
                ", ans14='" + ans14 + '\'' +
                ", ans15='" + ans15 + '\'' +
                ", ans16='" + ans16 + '\'' +
                ", ans17='" + ans17 + '\'' +
                ", ans18='" + ans18 + '\'' +
                ", ans19='" + ans19 + '\'' +
                ", ans20='" + ans20 + '\'' +
                ", ans21='" + ans21 + '\'' +
                ", ans22='" + ans22 + '\'' +
                ", ans23='" + ans23 + '\'' +
                ", ans24='" + ans24 + '\'' +
                ", ans25='" + ans25 + '\'' +
                ", ans26='" + ans26 + '\'' +
                ", ans27='" + ans27 + '\'' +
                ", ans28='" + ans28 + '\'' +
                ", ans29='" + ans29 + '\'' +
                ", ans30='" + ans30 + '\'' +
                ", ans31='" + ans31 + '\'' +
                ", ans32='" + ans32 + '\'' +
                ", ans33='" + ans33 + '\'' +
                ", ans34='" + ans34 + '\'' +
                ", ans35='" + ans35 + '\'' +
                ", ans36='" + ans36 + '\'' +
                ", ans37='" + ans37 + '\'' +
                ", ans38='" + ans38 + '\'' +
                ", ans39='" + ans39 + '\'' +
                ", ans40='" + ans40 + '\'' +
                '}';
    }
}
