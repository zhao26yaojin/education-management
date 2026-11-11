<template>
	<div>
		<u-form :model="roleQuery">
		</u-form>
		<u-button @click="onGetRoleList">Query</u-button>
		<u-form ::model="roleList">
			<u-form-item label="id" prop="id">
				<u-input v-model="id">
				</u-input>
			</u-form-item>
			<u-form-item label="角色名" prop="name">
				<u-input v-model="name">
				</u-input>
			</u-form-item>
			<u-form-item label="状态" prop="status">
				<u-input v-model="status">
				</u-input>
			</u-form-item>
		</u-form>
	</div>
</template>
<script setup>
import { onLoad } from "@dcloudio/uni-app"
import { getList as getRoleList } from "@/api/sys/role"
import { reactive } from "vue"

const roleQuery = reactive({})
const roleList = reactive([])
const onGetRoleList = () => {
	const { result } = getRoleList(roleQuery)

	roleList.splice(0, roleList.length)

	if (result && result.length > 0) {
		roleList.push({spread: result})
	}

}
onLoad(() => onGetRoleList())

</script>
<style scoped>

</style>
