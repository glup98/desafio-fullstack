import axios from "axios";
import { User } from "../types/User";

const API_URL = "http://localhost:8080/api/v1/users";

export const getUsers = async (): Promise<User[]> => {
  const response = await axios.get(API_URL);
  return response.data;
};

export const getUserById = async (id: string): Promise<User> => {
  const response = await axios.get(`${API_URL}/${id}`);
  return response.data;
};

export const createUser = async (user: Partial<User>) => {
  const response = await axios.post(API_URL, user);
  return response.data;
};

export const updateUser = async (id: string, user: Partial<User>) => {
  const response = await axios.put(`${API_URL}/${id}`, user);
  return response.data;
};

export const deleteUser = async (id: string) => {
  await axios.delete(`${API_URL}/${id}`);
};
