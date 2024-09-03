package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Shequxinxi;
import com.example.exception.CustomException;
import com.example.service.ShequxinxiService;
import com.example.vo.ShequxinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("shequxinxiService")
public class ShequxinxiServiceImpl extends ServiceImpl<ShequxinxiDao, Shequxinxi> implements ShequxinxiService {

    @Resource
    private ShequxinxiDao shequxinxiDao;

    public Shequxinxi add(Shequxinxi shequxinxi) {
		
	   //youquchong1
        shequxinxi.setAddtime(new Date());
        shequxinxiDao.insert(shequxinxi);
        return shequxinxi;
    }

    @Override
    public Long getshequ(String yhm, String wmc, String lxmc, String bjmc) {
        return shequxinxiDao.getshequ(yhm,wmc,lxmc,bjmc);
    }


    public void delete(Long id) {
        shequxinxiDao.deleteById(id);
    }
	

    public void update(Shequxinxi shequxinxi) {
        //youquchong2
        shequxinxiDao.updateById(shequxinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return shequxinxiDao.daochuexcel();
    }

    @Override
    public Shequxinxi findById(Integer id) {
        return shequxinxiDao.selectById(id);
    }

    public ShequxinxiVo findPage(ShequxinxiVo shequxinxiVo) {
        LambdaQueryWrapper<Shequxinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(shequxinxiVo.getWangdianmingcheng()), Shequxinxi::getWangdianmingcheng,shequxinxiVo.getWangdianmingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(shequxinxiVo.getWangdianlianxifangshi()), Shequxinxi::getWangdianlianxifangshi,shequxinxiVo.getWangdianlianxifangshi());
        wrapper.like(ObjectUtils.isNotEmpty(shequxinxiVo.getWangdianweizhi()), Shequxinxi::getWangdianweizhi,shequxinxiVo.getWangdianweizhi());
        wrapper.like(ObjectUtils.isNotEmpty(shequxinxiVo.getWangdianleixing()), Shequxinxi::getWangdianleixing,shequxinxiVo.getWangdianleixing());
        wrapper.like(ObjectUtils.isNotEmpty(shequxinxiVo.getBeijianmingcheng()), Shequxinxi::getBeijianmingcheng,shequxinxiVo.getBeijianmingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(shequxinxiVo.getHuafeijine()), Shequxinxi::getHuafeijine,shequxinxiVo.getHuafeijine());
        wrapper.like(ObjectUtils.isNotEmpty(shequxinxiVo.getYonghuming()), Shequxinxi::getYonghuming,shequxinxiVo.getYonghuming());
        
        Page<Shequxinxi> page = new Page<>(shequxinxiVo.getCurrent(),shequxinxiVo.getCurrentNum());
        shequxinxiDao.selectPage(page,wrapper);
        List<Shequxinxi> shequxinxis = page.getRecords();
        shequxinxiVo.setList(shequxinxis);
        shequxinxiVo.setPages(page.getPages());
        shequxinxiVo.setTotal(page.getTotal());
        shequxinxiVo.setCurrent(page.getCurrent());
        shequxinxiVo.setCurrentNum(page.getSize());
        return shequxinxiVo;
    }

    @Override
    public void deleteList(List<Shequxinxi> list) {
        List<Integer> ids =  list.stream().map(Shequxinxi::getId).collect(Collectors.toList());
        shequxinxiDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
