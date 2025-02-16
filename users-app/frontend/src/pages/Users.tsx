import { columns, UserDataTable } from '@/components/users';
import { CreateUserDialog } from '@/components/users/dialogs/CreateUserDialog';
import { useUsers } from '@/hooks';

export const Users = () => {
  const { users, isLoading, error } = useUsers();

  if (isLoading) return <p>Cargando...</p>;
  if (error) return <p>Error al cargar usuarios</p>;

  return (
    <div>
      <h1>Lista de Usuarios</h1>
      <div className='container mx-auto py-10'>
        <UserDataTable
          title='Mantenedor de Usuarios'
          columns={columns}
          data={users ?? []}
          createButton={<CreateUserDialog />}
        />
      </div>
    </div>
  );
};
