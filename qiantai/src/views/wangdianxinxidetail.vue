<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>首页>> 网点信息列表 >> 网点信息详细 </p>
      </div>
    </div>
    <div class="main">
      <el-card shadow="hover" style="width: 560px; float:left">
        <div class="block">
          <div>
            <img style="height:500px;width: 500px" :src="`/api/`+wangdianxinxidetail.dianmiantupian"/>
          </div>
        </div>
      </el-card>
      <div class="content">
        <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" class="newsline">
          <tr>
            <td width='22%' height=44>网点编号：</td>
            <td width='39%'>{{ wangdianxinxidetail.wangdianbianhao }}</td>
          </tr>
          <tr>
            <td width='22%' height=44>网点名称：</td>
            <td width='39%'>{{ wangdianxinxidetail.wangdianmingcheng }}</td>
          </tr>
          <tr>
            <td width='22%' height=44>网点位置：</td>
            <td width='39%'>{{ wangdianxinxidetail.wangdianweizhi }}</td>
          </tr>
          <tr>
            <td width='22%' height=44>网点联系方式：</td>
            <td width='39%'>{{ wangdianxinxidetail.wangdianlianxifangshi }}</td>
          </tr>
          <tr>

            <td width='22%' height=44>类型名称：</td>
            <td width='39%'>{{ wangdianxinxidetail.leixingmingcheng }}</td>
          </tr>
        </table>
        <div class="button">
          <!--dshoucang1-->
          <el-button class='like' @click='handleEdit()'>我有话说</el-button>
          <el-button class='hsg1' @click='wyyy()'>预约添加</el-button>
        </div>
      </div>
      <el-table size="small" :data="pinglun" highlight-current-row v-loading="loading" border
                element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
        <el-table-column sortable prop="pingfen" label="评分"></el-table-column>
        <el-table-column sortable prop="pinglunneirong" label="评论内容"></el-table-column>
        <el-table-column sortable prop="pinglunren" label="评论人"></el-table-column>
        <el-table-column sortable prop="addtime" label="添加时间" width="160">
          <template slot-scope="scope">
            <div>{{ scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss') }}</div>
          </template>
        </el-table-column>
      </el-table>
      <el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
        <el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
          <el-form-item label="评论内容" prop="pinglunneirong">
            <el-input type="textarea" size="small" v-model="editForm.pinglunneirong" auto-complete="off"
                      placeholder="请输入评论内容" style='width:100%'></el-input>
          </el-form-item>
          <el-form-item label="评分" prop="pingfen">
            <el-radio v-model='editForm.pingfen' label='1'>1</el-radio>
            <el-radio v-model='editForm.pingfen' label='2'>2</el-radio>
            <el-radio v-model='editForm.pingfen' label='3'>3</el-radio>
            <el-radio v-model='editForm.pingfen' label='4'>4</el-radio>
            <el-radio v-model='editForm.pingfen' label='5'>5</el-radio>
          </el-form-item>
          <el-form-item label="表" prop="biao" style="display: none">
            <el-input size="small" v-model="editForm.biao" auto-complete="off" placeholder="请输入表"
                      style='width:50%'></el-input>
          </el-form-item>
          <el-form-item label="表" prop="shujuid" style="display: none">
            <el-input size="small" v-model="editForm.shujuid" auto-complete="off" placeholder="请输入表"
                      style='width:50%'></el-input>
          </el-form-item>
          <el-form-item label="评论人" prop="pinglunren">
            <el-input size="small" v-model="editForm.pinglunren" auto-complete="off" placeholder="请输入评论人"
                      style='width:50%' disabled></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button size="small" @click="closeDialog">取消</el-button>
          <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存
          </el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>

export default {
  data() {
    return {
      dis: false, // 控制“加入购物车按钮是否可用”
      wangdianxinxiID: '',
      wangdianxinxidetail: "", // 商品详细信息
      editFormVisible: false,
      pinglun: "",
      editForm: {
        pingfen: "5",
      },
      total: 0,
      currentPage: 0,
      currentNum: 10,
      current: 1,
      activeName: "-1",
      formInline: {
        page: 1,
        limit: 10,
      },
    };
  },
  watch: {
    '$route'(to, from) {
      // 路由发生变化页面刷新
      this.$router.go(0);
    }
  },
  created() {
    this.wangdianxinxiID = this.$route.params.id;
    let id = this.$route.params.id;
    this.id = id;
    this.getDetails(id);
    this.getpinglun();
  },
  methods: {
    handleEdit: function () {
      if (!this.$store.getters.getUser) {
        this.$store.dispatch("setShowLogin", true);
        return;
      }
      this.editFormVisible = true
      this.title = '添加评论'
      this.editForm.biao = "wangdianxinxi";
      this.editForm.shujuid = this.wangdianxinxiID;
      this.userInfo = JSON.parse(localStorage.getItem("user"));
      this.editForm.pinglunren = localStorage.getItem("username");
    },
    getpinglun() {
      this.$axios
          .post("/api/front/pinglun", {biao: "wangdianxinxi", shujuid: this.wangdianxinxiID})
          .then(res => {

            this.pinglun = res.data.data.list;
            this.currentPage = this.formInline.current
            this.pageSize = this.formInline.currentNum
            this.total = res.data.data.total
          })
          .catch(err => {
            return Promise.reject(err);
          });
    },
    submitForm(editData) {
      this.$refs[editData].validate(valid => {
        if (valid) {

          this.$axios
              .post("/api/front/postpinglun/", this.editForm)
              .then(res => {
                if (res.data.code == '0') {
                  this.editFormVisible = false
                  this.getpinglun();
                  this.$message({
                    type: 'success',
                    message: '评论成功！'
                  })
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

        } else {
          return false
        }
      })
    },
    closeDialog() {
      this.editFormVisible = false
    },
    download(xx) {
      location.href = "http://localhost:9999/" + xx;
    },
    getDetails(val) {
      this.$axios
          .get("/api/front/getwangdianxinxidetail/" + val,)
          .then(res => {
            debugger
            this.wangdianxinxidetail = res.data.data;
          })
          .catch(err => {
            return Promise.reject(err);
          });
    },

    wyyy() {
      if (!this.$store.getters.getUser) {
        this.$store.dispatch("setShowLogin", true);
        return;
      }
      let id = this.$route.params.id;
      this.$router.push('/yuyuexinxiadd/' + id)
    },
    addCollect() {
      if (!this.$store.getters.getUser) {
        this.$store.dispatch("setShowLogin", true);
        return;
      }

      this.$axios
          .post("/api/front/addCollect", {
            userId: this.$store.getters.getUser.id,
            shangpinxinxiID: this.wangdianxinxiID
          })
          .then(res => {
            if (res.data.code == "0") {
              this.notifySucceed(res.data.msg);
            } else {
              this.notifyError(res.data.msg);
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
  padding-top: 30px;
  margin: 0 auto;
}

#details .main .block {
  float: left;
  width: 520px;
  height: 520px;
  padding-right: 20px;
}

#details .main .block:hover {
  transform: scale(0.9);
  -ms-transform: scale(0.9);
}

#details .el-carousel .el-carousel__indicator .el-carousel__button {
  background-color: rgba(163, 163, 163, 0.8);
}

#details .main .content {
  float: left;
  margin-left: 25px;
  width: 50%;
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
  width: 140px;
  background-color: #ff6700;
}

#details .main .content .button .shop-cart:hover {
  background-color: #f25807;
}

#details .main .content .button .hsg1 {
  width: 140px;
  background-color: #4ba3ff;
}

#details .main .content .button .hsg1:hover {
  background-color: #4561ff;
}

#details .main .content .button .like {
  width: 140px;
  margin-left: 40px;
  background-color: #46b273;
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

