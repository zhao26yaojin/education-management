import service from "@/utils/request"

export function getList(params){
	return service({
		url: `/education/teacher/list`,
		method: "get",
		params: params
	})
}
export function saveForm(data){
	return service({
		url: `/education/teacher/save`,
		method: "post",
		data: data
	})
}
export function getDetail(params){
	return service({
		url: `/education/teacher/detail`,
		method: "get",
		params: params
	})
}
