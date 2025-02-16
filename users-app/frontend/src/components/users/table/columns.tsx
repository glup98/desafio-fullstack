import { MoreHorizontal } from 'lucide-react';

import { Button } from '@/components/ui/button';
import { ColumnDef } from '@tanstack/react-table';

import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu';

import { User } from '@/types/User';
import { EditDialog } from '../dialogs';
import { DeleteDialog } from '../dialogs/DeleteDialog';

export const columns: ColumnDef<User>[] = [
  {
    accessorKey: 'nombres',
    header: 'Nombres',
  },
  {
    accessorKey: 'apellidos',
    header: 'Apellidos',
  },
  {
    accessorKey: 'rut',
    header: 'rut',
  },
  {
    accessorKey: 'fechaNacimiento',
    header: 'Fecha de nacimiento',
  },
  {
    accessorKey: 'correoElectronico',
    header: 'Correo electrónico',
  },
  {
    id: 'actions',
    cell: ({ row }) => {
      const user = row.original;

      return (
        <DropdownMenu>
          <DropdownMenuTrigger asChild>
            <Button variant='ghost' className='h-8 w-8 p-0'>
              <span className='sr-only'>menu</span>
              <MoreHorizontal className='h-4 w-4' />
            </Button>
          </DropdownMenuTrigger>
          <DropdownMenuContent align='end' className='space-y-2 p-2'>
            <DropdownMenuItem asChild className='p-0'>
              <EditDialog />
            </DropdownMenuItem>
            <DropdownMenuItem asChild className='p-0'>
              <DeleteDialog user={user} />
            </DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
      );
    },
  },
];
