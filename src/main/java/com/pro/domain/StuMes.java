package com.pro.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("comment")
public class StuMes {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long user_id;
    private Long test_id;
    private int mes_num;
    private String mes;
    private String mes_time;
    private int user_type;
    private String user_nickname;

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
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

    public int getMes_num() {
        return mes_num;
    }

    public void setMes_num(int mes_num) {
        this.mes_num = mes_num;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMes_time() {
        return mes_time;
    }

    public void setMes_time(String mes_time) {
        this.mes_time = mes_time;
    }

    public StuMes() {
    }

    @Override
    public String toString() {
        return "StuMes{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", test_id=" + test_id +
                ", mes_num=" + mes_num +
                ", mes='" + mes + '\'' +
                ", mes_time=" + mes_time +
                '}';
    }
}
