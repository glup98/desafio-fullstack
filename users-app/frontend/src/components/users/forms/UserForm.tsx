import { zodResolver } from '@hookform/resolvers/zod';
import { format } from 'date-fns';
import { CalendarIcon } from 'lucide-react';
import { useForm } from 'react-hook-form';
import { z } from 'zod';

import { Button } from '@/components/ui/button';
import { Calendar } from '@/components/ui/calendar';
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from '@/components/ui/form';
import { Popover, PopoverContent, PopoverTrigger } from '@/components/ui/popover';
import { Input } from '@/components/ui/input';
import { userSchema } from '@/schemas';
import { useUsers } from '@/hooks';
import { User } from '@/types/User';
import { SuccessMessage } from '@/components/utils';
import { CalendarCustomCaption } from './CalendarCustomCaption';
import { es } from 'date-fns/locale';

interface UserFormProps {
  user?: User;
}

export const UserForm = ({ user }: UserFormProps) => {
  const { mutationCreate, mutationUpdate } = useUsers();

  const form = useForm<z.infer<typeof userSchema>>({
    resolver: zodResolver(userSchema),
    defaultValues: {
      nombres: user?.nombres || '',
      apellidos: user?.apellidos || '',
      rut: user?.rut || '',
      fechaNacimiento: user?.fechaNacimiento || '',
      correoElectronico: user?.correoElectronico || '',
      contrasena: user?.contrasena || '',
    },
  });

  const onSubmit = (values: z.infer<typeof userSchema>) => {
    if (user) {
      mutationUpdate.mutate(
        {
          id: user.id,
          user: {
            ...values,
            fechaNacimiento: values.fechaNacimiento
              ? new Date(values.fechaNacimiento).toISOString()
              : undefined,
          },
        },
        {
          onSuccess: () => form.reset(),
        },
      );
    } else {
      mutationCreate.mutate(values, {
        onSuccess: () => form.reset(),
      });
    }
  };

  return (
    <>
      {mutationCreate.isSuccess || mutationUpdate.isSuccess ? (
        <SuccessMessage message={`Se ha ${user ? 'actualizado' : 'creado'} exitosamente!`} />
      ) : (
        <Form {...form}>
          <form onSubmit={form.handleSubmit(onSubmit)} className='space-y-6'>
            {/* Nombres */}
            <FormField
              control={form.control}
              name='nombres'
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Nombres</FormLabel>
                  <FormControl>
                    <Input placeholder='Juan' {...field} />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />

            {/* Apellidos */}
            <FormField
              control={form.control}
              name='apellidos'
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Apellidos</FormLabel>
                  <FormControl>
                    <Input placeholder='Pérez' {...field} />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />

            {/* RUT */}
            <FormField
              control={form.control}
              name='rut'
              render={({ field }) => (
                <FormItem>
                  <FormLabel>RUT</FormLabel>
                  <FormControl>
                    <Input placeholder='12345678-9' {...field} />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />

            {/* Fecha de Nacimiento */}
            <FormField
              control={form.control}
              name='fechaNacimiento'
              render={({ field }) => (
                <FormItem className='flex flex-col'>
                  <FormLabel>Fecha de Nacimiento</FormLabel>
                  <Popover>
                    <PopoverTrigger asChild>
                      <FormControl>
                        <Button
                          variant={'outline'}
                          className={`w-full text-left font-normal ${
                            !field.value ? 'text-muted-foreground' : ''
                          }`}
                        >
                          {field.value ? (
                            format(new Date(field.value), 'PPP', { locale: es })
                          ) : (
                            <span>Selecciona una fecha</span>
                          )}
                          <CalendarIcon className='ml-auto h-4 w-4 opacity-50' />
                        </Button>
                      </FormControl>
                    </PopoverTrigger>
                    <PopoverContent className='w-auto p-0' align='start'>
                      <Calendar
                        mode='single'
                        selected={field.value ? new Date(field.value) : undefined}
                        onSelect={(date) => field.onChange(date?.toISOString())}
                        disabled={(date) => date > new Date() || date < new Date('1900-01-01')}
                        initialFocus
                        components={{
                          Caption: CalendarCustomCaption,
                        }}
                        fromYear={1900}
                        toYear={new Date().getFullYear()}
                        locale={es}
                      />
                    </PopoverContent>
                  </Popover>
                  <FormMessage />
                </FormItem>
              )}
            />

            {/* Correo Electrónico */}
            <FormField
              control={form.control}
              name='correoElectronico'
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Correo Electrónico</FormLabel>
                  <FormControl>
                    <Input type='email' placeholder='correo@ejemplo.com' {...field} />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />

            {/* Contraseña */}

            <FormField
              control={form.control}
              name='contrasena'
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Contraseña</FormLabel>
                  <FormControl>
                    <Input type='password' placeholder='********' {...field} />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />

            {(mutationCreate.isError || mutationUpdate.isError) && (
              <p className='text-red-500 text-sm'>
                Error: {mutationCreate.error?.message || mutationUpdate.error?.message}
              </p>
            )}

            {/* Botón de Enviar */}
            <Button
              variant='highlight'
              type='submit'
              disabled={mutationCreate.isPending || mutationUpdate.isPending}
            >
              {user?.id
                ? mutationUpdate.isPending
                  ? 'Actualizando...'
                  : 'Actualizar Usuario'
                : mutationCreate.isPending
                  ? 'Creando...'
                  : 'Crear Usuario'}
            </Button>
          </form>
        </Form>
      )}
    </>
  );
};
