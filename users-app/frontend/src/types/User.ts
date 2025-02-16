export interface User {
  id: string;
  nombres: string;
  apellidos: string;
  rut: number;
  fechaNacimiento: string;
  correoElectronico: string;
  creadoEn?: string;
  actualizadoEn?: string;
}
