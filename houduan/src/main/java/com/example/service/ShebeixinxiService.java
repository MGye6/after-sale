package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Shebeixinxi;
import com.example.vo.ShebeixinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ShebeixinxiService extends IService<Shebeixinxi> {
    Shebeixinxi add(Shebeixinxi shebeixinxi);
    void delete(Long id);
    void update(Shebeixinxi shebeixinxi);
    Shebeixinxi findById(Integer id);
    ShebeixinxiVo findPage(ShebeixinxiVo shebeixinxiVo);
	
    void deleteList(List<Shebeixinxi> list);
	
	List<Shebeixinxi> getByym(String yhm);
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
