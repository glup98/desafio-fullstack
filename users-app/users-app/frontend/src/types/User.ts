export interface User {
  id: string;
  nombres: string;
  apellidos: string;
  rut: string;
  fechaNacimiento: string;
  correoElectronico: string;
  contrasena: string;
  creadoEn?: string;
  actualizadoEn?: string;
}
