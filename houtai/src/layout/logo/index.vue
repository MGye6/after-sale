<template>

	<div class="container">
		<div class="logo">{{ getThemeConfig.globalTitle }}</div>
		<div class="open-nav"><i class="iconfont"></i></div>
		<ul class="layui-nav right" lay-filter="">
			<br>
			<li class="layui-nav-item" style="padding-right: 30px;">当前用户：{{username}}</li>

		</ul>
	</div>

</template>

<script>
import {recommendList} from "../../views/home/mock";
import { Session } from '@/utils/storage';
export default {
	name: 'layoutLogo',
	data() {
		return {

			userInfo: {},
			username:'',
			cx:'',

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
		// 设置 logo 是否显示
		setShowLogo() {
			let { isCollapse, layout } = this.$store.state.themeConfig.themeConfig;
			return !isCollapse || layout === 'classic' || document.body.clientWidth < 1000;
		},
	},
	methods: {
		// logo 点击实现菜单展开/收起
		onThemeConfigChange() {
			if (this.$store.state.themeConfig.themeConfig.layout === 'transverse') return false;
			this.$store.state.themeConfig.themeConfig.isCollapse = !this.$store.state.themeConfig.themeConfig.isCollapse;
		},
		initUserInfo() {
debugger
			if (!Session.get('userInfo')) return false;
			this.userInfo = Session.get('userInfo');
			this.username=localStorage.getItem("username");
			this.cx=localStorage.getItem("cx");
			this.userInfo.time = formatDate(new Date(this.userInfo.time), 'YYYY-mm-dd HH:MM:SS');
		},
	},
};
</script>

<style scoped lang="scss">
	@import "../../images/css/font.css";
	@import "../../images/css/xadmin.css";
	@import "../../images/hsg3.css";

</style>
