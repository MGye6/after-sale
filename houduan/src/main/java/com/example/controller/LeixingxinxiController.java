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
import com.example.entity.Leixingxinxi;
import com.example.exception.CustomException;
import com.example.service.LeixingxinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.LeixingxinxiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/leixingxinxi")
public class LeixingxinxiController {

    @Resource
    private LeixingxinxiService leixingxinxiService;

    @PostMapping
    public Result<Leixingxinxi> add(@RequestBody LeixingxinxiVo leixingxinxi) {
		//yoxuxiaxnci
        leixingxinxiService.add(leixingxinxi);
        return Result.success(leixingxinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("leixingmingcheng","类型名称");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = leixingxinxiService.daochuexcel();
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
    public Result<Leixingxinxi> deleteList(@RequestBody LeixingxinxiVo leixingxinxi) {
        leixingxinxiService.deleteList(leixingxinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        leixingxinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody LeixingxinxiVo leixingxinxi) {
        leixingxinxiService.update(leixingxinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Leixingxinxi> detail(@PathVariable Integer id) {
        Leixingxinxi leixingxinxi = leixingxinxiService.findById(id);
        return Result.success(leixingxinxi);
    }

    @GetMapping
    public Result<List<Leixingxinxi>> all() {
        return Result.success(leixingxinxiService.list());
    }

    @PostMapping("/page")
    public Result<LeixingxinxiVo> page(@RequestBody LeixingxinxiVo leixingxinxiVo) {
        return Result.success(leixingxinxiService.findPage(leixingxinxiVo));
    }
	//youupdt2login
}
