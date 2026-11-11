<template>
	<div>
		<u-form :model="userQuery">
		</u-form>
		<u-button @click="onGetUserList">Query</u-button>
		<u-form ::model="userList">
			<u-form-item label="id" prop="id">
				<u-input v-model="id">
				</u-input>
			</u-form-item>
			<u-form-item label="用户名" prop="name">
				<u-input v-model="name">
				</u-input>
			</u-form-item>
			<u-form-item label="密码" prop="password">
				<u-input v-model="password">
				</u-input>
			</u-form-item>
			<u-form-item label="性别" prop="gender">
				<u-input v-model="gender">
				</u-input>
			</u-form-item>
			<u-form-item label="邮箱" prop="email">
				<u-input v-model="email">
				</u-input>
			</u-form-item>
			<u-form-item label="手机" prop="phone">
				<u-input v-model="phone">
				</u-input>
			</u-form-item>
			<u-form-item label="状态" prop="status">
				<u-input v-model="status">
				</u-input>
			</u-form-item>
			<u-form-item label="逻辑删除" prop="deleted">
				<u-input v-model="deleted">
				</u-input>
			</u-form-item>
		</u-form>
	</div>
</template>
<script setup>
import { onLoad } from "@dcloudio/uni-app"
import { getList as getUserList } from "@/api/sys/user"
import { reactive } from "vue"

const userQuery = reactive({})
const userList = reactive([])
const onGetUserList = () => {
	const { result } = getUserList(userQuery)

	userList.splice(0, userList.length)

	if (result && result.length > 0) {
		userList.push({spread: result})
	}

}
onLoad(() => onGetUserList())

</script>
<style scoped>

</style>
