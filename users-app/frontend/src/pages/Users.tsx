import { columns, DataTable } from '@/components/users';
import { useUsers } from '@/hooks';

export const Users = () => {
  const { users, isLoading, error } = useUsers();

  if (isLoading) return <p>Cargando...</p>;
  if (error) return <p>Error al cargar usuarios</p>;
  if (users?.length === 0) return <p>No hay usuarios</p>;

  return (
    <div>
      <h1>Lista de Usuarios</h1>
      <div className='container mx-auto py-10'>
        <DataTable columns={columns} data={users ?? []} />
      </div>
    </div>
  );
};
