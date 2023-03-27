export class Ejercicio {
    public nombre: string;
    public descripcion: string;
    public grupoMuscular: string;
    public equipoNecesario: string;;

    constructor(nombre: string, descripcion: string, grupoMuscular: string, equipoNecesario: string) {
    
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.grupoMuscular = grupoMuscular;
        this.equipoNecesario = equipoNecesario;

    }
}
