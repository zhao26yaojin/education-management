import { http } from "@/utils/http"

export function getList(roleQuery, params){
	return http({
		url: `/acl/role/list`,
		method: "get",
		params: params
	})
}
export function saveForm(roleForm, params){
	return http({
		url: `/acl/role/save`,
		method: "post",
		params: params
	})
}
