package com.pro.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("stutest")
public class StuTest {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long user_id;
    private Long test_id;
    private String createtime;
    private String endtime;
    private int ans_num;
    private String original_ans;
    private Double score;
    private String test_name;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getOriginal_ans() {
        return original_ans;
    }

    public void setOriginal_ans(String original_ans) {
        this.original_ans = original_ans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getAns_num() {
        return ans_num;
    }

    public void setAns_num(int ans_num) {
        this.ans_num = ans_num;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public StuTest() {
    }

    @Override
    public String toString() {
        return "StuTest{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", test_id=" + test_id +
                ", createtime='" + createtime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", ans_num=" + ans_num +
                ", original_ans='" + original_ans + '\'' +
                ", score=" + score +
                ", test_name='" + test_name + '\'' +
                '}';
    }
}
