import { http } from "@/utils/http"

export function getList(teacherQuery, params){
	return http({
		url: `/education/teacher/list`,
		method: "get",
		params: params
	})
}
export function saveForm(teacherForm, params){
	return http({
		url: `/education/teacher/save`,
		method: "post",
		params: params
	})
}
