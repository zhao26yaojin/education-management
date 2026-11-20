import service from "@/utils/request"

export function getLoginInfo(params){
	return service({
		url: `/acl/user/auth/loginInfo`,
		method: "get",
		params: params
	})
}
export function getList(params){
	return service({
		url: `/acl/user/list`,
		method: "get",
		params: params
	})
}
export function deleteByIds(data){
	return service({
		url: `/acl/user/delete`,
		method: "post",
		data: data
	})
}
export function saveForm(data){
	return service({
		url: `/acl/user/save`,
		method: "post",
		data: data
	})
}
export function getDetail(params){
	return service({
		url: `/acl/user/detail`,
		method: "get",
		params: params
	})
}
export function login(data){
	return service({
		url: `/acl/user/auth/login`,
		method: "post",
		data: data
	})
}
