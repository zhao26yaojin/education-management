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
	</div>
</template>
<script setup>
import { getList as getTeacherList } from "@/api/edu/teacher"
import { onMounted, reactive } from "vue"

const teacherQuery = reactive({
	id: '',
	name: '',
	level: ''
})
const teacherList = reactive([])
const onGetTeacherList = async () => {
	const { result } = await getTeacherList(teacherQuery)
	teacherList.splice(0, teacherList.length)
	if (result && result.length > 0) {
		teacherList.push(...result)
	}

}
onMounted(() => onGetTeacherList())

</script>
<style scoped>
.frame {
	width: 800px;
	margin: auto;
	padding-top: 30px;
}

.form-inline {
}


</style>
