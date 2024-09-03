package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.exception.CustomException;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.*;
import com.example.service.*;
import com.example.service.impl.CollectServiceImpl;
import com.example.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/front")
public class FrontController {
    @Autowired
    private YonghuxinxiService yonghuxinxiService;
    @Autowired
    private BeijianxinxiService beijianxinxiService;
    @Autowired
    private LeixingxinxiService leixingxinxiService;
    @Autowired
    private ShequxinxiService shequxinxiService;
    @Autowired
    private WangdianxinxiService wangdianxinxiService;
    @Autowired
    private YuyuexinxiService yuyuexinxiService;

    @Autowired
    private PinglunService pinglunService;
    @Autowired
    private BianhuantuService bianhuantuService;
    @Autowired
    private XinwentongzhiService xinwentongzhiService;
    @Autowired
    private LiuyanbanService liuyanbanService;
    @Autowired
    private ShebeixinxiService shebeixinxiService;
    @Resource
    private CollectServiceImpl collectService;

    @PostMapping("/loginyonghuxinxi")
    public Result loginyonghuxinxi(@RequestBody Yonghuxinxi yonghuxinxi) {
        return Result.success(yonghuxinxiService.login(yonghuxinxi));
    }

    @GetMapping("/getshequxinxidetail/{id}")
    public Result getshequxinxidetail(@PathVariable Integer id) {
        return Result.success(shequxinxiService.findById(id));
    }
    @GetMapping("/getleixingList")
    public Result getleixingList() {
        List<Leixingxinxi> list = leixingxinxiService.list();

        return Result.success(list);
    }

    @PostMapping("/shequxinxi")
    public Result<ShequxinxiVo> shequxinxi(@RequestBody ShequxinxiVo shequxinxiVo) {
        return Result.success(shequxinxiService.findPage(shequxinxiVo));
    }

    @GetMapping("/getwangdianxinxidetail/{id}")
    public Result getwangdianxinxidetail(@PathVariable Integer id) {
        return Result.success(wangdianxinxiService.findById(id));
    }

    @PostMapping("/wangdianxinxi")
    public Result<WangdianxinxiVo> wangdianxinxi(@RequestBody WangdianxinxiVo wangdianxinxiVo) {
        return Result.success(wangdianxinxiService.findPage(wangdianxinxiVo));
    }

    @GetMapping("/getyuyuexinxidetail/{id}")
    public Result getyuyuexinxidetail(@PathVariable Integer id) {
        return Result.success(yuyuexinxiService.findById(id));
    }

    @GetMapping("/beijianList")
    public Result beijianList(String wangdianbianhao) {
        List<Beijianxinxi> list = beijianxinxiService.beijianlist(wangdianbianhao);
        return Result.success(list);
    }
    @GetMapping("/shebeiList")
    public Result shebeiList(String yonghuming) {
        List<Shebeixinxi> shebeixinxiList = shebeixinxiService.getByym(yonghuming);
        return Result.success(shebeixinxiList);
    }

    @PostMapping("/yuyuexinxi")
    public Result<YuyuexinxiVo> yuyuexinxi(@RequestBody YuyuexinxiVo yuyuexinxiVo) {
        return Result.success(yuyuexinxiService.findPage(yuyuexinxiVo));
    }

    @PostMapping("/postyuyuexinxi")
    public Result<Yuyuexinxi> postyuyuexinxi(@RequestBody Yuyuexinxi yuyuexinxi) {
        return Result.success(yuyuexinxiService.add(yuyuexinxi));
    }
    @PostMapping("/addShequ")
    public Result addShequ(@RequestBody Yuyuexinxi yuyuexinxi) {
        Long getshequ = shequxinxiService.getshequ(yuyuexinxi.getYonghuming(), yuyuexinxi.getWangdianmingcheng(), yuyuexinxi.getLeixingmingcheng(), yuyuexinxi.getBeijianmingcheng());
        if (getshequ>0){
            return Result.error();
        }
        Shequxinxi shequxinxi = new Shequxinxi();
        shequxinxi.setWangdianmingcheng(yuyuexinxi.getWangdianmingcheng());
        shequxinxi.setWangdianlianxifangshi(yuyuexinxi.getWangdianlianxifangshi());
        shequxinxi.setWangdianweizhi(yuyuexinxi.getWangdianweizhi());
        shequxinxi.setBeijianmingcheng(yuyuexinxi.getBeijianmingcheng());
        shequxinxi.setYonghuming(yuyuexinxi.getYonghuming());
        shequxinxi.setWangdianleixing(yuyuexinxi.getLeixingmingcheng());
        shequxinxi.setHuafeijine(yuyuexinxi.getYujihuafei());
        shequxinxi.setAddtime(new Date());
        return Result.success(shequxinxiService.add(shequxinxi));
    }


    @PostMapping("/postpinglun")
    public Result<Pinglun> postpinglun(@RequestBody Pinglun pinglun) {
        return Result.success(pinglunService.add(pinglun));
    }

    @PostMapping("/pinglun")
    public Result<PinglunVo> pinglun(@RequestBody PinglunVo pinglunVo) {
        return Result.success(pinglunService.findPage(pinglunVo));
    }

    @GetMapping("/bianhuantu")
    public Result bianhuantu() {
        return Result.success(bianhuantuService.list());
    }

    @GetMapping("/xinwentongzhi")
    public Result xinwentongzhi() {
        return Result.success(xinwentongzhiService.list());
    }

    @GetMapping("/getxinwentongzhi/{id}")
    public Result getxinwentongzhi(@PathVariable Integer id) {
        return Result.success(xinwentongzhiService.findById(id));
    }

    @PostMapping("/addLiuyan")
    public Result addComment(@RequestBody Liuyanban liuyanban) {
        liuyanbanService.add(liuyanban);
        return Result.success();
    }

    @GetMapping("/getLiuyan")
    public Result<List<Liuyanban>> getCommentTiezi() {
        return Result.success(liuyanbanService.getLiuyan());
    }

    @PostMapping("/addCollect")
    public Result addCollect(@RequestBody Collect collect) {
        Collect collect1 = collectService.add(collect);
        if (collect1 == null) {
            return Result.success("请勿重复收藏");
        }
        return Result.success();
    }

    @DeleteMapping("/deleteCollect/{id}")
    public Result deleteCollect(@PathVariable Integer id) {
        collectService.delete(id);
        return Result.success();
    }

    @PostMapping("/getUserCollect")
    public Result getUserCollect(@RequestBody Collect collect) {
        return Result.success(collectService.findFrontPages(collect.getUserId()));
    }

    @DeleteMapping("/deleteCollect/{id}/{userId}")
    public Result deleteCollect(@PathVariable Integer id, @PathVariable Integer userId) {
        collectService.deleteByUserId(id, userId);
        return Result.success();
    }

    @PutMapping("/yonghuxinxi")
    public Result updateYonghuxinxi(@RequestBody YonghuxinxiVo yonghuxinxi) {
        yonghuxinxiService.update(yonghuxinxi);
        return Result.success();
    }

    @PutMapping("/beijianxinxi")
    public Result updateBeijianxinxi(@RequestBody BeijianxinxiVo beijianxinxi) {
        beijianxinxiService.update(beijianxinxi);
        return Result.success();
    }

    @PutMapping("/leixingxinxi")
    public Result updateLeixingxinxi(@RequestBody LeixingxinxiVo leixingxinxi) {
        leixingxinxiService.update(leixingxinxi);
        return Result.success();
    }

    @PutMapping("/shequxinxi")
    public Result updateShequxinxi(@RequestBody ShequxinxiVo shequxinxi) {
        shequxinxiService.update(shequxinxi);
        return Result.success();
    }

    @PutMapping("/wangdianxinxi")
    public Result updateWangdianxinxi(@RequestBody WangdianxinxiVo wangdianxinxi) {
        wangdianxinxiService.update(wangdianxinxi);
        return Result.success();
    }

    @PutMapping("/yuyuexinxi")
    public Result updateYuyuexinxi(@RequestBody YuyuexinxiVo yuyuexinxi) {
        yuyuexinxiService.update(yuyuexinxi);
        return Result.success();
    }

    @PostMapping("/shebeixinxi")
    public Result<ShebeixinxiVo> shebeixinxi(@RequestBody ShebeixinxiVo shebeixinxiVo) {
        ShebeixinxiVo page = shebeixinxiService.findPage(shebeixinxiVo);
        return Result.success(page);
    }
    @PostMapping("/postshebeixinxi")
    public Result<Shebeixinxi> postshebeixinxi(@RequestBody Shebeixinxi shebeixinxi) {
        return Result.success(shebeixinxiService.add(shebeixinxi));
    }

    @PutMapping("/shebeixinxi")
    public Result updateShebeixinxi(@RequestBody ShebeixinxiVo shebeixinxi) {
        shebeixinxiService.update(shebeixinxi);
        return Result.success();
    }

    @GetMapping("/getshebeixinxidetail/{id}")
    public Result getshebeixinxidetail(@PathVariable Integer id) {
        return Result.success(shebeixinxiService.findById(id));
    }

    @PostMapping("/registeryonghuxinxi")
    public Result registeryonghuxinxi(@RequestBody Yonghuxinxi yonghuxinxi) {
        Yonghuxinxi add = yonghuxinxiService.add(yonghuxinxi);
        if (add!=null){
            return Result.success(add);
        }else{
            return Result.error("100001","用户名重复");
        }
    }
}
