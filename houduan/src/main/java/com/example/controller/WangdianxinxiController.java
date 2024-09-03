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
import com.example.entity.Wangdianxinxi;
import com.example.exception.CustomException;
import com.example.service.WangdianxinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.WangdianxinxiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/wangdianxinxi")
public class WangdianxinxiController {

    @Resource
    private WangdianxinxiService wangdianxinxiService;

    @PostMapping
    public Result<Wangdianxinxi> add(@RequestBody WangdianxinxiVo wangdianxinxi) {
		//yoxuxiaxnci
        wangdianxinxiService.add(wangdianxinxi);
        return Result.success(wangdianxinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("wangdianbianhao","网点编号");        row.put("wangdianmingcheng","网点名称");        row.put("wangdianweizhi","网点位置");        row.put("wangdianlianxifangshi","网点联系方式");        row.put("leixingmingcheng","类型名称");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = wangdianxinxiService.daochuexcel();
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
    public Result<Wangdianxinxi> deleteList(@RequestBody WangdianxinxiVo wangdianxinxi) {
        wangdianxinxiService.deleteList(wangdianxinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        wangdianxinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody WangdianxinxiVo wangdianxinxi) {
        wangdianxinxiService.update(wangdianxinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Wangdianxinxi> detail(@PathVariable Integer id) {
        Wangdianxinxi wangdianxinxi = wangdianxinxiService.findById(id);
        return Result.success(wangdianxinxi);
    }

    @GetMapping
    public Result<List<Wangdianxinxi>> all() {
        return Result.success(wangdianxinxiService.list());
    }

    @PostMapping("/page")
    public Result<WangdianxinxiVo> page(@RequestBody WangdianxinxiVo wangdianxinxiVo) {
        return Result.success(wangdianxinxiService.findPage(wangdianxinxiVo));
    }
	//youupdt2login
}
