<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>首页>> 预约信息列表 >> 预约信息详细 </p>
      </div>
    </div>
    <div class="main">

      <div class="content">
        <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1"
               style="border-bottom: #c9c9c9 1px dashed; ">
          <tr>
            <td width='11%' height='60px;'>网点名称：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.wangdianmingcheng }}</td>
            <td width='11%' height='60px;'>网点联系方式：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.wangdianlianxifangshi }}</td>
          </tr>
          <tr>
            <td width='11%' height='60px;'>网点位置：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.wangdianweizhi }}</td>
            <td width='11%' height='60px;'>类型名称：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.leixingmingcheng }}</td>
          </tr>
          <tr>
            <td width='11%' height='60px;'>设备名称：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.shebeimingcheng }}</td>
            <td width='11%' height='60px;'>防伪码：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.fangweima }}</td>
          </tr>
          <tr>
            <td width='11%' height='60px;'>预约日期：</td>
            <td width='39%' height='60px;'>{{ removeLastZero(yuyuexinxidetail.yuyueriqi) }}</td>
            <td width='11%' height='60px;'>备件名称：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.beijianmingcheng }}</td>
          </tr>
          <tr>
            <td width='11%' height='60px;'>预计花费：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.yujihuafei }}</td>
            <td width='11%' height='60px;'>用户名：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.yonghuming }}</td>
          </tr>
          <tr>
            <td width='11%' height='60px;'>当前状态：</td>
            <td width='39%' height='60px;'>{{ yuyuexinxidetail.issh?'已确认':'待查看' }}</td>
          </tr>
        </table>
        <div class="button">
          <el-button class="shop-cart" @click="addCollect">分享</el-button>
        </div>

      </div>
    </div>
  </div>
</template>
<script>

export default {
  data() {
    return {
      dis: false, // 控制“加入购物车按钮是否可用”
      yuyuexinxiID: '',
      yuyuexinxidetail: "", // 商品详细信息

    };
  },
  watch: {
    '$route'(to, from) {
      // 路由发生变化页面刷新
      this.$router.go(0);
    }
  },
  created() {
    this.yuyuexinxiID = this.$route.params.id;
    let id = this.$route.params.id;
    this.id = id;
    this.getDetails(id);
  },
  methods: {
    download(xx) {
      location.href = "http://localhost:9999/" + xx;
    },
    removeLastZero(value){
      if (value && value.endsWith('.0')) {
        return value.slice(0, -2)
      }
      return value
    },
    // 获取商品详细信息
    getDetails(val) {
      this.$axios
          .get("/api/front/getyuyuexinxidetail/" + val,)
          .then(res => {
            debugger
            this.yuyuexinxidetail = res.data.data;
          })
          .catch(err => {
            return Promise.reject(err);
          });
    },
    // 加入购物车

    addCollect() {
      this.$axios
          .post("/api/front/addShequ",this.yuyuexinxidetail)
          .then(res => {
            console.log(res)
            debugger
            if (res.data.code == -1){
              this.$message({
                type: 'info',
                message: '已分享'
              })
            }
          })
          .catch(err => {
            return Promise.reject(err);
          });
    }
  }
};
</script>
<style>
@import "../assets/css/index.scss";
/* 头部CSS */
#details .page-header {
  height: 64px;
  margin-top: -20px;
  z-index: 4;
  background: #fff;
  border-bottom: 1px solid #e0e0e0;
  -webkit-box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
}

#details .page-header .title {
  width: 1225px;
  height: 64px;
  line-height: 64px;
  font-size: 18px;
  font-weight: 400;
  color: #212121;
  margin: 0 auto;
}

#details .page-header .title p {
  float: left;
}

#details .page-header .title .list {
  height: 64px;
  float: right;
}

#details .page-header .title .list li {
  float: left;
  margin-left: 20px;
}

#details .page-header .title .list li a {
  font-size: 14px;
  color: #616161;
}

#details .page-header .title .list li a:hover {
  font-size: 14px;
  color: #ff6700;
}

/* 头部CSS END */

/* 主要内容CSS */
#details .main {
  width: 1225px;
  height: 560px;
  padding-top: 30px;
  margin: 0 auto;
}

#details .main .block {
  float: left;
  width: 560px;
  height: 560px;
}

#details .el-carousel .el-carousel__indicator .el-carousel__button {
  background-color: rgba(163, 163, 163, 0.8);
}

#details .main .content {
  float: left;
  margin-left: 25px;
  width: 100%;
}

#details .main .content .name {
  height: 30px;
  line-height: 30px;
  font-size: 24px;
  font-weight: normal;
  color: #212121;
}

#details .main .content .intro {
  color: #b0b0b0;
  padding-top: 10px;
}

#details .main .content .store {
  color: #ff6700;
  padding-top: 10px;
}

#details .main .content .price {
  display: block;
  font-size: 18px;
  color: #ff6700;
  border-bottom: 1px solid #e0e0e0;
  padding: 25px 0 25px;
}

#details .main .content .price .del {
  font-size: 14px;
  margin-left: 10px;
  color: #b0b0b0;
  text-decoration: line-through;
}

#details .main .content .pro-list {
  background: #f9f9fa;
  padding: 30px 60px;
  margin: 50px 0 50px;
}

#details .main .content .pro-list span {
  line-height: 30px;
  color: #616161;
}

#details .main .content .pro-list .pro-price {
  float: right;
}

#details .main .content .pro-list .pro-price .pro-del {
  margin-left: 10px;
  text-decoration: line-through;
}

#details .main .content .pro-list .price-sum {
  color: #ff6700;
  font-size: 24px;
  padding-top: 20px;
}

#details .main .content .button {
  height: 55px;
  margin: 10px 0 20px 0;
}

#details .main .content .button .el-button {

  float: left;
  height: 55px;
  font-size: 16px;
  color: #fff;
  border: none;
  text-align: center;
}

#details .main .content .button .shop-cart {
  width: 340px;
  background-color: #ff6700;
}

#details .main .content .button .shop-cart:hover {
  background-color: #f25807;
}

#details .main .content .button .like {
  width: 260px;
  margin-left: 40px;
  background-color: #b0b0b0;
}

#details .main .content .button .like:hover {
  background-color: #757575;
}

#details .main .content .pro-policy li {
  float: left;
  margin-right: 20px;
  color: #b0b0b0;
}

/* 主要内容CSS END */
</style>
