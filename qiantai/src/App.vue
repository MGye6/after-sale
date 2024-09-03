<template>
  <div id="app" name="app">
    <el-container>
      <!-- 顶部导航栏 -->
      <div class="header">
        <div class="container">
          <div class="logo">
            <table>
              <tr>
                <td><a href="/"><img src="./assets/imgs/logo.png"></a></td>
                <td><a>商品售后服务预约系统</a></td>
              </tr>
            </table>

          </div>
          <div class="top-search-social-nav">
            <ul>
              <li class="active"><a href="#"><img src="./assets/facebook.png" title="Facebook" alt=""></a></li>
              <li><a href="#"><img src="./assets/twitter.png" title="Twitter" alt=""></a></li>
              <li><a href="#"><img src="./assets/gpluse.png" title="Googlepluse" alt=""></a></li>
              <li><a href="#"><img src="./assets/rss.png" title="Rss" alt=""></a></li>
            </ul>
          </div>
          <div class="top-search-social-nav2">
            <ul>
              <li v-if="!this.$store.getters.getUser" style="float:left">
                <el-button type="text" @click="login" style="color: #fff;
    display: inline-block;
    text-transform: uppercase;
    text-decoration: none;
    background: #FF8D1B;
    text-align: center;
    padding: 6px 30px;
    font-weight: bold;">登录
                </el-button><font>|</font>
                <el-button type="text" @click="register = true" style="color: #fff;
    display: inline-block;
    text-transform: uppercase;
    text-decoration: none;
    background: #FF8D1B;
    text-align: center;
    padding: 6px 30px;
    font-weight: bold;">注册
                </el-button>
              </li>
              <li v-else>
                欢迎 {{ username }} [{{ cx }}]&nbsp;
                <el-button type="text" @click="logout" style="color: #fff;
    display: inline-block;
    text-transform: uppercase;
    text-decoration: none;
    background: #FF8D1B;
    text-align: center;
    padding: 6px 30px;
    font-weight: bold;">退出
                </el-button>
                <el-popover placement="top" width="180" v-model="visible">
                  <p>确定退出登录吗？</p>
                  <div style="text-align: right; margin: 10px 0 0">
                    <el-button size="mini" type="text" @click="visible = false">取消</el-button>
                    <el-button type="primary" size="mini" @click="logout">确定</el-button>
                  </div>
                  <el-button type="text" slot="reference">{{ this.$store.getters.getUser.userName }}</el-button>
                </el-popover>
              </li>
              <li v-if="!this.$store.getters.getUser">
                <el-button type='text' style="color: #fff;
    display: inline-block;
    text-transform: uppercase;
    text-decoration: none;
    background: #FF8D1B;
    text-align: center;
    padding: 6px 30px;
    font-weight: bold;" @click="hsghoutai()">跳转后台
                </el-button>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <!--        </div>-->
      <!--      </div>-->
      <!-- 顶部导航栏END -->


      <!-- 顶栏容器 -->
      <el-header class="movies_nav">
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" active-text-color="#409eff"
                 router>
          <el-menu-item index="/"><font color="#ffffff">首页</font></el-menu-item>
          <el-submenu index="shebeixinxi">
            <template slot="title"><font color="#ffffff">设备信息</font></template>
              <el-menu-item index="/shebeixinxilisttp"><font color="#000000">设备信息</font></el-menu-item>
              <el-menu-item index="/shebeixinxiadd"><font color="#000000">设备添加</font></el-menu-item>
          </el-submenu>
            <el-submenu index="wangdianxinxi">
              <template slot="title"><font color="#ffffff">网点信息</font></template>
              <el-menu-item index="/wangdianxinxilisttp"><font color="#000000">网点信息</font></el-menu-item>
            </el-submenu>
            <el-submenu index="yuyuexinxi">
              <template slot="title"><font color="#ffffff">预约信息</font></template>
              <el-menu-item index="/yuyuexinxi"><font color="#000000">预约信息</font></el-menu-item>
            </el-submenu>
            <el-submenu index="shequxinxi">
              <template slot="title"><font color="#ffffff">社区信息</font></template>
              <el-menu-item index="/shequxinxi"><font color="#000000">社区信息</font></el-menu-item>
            </el-submenu>
            <el-submenu index="xinwenxinxi">
              <template slot="title"><font color="#ffffff">新闻信息</font></template>
              <el-menu-item index="/xinwentongzhi/站内新闻"><font color="#000000">站内新闻</font></el-menu-item>
            </el-submenu>
            <el-submenu index="zaixianliuyan">
              <template slot="title"><font color="#ffffff">在线留言</font></template>
              <el-menu-item index="/Liuyan"><font color="#000000">在线留言</font></el-menu-item>
            </el-submenu><!--yoxulixuyaxn-->
        </el-menu>
      </el-header>
      <!-- 顶栏容器END -->
      <div style=" margin: 0 auto;
      max-width: 100%;
      width: 100%;">
        <el-carousel height="480px" indicator-position="outside">
          <el-carousel-item v-for="item in carouselItems" :key="item.id">
            <img :src="'/api/'+item.tupian" style="height: 480px; width: 100%"/>
          </el-carousel-item>
        </el-carousel>
      </div>
      <!-- 登录模块 -->
      <MyLogin></MyLogin>
      <!-- 注册模块 -->
      <MyRegister :register="register" @fromChild="isRegister"></MyRegister>
      <!-- 主要区域容器 -->
      <el-main>
        <keep-alive>
          <router-view></router-view>
        </keep-alive>
      </el-main>
      <!-- 主要区域容器END -->
      <el-footer>

        <div class="footer">
          <div class="container">

            <div class="clearfix"></div>
          </div>
        </div>
        <div class="copy-right">
          <p>Copyright &copy; 2024.Company name All rights reserved </p>
        </div>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import {mapActions} from "vuex";
import {mapGetters} from "vuex";

export default {
  beforeUpdate() {
    this.activeIndex = this.$route.path;
  },
  data() {
    return {
      carouselItems: [], // 存储轮播图数据
      activeIndex: "", // 头部导航栏选中的标签
      search: "", // 搜索条件
      register: false, // 是否显示注册组件
      visible: false, // 是否退出登录
      username: '',
      cx: '',
    };
  },
  created() {
    // 获取浏览器localStorage，判断用户是否已经登录
    if (localStorage.getItem("user")) {
      // 如果已经登录，设置vuex登录状态
      this.setUser(JSON.parse(localStorage.getItem("user")));
      this.username = localStorage.getItem("username");
      this.cx = localStorage.getItem("cx");
    }
    this.fetchCarouselData();
  },
  computed: {
    ...mapGetters(["getUser", "getNum"])
  },
  watch: {},
  methods: {
    fetchCarouselData() {
      this.$axios
          .get("/api/front/bianhuantu", {})
          .then(res => {
            let data = res.data.data;
            let filteredData = [];
            data.forEach(item => {
              filteredData.push(item);
            });
            this.carouselItems = filteredData;
          })
          .catch(err => {
            return Promise.reject(err);
          });
    },
    ...mapActions(["setUser", "setShowLogin", "setShoppingCart"]),
    login() {
      // 点击登录按钮, 通过更改vuex的showLogin值显示登录组件
      this.setShowLogin(true);
    },
    hsghoutai() {
      const w = window.open("about:blank");
      w.location.href = 'http://localhost:9999/#/';
    },
    // 退出登录
    logout() {
      this.visible = false;
      // 清空本地登录信息
      localStorage.setItem("user", "");
      // 清空vuex登录信息
      this.setUser("");
      this.notifySucceed("成功退出登录");
    },
    // 接收注册子组件传过来的数据
    isRegister(val) {
      this.register = val;
    },
  }
};
</script>

<style>
/* 全局CSS */
* {
  padding: 0;
  margin: 0;
  border: 0;
  list-style: none;
}

#app .el-header {
  padding: 0;
}

#app .el-main {
  min-height: 300px;
  padding: 20px 0;
}

#app .el-footer {
  padding: 0;
}

a,
a:hover {
  text-decoration: none;
}

/* 全局CSS END */

/* 顶部导航栏CSS */
.topbar {
  height: 40px;
  background-color: #3d3d3d;
  margin-bottom: 20px;
}

.topbar .nav {
  width: 1225px;
  margin: 0 auto;
}

.topbar .nav ul {
  float: right;
}

.topbar .nav li {
  float: left;
  height: 40px;
  color: #b0b0b0;
  font-size: 14px;
  text-align: center;
  line-height: 40px;
  margin-left: 20px;
}

.topbar .nav .sep {
  color: #b0b0b0;
  font-size: 12px;
  margin: 0 5px;
}

.topbar .nav li .el-button {
  color: #b0b0b0;
}

.topbar .nav .el-button:hover {
  color: #fff;
}

.topbar .nav li a {
  color: #b0b0b0;
}

.topbar .nav a:hover {
  color: #fff;
}

.topbar .nav .shopCart {
  width: 120px;
  background: #424242;
}

.topbar .nav .shopCart:hover {
  background: #fff;
}

.topbar .nav .shopCart:hover a {
  color: #ff6700;
}

.topbar .nav .shopCart-full {
  width: 120px;
  background: #ff6700;
}

.topbar .nav .shopCart-full a {
  color: white;
}

/* 顶部导航栏CSS END */

/* 顶栏容器CSS */
.el-header .el-menu {
  max-width: 1225px;
  margin: 0 auto;
  background-color: transparent;
}

.el-header .logo {
  height: 60px;
  width: 189px;
  float: left;
  margin-right: 100px;
}

.el-header .so {
  margin-top: 10px;
  width: 300px;
  float: right;
}

/* 顶栏容器CSS END */
.header {
  padding: 1em 0;
}

.w3layouts_logo {
  float: left;
}

.w3layouts_logo a {
  display: block;
  text-decoration: none;
}

h1, h2, h3, h4, h5, h6, a {
  font-family: 'Roboto Condensed', sans-serif;
  margin: 0;
}

.w3layouts_logo a h1 {
  padding-left: 20px;
  padding-top: 20px;
  font-size: 2.8em;
  color: #212121;
  text-transform: uppercase;

  padding-right: 1.67em;
  font-weight: 900;
  padding-bottom: 0.3em;
}

.w3layouts_logo a h1 span {

  color: #FF8D1B;
  font-size: .3em;
  display: block;
  font-weight: 300;
  letter-spacing: 5px;
  text-align: right;
  line-height: 0;
}

.w3_search input[type="text"] {
  outline: none;
  border: none;
  background: #EFEFEF;
  padding: 11px;
  text-align: center;
  font-size: 14px;
  color: #999;
  width: 71%;
  float: left;
  border-top-left-radius: 25px;
  border-bottom-left-radius: 25px;
}

.w3_search input[type="submit"] {
  outline: none;
  border: none;
  background: #212121;
  padding: 10px 0;
  font-size: 14px;
  color: #fff;
  width: 22%;
  border-top-right-radius: 25px;
  border-bottom-right-radius: 25px;
}

.w3l_sign_in_register {
  float: right;
  margin-top: 1em;
  width: 35%;
}

.w3l_sign_in_register ul li a {
  color: #fff;
  display: inline-block;
  text-transform: uppercase;
  text-decoration: none;
  background: #FF8D1B;
  text-align: center;
  padding: 6px 30px;
  font-weight: bold;
}

.fa-phone:before {
  content: "\f095";
}

.navbar-nav > li {
  float: left;
  border-right: 1px dotted #fff;
  width: 9%;
  text-align: center;
}

.navbar-default .navbar-nav > li > a {
  color: #fff;
  text-transform: uppercase;
}

.navbar-default .navbar-nav > li > a {
  color: #777;
}

.navbar-default .navbar-collapse, .navbar-default .navbar-form {
  border-color: #e7e7e7;
}

.navbar-nav > li > a {
  padding-top: 10px;
  padding-bottom: 10px;
  line-height: 20px;
}

.nav > li {
  position: relative;
  display: block;
}

p, ul li, ol li {
  margin: 0;
  font-size: 14px;
}

article, aside, details, figcaption, figure, footer, header, hgroup, main, menu, nav, section, summary {
  display: block;
}

.movies_nav {
  background: #6a737b;
}

.w3l_sign_in_register ul li a {
  color: #fff;
  display: inline-block;
  text-transform: uppercase;
  text-decoration: none;
  background: #FF8D1B;
  text-align: center;
  padding: 6px 30px;
  font-weight: bold;
}

.owl-carousel {
  display: none;
  position: relative;
  width: 100%;
  -ms-touch-action: pan-y;
  background: #fff;
}

.img-responsive, .thumbnail > img, .thumbnail a > img, .carousel-inner > .item > img, .carousel-inner > .item > a > img {
  display: block;
  max-width: 100%;
  height: auto;
}

.w3l-movie-gride-agile {
  text-align: center;
  box-shadow: 0px 0px 10px rgba(255, 255, 255, 0.35);
  margin-right: 0%;
  margin-bottom: 3%;
  position: relative;
  padding-left: 0;
}

.hvr-shutter-out-horizontal {
  display: inline-block;
  vertical-align: middle;
  -webkit-transform: translateZ(0);
  transform: translateZ(0);
  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
  -moz-osx-font-smoothing: grayscale;
  position: relative;
  background: #e1e1e1;
  -webkit-transition-property: color;
  transition-property: color;
  -webkit-transition-duration: 0.3s;
  transition-duration: 0.3s;
}


h4, h5, h6,
h1, h2, h3 {
  margin: 0;
}

ul, ol {
  margin: 0;
}

p {
  margin: 0;
}

html, body {
  font-family: 'Hind-Regular';
  font-size: 100%;
  background: #fff;
}

body {
  font-family: 'Sintony', sans-serif !important;
  border-top: 5px solid #42A5F5;
}

body a {
  text-decoration: none;
  transition: 0.5s all;
  -webkit-transition: 0.5s all;
  -moz-transition: 0.5s all;
  -o-transition: 0.5s all;
  -ms-transition: 0.5s all;
}

body a:hover {
  text-decoration: none;
}

/*---start-header---*/
.header {
  padding: 12px 0em;
  background: rgba(238, 238, 238, 0.63);
}

.top-search-social-nav ul {
  margin: 1em 0em 0em 0em;
  padding: 0px;
}

.logo {
  float: left;
  padding-left: 20px;
}

.logo a {
  font-size: 24px;

  color: #42a5f5;
  font-family: 'Fjalla One', sans-serif;
}

.logo a:hover {
  color: #42a5f5;
  padding-left: 10px;
  text-decoration: none;
}

.top-search-social-nav ul li {
  display: inline-block;
}

.top-search-social-nav2 ul li {
  display: inline-block;
  padding-top: 12px;
  padding-right: 10px;
}

.top-search-social-nav ul li a {
  background: #000;
  padding: 8px 9px;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
  display: block;
  margin: 0px 8px 0px 0px;
  -webkit-border-radius: 50%;
  -moz-border-radius: 50%;
  border-radius: 50%;
  font-family: 'Sintony', sans-serif;
  line-height: 1em;
}

.top-search-social-nav2 ul li a {

  padding: 8px 9px;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;

  margin: 0px 8px 0px 0px;
  -webkit-border-radius: 50%;
  -moz-border-radius: 50%;
  border-radius: 50%;
  font-family: 'Sintony', sans-serif;
  line-height: 1em;
  font-size: 13px;
}

.top-search-social-nav li.active > a, .top-search-social-nav li > a:hover {
  background: #42a5f5;
}

.top-search-social-nav2 li.active > a, .top-search-social-nav li > a:hover {
  background: #42a5f5;
}

.top-search-social-nav {
  float: right;
}

.top-search-social-nav2 {
  float: right;
}

/*---top-nav----*/
.top-nav {
  background: #6a737b;
  border-bottom: 2px solid #42A5F5;
}

.top-nav ul li {
  display: inline-block;
  float: left;

  border-right: 1px solid rgba(78, 78, 78, 0.57);
}

.top-nav li.active1 > a, .top-nav li > a:hover {
  background: #42a5f5;
}

.top-nav li a {
  padding: 15px 101px;
  display: block;
  text-transform: uppercase;
  color: #FFF;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
  font-size: 0.9em;
  text-align: center;
  font-family: 'Sintony', sans-serif;
}

.top-nav li a:hover {
  background: #42a5f5 !important;
}

.navbar-nav {
  float: none !important;
}

/*---start-content----*/
/*  GRID OF FOUR   ============================================================================= */
.content {
  /*margin:6em 0em;*/
}

.section {
  clear: both;
  padding: 0px;
  margin: 0px;
}

.group:before,
.group:after {
  content: "";
  display: table;
}

.group:after {
  clear: both;
}

.group {
  zoom: 1;
}

.col_1_of_4 {
  display: block;
  float: left;
  margin: 1% 0 1% 1.3%;
  border: 1px solid rgba(192, 192, 192, 0.28);
}

.active-grid h3 {
  font-family: 'Sintony', sans-serif;
  color: #2E2E2E;
  font-size: 1.5em;
  font-weight: 600;
  text-transform: uppercase;
}

.active-grid p {
  font-size: 0.9em;
  padding: 0.4em 0 0 0;
  color: #777;
  line-height: 1.6em;
  font-family: verdana, arial, helvetica, helve, sans-serif;
  font-family: 'Sintony', sans-serif;
}

.grids h4 {
  font-family: 'Sintony', sans-serif;
  color: #2E2E2E;
  font-size: 1.8em;
  text-transform: uppercase;
  float: left;
  font-weight: 600;
  margin: 0em 0em 1.2em 0em;
}

.grids h5 {
  float: right;
  width: 85%;
  background: url(./assets/hd-bg.png) 0% 73% repeat-x;
  display: inline-block;
  padding: 10px;
  height: 15px;
  margin: 0em;
}

.grids h3 img {
  vertical-align: middle;
  padding-right: 8px;
}

.active-grid {

  color: #fff;
  padding: 1em 1.5em;
  height: 250px;

}

.active-grid:hover {
  background: #6a737b;
}

.active-grid h3, .active-grid p {
  color: #fff;
}

.span_1_of_4:hover h3 {
  color: #fff;
}

.span_1_of_4:hover p {
  color: #fff;
}

.big-button {
  padding: 20px;
  margin: 5em 0em 0em 0em;
}

.recent-places {
  margin: 5em 0em 0em 0em;
}

.we-do {
  padding: 0em 0.6em 0em 0em !important;
}

.big-b-text {
  float: left;
}

.big-b-text p {
  font-family: 'Sintony', sans-serif;
  color: #2E2E2E;
  font-size: 2.1em;
  text-transform: uppercase;
}

.big-b-btn {
  float: right;
}

.big-b-btn a {
  font-family: 'Sintony', sans-serif;
  color: #FFF !important;
  font-size: 1.2em;
  text-transform: uppercase;
  background: #6a737b;
  padding: 13px 10px;
  display: block;
  margin-top: 10px;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.big-b-btn a:hover {
  background: #42a5f5;
  color: #fff;
}

.big-b-text span {
  float: left;
  font-size: 1em;
  color: #777;
  line-height: 1.6em;
  font-family: verdana, arial, helvetica, helve, sans-serif;
  font-family: 'Sintony', sans-serif;
  text-transform: uppercase;
}

/*---recent-places----*/
.recent-places h4 {
  font-family: 'Sintony', sans-serif;
  color: #2E2E2E;
  font-size: 1.8em;
  text-transform: uppercase;
  margin: 0em 0em 1.5em 0em;
  float: left;
  font-weight: 600;
}

.recent-places h5 {
  float: right;
  /*width: 80%;*/
  display: inline-block;
  height: 15px;
  margin: 0.2em 0em 0em 0em;
}

/* Common division block */
.holder img {
  display: block;
}

/* Caption and Light */
.caption {
  color: rgba(0, 0, 0, 0);
  line-height: 100px;

}

.caption:hover {
  border: 6px solid #E0E0E0;
  color: rgb(255, 255, 255);
  line-height: 500px;
  box-shadow: 0px 0px 10px 7px #FFFFFF;
}

.caption > div {
  position: absolute;
  top: 0px;
  left: 50px;
  font-size: 30px;
}

/* Smooth Caption */
.smooth:hover img {
  cursor: pointer;
  box-shadow: 2px 6px 6px #00FF33;
}

.go-left {
  background-color: rgba(0, 0, 0, 0.5);
  color: #FFFFFF;
  position: absolute;
  bottom: 0px;
  right: -600px;
  width: 360px;
  text-align: center;
  font-size: 20px;
  margin: 10px;
  padding: 10px;
  -webkit-transition: 0.5s Ease;
  -moz-transition: 0.5s Ease;
  -o-transition: 0.5s Ease;
  transition: 0.5s Ease;
}

.smooth:hover > .go-left {
  right: 0px;
}

/*.go-top{*/
/*  background-color:rgba(66, 165, 245, 0.7);*/
/*  color: #FFFFFF;*/
/*  position: absolute;*/
/*  bottom: 0px;*/
/*  top: 600px;*/
/*  width: 97%;*/
/*  text-align:center;*/
/*  font-size:15px;*/
/*  overflow: hidden;*/
/*  -webkit-transition: 0.5s Ease;*/
/*  -moz-transition: 0.5s Ease;*/
/*  -o-transition: 0.5s Ease;*/
/*  transition: 0.5s Ease;*/

/*}*/
.copyrights {
  text-indent: -9999px;
  height: 0;
  line-height: 0;
  font-size: 0;
  overflow: hidden;
}

.smooth:hover > .go-top {
  top: 0px;
}

.go-top p {
  font-size: 12px;
}

.go-top h3 {
  font-family: 'Sintony', sans-serif;
  color: #fff;
  font-size: 1.2em;
  text-transform: uppercase;
  margin-top: 25px
}

.go-top p {
  font-size: 0.8em;
  padding: 0.4em 0 0 0;
  color: #FFF;
  line-height: 1.5em;
  font-family: verdana, arial, helvetica, helve, sans-serif;
  font-family: 'Sintony', sans-serif;
}

.go-top a {
  font-family: 'Sintony', sans-serif;
  color: #2E2E2E;
  font-size: 0.875em;
  text-transform: uppercase;
  background: #FFF;
  padding: 8px 13px;
  display: inline-block;
  margin: 14px;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.last-grid {
  margin-right: 0px;
}

.holder img {

  opacity: 5;
  transition: all 300ms !important;
  -webkit-transition: all 300ms !important;
  -moz-transition: all 300ms !important;
  width: 100%;
  padding-bottom: 10px;
}

/*---footer----*/
.footer {
  background: #2E2E2E;

}

.footer-grid.center-grid ul {
  padding: 0px;
}

.footer-grid h3 {
  font-family: 'Sintony', sans-serif;
  color: #FFF;
  font-size: 1.5em;
  text-transform: uppercase;
  margin: 0em 0em 0.8em 0em;
}

.footer-grid p {
  font-size: 0.9em;
  color: #777;
  line-height: 1.8em;
  font-family: 'Sintony', sans-serif;
}

.footer-grid a {
  font-family: 'Sintony', sans-serif;
  color: #202020;
  font-size: 1em;
  text-transform: uppercase;
  background: #FFF;
  padding: 10px 15px;
  display: inline-block;
  margin: 9px 0;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.footer-grid a:hover {
  background: #42a5f5;
  color: #FFF;
}

.footer-grid ul li {
  display: block;
}

.footer-grid.twitts label a {
  background: none;
  color: #42A5F5;
  padding: 0px;
  margin: 0px;
}

.footer-grid.twitts label a:hover {
  color: #fff;
}

.center-grid a {
  background: none;
  padding: 0px;
  color: #777;
  margin: 5px;
  border-bottom: 1px ridge rgba(192, 192, 192, 0.13);
  padding: 0px 0px 9px 0px;
}

.center-grid {
  width: 20%;
}

.center-grid a:hover {
  background: none;
}

.center-grid ul {
  margin-top: 5px;
}

.twitts p label {
  font-weight: bold;
  font-size: 1em;
  cursor: pointer;
  padding-right: 5px;
}

.twitts span {
  display: block;
  color: #42a5f5;
  font-family: 'Sintony', sans-serif;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.twitts span:hover {
  color: #fff;
  cursor: pointer;
}

/*----copy-right-----*/
.copy-right {
  text-align: center;
  padding: 1.5em 0em;
  background: #202020;
}

.copy-right p {
  font-family: 'Sintony', sans-serif;
  color: #FFF;
  font-size: 1em;
  margin: 0em;
  text-transform: uppercase;
}

.copy-right p a {
  color: #42a5f5;
  font-family: 'Sintony', sans-serif;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.copy-right p a:hover {
  color: #fff;
}

/*----start-about-----*/
.about-grid h3 {
  color: #2E2E2E;
  font-size: 1.8em;
  text-transform: uppercase;
  margin: 0em 0em 1em 0em;
  float: left;
  font-weight: 600;
}

.about-grid h5 {
  float: left;
  width: 37.5%;
  background: url(./assets/hd-bg.png) 0% 73% repeat-x;
  display: inline-block;
  padding: 10px;
  height: 15px;
  margin: 0em 0em 0em 1em;
}

.about-grid span {
  font-family: Arial, Helvetica, sans-serif;
  color: #6a6a6a;
  font-size: 1em;
  padding: 5px 0 1px 0;
  line-height: 1.8em;
  font-weight: bold;
  display: block;
}

.about-grid p {
  font-size: 0.9em;
  padding: 0.4em 0 0.5em 0;
  color: #777;
  line-height: 1.9em;
  font-family: 'Sintony', sans-serif;
}

.center-grid1 p {
  padding: 0px 0px 10px 0px;
}

.center-grid1 label {
  font-family: 'Sintony', sans-serif;
  font-size: 14px;
  line-height: 22px;
  text-transform: uppercase;
  color: #42a5f5;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
  cursor: pointer;
}

.center-grid1 label:hover {
  color: #2E2E2E;
}

.about-team-left {
  float: left;
  width: 25%;
}

.about-team-right {
  float: right;
  width: 72%;
}

.about-grid {
  padding: 0px 15px 0px 0px !important;
}

.about-team-right p {
  font-size: 0.9em;
  padding: 0em 0 0.5em 0;
  color: #777;
  line-height: 1.9em;
  font-family: 'Sintony', sans-serif;
}

.client {
  padding-bottom: 10px;
}

.about-grids {
  padding: 10px 0px 0px 0px;
}

.about-team-left img {
  -webkit-filter: grayscale(100%);
  opacity: 5;
  transition: all 300ms !important;
  -webkit-transition: all 300ms !important;
  -moz-transition: all 300ms !important;
}

.about-team-left img:hover {
  opacity: 1;
  -webkit-filter: grayscale(0%);
  cursor: pointer;
}

.button1 {
  font-family: 'Sintony', sans-serif;
  color: #FFF !important;
  font-size: 1em;
  text-transform: uppercase;
  background: #2E2E2E;
  padding: 10px 15px;
  display: inline-block;
  margin: 11px 14px 10px 0px;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.button1:hover {
  background: #42a5f5;
  color: #fff;
}

.holder.smooth {
  padding: 0em 0.6em 0em 0em;
}

/*---services----*/
/*  GRID OF THREE   ============================================================================= */
.section {
  clear: both;
  padding: 0px;
  margin: 0px;
}

.group:before,
.group:after {
  content: "";
  display: table;
}

.group:after {
  clear: both;
}

.group {
  zoom: 1;
}

.listimg {
  display: block;
  float: left;
}

.text {
  display: block;
  float: left;
  margin: 0% 0 0% 3.6%;
}

.listview_1_of_2 {
  margin: 0em 0em 2em 0em;
}

.images_1_of_2 {
  padding: 2.5%;
  box-shadow: 0px 0px 10px rgba(187, 255, 181, 0.26);
  border: 1px solid rgba(192, 192, 192, 0.28);
}

.listimg_2_of_1 {
  width: 30.2%;
}

.list_2_of_1 {
  width: 66.2%;
}

.images_1_of_2 img {
  max-width: 100%;
  display: block;
}

.list_2_of_1 h3 {
  font-family: 'Sintony', sans-serif;
  color: #2E2E2E;
  font-size: 1.5em;
  margin: 0em;
  text-transform: uppercase;
}

.list_2_of_1 p {
  font-size: 0.9em;
  padding: 0.1em 0 0.1em 0;
  color: #777;
  line-height: 1.8em;
  margin: 0.3em 0em;
  font-family: 'Sintony', sans-serif;
}

.list_2_of_1 .button {
  line-height: 1.9em;
  margin-top: 0.5em;
}

.list_2_of_1 .button a {
  font-family: 'Sintony', sans-serif;
  color: #FFF;
  font-size: 1em;
  text-transform: uppercase;
  background: #2E2E2E;
  padding: 5px 15px;
  display: inline-block;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.list_2_of_1 .button a:hover {
  background: #42a5f5;
}

.services h4 {
  font-family: 'Sintony', sans-serif;
  color: #2E2E2E;
  font-size: 1.8em;
  text-transform: uppercase;
  padding: 0px;
  float: left;
  margin: 0em 0em 1.5em 0em;
  font-weight: 600;
}

.services h5 {
  float: right;
  width: 80%;
  background: url(./assets/hd-bg.png) 0% 73% repeat-x;
  display: inline-block;
  padding: 0px;
  height: 15px;
  margin: 0em;
}

.listview_1_of_2 {
  padding: 0px 15px 0px 0px !important;
}

.services {
  margin-bottom: 35px;
}

/*---start-gallery---*/
.gallerys {
  padding-top: 10px;
}

.gallery-grid {
  padding: 0em 1em 0em 0em;
}

.gallerys h3 {
  font-family: 'Sintony', sans-serif;
  color: #2E2E2E;
  font-size: 1.8em;
  text-transform: uppercase;
  margin: 0em 0em 1.5em 0em;
  float: left;
  font-weight: 600;
}

.gallerys h5 {
  float: right;
  width: 80%;
  background: url(./assets/hd-bg.png) 0% 73% repeat-x;
  display: inline-block;
  height: 15px;
  margin-top: 7px;
}

.gallery-grid p {
  font-size: 0.9em;
  padding: 0.1em 0 0.6em 0;
  color: #777;
  line-height: 1.6em;
  font-family: verdana, arial, helvetica, helve, sans-serif;
  font-family: 'Sintony', sans-serif;
}

.gallery-button a {
  font-family: 'Sintony', sans-serif;
  color: #FFF;
  font-size: 1em;
  text-transform: uppercase;
  background: #2E2E2E;
  padding: 9px 15px;
  display: inline-block;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
  display: inline-block;
}

.gallery-button a:hover {
  background: #42a5f5;
  color: #FFF;
}

.gallery-grids {
  margin-bottom: 5em;
}

.projects-bottom-paination ul li {
  display: inline-block;
}

.projects-bottom-paination {
  text-align: center;
  padding-top: 55px;
}

.projects-bottom-paination li a {
  font: 400 12px/1.2em Arial;
  color: #5a5a5a;
  padding: 11px 18px;
  background: #fff;
  text-decoration: none;
  text-shadow: none;
  border: 1px solid #e9e9e9;
  margin-top: 16px;
  font-family: 'Sintony', sans-serif;
}

.projects-bottom-paination li.active > a, .projects-bottom-paination li > a:hover {
  background: #42a5f5;
  color: #fff;
}

.gallery-grid h4 {
  font-family: 'Sintony', sans-serif;
  font-size: 18px;
  line-height: 22px;
  text-transform: uppercase;
  color: #2E2E2E;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
  cursor: pointer;
}

.gallery-grid h4:hover {
  color: #42a5f5;
}

/*  Contact Form  ============================================================================= */
.section {
  clear: both;
  padding: 0px;
  margin: 0px;
}

.group:before,
.group:after {
  content: "";
  display: table;
}

.group:after {
  clear: both;
}

.group {
  zoom: 1;
}

.span_2_of_3 h3,
.span_1_of_3 h3, .contact-form h3 {
  font-family: 'Sintony', sans-serif;
  color: #2E2E2E;
  font-size: 1.8em;
  text-transform: uppercase;
  margin: 0em 0em 1em 0em;
  float: left;
  font-weight: 600;
}

.span_1_of_3 h5, .contact-form h5 {
  float: right;
  width: 75.5%;
  background: url(./assets/hd-bg.png) 0% 73% repeat-x;
  display: inline-block;
  height: 15px;
  margin: 0.2em 0em 0em 0em;
}

.contact_info {
  margin-bottom: 3em;
}

.contact-form {
  position: relative;
  padding-bottom: 30px;
}

.contact-form div {
  padding: 5px 0;
}

.contact-form span {
  display: block;
  font-size: 1em;
  color: #2E2E2E;
  padding-bottom: 5px;
  font-family: 'Sintony', sans-serif;
}

.contact-form input[type="text"], .contact-form textarea {
  padding: 8px;
  display: block;
  width: 98%;
  border: none;
  outline: none;
  color: #464646;
  font-size: 0.8125em;
  font-family: Arial, Helvetica, sans-serif;
  border: 1px solid rgba(192, 192, 192, 0.41);
  -webkit-appearance: none;
}

.contact-form textarea {
  resize: none;
  height: 120px;
}

.contact-form input[type="submit"] {
  font-family: 'Sintony', sans-serif;
  color: #FFF;
  font-size: 1em;
  text-transform: uppercase;
  background: #2E2E2E;
  padding: 12px 20px;
  display: inline-block;
  -webkit-transition: all 0.3s ease-out;
  -moz-transition: all 0.3s ease-out;
  -ms-transition: all 0.3s ease-out;
  -o-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
  display: inline-block;
  border: none;
  outline: none;
  -webkit-appearance: none;
  cursor: pointer;
}

.contact-form input[type="submit"]:hover {
  background: #42a5f5;
}

.contact-form input[type="submit"]:active {
  background: #42a5f5;
}

.company_address p {
  font-size: 0.875em;
  color: #6a6a6a;
  line-height: 1.9em;
  margin: 0px;
}

.company_address p span, .company_address p span a {
  text-decoration: underline;
  color: #454545;
  cursor: pointer;
}

.map {
  margin-bottom: 15px;
}

/*----responsive-design-----*/
@media (max-width: 1366px) {
  .wrap {
    width: 90%;
  }

  .top-nav li a {
    padding: 15px 95.6px;
  }

  .grids h5 {
    width: 84%;
  }

  .recent-places h5 {
    width: 81%;
  }

  .holder {
    width: 23.2%;
  }

  .go-top h3 {
    margin-top: 25px;
  }

  .about-grid h5 {
    width: 34%;
  }
}

@media (max-width: 1280px) {
  .wrap {
    width: 90%;
  }

  .top-nav li a {
    padding: 15px 87.9px;
  }

  .grids h5 {
    width: 84%;
  }

  .recent-places h5 {
    width: 80%;
  }

  .holder {
    width: 23%;
  }

  .about-grid h5 {
    width: 29%;
  }

  .span_1_of_3 h5, .contact-form h5 {
    width: 73.5%;
  }
}

@media (max-width: 1024px) {
  .wrap {
    width: 90%;
  }

  .top-nav li a {
    padding: 15px 64.9px;
  }

  .grids h5 {
    width: 79%;
  }

  .big-b-text p {
    font-size: 1.7em;
  }

  .recent-places h5 {
    width: 74%;
  }

  .holder {
    width: 22.6%;
  }

  .go-top h3 {
    margin-top: 18px;
  }

  .about-grid h5 {
    width: 10%;
  }

  .span_1_of_3 h5, .contact-form h5 {
    width: 66.5%;
  }

  .span_1_of_4 h3 {
    font-size: 1.3em;
  }

  .go-top h3 {
    font-size: 0.9em;
  }

  .go-top p {
    padding: 0;
  }

  .list_2_of_1 h3 {
    font-size: 1.2em;
  }
}

@media (max-width: 768px) {
  .wrap {
    width: 90%;
  }

  .top-nav li a {
    padding: 15px 42.7px;
  }

  .grids h5 {
    width: 72%;
  }

  .big-b-text p {
    font-size: 1.2em;
  }

  .recent-places h5 {
    width: 66%;
  }

  .holder {
    width: 21.8%;
  }

  .go-top h3 {
    margin-top: 6px;
    font-size: 0.8em;
  }

  .span_1_of_3 h5, .contact-form h5 {
    width: 70.5%;
  }

  .span_1_of_4 h3 {
    font-size: 1.3em;
  }

  .go-top h3 {
    font-size: 0.9em;
  }

  .go-top {
    width: 100%;
  }

  .span_1_of_4 {
    width: 20.6%;
  }

  .big-b-btn a {
    font-size: 1.2em;
    padding: 7px 8px;
  }

  .go-top a {
    font-size: 0.7em;
    padding: 5px 12px;
    margin: 5px 0px 14px 0px;
  }

  .footer-grid h3 {
    font-size: 1.2em;
  }

  .about-grid h3 {
    font-size: 1.3em;
  }

  .about-grid h5 {
    margin-top: 0px;
    padding: 0px;
    width: 70% !important;
  }

  .we-do {
    float: left;
    width: 50%;
    margin-bottom: 0.6em;
  }

  .holder.smooth {
    float: left;
    width: 25%;
  }

  .content {
    margin: 4em 0em;
  }

  .big-button {
    margin: 3em 0em 0em 0em;
  }

  .recent-places {
    margin: 3em 0em 0em 0em;
  }

  .footer-grid {
    float: left;
    width: 50%;
    margin-bottom: 2em;
  }

  .about-grid {
    margin-bottom: 2em;
  }

  .go-top {
    width: 95%;
  }

  .services h5 {
    width: 71%;
  }

  .gallery-grids {
    margin-bottom: 0em;
  }

  .gallery-grid {
    margin-bottom: 2em;
  }

  .projects-bottom-paination {
    padding-top: 30px;
  }

  .content {
    margin: 3em 0em;
  }

  .contact-form {
    padding-bottom: 0px;
  }

  .span_1_of_3 {
    margin-bottom: 3em;
  }
}

@media (max-width: 640px) {
  .navbar-header {
    text-align: center !important;
  }

  .navbar-toggle {
    float: none !important;
    margin-right: 0px !important;
    background-color: #42A5F5 !important;
  }

  .navbar-toggle .icon-bar {
    background: #fff !important;
  }

  .top-nav ul li {
    float: none;
    width: 100%;
  }

  .big-b-btn a {
    margin: 0em;
    font-size: 0.9em;
  }

  .big-b-text p {
    font-size: 1.1em;
    margin: 0px;
  }

  .big-b-text span {
    font-size: 0.8em;
  }

  .footer-grid {
    width: 100%;
    margin-bottom: 1.5em;
  }

  .copy-right p {
    font-size: 0.9em;
  }

  .go-top p {
    font-size: 0.7em;
    padding: 0px 5px 0 0;
    margin: 0px;
  }

  .services h5 {
    width: 68%;
  }

  .about-grid h3 {
    font-size: 1.6em;
  }

  .about-grid h5 {
    width: 60% !important;
  }
}

@media (max-width: 480px) {
  .logo a {
    font-size: 2em;
  }

  .top-search-social-nav ul {
    margin: 0.5em 0em 0em 0em;
  }

  .top-search-social-nav ul li a {
    padding: 5px 6px;
    margin: 0px 1px 0px 0px;
    line-height: 1em;
  }

  .content {
    margin: 3em 0em;
  }

  .grids h5 {
    width: 60%;
  }

  .we-do {
    padding: 0em !important;
  }

  .we-do {
    margin-bottom: 1em;
  }

  .big-button {
    margin: 1em 0em 0em 0em;
  }

  .we-do {
    float: none;
    width: 100%;
  }

  .big-b-text {
    float: none;
    width: 100%;
  }

  .big-b-btn {

    float: none;
    width: 32%;
    text-align: center;
    margin: 1.5em auto 0em;
  }

  .big-b-text p {
    font-size: 0.76em;
  }

  .big-b-text span {
    font-size: 0.7em;
  }

  .holder.smooth {
    float: left;
    width: 50%;
    margin: 0em auto 0.8em;
  }

  .recent-places h4 {
    margin: 0em 0em 1em 0em;
  }

  .footer {
    padding: 2.5em 0em;
  }

  .footer-grid h3 {
    font-size: 1.3em;
  }

  .go-top {
    width: 96.5%;
  }

  .go-top h3 {
    margin-top: 25px;
  }

  .listview_1_of_2 {
    padding: 0px 0px 0px 0px !important;
  }

  .list_2_of_1 .button a {
    font-size: 0.85em;
    padding: 2px 12px;
  }

  .list_2_of_1 p {
    font-size: 0.83em;
  }

  .list_2_of_1 h3 {
    font-size: 1.05em;
  }

  .services h5 {
    width: 55%;
  }

  .grids h4 {
    font-size: 1.5em;
    margin: 0em 0em 1em 0em;
  }

  .active-grid h3 {
    font-size: 1.1em;
    margin: 0.2em 0em;
  }

  .recent-places h4 {
    font-size: 1.5em;
  }

  .recent-places {
    margin: 2em 0em 0em 0em;
  }

  .about-grid {
    margin-bottom: 1em;
  }

  .listview_1_of_2 {
    margin: 0em 0em 1em 0em;
  }

  .about-grid h3 {
    font-size: 1.4em;
  }

  .gallerys h5 {
    float: right;
    width: 70%;
  }

  .footer-grid {
    padding: 0px !important;
  }

  .gallery-grid {
    padding: 0px !important;
  }

  .projects-bottom-paination {
    padding-top: 10px;
  }

  .services h4 {
    font-size: 1.5em;
    margin: 0em 0em 1em 0em;
  }

  .gallerys h3 {
    font-size: 1.5em;
    margin: 0em 0em 1em 0em;
  }

  .gallery-grid h4 {
    font-size: 15px;
  }

  .gallery-button a {
    font-size: 0.8em;
    padding: 8px 10px;
  }

  .footer-grid a {
    font-size: 0.85em;
    padding: 5px 10px;
  }

  .span_2_of_3 h3, .span_1_of_3 h3, .contact-form h3 {
    font-size: 1.5em;
  }

  .span_1_of_3 {
    margin-bottom: 1.5em;
    padding: 0px !important;
  }

  .contact_info {
    margin-bottom: 1.5em;
  }

  .span_1_of_3 h5, .contact-form h5 {
    width: 65%;
  }

  .span_2_of_3 {
    padding: 0px !important;
  }

  .contact-form span {
    font-size: 0.85em;
  }

  .about-grid h5 {
    width: 50% !important;
    margin-top: 0.2em;
  }

  .footer-grid p {
    font-size: 0.85em;
  }
}

@media (max-width: 320px) {
  .logo a {
    font-size: 1.7em;
  }

  .top-search-social-nav ul {
    margin: 0.25em 0em 0em 0em;
  }

  .nav > li > a {
    padding: 5px 10px !important;
    font-size: 0.8em !important;
  }

  .content {
    margin: 2em 0em;
  }

  .grids h5 {
    width: 50%;
  }

  .active-grid p {
    margin: 0px;
  }

  .recent-places h5 {
    width: 53%;
  }

  .go-top p {
    font-size: 0.65em;
  }

  .go-top h3 {
    font-size: 0.8em;
    margin-top: 1px;
  }

  .big-b-btn {
    float: none;
    width: 40%;
  }

  .big-b-btn a {
    font-size: 0.75em;
    text-align: center;
  }

  .copy-right p {
    font-size: 0.8em;
  }

  .go-top {
    width: 94%;
  }

  .services h5 {
    width: 40%;
  }

  .list_2_of_1 h3 {
    font-size: 0.9em;
  }

  .list_2_of_1 p {
    font-size: 0.75em;
  }

  .list_2_of_1 .button a {
    font-size: 0.75em;
    padding: 2px 10px;
  }

  .gallerys h5 {
    width: 60%;
  }

  .gallery-grid p {
    font-size: 0.85em;
  }

  .gallery-grid h4 {
    font-size: 15px;
    margin: 0.2em 0em;
  }

  .contact-form span {
    padding-bottom: 0px;
  }

  .span_1_of_3 h5, .contact-form h5 {
    width: 50%;
  }

  .navbar-toggle .icon-bar {
    width: 18px !important;
    height: 1px !important;
  }

  .navbar-toggle {
    padding: 5px 5px !important;
  }

  .big-button {
    padding: 10px;
  }

  .big-b-text p {
    font-size: 0.85em;
  }

  .big-b-text span {
    font-size: 0.65em;
  }

  .about-grid h5 {
    width: 29% !important;
  }
}


html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr,
acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody,
tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header,
hgroup, menu, nav, output, section, summary, time, mark, audio, video {
  margin: 0;

  border: 0
}


/*header*/
.header-line {
  width: 100%;
  height: 4px;
  background: #0dbfdd;
}

/*content*/
.content {


  text-align: center;
}

.content-logo {
  width: 80px;
  height: 80px;
}

.content-title {
  margin: 10px 0 25px 0;
  font-size: 2em;
  color: #747474;
  font-weight: normal;
}

.content-form {
  width: 100%;
  padding: 16px 0 20px;

  text-align: left;
  background: #fff;
}

.content-form form div {
  margin-bottom: 19px;
}

.content-form form .user {
  width: 400px;

  padding: 10px;
  font-size: 1em;
  border: 1px solid #cccbcb;
  border-radius: 7px;
  letter-spacing: 1px;
}

.content-form form .xingbie {
  width: 100px;

  padding: 10px;
  font-size: 1em;
  border: 1px solid #cccbcb;
  border-radius: 7px;
  letter-spacing: 1px;
}

input:focus {
  outline: none;
  -webkit-box-shadow: 0 0 5px #0dbfdd;
  box-shadow: 0 0 5px #0dbfdd;
}

select:focus {
  outline: none;
  -webkit-box-shadow: 0 0 5px #0dbfdd;
  box-shadow: 0 0 5px #0dbfdd;
}

textarea:focus {
  outline: none;
  -webkit-box-shadow: 0 0 5px #0dbfdd;
  box-shadow: 0 0 5px #0dbfdd;
}

.content-form form .password {
  width: 200px;

  padding: 10px;
  font-size: 1em;
  border: 1px solid #cccbcb;
  border-radius: 7px;
  letter-spacing: 1px;
}

.content-form form input:focus {
  outline: none;
  -webkit-box-shadow: 0 0 5px #0dbfdd;
  box-shadow: 0 0 5px #0dbfdd;
}

.content-form-signup {

  margin: 0 auto;
  padding: 10px;
  border: 1px solid #cccbcb;
  border-radius: 7px;
  font-size: 1em;
  font-weight: bold;
  color: #fff;
  background: #943850;
  cursor: pointer;
}

.content-form-signup:hover {
  background: #0cb3d0;
}

.content-form-signup:focus {
  outline: none;
  border: 1px solid #0cb3d0;
}

.content-login-description {
  margin-top: 25px;
  line-height: 1.63636364;
  color: #747474;
  font-size: .91666667rem;
}

.content-login-link {
  font-size: 16px;
  color: #0dbfdd;
  text-decoration: none;
}


#remind_1,
#remind_2 {
  width: 76%;
  margin: 0 auto 2px;
  text-align: left;
  font-size: .2em;
  color: #f00;
}

.fy {
  text-align: center;
  padding-top: 20px
}

.fy a {
  display: inline-block;
  padding: 4px 10px;
  border: 1px solid #f5e703;
  margin: 0 2px;
  color: #d75e15;
  text-decoration: none
}

.fy .ac {
  background: #3c9fee;
  border-color: #83c414;
  color: #fff
}

.fy a:hover {
  background: #FFCC99;
  border-color: #83c414;
  color: #fff
}

.newsline TD {
  LINE-HEIGHT: 25px;
  BORDER-BOTTOM: #c9c9c9 1px dashed;
  text-align: left;
}

.newsline TD A:link {
  COLOR: #000
}

.newsline TD A:visited {
  COLOR: #000
}

.newsline TD A:hover {
  COLOR: #000
}

.newsline TD A:active {
  COLOR: #000
}


.hsgqiehuanshitu {

  margin: 0 auto;
  padding: 10px;
  border: 1px solid #cccbcb;
  border-radius: 7px;
  font-size: 1em;
  font-weight: bold;
  color: #fff;
  background: #545454;
  cursor: pointer;
}

.hsgqiehuanshitu:hover {
  background: #878787;
}

.hsgqiehuanshitu:focus {
  outline: none;
  border: 1px solid #0cb3d0;
}

.container {
  max-width: 1440px;
  font-size: 1em;
}

/* 底栏容器CSS END */
</style>