import service from "@/utils/request"

export function getRoleTree(params){
	return service({
		url: `/acl/permission/role/tree`,
		method: "get",
		params: params
	})
}
