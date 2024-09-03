<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>首页>> 预约信息列表 >> 预约信息添加 </p>
      </div>
    </div>
    <div class="main">
      <div class="content">
        <el-form label-width="150px" ref="editForm" :model="editForm" :rules="rules">
          <el-form-item label="网点名称" prop="wangdianmingcheng">
            <el-input size="small" v-model="editForm.wangdianmingcheng" auto-complete="off" placeholder="请输入网点名称"
                      style='width:50%' disabled></el-input>
          </el-form-item>
          <el-form-item label="网点联系方式" prop="wangdianlianxifangshi">
            <el-input size="small" v-model="editForm.wangdianlianxifangshi" auto-complete="off"
                      placeholder="请输入网点联系方式" style='width:50%' disabled></el-input>
          </el-form-item>
          <el-form-item label="网点位置" prop="wangdianweizhi">
            <el-input size="small" v-model="editForm.wangdianweizhi" auto-complete="off" placeholder="请输入网点位置"
                      style='width:50%' disabled></el-input>
          </el-form-item>
          <el-form-item label="类型名称" prop="leixingmingcheng">
            <el-input size="small" v-model="editForm.leixingmingcheng" auto-complete="off" placeholder="请输入类型名称"
                      style='width:50%' disabled></el-input>
          </el-form-item>
          <el-form-item label="预约日期" prop="yuyueriqi">
            <el-date-picker type="datetime" value-format="yyyy-MM-dd HH:mm:ss" size="small" v-model="editForm.yuyueriqi"
                            style='width:50%'/>
          </el-form-item>
          <el-form-item label="设备选择" prop="shebeimingcheng">
            <el-select v-model="editForm.shebeimingcheng" @change="fangweima">
              <el-option
                  v-for="item in optionshe"
                  :key="item.shebeimingcheng"
                  :label="item.shebeimingcheng"
                  :value="item.shebeimingcheng"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="防伪码" prop="fangweima">
            <el-input size="small" v-model="editForm.fangweima" auto-complete="off"
                      style='width:50%' disabled></el-input>
          </el-form-item>
          <el-form-item label="备件更换" prop="beijianmingcheng">
            <el-select v-model="selectedItems" multiple>
              <el-option
                  v-for="item in options"
                  :key="item.beijianmingcheng"
                  :label="item.beijianmingcheng"
                  :value="item.beijianmingcheng"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="预计花费" prop="yujihuafei" style="display: none">
            <el-input size="small" v-model="editForm.yujihuafei" auto-complete="off" placeholder="请输入预计花费"
                      style='width:50%'></el-input>
          </el-form-item>
          <el-form-item label="用户名" prop="yonghuming">
            <el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="请输入用户名"
                      style='width:50%'></el-input>
          </el-form-item>


        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加
          </el-button>
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
      wangdianxinxiID: '',
      wangdianxinxi: '',

      rules: {},
      editForm: {
        avater: '',
        wangdianmingcheng: '',
        wangdianlianxifangshi: '',
        wangdianweizhi: '',
        leixingmingcheng: '',
        beijianmingcheng: '',
        wangdianbianhao: ''
      },
      selectedItems: [],
      options: [],
      optionshe: [],
    };
  },
  watch: {
    '$route'(to, from) {
      // 路由发生变化页面刷新
      this.$router.go(0);
    }
  },
  created() {
    if (localStorage.getItem("user")) {
      // 如果已经登录，设置vuex登录状态
      //this.setUser(JSON.parse(localStorage.getItem("user")));
      this.userInfo = JSON.parse(localStorage.getItem("user"));
      this.username = localStorage.getItem("username");
      this.cx = localStorage.getItem("cx");
    }
    this.editForm.yonghuming = this.userInfo.yonghuming;
    let id = this.$route.params.id;
    this.getDetails(id);
  },
  methods: {
    fangweima(value){
      const shebei = this.optionshe.find(item=>item.shebeimingcheng === value);
      this.editForm.fangweima = shebei.fangweima;
    },
    getProjectNum() {
      const projectTime = new Date() // 当前中国标准时间
      const Year = projectTime.getFullYear() // 获取当前年份 支持IE和火狐浏览器.
      const Month = projectTime.getMonth() + 1 // 获取中国区月份
      const Day = projectTime.getDate() // 获取几号
      var CurrentDate = Year
      if (Month >= 10) { // 判断月份和几号是否大于10或者小于10
        CurrentDate += Month
      } else {
        CurrentDate += '0' + Month
      }
      if (Day >= 10) {
        CurrentDate += Day
      } else {
        CurrentDate += '0' + Day
      }
      return CurrentDate
    },
    //qixuzhijixsuan3
    getDetails(id) {
      this.$axios
          .get("/api/front/getwangdianxinxidetail/" + id,)
          .then(res => {
            this.wangdianxinxi = res.data.data;
            this.editForm.wangdianmingcheng = this.wangdianxinxi.wangdianmingcheng;
            this.editForm.wangdianlianxifangshi = this.wangdianxinxi.wangdianlianxifangshi;
            this.editForm.wangdianweizhi = this.wangdianxinxi.wangdianweizhi;
            this.editForm.leixingmingcheng = this.wangdianxinxi.leixingmingcheng;
            this.editForm.wangdianbianhao = this.wangdianxinxi.wangdianbianhao;

            this.editForm.yonghuming = this.username;
            this.option1();
            this.option2(this.username);
          })
          .catch(err => {
            return Promise.reject(err);
          });

    },
    option1() {
      this.$axios
          .get("/api/front/beijianList?wangdianbianhao=" + this.editForm.wangdianbianhao)
          .then(res => {
            this.options = res.data.data
          })
          .catch(err => {
            return Promise.reject(err);
          });
    },
    option2(params) {
      this.$axios
          .get("/api/front/shebeiList?yonghuming=" + params)
          .then(res => {
            console.log(res.data)
            this.optionshe = res.data.data
          })
          .catch(err => {
            return Promise.reject(err);
          });
    },
    submitForm(editData) {
      this.$refs[editData].validate(valid => {
        if (valid) {
          if (this.editForm.id) {
          } else {
            debugger
            this.editForm.beijianmingcheng = this.selectedItems.join(',');
            console.log(this.editForm)

            this.$axios
                .post("/api/front/postyuyuexinxi/", this.editForm)
                .then(res => {
                  if (res.data.code == '0') {
                    //kuabiaogaizhi1
                    this.$message({
                      type: 'success',
                      message: '添加成功！'
                    })
                    this.$router.push({name: 'yuyuexinxi'})
                  } else {
                    this.$message({
                      type: 'info',
                      message: res.msg
                    })
                  }
                }).catch(err => {
              if (err) {
                this.$message.error(err)
              } else {
                this.$message.error('操作失败，请稍后再试！')
              }
            })
          }
        } else {
          return false
        }
      })
    },
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
  width: 640px;
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
