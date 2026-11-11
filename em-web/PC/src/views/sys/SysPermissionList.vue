<template>
	<div class="frame">
		<el-form :inline="true" :model="permissionQuery" class="form-inline">
			<el-form-item label="权限名">
				<el-input v-model="permissionQuery.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="权限类型: menu/operation">
				<el-input v-model="permissionQuery.type" placeholder="type" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onGetPermissionList">Query</el-button>
			</el-form-item>
		</el-form>
		<el-table :data="permissionList" border>
			<el-table-column prop="name" label="权限名">
			</el-table-column>
			<el-table-column prop="type" label="权限类型: menu/operation">
			</el-table-column>
			<el-table-column prop="parentId" label="父级id" min-width="60px">
			</el-table-column>
			<el-table-column prop="pidPath" label="路径编码">
			</el-table-column>
			<el-table-column prop="path" label="路由">
			</el-table-column>
			<el-table-column prop="component" label="组件路径">
			</el-table-column>
		</el-table>
	</div>
</template>
<script setup>
import { getList as getPermissionList } from "@/api/sys/permission"
import { onMounted, reactive } from "vue"

const permissionQuery = reactive({
	name: '',
	type: ''
})
const permissionList = reactive([])
const onGetPermissionList = async () => {
	const { result } = await getPermissionList(permissionQuery)

	permissionList.splice(0, permissionList.length)

	if (result && result.length > 0) {
		permissionList.push(...result)
	}

}
onMounted(() => onGetPermissionList())

</script>
<style scoped>
.frame {
	width: 800px;
	margin: auto;
	padding-top: 30px;
	padding-bottom: 30px;
}

.form-inline {
}


</style>
