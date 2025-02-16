import { Trash2 } from 'lucide-react';
import { Button } from '@/components/ui/button';
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
  DialogClose,
} from '@/components/ui/dialog';

import { useUsers } from '@/hooks';
import { User } from '@/types/User';
import { SuccessMessage } from '@/components/utils';

interface DeleteDialogProps {
  user: User;
}

export const DeleteDialog: React.FC<DeleteDialogProps> = ({ user }) => {
  const { mutationDelete } = useUsers();

  const handleDelete = () => {
    mutationDelete.mutate(user.id);
  };

  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button variant='destructive' className='flex items-center justify-center w-full space-x-2'>
          <Trash2 className='h-4 w-4' />
          <span>Eliminar</span>
        </Button>
      </DialogTrigger>
      <DialogContent>
        <DialogHeader className='text-center'>
          <DialogTitle className='text-primary text-2xl'>{user.nombres}</DialogTitle>
        </DialogHeader>

        {mutationDelete.isSuccess ? (
          <SuccessMessage message={`Eliminado con éxito`} />
        ) : (
          <>
            <DialogDescription className='text-center'>
              ¿Está seguro que desea eliminar este usuario? Esta acción no se puede deshacer.
            </DialogDescription>
            <DialogFooter className='flex justify-center space-x-4 mt-4'>
              <DialogClose asChild>
                <Button
                  variant='secondary'
                  className='rounded-xl'
                  disabled={mutationDelete.isPending}
                >
                  Cancelar
                </Button>
              </DialogClose>
              <Button
                className='rounded-xl'
                onClick={handleDelete}
                disabled={mutationDelete.isPending}
                variant='destructive'
              >
                {mutationDelete.isPending ? 'Eliminando...' : 'Eliminar'}
              </Button>
            </DialogFooter>
          </>
        )}
      </DialogContent>
    </Dialog>
  );
};
