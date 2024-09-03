<template>
	<div class="personal">
		<el-form label-width="100px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="网点名称" prop="wangdianmingcheng"><el-input size="small" v-model="editForm.wangdianmingcheng" auto-complete="off" placeholder="请输入网点名称" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="网点联系方式" prop="wangdianlianxifangshi"><el-input size="small" v-model="editForm.wangdianlianxifangshi" auto-complete="off" placeholder="请输入网点联系方式" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="网点位置" prop="wangdianweizhi"><el-input size="small" v-model="editForm.wangdianweizhi" auto-complete="off" placeholder="请输入网点位置" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="网点类型" prop="wangdianleixing"><el-input size="small" v-model="editForm.wangdianleixing" auto-complete="off" placeholder="请输入网点类型" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="备件名称" prop="beijianmingcheng"><el-input size="small" v-model="editForm.beijianmingcheng" auto-complete="off" placeholder="请输入备件名称" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="花费金额" prop="huafeijine"><el-input size="small" v-model="editForm.huafeijine" auto-complete="off" placeholder="请输入花费金额" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="用户名" prop="yonghuming"><el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="请输入用户名" style='width:50%' disabled></el-input></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加</el-button>
		</div>
	</div>
</template>

<script>
	import {shequxinxiEdit, shequxinxiSave,shequxinxiDetail} from "@/api/shequxinxi/shequxinxiApi";
	import {Session} from "@/utils/storage";
/*import {yuyuexinxixiDetail,yuyuexinxixiEdit} from "../../api/yuyuexinxixi/yuyuexinxixiApi";*/
//xiabiaoduan1
export default {
	name: 'personal',
	data() {
		return {
			rules: {
				//yztssssss1
			},
			editForm: {
				avater:'',
				wangdianmingcheng:'',
				wangdianlianxifangshi:'',
				wangdianweizhi:'',
				wangdianleixing:'',
				beijianmingcheng:'',
				huafeijine:'',
				yonghuming:'',
				
			},
			username:'',
			cx:'',
			//xiabiaoduan2
		};
	},
	created() {
		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
		this.username=localStorage.getItem("username");
		this.cx=localStorage.getItem("cx");
		let id = this.$route.params.id;
		//xiabiaoduan3
		this.getUserInfo(id);
	},
	computed: {
		headers(){
			return {"token":Session.get("token")}
		},
	},
	methods:{
		getUserInfo(id){
			yuyuexinxixiDetail(id).then(res=>{
				if(res.code == '0'){
					this.yuyuexinxixi = res.data
					this.editForm.wangdianmingcheng = this.yuyuexinxixi.wangdianmingcheng;
					this.editForm.wangdianlianxifangshi = this.yuyuexinxixi.wangdianlianxifangshi;
					this.editForm.wangdianweizhi = this.yuyuexinxixi.wangdianweizhi;
					this.editForm.wangdianleixing = this.yuyuexinxixi.wangdianleixing;
					this.editForm.beijianmingcheng = this.yuyuexinxixi.beijianmingcheng;
					this.editForm.huafeijine = this.yuyuexinxixi.huafeijine;
					this.editForm.yonghuming = this.yuyuexinxixi.yonghuming;
				
					this.editForm.wangdianmingcheng= this.userInfo.yonghuming;
					
					
				}
			})
		},
		
		//qixuzhijixsuan3
		//xia2sui1
		// 编辑、增加页面保存方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						
					}else {
						shequxinxiSave(this.editForm).then(res => {
							if (res.code == '0') {
								
								this.$message({
									type: 'success',
									message: '添加成功！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							if(err){
								this.$message.error(err)
							}else {
								this.$message.error('操作失败，请稍后再试！')
							}
						})
					}
				} else {
					return false
				}
			})
		},
		
		//youscwexnjiaxn
		//xiabiaoduan4
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
