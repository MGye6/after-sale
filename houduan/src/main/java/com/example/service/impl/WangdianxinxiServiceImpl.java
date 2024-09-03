package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Wangdianxinxi;
import com.example.exception.CustomException;
import com.example.service.WangdianxinxiService;
import com.example.vo.WangdianxinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("wangdianxinxiService")
public class WangdianxinxiServiceImpl extends ServiceImpl<WangdianxinxiDao, Wangdianxinxi> implements WangdianxinxiService {

    @Resource
    private WangdianxinxiDao wangdianxinxiDao;

    public Wangdianxinxi add(Wangdianxinxi wangdianxinxi) {
		
	    LambdaQueryWrapper<Wangdianxinxi> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Wangdianxinxi::getWangdianbianhao,wangdianxinxi.getWangdianbianhao());
        Wangdianxinxi findWangdianxinxi = wangdianxinxiDao.selectOne(wrapper);
        if (findWangdianxinxi != null) {
            throw new CustomException("1001", "" + wangdianxinxi.getWangdianbianhao() + "\"已存在");
        }
        wangdianxinxi.setAddtime(new Date());
        wangdianxinxiDao.insert(wangdianxinxi);
        return wangdianxinxi;
    }
	
	
	
    public void delete(Long id) {
        wangdianxinxiDao.deleteById(id);
    }
	

    public void update(Wangdianxinxi wangdianxinxi) {
         LambdaQueryWrapper<Wangdianxinxi> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Wangdianxinxi::getWangdianbianhao,wangdianxinxi.getWangdianbianhao());
        Wangdianxinxi findWangdianxinxi = wangdianxinxiDao.selectOne(wrapper);
		if (findWangdianxinxi != null && wangdianxinxi.getId() != findWangdianxinxi.getId()) {
            throw new CustomException("1001", "" + wangdianxinxi.getWangdianbianhao() + "\"已存在");
        }
        wangdianxinxiDao.updateById(wangdianxinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return wangdianxinxiDao.daochuexcel();
    }

    @Override
    public Wangdianxinxi findById(Integer id) {
        return wangdianxinxiDao.selectById(id);
    }

    public WangdianxinxiVo findPage(WangdianxinxiVo wangdianxinxiVo) {
        LambdaQueryWrapper<Wangdianxinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(wangdianxinxiVo.getWangdianbianhao()), Wangdianxinxi::getWangdianbianhao,wangdianxinxiVo.getWangdianbianhao());        wrapper.like(ObjectUtils.isNotEmpty(wangdianxinxiVo.getWangdianmingcheng()), Wangdianxinxi::getWangdianmingcheng,wangdianxinxiVo.getWangdianmingcheng());        wrapper.like(ObjectUtils.isNotEmpty(wangdianxinxiVo.getWangdianweizhi()), Wangdianxinxi::getWangdianweizhi,wangdianxinxiVo.getWangdianweizhi());        wrapper.like(ObjectUtils.isNotEmpty(wangdianxinxiVo.getWangdianlianxifangshi()), Wangdianxinxi::getWangdianlianxifangshi,wangdianxinxiVo.getWangdianlianxifangshi());        wrapper.like(ObjectUtils.isNotEmpty(wangdianxinxiVo.getDianmiantupian()), Wangdianxinxi::getDianmiantupian,wangdianxinxiVo.getDianmiantupian());        wrapper.like(ObjectUtils.isNotEmpty(wangdianxinxiVo.getLeixingmingcheng()), Wangdianxinxi::getLeixingmingcheng,wangdianxinxiVo.getLeixingmingcheng());        
        Page<Wangdianxinxi> page = new Page<>(wangdianxinxiVo.getCurrent(),wangdianxinxiVo.getCurrentNum());
        wangdianxinxiDao.selectPage(page,wrapper);
        List<Wangdianxinxi> wangdianxinxis = page.getRecords();
        wangdianxinxiVo.setList(wangdianxinxis);
        wangdianxinxiVo.setPages(page.getPages());
        wangdianxinxiVo.setTotal(page.getTotal());
        wangdianxinxiVo.setCurrent(page.getCurrent());
        wangdianxinxiVo.setCurrentNum(page.getSize());
        return wangdianxinxiVo;
    }

    @Override
    public void deleteList(List<Wangdianxinxi> list) {
        List<Integer> ids =  list.stream().map(Wangdianxinxi::getId).collect(Collectors.toList());
        wangdianxinxiDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
