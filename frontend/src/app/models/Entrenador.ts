export class Entrenador {
    public nombre: string;
    public correo: string;
    public certificaciones: string;
    public especializacion: string;
    public aniosExperiencia: string;
    

    constructor(nombre: string, correo: string, certificaciones: string, especializacion: string, aniosExperiencia: string) {
    
        this.nombre = nombre;
        this.correo = correo;
        this.certificaciones = certificaciones;
        this.especializacion = especializacion;
        this.aniosExperiencia = aniosExperiencia;      
    }
}
