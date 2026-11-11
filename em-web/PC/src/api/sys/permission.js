import service from "@/utils/request"

export function getRoleTree(params){
	return service({
		url: `/acl/permission/role/tree`,
		method: "get",
		params: params
	})
}
export function getList(params){
	return service({
		url: `/acl/permission/list`,
		method: "get",
		params: params
	})
}
export function saveForm(data){
	return service({
		url: `/acl/permission/save`,
		method: "post",
		data: data
	})
}
