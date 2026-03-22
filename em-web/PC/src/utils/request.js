import axios from "axios"

const service = axios.create({
	baseURL: import.meta.env.VITE_BASE_API
})
const requestSuccess = config => {
	return config
}
const requestError = error => {
	return error
}
service.interceptors.request.use(requestSuccess, requestError)
const responseSuccess = response => {
	return response.data
}
const responseError = error => {
	return Promise.reject(error)
}
service.interceptors.response.use(responseSuccess, responseError)
export default service