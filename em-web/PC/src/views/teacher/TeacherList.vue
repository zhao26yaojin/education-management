<template>
	<div class="frame">
		<el-form :inline="true" :model="teacherQuery" class="form-inline">
			<el-form-item label="id">
				<el-input v-model="teacherQuery.id" placeholder="id" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="名字">
				<el-input v-model="teacherQuery.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="级别">
				<el-input v-model="teacherQuery.level" placeholder="level" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onGetTeacherList">Query</el-button>
			</el-form-item>
		</el-form>
		<el-table :data="teacherList">
			<el-table-column prop="id" label="id">
			</el-table-column>
			<el-table-column prop="name" label="名字">
			</el-table-column>
			<el-table-column prop="level" label="级别">
			</el-table-column>
			<el-table-column prop="avatar" label="头像">
			</el-table-column>
		</el-table>
		<el-form :model="teacherForm" class="form-inline" :inline="true">
			<el-form-item label="id">
				<el-input v-model="teacherForm.id" placeholder="id" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="名字">
				<el-input v-model="teacherForm.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="级别">
				<el-input v-model="teacherForm.level" placeholder="level" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="头像">
				<el-input v-model="teacherForm.avatar" placeholder="avatar" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSaveTeacherForm">Save</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script setup>
import { getList as getTeacherList, saveForm as saveTeacherForm } from "@/api/edu/teacher"
import { onMounted, reactive } from "vue"

const params = reactive({
	id: '',
	name: '',
	level: ''
})
const teacherList = reactive([])
const onGetTeacherList = async () => {
	const { result } = await getTeacherList(params)
	teacherList.splice(0, teacherList.length)
	if (result && result.length > 0) {
		teacherList.push(...result)
	}

}
const data = reactive({
	id: '',
	name: '',
	level: '',
	avatar: ''
})
const onSaveTeacherForm = async () => {
	const { result } = await saveTeacherForm(data)
	const success = result == null
	ElMessage({
		message: success ? "保存成功": result,
		type: success ? "success": "error"
	})
}
onMounted(() => onGetTeacherList())

</script>
<style scoped>
.frame {
	width: 800px;
	margin: auto;
	padding-top: 30px;
}

form-inline {
}


</style>
