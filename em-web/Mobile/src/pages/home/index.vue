<template>
	<view class="container">
		<view class="header">
			<u-icon name="list" size="50" @click="onMenuIconClick">
			</u-icon>
		</view>
		<TeacherList v-if="selectL2Menu === 'home_teacher'">
		</TeacherList>
		<TeacherEdit v-if="selectL2Menu === 'home_teacher'">
		</TeacherEdit>
		<CourseList v-if="selectL2Menu === 'home_course'">
		</CourseList>
		<SysUserList v-if="selectL2Menu === 'home_sys'">
		</SysUserList>
		<SysUserForm v-if="selectL2Menu === 'home_sys'">
		</SysUserForm>
		<SysRoleList v-if="selectL2Menu === 'home_sys'">
		</SysRoleList>
		<SysRoleForm v-if="selectL2Menu === 'home_sys'">
		</SysRoleForm>
		<SysPermissionList v-if="selectL2Menu === 'home_sys'">
		</SysPermissionList>
		<SysPermissionForm v-if="selectL2Menu === 'home_sys'">
		</SysPermissionForm>
		<Login v-if="selectL2Menu === 'None_'">
		</Login>
		<Register v-if="selectL2Menu === 'None_'">
		</Register>
		<view v-show="showL1Menu" class="menu-container">
			<ul>
				<li>
					<view @click="onL1MenuClick('teacher')">Teacher</view>
				</li>
				<li>
					<view @click="onL1MenuClick('course')">Course</view>
				</li>
				<li>
					<view @click="onL1MenuClick('sys')">Sys</view>
				</li>
			</ul>
		</view>
	</view>
	<view class="container">
		<view class="header">
			<u-icon name="list" size="50" @click="onMenuIconClick">
			</u-icon>
		</view>
		<TeacherList v-if="selectL2Menu === 'home_teacher'">
		</TeacherList>
		<TeacherEdit v-if="selectL2Menu === 'home_teacher'">
		</TeacherEdit>
		<CourseList v-if="selectL2Menu === 'home_course'">
		</CourseList>
		<SysUserList v-if="selectL2Menu === 'home_sys'">
		</SysUserList>
		<SysUserForm v-if="selectL2Menu === 'home_sys'">
		</SysUserForm>
		<SysRoleList v-if="selectL2Menu === 'home_sys'">
		</SysRoleList>
		<SysRoleForm v-if="selectL2Menu === 'home_sys'">
		</SysRoleForm>
		<SysPermissionList v-if="selectL2Menu === 'home_sys'">
		</SysPermissionList>
		<SysPermissionForm v-if="selectL2Menu === 'home_sys'">
		</SysPermissionForm>
		<Login v-if="selectL2Menu === 'None_'">
		</Login>
		<Register v-if="selectL2Menu === 'None_'">
		</Register>
		<view v-show="showL1Menu" class="menu-container">
			<ul>
			</ul>
		</view>
	</view>
	<view class="container">
		<view class="header">
			<u-icon name="list" size="50" @click="onMenuIconClick">
			</u-icon>
		</view>
		<TeacherList v-if="selectL2Menu === 'home_teacher'">
		</TeacherList>
		<TeacherEdit v-if="selectL2Menu === 'home_teacher'">
		</TeacherEdit>
		<CourseList v-if="selectL2Menu === 'home_course'">
		</CourseList>
		<SysUserList v-if="selectL2Menu === 'home_sys'">
		</SysUserList>
		<SysUserForm v-if="selectL2Menu === 'home_sys'">
		</SysUserForm>
		<SysRoleList v-if="selectL2Menu === 'home_sys'">
		</SysRoleList>
		<SysRoleForm v-if="selectL2Menu === 'home_sys'">
		</SysRoleForm>
		<SysPermissionList v-if="selectL2Menu === 'home_sys'">
		</SysPermissionList>
		<SysPermissionForm v-if="selectL2Menu === 'home_sys'">
		</SysPermissionForm>
		<Login v-if="selectL2Menu === 'None_'">
		</Login>
		<Register v-if="selectL2Menu === 'None_'">
		</Register>
		<view v-show="showL1Menu" class="menu-container">
			<ul>
			</ul>
		</view>
	</view>
</template>
<script setup>

const onMenuIconClick = () => {
	selectL1Menu.name.value = ""
}
const onL1MenuClick = () => {
selectL1Menu.name == tag ? selectL1Menu.name = "": selectL1Menu.name = tag}
const onL2MenuClick = () => {
	showL1Menu.name.value = false
}

</script>
<style scoped>
.container {
	position: relative;
}

.header {
	height: 100rpx;
	border-bottom: 2rpx #858a83 solid;
}

.menu-container {
	position: absolute;
	left: 0;
	top: 100rpx;
	width: 320rpx;
	height: 100vh;
	background-color: #f3f3f3;
}


</style>
