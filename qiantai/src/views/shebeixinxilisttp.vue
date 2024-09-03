<template>
  <div class="goods" id="goods" name="goods">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
        <el-breadcrumb-item>设备信息</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="main">
      <div class="list">
        <el-form :inline="true" :model="formInline" class="user-search">
          <el-form-item label="">
            <el-input size="small" v-model="formInline.shebeimingcheng" placeholder="输入设备名称"></el-input>
          </el-form-item>

          <el-form-item>
            <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
          </el-form-item>
        </el-form>
        <shebeixinxilisttp :list="shebeixinxi" v-if="shebeixinxi.length>0"></shebeixinxilisttp>
        <div v-else class="none-product">抱歉没有找到相关的数据</div>
      </div>
      <div class="pagination">
        <el-pagination background layout="prev, pager, next" :current-page="currentPage" :page-size="currentNum"
                       :total="total" @current-change="currentChange"></el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      shebeixinxi: "", // 商品列表
      total: 0, // 商品总量
      currentPage: 0,
      currentNum: 10, // 每页显示的商品数量
      current: 1, //当前页码
      activeName: "-1", // 分类列表当前选中的id
      formInline: {
        page: 1,
        limit: 10,
      },
    };
  },
  created() {
    if (localStorage.getItem("user")) {
      // 如果已经登录，设置vuex登录状态
      //this.setUser(JSON.parse(localStorage.getItem("user")));
      this.userInfo = JSON.parse(localStorage.getItem("user"));
      this.username = localStorage.getItem("username");
      this.cx = localStorage.getItem("cx");
    }
    this.formInline.yonghuming = this.username;
    this.getshebeixinxi(this.formInline);
  },
  activated() {
  },
  methods: {
    currentChange(val) {
      this.formInline.current = val
      this.getshebeixinxi(this.formInline)
    },
    search() {
      this.getshebeixinxi(this.formInline)
    },
    getshebeixinxi(parameter) {
      this.$axios
          .post("/api/front/shebeixinxi", {...parameter})
          .then(res => {
            this.shebeixinxi = res.data.data.list;
            this.currentPage = this.formInline.current
            this.pageSize = this.formInline.currentNum
            this.total = res.data.data.total
          })
          .catch(err => {
            return Promise.reject(err);
          });
    },
  },
};
</script>
<style scoped>
.goods {
  background-color: #f5f5f5;
}

.el-tabs--card .el-tabs__header {
  border-bottom: none;
}

.goods .breadcrumb {
  height: 50px;
  background-color: white;
}

.goods .breadcrumb .el-breadcrumb {
  width: 1225px;
  line-height: 30px;
  font-size: 16px;
  margin: 0 auto;
}

.goods .nav {
  background-color: white;
}

.goods .nav .product-nav {
  width: 1225px;
  height: 40px;
  line-height: 40px;
  margin: 0 auto;
}

.nav .product-nav .title {
  width: 50px;
  font-size: 16px;
  font-weight: 700;
  float: left;
}

.goods .main {
  margin: 0 auto;
  max-width: 1225px;
}

.goods .main .list {
  min-height: 650px;
  padding-top: 14.5px;
  margin-left: -13.7px;
  overflow: auto;
}

.goods .main .pagination {
  height: 50px;
  text-align: center;
}

.goods .main .none-product {
  color: #333;
  margin-left: 13.7px;
}
</style>