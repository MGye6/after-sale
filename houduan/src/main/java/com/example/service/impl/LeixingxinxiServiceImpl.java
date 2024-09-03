package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Leixingxinxi;
import com.example.exception.CustomException;
import com.example.service.LeixingxinxiService;
import com.example.vo.LeixingxinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("leixingxinxiService")
public class LeixingxinxiServiceImpl extends ServiceImpl<LeixingxinxiDao, Leixingxinxi> implements LeixingxinxiService {

    @Resource
    private LeixingxinxiDao leixingxinxiDao;

    public Leixingxinxi add(Leixingxinxi leixingxinxi) {
		
	   //youquchong1
        leixingxinxi.setAddtime(new Date());
        leixingxinxiDao.insert(leixingxinxi);
        return leixingxinxi;
    }
	
	
	
    public void delete(Long id) {
        leixingxinxiDao.deleteById(id);
    }
	

    public void update(Leixingxinxi leixingxinxi) {
        //youquchong2
        leixingxinxiDao.updateById(leixingxinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return leixingxinxiDao.daochuexcel();
    }

    @Override
    public Leixingxinxi findById(Integer id) {
        return leixingxinxiDao.selectById(id);
    }

    public LeixingxinxiVo findPage(LeixingxinxiVo leixingxinxiVo) {
        LambdaQueryWrapper<Leixingxinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(leixingxinxiVo.getLeixingmingcheng()), Leixingxinxi::getLeixingmingcheng,leixingxinxiVo.getLeixingmingcheng());        
        Page<Leixingxinxi> page = new Page<>(leixingxinxiVo.getCurrent(),leixingxinxiVo.getCurrentNum());
        leixingxinxiDao.selectPage(page,wrapper);
        List<Leixingxinxi> leixingxinxis = page.getRecords();
        leixingxinxiVo.setList(leixingxinxis);
        leixingxinxiVo.setPages(page.getPages());
        leixingxinxiVo.setTotal(page.getTotal());
        leixingxinxiVo.setCurrent(page.getCurrent());
        leixingxinxiVo.setCurrentNum(page.getSize());
        return leixingxinxiVo;
    }

    @Override
    public void deleteList(List<Leixingxinxi> list) {
        List<Integer> ids =  list.stream().map(Leixingxinxi::getId).collect(Collectors.toList());
        leixingxinxiDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
