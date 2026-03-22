import service from "@/utils/request"

export function getPage(params){
	return service({
		url: `/education/course/page`,
		method: "get",
		params: params
	})
}
