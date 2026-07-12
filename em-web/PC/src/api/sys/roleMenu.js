import service from "@/utils/request"

export function getDetail(params){
	return service({
		url: `/acl/roleMenu/detail`,
		method: "get",
		params: params
	})
}
