package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Yuyuexinxi;
import com.example.vo.YuyuexinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface YuyuexinxiService extends IService<Yuyuexinxi> {
    Yuyuexinxi add(Yuyuexinxi yuyuexinxi);
    void delete(Long id);
    void update(Yuyuexinxi yuyuexinxi);
    Yuyuexinxi findById(Integer id);
    YuyuexinxiVo findPage(YuyuexinxiVo yuyuexinxiVo);
	
    void deleteList(List<Yuyuexinxi> list);

    List<Map<String,Object>> yuyuexinxi_tj_leixingmingcheng();
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
