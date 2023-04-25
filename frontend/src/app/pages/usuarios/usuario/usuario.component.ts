import { Component } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Usuario } from '../../../models/Usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent {

  usuarios: Usuario[];

  constructor(private appService: AppService,private router:Router){}

  ngOnInit(): void{
    this.obtenerUsuarios();
  }

  actualizarUsuario(id:number){
    this.router.navigate(['actualizar-usuarios',id]);
  }

  eliminarUsuario(id: number){
    this.appService.eliminarUsuario(id).subscribe(dato => {
      console.log(dato);
      this.obtenerUsuarios();
    });
  }

  private obtenerUsuarios(){
    this.appService.obtenerUsuarios().subscribe(dato =>{
      this.usuarios = dato;
    });
  }
}
