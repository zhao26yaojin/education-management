import service from "@/utils/request"

export function getList(params){
	return service({
		url: `/acl/role/list`,
		method: "get",
		params: params
	})
}
export function deleteByIds(data){
	return service({
		url: `/acl/role/delete`,
		method: "post",
		data: data
	})
}
export function saveForm(data){
	return service({
		url: `/acl/role/save`,
		method: "post",
		data: data
	})
}
export function getDetail(params){
	return service({
		url: `/acl/role/detail`,
		method: "get",
		params: params
	})
}
