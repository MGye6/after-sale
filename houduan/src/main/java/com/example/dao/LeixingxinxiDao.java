package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Leixingxinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LeixingxinxiDao extends BaseMapper<Leixingxinxi> {

@Select("select * from leixingxinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
