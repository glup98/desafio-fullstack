import { Button } from '@/components/ui/button';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from '@/components/ui/dialog';
import { Plus } from 'lucide-react';
import { UserForm } from '../forms';

export const CreateUserDialog = () => {
  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button variant='secondary' className='flex items-center justify-center w-full space-x-2 '>
          <Plus className='h-4 w-4' />
          <p className='text-sm'>Nuevo Usuario</p>
        </Button>
      </DialogTrigger>

      <DialogContent>
        <DialogHeader style={{ textAlign: 'center' }}>
          <DialogTitle>Nuevo Usuario</DialogTitle>
        </DialogHeader>
        <UserForm />
      </DialogContent>
    </Dialog>
  );
};
