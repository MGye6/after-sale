package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.Beijianxinxi;
import com.example.exception.CustomException;
import com.example.service.BeijianxinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.BeijianxinxiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/beijianxinxi")
public class BeijianxinxiController {

    @Resource
    private BeijianxinxiService beijianxinxiService;

    @PostMapping
    public Result<Beijianxinxi> add(@RequestBody BeijianxinxiVo beijianxinxi) {
		//yoxuxiaxnci
        beijianxinxiService.add(beijianxinxi);
        return Result.success(beijianxinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("wangdianbianhao","网点编号");        row.put("wangdianmingcheng","网点名称");        row.put("beijianmingcheng","备件名称");        row.put("beijiankucun","备件库存");        row.put("beijianjine","备件金额");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = beijianxinxiService.daochuexcel();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=chaoba.xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	
	

    @PostMapping("/deleteList")
    public Result<Beijianxinxi> deleteList(@RequestBody BeijianxinxiVo beijianxinxi) {
        beijianxinxiService.deleteList(beijianxinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        beijianxinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody BeijianxinxiVo beijianxinxi) {
        beijianxinxiService.update(beijianxinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Beijianxinxi> detail(@PathVariable Integer id) {
        Beijianxinxi beijianxinxi = beijianxinxiService.findById(id);
        return Result.success(beijianxinxi);
    }

    @GetMapping
    public Result<List<Beijianxinxi>> all() {
        return Result.success(beijianxinxiService.list());
    }

    @PostMapping("/page")
    public Result<BeijianxinxiVo> page(@RequestBody BeijianxinxiVo beijianxinxiVo) {
        return Result.success(beijianxinxiService.findPage(beijianxinxiVo));
    }
	//youupdt2login
}
