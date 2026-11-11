import { http } from "@/utils/http"

export function getList(permissionQuery, params){
	return http({
		url: `/acl/permission/list`,
		method: "get",
		params: params
	})
}
export function saveForm(permissionForm, params){
	return http({
		url: `/acl/permission/save`,
		method: "post",
		params: params
	})
}
