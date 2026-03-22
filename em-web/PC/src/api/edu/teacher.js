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
