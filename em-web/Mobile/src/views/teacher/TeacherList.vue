<template>
	<div>
		<u-form :model="teacherQuery">
		</u-form>
		<u-button @click="onGetTeacherList">Query</u-button>
		<u-form ::model="teacherList">
			<u-form-item label="id" prop="id">
				<u-input v-model="id">
				</u-input>
			</u-form-item>
			<u-form-item label="名字" prop="name">
				<u-input v-model="name">
				</u-input>
			</u-form-item>
			<u-form-item label="级别" prop="level">
				<u-input v-model="level">
				</u-input>
			</u-form-item>
			<u-form-item label="头像" prop="avatar">
				<u-input v-model="avatar">
				</u-input>
			</u-form-item>
		</u-form>
	</div>
</template>
<script setup>
import { reactive } from "vue"
import { getList as getTeacherList } from "@/api/edu/teacher"
import { onLoad } from "@dcloudio/uni-app"

const teacherQuery = reactive({})
const teacherList = reactive([])
const onGetTeacherList = () => {
	const { result } = getTeacherList(teacherQuery)
	teacherList.splice(0, teacherList.length)
	if (result && result.length > 0) {
		teacherList.push({spread: result})
	}

}
onLoad(() => onGetTeacherList())

</script>
<style scoped>

</style>
