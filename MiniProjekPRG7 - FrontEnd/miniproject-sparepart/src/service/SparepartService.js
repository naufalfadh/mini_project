import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/spareparts";

export const listSpareparts = () => axios.get(REST_API_BASE_URL + "/getAllSpareparts");
export const saveSparepart = (sparepat) => axios.post(REST_API_BASE_URL + "/saveSparepart", sparepat);
export const getSparepartById = (id) => axios.get(REST_API_BASE_URL + `/getSparepartById/${id}`);
export const updateSparepart = (sparepat, id) => axios.post(REST_API_BASE_URL + `/updateSparepart/${id}`, sparepat);
export const deleteSparepart = (id) => axios.post(REST_API_BASE_URL + `/deleteSparepart/${id}`);
