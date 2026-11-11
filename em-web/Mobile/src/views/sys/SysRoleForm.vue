<template>
	<div>
	</div>
	<view>
		<u-form :model="roleForm">
			<u-form-item label="id" prop="roleForm.id">
				<u-input v-model="roleForm.id">
				</u-input>
			</u-form-item>
			<u-form-item label="角色名" prop="roleForm.name">
				<u-input v-model="roleForm.name">
				</u-input>
			</u-form-item>
			<u-form-item label="状态" prop="roleForm.status">
				<u-input v-model="roleForm.status">
				</u-input>
			</u-form-item>
		</u-form>
		<u-button @click="onSaveRoleForm">Save</u-button>
	</view>
</template>
<script setup>
import uni from "@dcloudio/vite-plugin-uni"
import { saveForm as saveRoleForm } from "@/api/sys/role"
import { reactive } from "vue"

const roleForm = reactive({
	id: '',
	name: '',
	status: ''
})
const onSaveRoleForm = () => {
	const { result } = saveRoleForm(roleForm)

	uni.showToast({
		icon: "success",
		title: "保存成功"
	})
}

</script>
<style scoped>

</style>
