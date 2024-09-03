package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Beijianxinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BeijianxinxiDao extends BaseMapper<Beijianxinxi> {

@Select("select * from beijianxinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

    @Select("select * from beijianxinxi where wangdianbianhao like #{wdbh}")
    List<Beijianxinxi> beijianlist(@Param("wdbh") String wdbh);
    @Select("select * from beijianxinxi where wangdianmingcheng like #{wdmc}")
    List<Beijianxinxi> beijianlistmc(@Param("wdmc") String wdmc);
//tonxgji1

    @Select("select sum(beijianjine) from beijianxinxi where wangdianmingcheng like #{wmc} and beijianmingcheng in (${mc})")
    String getjine(@Param("mc")String mc,@Param("wmc")String wmc);
}
