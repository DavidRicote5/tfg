export class Entrenador {
    public nombre: string;
    public correo: string;
    public certificaciones: string;
    public especializacion: string;
    public añosExperiencia: string;
    

    constructor(nombre: string, correo: string, certificaciones: string, especializacion: string, añosExperiencia: string) {
    
        this.nombre = nombre;
        this.correo = correo;
        this.certificaciones = certificaciones;
        this.especializacion = especializacion;
        this.añosExperiencia = añosExperiencia;      
    }
}
