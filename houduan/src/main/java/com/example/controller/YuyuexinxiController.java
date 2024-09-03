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
import com.example.entity.Yuyuexinxi;
import com.example.exception.CustomException;
import com.example.service.BeijianxinxiService;
import com.example.service.YuyuexinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.YuyuexinxiVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/yuyuexinxi")
public class YuyuexinxiController {

    @Resource
    private YuyuexinxiService yuyuexinxiService;
    @Resource
    private BeijianxinxiService beijianxinxiService;

    @PostMapping
    public Result<Yuyuexinxi> add(@RequestBody YuyuexinxiVo yuyuexinxi) {
		//yoxuxiaxnci
        yuyuexinxiService.add(yuyuexinxi);
        return Result.success(yuyuexinxi);
    }

    @GetMapping("/beijianList")
    public Result beijianList(String wangdianmingcheng) {
        return Result.success(beijianxinxiService.beijianlistmc(wangdianmingcheng));
    }

	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("wangdianmingcheng","网点名称");
        row.put("wangdianlianxifangshi","网点联系方式");
        row.put("wangdianweizhi","网点位置");
        row.put("leixingmingcheng","类型名称");
        row.put("yuyueriqi","预约日期");
        row.put("beijianmingcheng","备件名称");
        row.put("yujihuafei","预计花费");
        row.put("yonghuming","用户名");
        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = yuyuexinxiService.daochuexcel();
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
    public Result<Yuyuexinxi> deleteList(@RequestBody YuyuexinxiVo yuyuexinxi) {
        yuyuexinxiService.deleteList(yuyuexinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        yuyuexinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody YuyuexinxiVo yuyuexinxi) {
        String s = yuyuexinxi.getBeijianmingcheng().replaceAll(",", "','");
            s = "'"+s+"'";
            String m = beijianxinxiService.getjine(s,yuyuexinxi.getWangdianmingcheng());
            if(m!=null){
                yuyuexinxi.setYujihuafei(m);
            }
        yuyuexinxiService.update(yuyuexinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Yuyuexinxi> detail(@PathVariable Integer id) {
        Yuyuexinxi yuyuexinxi = yuyuexinxiService.findById(id);
        return Result.success(yuyuexinxi);
    }

    @GetMapping
    public Result<List<Yuyuexinxi>> all() {
        return Result.success(yuyuexinxiService.list());
    }

    @PostMapping("/page")
    public Result<YuyuexinxiVo> page(@RequestBody YuyuexinxiVo yuyuexinxiVo) {
        return Result.success(yuyuexinxiService.findPage(yuyuexinxiVo));
    }
    @GetMapping("/yuyuexinxi_tj_leixingmingcheng")
    public Result yuyuexinxi_tj_leixingmingcheng() {
        return Result.success(yuyuexinxiService.yuyuexinxi_tj_leixingmingcheng());
    }
	//youupdt2login
}
