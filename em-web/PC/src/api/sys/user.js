import service from "@/utils/request"

export function login(data){
	return service({
		url: `/acl/user/login`,
		method: "post",
		data: data
	})
}
