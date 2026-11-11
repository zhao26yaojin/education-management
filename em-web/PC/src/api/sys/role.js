import service from "@/utils/request"

export function getList(params){
	return service({
		url: `/acl/role/list`,
		method: "get",
		params: params
	})
}
export function saveForm(data){
	return service({
		url: `/acl/role/save`,
		method: "post",
		data: data
	})
}
