import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-actualizar-usuario',
  templateUrl: './actualizar-usuario.component.html',
  styleUrls: ['./actualizar-usuario.component.css']
})
export class ActualizarUsuarioComponent implements OnInit {

  constructor(
    private route:ActivatedRoute, 
    private usuarioService:UserService, 
    private router:Router) { }

    username = 0;
    usuario:any;
    usuarios:any;

  ngOnInit(): void {
    this.username = this.route.snapshot.params['username'];
    this.usuarioService.obtenerUsuario(this.username).subscribe(
      (data) => {
        this.usuario = data;
        console.log(this.usuario);
      },
      (error) => {
        console.log(error);
      }
    )
  }

  public actualizarDatos(){
    this.usuarioService.actualizarUsuario(this.usuario).subscribe(
      (data) => {
        Swal.fire('Usuario actualizado','El usuario ha sido actualizado con éxito','success').then(
          (e) => {
            this.router.navigate(['/admin/usuarios']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se ha podido actualizar el usuario','error');
        console.log(error);
      }
    )

  }

}
