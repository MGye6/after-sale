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
import com.example.entity.Shebeixinxi;
import com.example.exception.CustomException;
import com.example.service.ShebeixinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.ShebeixinxiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/shebeixinxi")
public class ShebeixinxiController {

    @Resource
    private ShebeixinxiService shebeixinxiService;

    @PostMapping
    public Result<Shebeixinxi> add(@RequestBody ShebeixinxiVo shebeixinxi) {
		//yoxuxiaxnci
        shebeixinxiService.add(shebeixinxi);
        return Result.success(shebeixinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("shebeimingcheng","设备名称");        row.put("yonghuming","用户名");        row.put("fangweima","防伪码");        row.put("shebeicanshu","设备参数");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = shebeixinxiService.daochuexcel();
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
    public Result<Shebeixinxi> deleteList(@RequestBody ShebeixinxiVo shebeixinxi) {
        shebeixinxiService.deleteList(shebeixinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        shebeixinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ShebeixinxiVo shebeixinxi) {
        shebeixinxiService.update(shebeixinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Shebeixinxi> detail(@PathVariable Integer id) {
        Shebeixinxi shebeixinxi = shebeixinxiService.findById(id);
        return Result.success(shebeixinxi);
    }

    @GetMapping
    public Result<List<Shebeixinxi>> all() {
        return Result.success(shebeixinxiService.list());
    }

    @PostMapping("/page")
    public Result<ShebeixinxiVo> page(@RequestBody ShebeixinxiVo shebeixinxiVo) {
        return Result.success(shebeixinxiService.findPage(shebeixinxiVo));
    }
	//youupdt2login
}
