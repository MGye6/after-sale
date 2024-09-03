package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Shequxinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShequxinxiDao extends BaseMapper<Shequxinxi> {

@Select("select * from shequxinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

    @Select("select count(1) from shequxinxi where yonghuming like #{yhm} and wangdianmingcheng like #{wmc} and wangdianleixing like #{lxmc} and beijianmingcheng like #{bjmc}")
    Long getshequ(@Param("yhm") String yhm,@Param("wmc") String wmc,@Param("lxmc") String lxmc,@Param("bjmc") String bjmc);
}
