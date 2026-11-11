<template>
	<div>
		<u-form :model="permissionQuery">
		</u-form>
		<u-button @click="onGetPermissionList">Query</u-button>
		<u-form ::model="permissionList">
			<u-form-item label="id" prop="id">
				<u-input v-model="id">
				</u-input>
			</u-form-item>
			<u-form-item label="权限名" prop="name">
				<u-input v-model="name">
				</u-input>
			</u-form-item>
			<u-form-item label="权限类型: menu/operation" prop="type">
				<u-input v-model="type">
				</u-input>
			</u-form-item>
			<u-form-item label="父级id" prop="parentId">
				<u-input v-model="parentId">
				</u-input>
			</u-form-item>
			<u-form-item label="路径编码" prop="pidPath">
				<u-input v-model="pidPath">
				</u-input>
			</u-form-item>
			<u-form-item label="路由" prop="path">
				<u-input v-model="path">
				</u-input>
			</u-form-item>
			<u-form-item label="组件路径" prop="component">
				<u-input v-model="component">
				</u-input>
			</u-form-item>
		</u-form>
	</div>
</template>
<script setup>
import { onLoad } from "@dcloudio/uni-app"
import { getList as getPermissionList } from "@/api/sys/permission"
import { reactive } from "vue"

const permissionQuery = reactive({})
const permissionList = reactive([])
const onGetPermissionList = () => {
	const { result } = getPermissionList(permissionQuery)

	permissionList.splice(0, permissionList.length)

	if (result && result.length > 0) {
		permissionList.push({spread: result})
	}

}
onLoad(() => onGetPermissionList())

</script>
<style scoped>

</style>
