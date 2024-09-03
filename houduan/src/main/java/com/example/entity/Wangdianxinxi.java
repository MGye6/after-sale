package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("wangdianxinxi")
@Data
public class Wangdianxinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "wangdianbianhao")	private String wangdianbianhao;	@TableField(value = "wangdianmingcheng")	private String wangdianmingcheng;	@TableField(value = "wangdianweizhi")	private String wangdianweizhi;	@TableField(value = "wangdianlianxifangshi")	private String wangdianlianxifangshi;	@TableField(value = "dianmiantupian")	private String dianmiantupian;	@TableField(value = "leixingmingcheng")	private String leixingmingcheng;	
    
	
	
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
    }	public String getWangdianweizhi() {
        return wangdianweizhi;
    }
    public void setWangdianweizhi(String wangdianweizhi) {
		this.wangdianweizhi = wangdianweizhi;
    }	public String getWangdianlianxifangshi() {
        return wangdianlianxifangshi;
    }
    public void setWangdianlianxifangshi(String wangdianlianxifangshi) {
		this.wangdianlianxifangshi = wangdianlianxifangshi;
    }	public String getDianmiantupian() {
        return dianmiantupian;
    }
    public void setDianmiantupian(String dianmiantupian) {
		this.dianmiantupian = dianmiantupian;
    }	public String getLeixingmingcheng() {
        return leixingmingcheng;
    }
    public void setLeixingmingcheng(String leixingmingcheng) {
		this.leixingmingcheng = leixingmingcheng;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}