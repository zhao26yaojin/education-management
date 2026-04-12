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
import { onLoad } from "@dcloudio/uni-app"
import uni from "@dcloudio/vite-plugin-uni"
import { getList as getTeacherList, saveForm as saveTeacherForm } from "@/api/edu/teacher"
import { reactive } from "vue"

const teacherQuery = reactive({})
const teacherList = reactive([])
const onGetTeacherList = () => {
	const { result } = getTeacherList(teacherQuery)
	teacherList.splice(0, teacherList.length)
	if (result && result.length > 0) {
		teacherList.push({spread: result})
	}

}
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
onLoad(() => onGetTeacherList())

</script>
<style scoped>

</style>
