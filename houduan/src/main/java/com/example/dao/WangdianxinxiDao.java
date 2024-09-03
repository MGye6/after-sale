package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Wangdianxinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface WangdianxinxiDao extends BaseMapper<Wangdianxinxi> {

@Select("select * from wangdianxinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
