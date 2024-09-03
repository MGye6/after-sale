package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Shebeixinxi;
import com.example.exception.CustomException;
import com.example.service.ShebeixinxiService;
import com.example.vo.ShebeixinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("shebeixinxiService")
public class ShebeixinxiServiceImpl extends ServiceImpl<ShebeixinxiDao, Shebeixinxi> implements ShebeixinxiService {

    @Resource
    private ShebeixinxiDao shebeixinxiDao;

    public Shebeixinxi add(Shebeixinxi shebeixinxi) {
		
	   //youquchong1
        shebeixinxi.setAddtime(new Date());
        shebeixinxiDao.insert(shebeixinxi);
        return shebeixinxi;
    }
	
	
	
    public void delete(Long id) {
        shebeixinxiDao.deleteById(id);
    }
	

    public void update(Shebeixinxi shebeixinxi) {
        //youquchong2
        shebeixinxiDao.updateById(shebeixinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return shebeixinxiDao.daochuexcel();
    }

    @Override
    public Shebeixinxi findById(Integer id) {
        return shebeixinxiDao.selectById(id);
    }

    public ShebeixinxiVo findPage(ShebeixinxiVo shebeixinxiVo) {
        LambdaQueryWrapper<Shebeixinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(shebeixinxiVo.getShebeimingcheng()), Shebeixinxi::getShebeimingcheng,shebeixinxiVo.getShebeimingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(shebeixinxiVo.getShebeitupian()), Shebeixinxi::getShebeitupian,shebeixinxiVo.getShebeitupian());
        wrapper.like(ObjectUtils.isNotEmpty(shebeixinxiVo.getYonghuming()), Shebeixinxi::getYonghuming,shebeixinxiVo.getYonghuming());
        wrapper.like(ObjectUtils.isNotEmpty(shebeixinxiVo.getFangweima()), Shebeixinxi::getFangweima,shebeixinxiVo.getFangweima());
        wrapper.like(ObjectUtils.isNotEmpty(shebeixinxiVo.getShebeicanshu()), Shebeixinxi::getShebeicanshu,shebeixinxiVo.getShebeicanshu());
        
        Page<Shebeixinxi> page = new Page<>(shebeixinxiVo.getCurrent(),shebeixinxiVo.getCurrentNum());
        shebeixinxiDao.selectPage(page,wrapper);
        List<Shebeixinxi> shebeixinxis = page.getRecords();
        shebeixinxiVo.setList(shebeixinxis);
        shebeixinxiVo.setPages(page.getPages());
        shebeixinxiVo.setTotal(page.getTotal());
        shebeixinxiVo.setCurrent(page.getCurrent());
        shebeixinxiVo.setCurrentNum(page.getSize());
        return shebeixinxiVo;
    }

    @Override
    public void deleteList(List<Shebeixinxi> list) {
        List<Integer> ids =  list.stream().map(Shebeixinxi::getId).collect(Collectors.toList());
        shebeixinxiDao.deleteBatchIds(ids);
    }

    @Override
    public List<Shebeixinxi> getByym(String yhm) {
        return shebeixinxiDao.getByym(yhm);
    }


    //youxxianxci
}
