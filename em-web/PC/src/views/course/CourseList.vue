<template>
	<div class="frame">
		<el-form :inline="true" :model="courseQuery" class="form-inline">
			<el-form-item label="id">
				<el-input v-model="courseQuery.id" placeholder="id" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="名字">
				<el-input v-model="courseQuery.name" placeholder="name" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onGetCoursePage">Query</el-button>
			</el-form-item>
		</el-form>
		<el-table :data="coursePage">
			<el-table-column prop="id" label="id">
			</el-table-column>
			<el-table-column prop="name" label="名字">
			</el-table-column>
			<el-table-column prop="parentId" label="父级id">
			</el-table-column>
		</el-table>
		<div>
			<el-pagination v-model:current-page="courseQuery.current" v-model:page-size="courseQuery.size" layout="prev, pager, next, jumper" :total="courseQuery.total" @current-change="onCoursePageChange">
			</el-pagination>
		</div>
	</div>
</template>
<script setup>
import { reactive, onMounted } from "vue"
import { getPage as getCoursePage } from "@/api/edu/course"

const params = reactive({
	id: '',
	name: ''
})
const coursePage = reactive([])
const onGetCoursePage = async () => {
	const { result } = await getCoursePage(params)
	params.total = result.total
	coursePage.splice(0, coursePage.length)
	if (result.records && result.records.length > 0) {
		coursePage.push(...result)
	}

}
onMounted(() => onGetCoursePage())

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
