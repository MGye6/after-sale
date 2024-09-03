package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Yuyuexinxi;
import com.example.exception.CustomException;
import com.example.service.YuyuexinxiService;
import com.example.vo.YuyuexinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("yuyuexinxiService")
public class YuyuexinxiServiceImpl extends ServiceImpl<YuyuexinxiDao, Yuyuexinxi> implements YuyuexinxiService {

    @Resource
    private YuyuexinxiDao yuyuexinxiDao;

    public Yuyuexinxi add(Yuyuexinxi yuyuexinxi) {
		
	   //youquchong1
        yuyuexinxi.setAddtime(new Date());
        yuyuexinxiDao.insert(yuyuexinxi);
        return yuyuexinxi;
    }
	
	
	
    public void delete(Long id) {
        yuyuexinxiDao.deleteById(id);
    }
	

    public void update(Yuyuexinxi yuyuexinxi) {
        //youquchong2
        yuyuexinxiDao.updateById(yuyuexinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return yuyuexinxiDao.daochuexcel();
    }

    @Override
    public Yuyuexinxi findById(Integer id) {
        return yuyuexinxiDao.selectById(id);
    }

    public YuyuexinxiVo findPage(YuyuexinxiVo yuyuexinxiVo) {
        LambdaQueryWrapper<Yuyuexinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(yuyuexinxiVo.getWangdianmingcheng()), Yuyuexinxi::getWangdianmingcheng,yuyuexinxiVo.getWangdianmingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuexinxiVo.getWangdianlianxifangshi()), Yuyuexinxi::getWangdianlianxifangshi,yuyuexinxiVo.getWangdianlianxifangshi());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuexinxiVo.getWangdianweizhi()), Yuyuexinxi::getWangdianweizhi,yuyuexinxiVo.getWangdianweizhi());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuexinxiVo.getLeixingmingcheng()), Yuyuexinxi::getLeixingmingcheng,yuyuexinxiVo.getLeixingmingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuexinxiVo.getYuyueriqi()), Yuyuexinxi::getYuyueriqi,yuyuexinxiVo.getYuyueriqi());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuexinxiVo.getBeijianmingcheng()), Yuyuexinxi::getBeijianmingcheng,yuyuexinxiVo.getBeijianmingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuexinxiVo.getYujihuafei()), Yuyuexinxi::getYujihuafei,yuyuexinxiVo.getYujihuafei());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuexinxiVo.getYonghuming()), Yuyuexinxi::getYonghuming,yuyuexinxiVo.getYonghuming());
        wrapper.eq(ObjectUtils.isNotEmpty(yuyuexinxiVo.getIssh()), Yuyuexinxi::getIssh,yuyuexinxiVo.getIssh());
        
        Page<Yuyuexinxi> page = new Page<>(yuyuexinxiVo.getCurrent(),yuyuexinxiVo.getCurrentNum());
        yuyuexinxiDao.selectPage(page,wrapper);
        List<Yuyuexinxi> yuyuexinxis = page.getRecords();
        yuyuexinxiVo.setList(yuyuexinxis);
        yuyuexinxiVo.setPages(page.getPages());
        yuyuexinxiVo.setTotal(page.getTotal());
        yuyuexinxiVo.setCurrent(page.getCurrent());
        yuyuexinxiVo.setCurrentNum(page.getSize());
        return yuyuexinxiVo;
    }

    @Override
    public void deleteList(List<Yuyuexinxi> list) {
        List<Integer> ids =  list.stream().map(Yuyuexinxi::getId).collect(Collectors.toList());
        yuyuexinxiDao.deleteBatchIds(ids);
    }

    @Override
    public List<Map<String,Object>> yuyuexinxi_tj_leixingmingcheng() {
        List<Map<String,Object>> returnMap = yuyuexinxiDao.yuyuexinxi_tj_leixingmingcheng();
        return returnMap;
    }
	
	
	
	//youxxianxci
}
