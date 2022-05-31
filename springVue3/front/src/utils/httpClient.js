import axios from "axios";

axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*';

export const get = async (url, body) => {
  const { data } = await axios.get(`http://localhost:8081/api${url}`, body);
  return data;
};

export const post = async (url, body) => {
  const { data } = await axios.post(`http://localhost:8081/api${url}`, body);
  return data;
};
