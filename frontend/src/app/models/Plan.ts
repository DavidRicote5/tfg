export class Plan {
    public nombre: string;
    public descripcion: string;
    public duracion: number;
    public precio: number;

    constructor(nombre: string, descripcion: string, duracion: number, precio: number) {
    
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
    }
}
