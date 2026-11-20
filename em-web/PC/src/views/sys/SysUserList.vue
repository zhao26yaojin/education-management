<template>
	<div class="frame">
		<el-form :inline="true" :model="userQuery" class="form-inline">
			<el-form-item label="用户名">
				<el-input v-model="userQuery.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onGetUserList">Query</el-button>
			</el-form-item>
		</el-form>
		<el-button type="primary" @click="onAddUser">Add</el-button>
		<el-table :data="userList" border>
			<el-table-column prop="name" label="用户名">
			</el-table-column>
			<el-table-column prop="password" label="密码">
			</el-table-column>
			<el-table-column prop="gender" label="性别">
			</el-table-column>
			<el-table-column prop="email" label="邮箱">
			</el-table-column>
			<el-table-column prop="phone" label="手机">
			</el-table-column>
			<el-table-column prop="status" label="状态" min-width="60px">
			</el-table-column>
			<el-table-column prop="deleted" label="逻辑删除" min-width="60px">
			</el-table-column>
			<el-table-column label="Operation" fixed="right">
				<template #default="{ row }">
					<el-button link type="primary" size="small" @click="onEditUser(row)">Edit</el-button>
					<el-button link type="danger" size="small" @click="onDeleteUserByIds(row)">Delete</el-button>
				</template>
			</el-table-column>
		</el-table>
	</div>
</template>
<script setup>
import { deleteByIds as deleteUserByIds, getList as getUserList } from "@/api/sys/user"
import { onMounted, reactive } from "vue"
import { useRouter } from "vue-router"

const router = useRouter()
const userQuery = reactive({name: ''})
const userList = reactive([])
const onGetUserList = async () => {
	const { result } = await getUserList(userQuery)

	userList.splice(0, userList.length)

	if (result && result.length > 0) {
		userList.push(...result)
	}

}
const onAddUser = () => {
	router.push({path: "/sys/userForm"})
}
const onEditUser = row => {
	router.push({
		path: "/sys/userForm",
		query: {
			id: row.id
		}
	})
}
const onDeleteUserByIds = async row => {
	try {
		ElMessageBox.confirm("确定删除吗？", "提示", {
			confirmButtonText: "是",
			cancelButtonText: "否",
			type: "warning"
		})
	}


	catch {
		return 
	}


	await deleteUserByIds(row.id)

	ElMessage.success("删除成功")

	onGetUserList()
}
onMounted(() => onGetUserList())

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
