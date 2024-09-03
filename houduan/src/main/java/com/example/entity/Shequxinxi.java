package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("shequxinxi")
@Data
public class Shequxinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "wangdianmingcheng")	private String wangdianmingcheng;	@TableField(value = "wangdianlianxifangshi")	private String wangdianlianxifangshi;	@TableField(value = "wangdianweizhi")	private String wangdianweizhi;	@TableField(value = "wangdianleixing")	private String wangdianleixing;	@TableField(value = "beijianmingcheng")	private String beijianmingcheng;	@TableField(value = "huafeijine")	private String huafeijine;	@TableField(value = "yonghuming")	private String yonghuming;	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getWangdianmingcheng() {
        return wangdianmingcheng;
    }
    public void setWangdianmingcheng(String wangdianmingcheng) {
		this.wangdianmingcheng = wangdianmingcheng;
    }	public String getWangdianlianxifangshi() {
        return wangdianlianxifangshi;
    }
    public void setWangdianlianxifangshi(String wangdianlianxifangshi) {
		this.wangdianlianxifangshi = wangdianlianxifangshi;
    }	public String getWangdianweizhi() {
        return wangdianweizhi;
    }
    public void setWangdianweizhi(String wangdianweizhi) {
		this.wangdianweizhi = wangdianweizhi;
    }	public String getWangdianleixing() {
        return wangdianleixing;
    }
    public void setWangdianleixing(String wangdianleixing) {
		this.wangdianleixing = wangdianleixing;
    }	public String getBeijianmingcheng() {
        return beijianmingcheng;
    }
    public void setBeijianmingcheng(String beijianmingcheng) {
		this.beijianmingcheng = beijianmingcheng;
    }	public String getHuafeijine() {
        return huafeijine;
    }
    public void setHuafeijine(String huafeijine) {
		this.huafeijine = huafeijine;
    }	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}