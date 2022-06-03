import axios from "axios";

axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*';

const baseURL = process.env.VUE_APP_API_BASE_URL;
const target = "api";

export const get = async (url, params) => {
  const { data } = await axios.get(`${baseURL}/${target}${url}${!params ? "" : "?" + convertToParam(params)}`, { withCredentials: true });
  return data;
};

export const post = async (url, body) => {
  const { data } = await axios.post(`${baseURL}/${target}${url}`, body, { withCredentials: true });
  return data;
};

const convertToParam = (params) => {
  let query = "";
  const keys = Object.keys(params);
  for(const key of keys) {
    query += `${key}=${params[key]}`;
  }
  return query;
}