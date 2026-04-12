<template>
	<div>
	</div>
	<view>
		<u-form :model="teacherForm">
			<u-form-item label="id" prop="teacherForm.id">
				<u-input v-model="teacherForm.id">
				</u-input>
			</u-form-item>
			<u-form-item label="名字" prop="teacherForm.name">
				<u-input v-model="teacherForm.name">
				</u-input>
			</u-form-item>
			<u-form-item label="级别" prop="teacherForm.level">
				<u-input v-model="teacherForm.level">
				</u-input>
			</u-form-item>
			<u-form-item label="头像" prop="teacherForm.avatar">
				<u-input v-model="teacherForm.avatar">
				</u-input>
			</u-form-item>
		</u-form>
		<u-button @click="onSaveTeacherForm">Save</u-button>
	</view>
</template>
<script setup>
import uni from "@dcloudio/vite-plugin-uni"
import { saveForm as saveTeacherForm } from "@/api/edu/teacher"
import { reactive } from "vue"

const teacherForm = reactive({
	id: '',
	name: '',
	level: '',
	avatar: ''
})
const onSaveTeacherForm = () => {
	const { result } = saveTeacherForm(teacherForm)
	uni.showToast({
		icon: "success",
		title: "保存成功"
	})
}

</script>
<style scoped>

</style>
