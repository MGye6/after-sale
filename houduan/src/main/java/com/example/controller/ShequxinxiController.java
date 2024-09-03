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
import com.example.entity.Shequxinxi;
import com.example.exception.CustomException;
import com.example.service.ShequxinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.ShequxinxiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/shequxinxi")
public class ShequxinxiController {

    @Resource
    private ShequxinxiService shequxinxiService;

    @PostMapping
    public Result<Shequxinxi> add(@RequestBody ShequxinxiVo shequxinxi) {
		//yoxuxiaxnci
        shequxinxiService.add(shequxinxi);
        return Result.success(shequxinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("wangdianmingcheng","网点名称");        row.put("wangdianlianxifangshi","网点联系方式");        row.put("wangdianweizhi","网点位置");        row.put("wangdianleixing","网点类型");        row.put("beijianmingcheng","备件名称");        row.put("huafeijine","花费金额");        row.put("yonghuming","用户名");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = shequxinxiService.daochuexcel();
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
    public Result<Shequxinxi> deleteList(@RequestBody ShequxinxiVo shequxinxi) {
        shequxinxiService.deleteList(shequxinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        shequxinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ShequxinxiVo shequxinxi) {
        shequxinxiService.update(shequxinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Shequxinxi> detail(@PathVariable Integer id) {
        Shequxinxi shequxinxi = shequxinxiService.findById(id);
        return Result.success(shequxinxi);
    }

    @GetMapping
    public Result<List<Shequxinxi>> all() {
        return Result.success(shequxinxiService.list());
    }

    @PostMapping("/page")
    public Result<ShequxinxiVo> page(@RequestBody ShequxinxiVo shequxinxiVo) {
        return Result.success(shequxinxiService.findPage(shequxinxiVo));
    }
	//youupdt2login
}
