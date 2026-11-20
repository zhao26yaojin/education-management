<template>
	<div class="frame">
		<el-form :inline="true" :model="roleQuery" class="form-inline">
			<el-form-item label="角色名">
				<el-input v-model="roleQuery.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onGetRoleList">Query</el-button>
			</el-form-item>
		</el-form>
		<el-button type="primary" @click="onAddRole">Add</el-button>
		<el-table :data="roleList" border>
			<el-table-column prop="name" label="角色名">
			</el-table-column>
			<el-table-column prop="status" label="状态" min-width="60px">
			</el-table-column>
			<el-table-column label="Operation" fixed="right">
				<template #default="{ row }">
					<el-button link type="primary" size="small" @click="onEditRole(row)">Edit</el-button>
					<el-button link type="danger" size="small" @click="onDeleteRoleByIds(row)">Delete</el-button>
					<el-button link type="primary" size="small" @click="onAssignRole(row)">Assign</el-button>
				</template>
			</el-table-column>
		</el-table>
	</div>
</template>
<script setup>
import { deleteByIds as deleteRoleByIds, getList as getRoleList } from "@/api/sys/role"
import { onMounted, reactive } from "vue"
import { useRouter } from "vue-router"

const router = useRouter()
const roleQuery = reactive({name: ''})
const roleList = reactive([])
const onGetRoleList = async () => {
	const { result } = await getRoleList(roleQuery)

	roleList.splice(0, roleList.length)

	if (result && result.length > 0) {
		roleList.push(...result)
	}

}
const onAddRole = () => {
	router.push({path: "/sys/roleForm"})
}
const onEditRole = row => {
	router.push({
		path: "/sys/roleForm",
		query: {
			id: row.id
		}
	})
}
const onDeleteRoleByIds = async row => {
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


	await deleteRoleByIds(row.id)

	ElMessage.success("删除成功")

	onGetRoleList()
}
onMounted(() => onGetRoleList())

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
