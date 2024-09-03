package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("shebeixinxi")
@Data
public class Shebeixinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "shebeimingcheng")	private String shebeimingcheng;	@TableField(value = "shebeitupian")	private String shebeitupian;	@TableField(value = "yonghuming")	private String yonghuming;	@TableField(value = "fangweima")	private String fangweima;	@TableField(value = "shebeicanshu")	private String shebeicanshu;	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getShebeimingcheng() {
        return shebeimingcheng;
    }
    public void setShebeimingcheng(String shebeimingcheng) {
		this.shebeimingcheng = shebeimingcheng;
    }	public String getShebeitupian() {
        return shebeitupian;
    }
    public void setShebeitupian(String shebeitupian) {
		this.shebeitupian = shebeitupian;
    }	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }	public String getFangweima() {
        return fangweima;
    }
    public void setFangweima(String fangweima) {
		this.fangweima = fangweima;
    }	public String getShebeicanshu() {
        return shebeicanshu;
    }
    public void setShebeicanshu(String shebeicanshu) {
		this.shebeicanshu = shebeicanshu;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}