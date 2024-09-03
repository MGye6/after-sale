package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("yuyuexinxi")
@Data
public class Yuyuexinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "wangdianmingcheng")
	private String wangdianmingcheng;
	@TableField(value = "wangdianlianxifangshi")
	private String wangdianlianxifangshi;
	@TableField(value = "wangdianweizhi")
	private String wangdianweizhi;
	@TableField(value = "leixingmingcheng")
	private String leixingmingcheng;
	@TableField(value = "yuyueriqi")
	private String yuyueriqi;
	@TableField(value = "beijianmingcheng")
	private String beijianmingcheng;
	@TableField(value = "yujihuafei")
	private String yujihuafei;
	@TableField(value = "yonghuming")
	private String yonghuming;
	@TableField(value = "shebeimingcheng")
	private String shebeimingcheng;
	@TableField(value = "fangweima")
	private String fangweima;
	@TableField(value = "issh")
	private Boolean issh;
	@TableField(value = "iszf")
	private String iszf;
	
    
	
	
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
    }
	public String getWangdianlianxifangshi() {
        return wangdianlianxifangshi;
    }
    public void setWangdianlianxifangshi(String wangdianlianxifangshi) {
		this.wangdianlianxifangshi = wangdianlianxifangshi;
    }
	public String getWangdianweizhi() {
        return wangdianweizhi;
    }
    public void setWangdianweizhi(String wangdianweizhi) {
		this.wangdianweizhi = wangdianweizhi;
    }
	public String getLeixingmingcheng() {
        return leixingmingcheng;
    }
    public void setLeixingmingcheng(String leixingmingcheng) {
		this.leixingmingcheng = leixingmingcheng;
    }
	public String getYuyueriqi() {
        return yuyueriqi;
    }
    public void setYuyueriqi(String yuyueriqi) {
		this.yuyueriqi = yuyueriqi;
    }
	public String getBeijianmingcheng() {
        return beijianmingcheng;
    }
    public void setBeijianmingcheng(String beijianmingcheng) {
		this.beijianmingcheng = beijianmingcheng;
    }
	public String getYujihuafei() {
        return yujihuafei;
    }
    public void setYujihuafei(String yujihuafei) {
		this.yujihuafei = yujihuafei;
    }
	public String getYonghuming() {
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