import { http } from "@/utils/http"

export function getList(userQuery, params){
	return http({
		url: `/acl/user/list`,
		method: "get",
		params: params
	})
}
export function saveForm(userForm, params){
	return http({
		url: `/acl/user/save`,
		method: "post",
		params: params
	})
}
