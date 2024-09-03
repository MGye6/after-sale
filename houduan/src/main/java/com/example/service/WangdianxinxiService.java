package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Wangdianxinxi;
import com.example.vo.WangdianxinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface WangdianxinxiService extends IService<Wangdianxinxi> {
    Wangdianxinxi add(Wangdianxinxi wangdianxinxi);
    void delete(Long id);
    void update(Wangdianxinxi wangdianxinxi);
    Wangdianxinxi findById(Integer id);
    WangdianxinxiVo findPage(WangdianxinxiVo wangdianxinxiVo);
	
    void deleteList(List<Wangdianxinxi> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
