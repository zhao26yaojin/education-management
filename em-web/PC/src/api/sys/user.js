import service from "@/utils/request"

export function getLoginInfo(params){
	return service({
		url: `/acl/user/auth/loginInfo`,
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
