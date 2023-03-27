export class Usuario {
    public nombre: string;
    public username: string;
    public contraseña: string;
    public correo: string;
    public fechaNac: string;
    public genero: string;
    public altura: number;
    public peso: number;

    constructor(nombre: string, username: string, contraseña: string, correo: string, fechaNac: string, genero: string, altura: number, peso: number) {
    
        this.nombre = nombre;
        this.username = username;
        this.contraseña = contraseña;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
    }
}
