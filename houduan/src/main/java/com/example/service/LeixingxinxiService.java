package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Leixingxinxi;
import com.example.vo.LeixingxinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface LeixingxinxiService extends IService<Leixingxinxi> {
    Leixingxinxi add(Leixingxinxi leixingxinxi);
    void delete(Long id);
    void update(Leixingxinxi leixingxinxi);
    Leixingxinxi findById(Integer id);
    LeixingxinxiVo findPage(LeixingxinxiVo leixingxinxiVo);
	
    void deleteList(List<Leixingxinxi> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
