<template>
	<div class="container">
		<div class="sidebar">
			<h5 class="title">education management</h5>
			<el-menu height="100%" background-color="#ffb8e7" active-text-color="#04718" text-color="#fff" router>
			</el-menu>
		</div>
		<router-view>
		</router-view>
	</div>
	<div>
	</div>
</template>
<script setup>


</script>
<style scoped>
.container {
	min-height: 100vh;
	display: flex;
}

.sidebar {
	width: 200px;
	background-color: #ffb8e7;
}

.title {
	height: 50px;
	color: white;
	font-size: 20px;
	text-align: center;
	line-height: 50px;
}


</style>
