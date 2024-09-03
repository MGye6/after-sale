<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item label=""><el-input size="small" v-model="formInline.wangdianbianhao" placeholder="输入网点编号"></el-input></el-form-item>			<el-form-item label=""><el-input size="small" v-model="formInline.wangdianmingcheng" placeholder="输入网点名称"></el-input></el-form-item>			<el-form-item label=""><el-input size="small" v-model="formInline.beijianmingcheng" placeholder="输入备件名称"></el-input></el-form-item>			
			<el-form-item>
				<el-button size="small" type="warning" icon="el-icon-search" @click="search">搜索</el-button>
				<el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()" >添加</el-button>
				<el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()" v-if="userInfo.roles[0] == 'guanliyuan'">导出</el-button>
				<el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()" v-if="userInfo.roles[0] == 'guanliyuan'">批量删除</el-button>
				
			</el-form-item>
			<el-form-item>
				<el-upload class="upload-demo" style="float: left; padding-right: 10px;" action='http://localhost:9999/beijianxinxi/upload' :headers='headers' :show-file-list='false' :on-success='handleDaoruSuccess' :before-upload='beforeDaoruUpload' ><el-button size="small" type="info" icon="el-icon-sell" @click="daoru()" v-if="userInfo.roles[0] == 'guanliyuan'">导入</el-button></el-upload>
			</el-form-item>
		</el-form>
		
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="wangdianbianhao" label="网点编号"></el-table-column>			<el-table-column sortable prop="wangdianmingcheng" label="网点名称"></el-table-column>			<el-table-column sortable prop="beijianmingcheng" label="备件名称"></el-table-column>			<el-table-column sortable prop="beijiankucun" label="备件库存"></el-table-column>			<el-table-column sortable prop="beijianjine" label="备件金额"></el-table-column>			
			<el-table-column sortable prop="addtime" label="添加时间" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>
			
			<el-table-column align="center" label="操作" min-width="160">
				<template slot-scope="scope">
					
					<!--liangbuan-->
					<el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan' ">编辑</el-button>
					<el-button size="mini" type="danger" @click="deleteBeijianxinxi(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan' ">删除</el-button>
					
					<!--zhixfuanniu-->
					
				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
		
		<el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
			<el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
				<el-form-item  label='网点编号' prop='wangdianbianhao'><el-select size='small' v-model='editForm.wangdianbianhao' placeholder='请选择网点编号' @change="hsgxia2suiwangdianbianhao"><el-option selected label='请选择网点编号' value=''></el-option><el-option v-for="item in wangdianxinxis" :key="item.wangdianbianhao" :label="item.wangdianbianhao" :value="item.wangdianbianhao"></el-option></el-select></el-form-item>		<el-form-item  label="网点名称" prop="wangdianmingcheng"><el-input size="small" v-model="editForm.wangdianmingcheng" auto-complete="off" placeholder="" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="备件名称" prop="beijianmingcheng"><el-input size="small" v-model="editForm.beijianmingcheng" auto-complete="off" placeholder="请输入备件名称" style='width:50%'></el-input></el-form-item>		<el-form-item  label="备件库存" prop="beijiankucun"><el-input size="small" v-model="editForm.beijiankucun" auto-complete="off" placeholder="请输入备件库存" style='width:50%'></el-input></el-form-item>		<el-form-item  label="备件金额" prop="beijianjine"><el-input-number size="small" v-model="editForm.beijianjine" auto-complete="off" placeholder="请输入备件金额" style='width:50%'></el-input-number></el-form-item>		
				
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeDialog">取消</el-button>
				<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存</el-button>
			</div>
		</el-dialog>
			
			
			<!--xiangxidhk-->
			<!--zhixfudhk-->
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { beijianxinxiList, beijianxinxiSave, beijianxinxiDelete,beijianxinxiEdit,beijianxinxiDeleteList } from '@/api/beijianxinxi/beijianxinxiApi';
import {wangdianxinxiAllList} from "@/api/wangdianxinxi/wangdianxinxiApi";				

import {Session} from "@/utils/storage";
import axios from 'axios';
export default {
	name: 'user',
	data() {
		return {
			loading: false, //是显示加载
			title: '',
			
			editFormVisible: false, //控制编辑页面显示与隐藏
			payVisible: false,
			tempdingdanxinxi: '',
			id: '',
			radio: '',
			//detaitFormVsisisble
			
			
			
			editForm: {
			},
			user:[],
			username:'',
			cx:'',
			wangdianxinxis:[],				
			rules: {
				wangdianbianhao: [{ required: true, message: '请输入网点编号', trigger: 'blur' },				],				beijianmingcheng: [{ required: true, message: '请输入备件名称', trigger: 'blur' },				],				beijianjine: [{ type: 'number', message: '备件金额必须为数字'},				],				
			},
			
			formInline: {
				page: 1,
				limit: 10,
			},
			
			
			listData: [],
			beijianxinxis:[],
			
			checkmenu: [],
			pageparm: {
				currentPage: 1,
				pageSize: 10,
				total: 0
			}
		};
	},
	computed:{
		headers(){
			return {"token":Session.get("token")}
		}
	},
	watch: {
			'$route' (to, from) {
				// 路由发生变化页面刷新
				this.$router.go(0);
			}
		},
	components: {
		Pagination
	},
	created() {
		
		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
		this.username=localStorage.getItem("username");
		this.cx=localStorage.getItem("cx");
		
		this.getdata(this.formInline)
		this.getAllwangdianxinxi();				
	},
	methods: {
		
		//zxhifuff
		handleShenheList(){
				const beijianxinxis = this.beijianxinxis;
				if(beijianxinxis.length == 0){
					this.$message({
						type: 'error',
						message: '请至少选择一项'
					})
				}else {
					this.$confirm('确定要批量审核吗?', '信息', {
						confirmButtonText: '确定',
						cancelButtonText: '取消',
						type: 'warning'
					}).then(() => {
						beijianxinxis.forEach(item=> {
							let data = {...item, issh: 1}
							beijianxinxiEdit(data).then(res => {})
						})
						this.getdata(this.formInline)
						this.$message({
							type: 'success',
							message: '批量审核成功！'
						})
					}).catch(() => {
						this.$message({
							type: 'info',
							message: '已取消批量审核'
						})
					})
				}
			},
		getdata(parameter) {
			beijianxinxiList(parameter)
					.then(res => {
						this.loading = false
						if (res.success == false) {
							this.$message({
								type: 'info',
								message: res.msg
							})
						} else {
							this.listData = res.data.list
							
							
							
							// 分页赋值
							this.pageparm.currentPage = this.formInline.current
							this.pageparm.pageSize = this.formInline.currentNum
							this.pageparm.total = res.data.total
						}
					})
					.catch(err => {
						this.loading = false
						this.$message.error('菜单加载失败，请稍后再试！')
					})
		},
		
		// 分页插件事件
		callFather(parm) {
			this.formInline.current = parm.currentPage
			this.getdata(this.formInline)
		},
		hsgxia2suiwangdianbianhao(){
			let wangdianbianhao = this.editForm.wangdianbianhao;
			this.wangdianxinxis.forEach(item=>{
				if(item.wangdianbianhao == wangdianbianhao){
					this.editForm.wangdianmingcheng = item.wangdianmingcheng					
					
					this.$forceUpdate()
				}
			})
		},
		// 搜索事件
		search() {
			this.getdata(this.formInline)
		},
		//显示编辑界面
		handleEdit: function (index, row) {
			this.editFormVisible = true
			if (row != undefined && row != 'undefined') {
				this.title = '修改备件信息'
				this.editForm = row
			} else {
				this.title = '添加备件信息'
				this.editForm = {}
				
				
				//zixdonxgbianxhao1
			}
		},
		daochu(){
			axios.get('/beijianxinxi/getExcel', {
				responseType: 'blob',
				headers: { token: Session.get("token"), 'Content-Type': 'application/x-download' }
			}).then((res) => {
				if (res.status === 200) {
					var a = document.createElement('a')
					var blob = new Blob([res.data], { type: 'application/vnd.ms-excel' })
					var href = window.URL.createObjectURL(blob)
					a.href = href
					a.download = '备件信息.xlsx'
					document.body.appendChild(a)
					a.click() 
					document.body.removeChild(a) 
					window.URL.revokeObjectURL(href)
				}
			}).catch((err) => {
				console.log(err)
			})
		},
		handleDaoruSuccess(res, file) {
				if(res.code == "0") {
					this.$message({
						type: 'success',
						message: '导入成功!'
					})
					this.getdata(this.formInline);
				}
			},
		beforeDaoruUpload(file) {
			const isJPG = file.type === 'application/vnd.ms-excel';
			if (!isJPG) {
				this.$message.error('上传只能是 excel 格式!');
			}
			return isJPG;
		},
		//zixdonxgbianxhao2
		
		
		//liangbuedit
		// 编辑、增加页面保存方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						beijianxinxiEdit(this.editForm).then(res => {
							this.editFormVisible = false
							
							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '备件信息修改成功！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.editFormVisible = false
							this.loading = false
							this.getdata(this.formInline)
						if(err){
								this.$message.error(err)
							}else {
								this.$message.error('操作失败，请稍后再试！')
							}
						})
					}else {
						beijianxinxiSave(this.editForm).then(res => {
							this.editFormVisible = false
							this.loading = false
							if (res.code == '0') {
								
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '备件信息添加成功！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.editFormVisible = false
							this.loading = false
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
		// 删除公司
		deleteBeijianxinxi(index, row) {
			this.$confirm('确定要删除吗?', '信息', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				beijianxinxiDelete(row.id).then(res => {
					if (res.code == '0') {
						this.$message({
								type: 'success',
							message: '备件信息已删除!'
						})
						this.getdata(this.formInline)
					} else {
						this.$message({
							type: 'info',
							message: res.msg
						})
					}
				}).catch(err => {
					this.loading = false
					this.$message.error('操作失败，请稍后再试')
				})
			}).catch(() => {
				this.$message({
					type: 'info',
					message: '已取消删除'
				})
			})
		},
		handleSelectionChange(val){
			this.beijianxinxis = val;
		},
		handleDeleteList(){
			const beijianxinxis = this.beijianxinxis;
			if(beijianxinxis.length == 0){
				this.$message({
					type: 'error',
					message: '请至少选择一项进行删除'
				})
			}else {
				this.$confirm('确定要批量删除吗?', '信息', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					beijianxinxiDeleteList(beijianxinxis).then(res => {
						if (res.code == '0') {
							this.$message({
								type: 'success',
								message: '批量删除成功!'
							})
							this.getdata(this.formInline)
						} else {
							this.$message({
								type: 'info',
								message: res.msg
							})
						}
					}).catch(err => {
						this.loading = false
						this.$message.error('操作失败，请稍后再试')
					})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					})
				})
			}
		},
		//xuaxnzeshxifou
		
		
		getAllwangdianxinxi(){wangdianxinxiAllList().then(res=>{if(res.code == '0'){this.wangdianxinxis = res.data}})},				
		
		//youscwexnjiaxn
		// 关闭编辑、增加弹出框
		closeDialog() {
			this.getdata(this.formInline)
			this.editFormVisible = false
		}
	},
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
