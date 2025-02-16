import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { getUsers, createUser, deleteUser, updateUser } from '../services/userService';
import { User } from '@/types/User';

export const useUsers = () => {
  const queryClient = useQueryClient();

  const {
    data: users,
    isLoading,
    error,
  } = useQuery({
    queryKey: ['users'],
    queryFn: getUsers,
  });

  const mutationDelete = useMutation({
    mutationFn: deleteUser,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['users'] });
    },
  });

  const mutationCreate = useMutation({
    mutationFn: createUser,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['users'] });
    },
  });

  const mutationUpdate = useMutation({
    mutationFn: ({ id, user }: { id: string; user: Partial<User> }) => updateUser(id, user),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['users'] });
    },
  });

  return { users, isLoading, error, mutationCreate, mutationDelete, mutationUpdate };
};
