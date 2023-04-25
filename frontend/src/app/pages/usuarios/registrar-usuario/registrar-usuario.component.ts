import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Usuario } from '../../../models/Usuario';

@Component({
  selector: 'app-registrar-usuario',
  templateUrl: './registrar-usuario.component.html',
  styleUrls: ['./registrar-usuario.component.css']
})
export class RegistrarUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario();
  constructor(private appService: AppService, private router: Router){}

  ngOnInit():void {
    
  }

  guardarUsuario(){
    this.appService.registrarUsuarios(this.usuario).subscribe(dato => {
      console.log(dato);
      this.irListaUsuarios();
    }, error => console.log(error))
  }

  irListaUsuarios(){
    this.router.navigate(['/adminUsuarios']);
  }
  onSubmit(){
    this.guardarUsuario();
  }
}
