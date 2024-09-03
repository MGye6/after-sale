<template>
  <div>

    <div class="wrapper" v-if="cx=='管理员'">
      <div class="left-nav">
        <div id="side-nav">
          <ul id="nav">

            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff1').style.display='block';document.querySelector('#hhh1').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>系统用户管理<i id="hhh1" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff1" class="sub-menu">
                <li>
                  <router-link :to="`/guanliyuan/1`">管理员用户</router-link>
                </li>
                <li>
                  <router-link :to="`/resetPass`">修改密码</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff2').style.display='block';document.querySelector('#hhh2').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>新闻数据管理<i id="hhh2" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff2" class="sub-menu">
                <li>
                  <router-link :to="`/xinwentongzhi/1`">新闻数据设置</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff3').style.display='block';document.querySelector('#hhh3').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>变幻图设置<i id="hhh3" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff3" class="sub-menu">
                <li>
                  <router-link :to="`/bianhuantu/1`">变幻图设置</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff4').style.display='block';document.querySelector('#hhh4').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>留言管理<i id="hhh4" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff4" class="sub-menu">
                <li>
                  <router-link :to="`/liuyanban/1`">留言管理</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff5').style.display='block';document.querySelector('#hhh5').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>用户管理<i id="hhh5" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff5" class="sub-menu">
                <li>
                  <router-link :to="`/yonghuxinxi/1`">用户查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff11').style.display='block';document.querySelector('#hhh11').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>设备管理<i id="hhh11" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff11" class="sub-menu">
                <li>
                  <router-link :to="`/shebeixinxi/1`">设备查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff6').style.display='block';document.querySelector('#hhh6').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>类型管理<i id="hhh6" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff6" class="sub-menu">
                <li>
                  <router-link :to="`/leixingxinxi/1`">类型查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff7').style.display='block';document.querySelector('#hhh7').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>备件管理<i id="hhh7" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff7" class="sub-menu">
                <li>
                  <router-link :to="`/beijianxinxi/1`">备件查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff8').style.display='block';document.querySelector('#hhh8').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>网点管理<i id="hhh8" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff8" class="sub-menu">
                <li>
                  <router-link :to="`/wangdianxinxi/1`">网点查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff9').style.display='block';document.querySelector('#hhh9').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>预约管理<i id="hhh9" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff9" class="sub-menu">
                <li>
                  <router-link :to="`/yuyuexinxi/1`">预约查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff10').style.display='block';document.querySelector('#hhh10').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>社区管理<i id="hhh10" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff10" class="sub-menu">
                <li>
                  <router-link :to="`/shequxinxi/1`">社区查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff12').style.display='block';document.querySelector('#hhh12').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>预约统计<i id="hhh12" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff12" class="sub-menu">
                <li>
                  <router-link :to="`/yuyuexinxi_tj_leixingmingcheng/1`">按类型名称统计</router-link>
                </li>


              </ul>
            </li>
            <!--zxzncd-->

            <!--jisacsicshu-->
            <!--yoxuqiaxntaid-->


          </ul>
        </div>
      </div>
    </div>
    <div class="wrapper" v-if="cx=='用户'">
      <div class="left-nav">
        <div id="side-nav">
          <ul id="nav">

            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff1').style.display='block';document.querySelector('#hhh1').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>个人资料管理<i id="hhh1" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff1" class="sub-menu">
                <li>
                  <router-link :to="`/yonghuxinxi_updt2/1`">修改个人资料</router-link>
                </li>
                <li>
                  <router-link :to="`/resetPass`">修改密码</router-link>
                </li>
              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff5').style.display='block';document.querySelector('#hhh5').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>设备管理<i id="hhh5" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff5" class="sub-menu">
                <li>
                  <router-link :to="`/shebeixinxi/1`">设备查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff2').style.display='block';document.querySelector('#hhh2').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>网点管理<i id="hhh2" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff2" class="sub-menu">
                <li>
                  <router-link :to="`/wangdianxinxi/1`">网点查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff3').style.display='block';document.querySelector('#hhh3').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>预约管理<i id="hhh3" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff3" class="sub-menu">
                <li>
                  <router-link :to="`/yuyuexinxi/1`">预约查询</router-link>
                </li>


              </ul>
            </li>
            <li class="list">
              <a style="cursor:pointer"
                 onclick="javascript:var kk=1;for(kk=1;kk<20;kk++){if(document.querySelector('#fff'+kk)){document.querySelector('#fff'+kk).style.display='none';document.querySelector('#hhh'+kk).innerHTML='&#xe697;';}}document.querySelector('#fff4').style.display='block';document.querySelector('#hhh4').innerHTML='&#xe6a6;';">
                <i class="iconfont">&#xe70b;</i>社区管理<i id="hhh4" class="iconfont nav_right">&#xe697;</i></a>
              <ul id="fff4" class="sub-menu">
                <li>
                  <router-link :to="`/shequxinxi/1`">社区查询</router-link>
                </li>


              </ul>
            </li>

            <!--zxzncd-->
            <!--youxqiaxntaixxinwxen-->
            <!--jisacsicshu-->
            <!--yoxuqiaxntaid-->


          </ul>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import SubItem from '@/layout/navMenu/subItem.vue';
import {Session} from '@/utils/storage';

export default {
  name: 'navMenuVertical',
  components: {SubItem},
  data() {
    return {

      userInfo: {},
      username: '',
      cx: '',

    };
  },
  props: {
    menuList: {
      type: Array,
      default() {
        return [];
      },
    },
  },
  data() {
    return {
      defaultActive: this.$route.path,
    };
  },
  created() {
    this.initUserInfo();

  },

  computed: {
    // 获取布局配置信息
    getThemeConfig() {
      return this.$store.state.themeConfig.themeConfig;
    },
    // 设置左侧菜单是否展开/收起
    setIsCollapse() {
      return document.body.clientWidth < 1000 ? false : this.$store.state.themeConfig.themeConfig.isCollapse;
    },
  },
  methods: {
    // logo 点击实现菜单展开/收起

    initUserInfo() {

      if (!Session.get('userInfo')) return false;
      this.userInfo = Session.get('userInfo');
      this.username = localStorage.getItem("username");
      this.cx = localStorage.getItem("cx");
      this.userInfo.time = formatDate(new Date(this.userInfo.time), 'YYYY-mm-dd HH:MM:SS');
    },
  },
  watch: {
    // 监听路由的变化
    $route: {
      handler(to) {
        this.defaultActive = to.path;
        const clientWidth = document.body.clientWidth;
        if (clientWidth < 1000) this.$store.state.themeConfig.themeConfig.isCollapse = false;
      },
      deep: true,
    },
  },
};
</script>
<style scoped lang="scss">
@import "../../images/css/font.css";
@import "../../images/css/xadmin.css";
@import "../../images/hsg3.css";

</style>
