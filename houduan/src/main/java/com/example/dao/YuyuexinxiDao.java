package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Yuyuexinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface YuyuexinxiDao extends BaseMapper<Yuyuexinxi> {

@Select("select * from yuyuexinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci
@Select("SELECT distinct(leixingmingcheng) as aa,count(id) as bb FROM yuyuexinxi group by leixingmingcheng order by id")
List<Map<String, Object>> yuyuexinxi_tj_leixingmingcheng();
//tonxgji1

}
