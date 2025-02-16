import { Pencil } from 'lucide-react';
import { Button } from '@/components/ui/button';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from '@/components/ui/dialog';
import { UserForm } from '../forms';
import { User } from '@/types/User';

interface UpdateUserDialogProps {
  user: User;
}

export const UpdateUserDialog: React.FC<UpdateUserDialogProps> = ({ user }) => {
  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button variant='secondary' className='flex items-center justify-center w-full space-x-2 '>
          <Pencil className='h-4 w-4' />
          <p className='text-sm'>Editar</p>
        </Button>
      </DialogTrigger>

      <DialogContent>
        <DialogHeader style={{ textAlign: 'center' }}>
          <DialogTitle>Editar {user.nombres}</DialogTitle>
        </DialogHeader>
        <UserForm user={user} />
      </DialogContent>
    </Dialog>
  );
};
