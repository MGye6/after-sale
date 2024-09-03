package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Beijianxinxi;
import com.example.vo.BeijianxinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface BeijianxinxiService extends IService<Beijianxinxi> {
    Beijianxinxi add(Beijianxinxi beijianxinxi);
    void delete(Long id);
    void update(Beijianxinxi beijianxinxi);
    Beijianxinxi findById(Integer id);
    BeijianxinxiVo findPage(BeijianxinxiVo beijianxinxiVo);
	
    void deleteList(List<Beijianxinxi> list);

    String getjine(String mc,String wmc);
	List<Beijianxinxi> beijianlist(String wdmc);
	List<Beijianxinxi> beijianlistmc(String wdmc);
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
