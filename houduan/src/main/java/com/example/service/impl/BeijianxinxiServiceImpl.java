package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Beijianxinxi;
import com.example.exception.CustomException;
import com.example.service.BeijianxinxiService;
import com.example.vo.BeijianxinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("beijianxinxiService")
public class BeijianxinxiServiceImpl extends ServiceImpl<BeijianxinxiDao, Beijianxinxi> implements BeijianxinxiService {

    @Resource
    private BeijianxinxiDao beijianxinxiDao;

    public Beijianxinxi add(Beijianxinxi beijianxinxi) {
		
	   //youquchong1
        beijianxinxi.setAddtime(new Date());
        beijianxinxiDao.insert(beijianxinxi);
        return beijianxinxi;
    }
	
	
	
    public void delete(Long id) {
        beijianxinxiDao.deleteById(id);
    }
	

    public void update(Beijianxinxi beijianxinxi) {
        //youquchong2
        beijianxinxiDao.updateById(beijianxinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return beijianxinxiDao.daochuexcel();
    }

    @Override
    public Beijianxinxi findById(Integer id) {
        return beijianxinxiDao.selectById(id);
    }

    public BeijianxinxiVo findPage(BeijianxinxiVo beijianxinxiVo) {
        LambdaQueryWrapper<Beijianxinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(beijianxinxiVo.getWangdianbianhao()), Beijianxinxi::getWangdianbianhao,beijianxinxiVo.getWangdianbianhao());
        wrapper.like(ObjectUtils.isNotEmpty(beijianxinxiVo.getWangdianmingcheng()), Beijianxinxi::getWangdianmingcheng,beijianxinxiVo.getWangdianmingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(beijianxinxiVo.getBeijianmingcheng()), Beijianxinxi::getBeijianmingcheng,beijianxinxiVo.getBeijianmingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(beijianxinxiVo.getBeijiankucun()), Beijianxinxi::getBeijiankucun,beijianxinxiVo.getBeijiankucun());
        wrapper.like(ObjectUtils.isNotEmpty(beijianxinxiVo.getBeijianjine()), Beijianxinxi::getBeijianjine,beijianxinxiVo.getBeijianjine());
        
        Page<Beijianxinxi> page = new Page<>(beijianxinxiVo.getCurrent(),beijianxinxiVo.getCurrentNum());
        beijianxinxiDao.selectPage(page,wrapper);
        List<Beijianxinxi> beijianxinxis = page.getRecords();
        beijianxinxiVo.setList(beijianxinxis);
        beijianxinxiVo.setPages(page.getPages());
        beijianxinxiVo.setTotal(page.getTotal());
        beijianxinxiVo.setCurrent(page.getCurrent());
        beijianxinxiVo.setCurrentNum(page.getSize());
        return beijianxinxiVo;
    }

    @Override
    public void deleteList(List<Beijianxinxi> list) {
        List<Integer> ids =  list.stream().map(Beijianxinxi::getId).collect(Collectors.toList());
        beijianxinxiDao.deleteBatchIds(ids);
    }

    @Override
    public String getjine(String mc,String wmc) {
        return beijianxinxiDao.getjine(mc,wmc);
    }

    @Override
    public List<Beijianxinxi> beijianlist(String wdmc) {
        return beijianxinxiDao.beijianlist(wdmc);
    }

    @Override
    public List<Beijianxinxi> beijianlistmc(String wdmc) {
        return beijianxinxiDao.beijianlistmc(wdmc);
    }


    //youxxianxci
}
