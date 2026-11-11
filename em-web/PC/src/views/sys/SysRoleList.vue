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
		<el-table :data="roleList" border>
			<el-table-column prop="name" label="角色名">
			</el-table-column>
			<el-table-column prop="status" label="状态" min-width="60px">
			</el-table-column>
		</el-table>
	</div>
</template>
<script setup>
import { getList as getRoleList } from "@/api/sys/role"
import { onMounted, reactive } from "vue"

const roleQuery = reactive({name: ''})
const roleList = reactive([])
const onGetRoleList = async () => {
	const { result } = await getRoleList(roleQuery)

	roleList.splice(0, roleList.length)

	if (result && result.length > 0) {
		roleList.push(...result)
	}

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
