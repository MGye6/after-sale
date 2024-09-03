<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item label=""><el-input size="small" v-model="formInline.wangdianmingcheng" placeholder="������������"></el-input></el-form-item>			<el-form-item label=""><el-input size="small" v-model="formInline.wangdianweizhi" placeholder="��������λ��"></el-input></el-form-item>			<el-form-item styxlexulxie6  prop="leixingmingcheng"><el-select size="small" v-model="formInline.leixingmingcheng" placeholder="��ѡ��"><el-option selected label="��ѡ��" value=""></el-option><el-option v-for="item in leixingxinxis" :key="item.leixingmingcheng" :label="item.leixingmingcheng" :value="item.leixingmingcheng"></el-option></el-select></el-form-item>			
			<el-form-item>
				<el-button size="small" type="primary" icon="el-icon-search" @click="search">����</el-button>
			</el-form-item>
		</el-form>
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="ƴ��������" @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="wangdianbianhao" label="������"></el-table-column>			<el-table-column sortable prop="wangdianmingcheng" label="��������"></el-table-column>			<el-table-column sortable prop="wangdianweizhi" label="����λ��"></el-table-column>			<el-table-column sortable prop="wangdianlianxifangshi" label="������ϵ��ʽ"></el-table-column>			<el-table-column align='center' prop='dianmiantupian' label='����ͼƬ' width='120'><template slot-scope='scope'><el-image :src='scope.row.dianmiantupian' style='height:70px'  v-if="scope.row.dianmiantupian"/><img src="../../../static/images/guanli.jpg" style='height:70px' v-else/></template></el-table-column>			<el-table-column sortable prop="leixingmingcheng" label="��������"></el-table-column>			
			<el-table-column sortable prop="addtime" label="���ʱ��" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>
			
			<el-table-column align="center" label="����" min-width="160">
				<template slot-scope="scope">
					<!--lianjie1-->
				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
		
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { wangdianxinxiList, wangdianxinxiSave, wangdianxinxiDelete,wangdianxinxiEdit,wangdianxinxiDeleteList } from '@/api/wangdianxinxi/wangdianxinxiApi';
import {leixingxinxiAllList} from "@/api/leixingxinxi/leixingxinxiApi";				

import {Session} from "@/utils/storage";
export default {
	name: 'user',
	data() {
		return {
			loading: false, //����ʾ����
			title: '',
			editFormVisible: false, //���Ʊ༭ҳ����ʾ������
			
			editForm: {
			},
			user:[],
			username:'',
			cx:'',
			leixingxinxis:[],				
			rules: {
				
			},
			
			formInline: {
				page: 1,
				limit: 10,
			},
			
			
			listData: [],
			wangdianxinxis:[],
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
				// ·�ɷ����仯ҳ��ˢ��
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
		if(this.userInfo.roles[0] == 'yonghu'){this.formInline.wangdianbianhao= this.username;}		
		this.getdata(this.formInline)
		this.getAllleixingxinxi();				
	},
	methods: {
		getdata(parameter) {
			wangdianxinxiList(parameter)
					.then(res => {
						this.loading = false
						if (res.success == false) {
							this.$message({
								type: 'info',
								message: res.msg
							})
						} else {
							this.listData = res.data.list
							
							// ��ҳ��ֵ
							this.pageparm.currentPage = this.formInline.current
							this.pageparm.pageSize = this.formInline.currentNum
							this.pageparm.total = res.data.total
						}
					})
					.catch(err => {
						this.loading = false
						this.$message.error('�˵�����ʧ�ܣ����Ժ����ԣ�')
					})
		},
		//qixuzhijixsuan3
		// ��ҳ����¼�
		callFather(parm) {
			this.formInline.current = parm.currentPage
			this.getdata(this.formInline)
		},
		//xia2sui1
		// �����¼�
		search() {
			this.getdata(this.formInline)
		},
		//��ʾ�༭����
		
		addSalary(index,row){
				this.$router.push({
					name:'xmkuaixAdd',
					params:{
						id:row.id
					}
				})
			},
		// �༭������ҳ�汣�淽��
		
		// ɾ����˾
		
	
		
		
		getAllleixingxinxi(){leixingxinxiAllList().then(res=>{if(res.code == '0'){this.leixingxinxis = res.data}})},				
		
		// �رձ༭�����ӵ�����
		
	},
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
