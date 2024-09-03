package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("beijianxinxi")
@Data
public class Beijianxinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "wangdianbianhao")	private String wangdianbianhao;	@TableField(value = "wangdianmingcheng")	private String wangdianmingcheng;	@TableField(value = "beijianmingcheng")	private String beijianmingcheng;	@TableField(value = "beijiankucun")	private String beijiankucun;	@TableField(value = "beijianjine")	private String beijianjine;	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getWangdianbianhao() {
        return wangdianbianhao;
    }
    public void setWangdianbianhao(String wangdianbianhao) {
		this.wangdianbianhao = wangdianbianhao;
    }	public String getWangdianmingcheng() {
        return wangdianmingcheng;
    }
    public void setWangdianmingcheng(String wangdianmingcheng) {
		this.wangdianmingcheng = wangdianmingcheng;
    }	public String getBeijianmingcheng() {
        return beijianmingcheng;
    }
    public void setBeijianmingcheng(String beijianmingcheng) {
		this.beijianmingcheng = beijianmingcheng;
    }	public String getBeijiankucun() {
        return beijiankucun;
    }
    public void setBeijiankucun(String beijiankucun) {
		this.beijiankucun = beijiankucun;
    }	public String getBeijianjine() {
        return beijianjine;
    }
    public void setBeijianjine(String beijianjine) {
		this.beijianjine = beijianjine;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}