import { columns, UserDataTable } from '@/components/users';
import { CreateUserDialog } from '@/components/users/dialogs/CreateUserDialog';
import { useUsers } from '@/hooks';

export const Users = () => {
  const { users, isLoading, error } = useUsers();

  if (isLoading) return <p>Cargando...</p>;
  if (error) return <p>Error al cargar usuarios</p>;

  return (
    <div className='container mx-auto py-10'>
      <div className='flex justify-center mb-6'>
        <img
          src='/previred-logo.png'
          alt='Previred Logo'
          width={200}
          height={60}
          className='object-contain'
        />
      </div>

      <UserDataTable
        title='Mantenedor de Usuarios'
        columns={columns}
        data={users ?? []}
        createButton={<CreateUserDialog />}
      />
    </div>
  );
};
