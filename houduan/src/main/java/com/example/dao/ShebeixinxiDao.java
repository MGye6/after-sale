package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Shebeixinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShebeixinxiDao extends BaseMapper<Shebeixinxi> {

@Select("select * from shebeixinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

    @Select("select * from shebeixinxi where yonghuming like #{yhm}")
    List<Shebeixinxi> getByym(@Param("yhm")String yhm);
//tonxgji1

}
