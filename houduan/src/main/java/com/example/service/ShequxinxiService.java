package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Shequxinxi;
import com.example.vo.ShequxinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ShequxinxiService extends IService<Shequxinxi> {
    Shequxinxi add(Shequxinxi shequxinxi);
    Long getshequ(String yhm,String wmc,String lxmc,String bjmc);
    void delete(Long id);
    void update(Shequxinxi shequxinxi);
    Shequxinxi findById(Integer id);
    ShequxinxiVo findPage(ShequxinxiVo shequxinxiVo);
	
    void deleteList(List<Shequxinxi> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
