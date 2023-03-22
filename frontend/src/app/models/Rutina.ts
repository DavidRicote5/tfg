export class Rutina {
    public nombre: string;
    public descripcion: string;
    public dificultad: string;
    public duracion: number;
    

    constructor(nombre: string, descripcion: string, dificultad: string, duracion: number) {
    
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.duracion = duracion;
    }
}
