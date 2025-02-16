import { z } from 'zod';

export const userSchema = z.object({
  nombres: z.string().min(3, { message: 'El nombre debe tener al menos 3 caracteres.' }),

  apellidos: z.string().min(3, { message: 'El apellido debe tener al menos 3 caracteres.' }),

  rut: z
    .string()
    .min(3, { message: 'El RUT debe tener al menos 3 caracteres.' })
    .regex(/^\d+-[0-9kK]$/, {
      message: 'El RUT debe tener el formato correcto, por ejemplo: 12345678-9',
    }),

  fechaNacimiento: z.string().refine(
    (value) => {
      const date = new Date(value);
      return !isNaN(date.getTime());
    },
    { message: 'Debe ser una fecha válida.' },
  ),

  correoElectronico: z.string().email({
    message: 'El correo electrónico debe tener un formato válido, por ejemplo: usuario@correo.com',
  }),

  contrasena: z
    .string()
    .min(8, { message: 'La contraseña debe tener al menos 8 caracteres.' })
    .regex(/[A-Z]/, { message: 'La contraseña debe incluir al menos una letra mayúscula.' })
    .regex(/[\W_]/, { message: 'La contraseña debe incluir al menos un símbolo especial.' }),
});
