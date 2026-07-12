import service from "@/utils/request"

export function getList(params){
	return service({
		url: `/acl/menu/list`,
		method: "get",
		params: params
	})
}
