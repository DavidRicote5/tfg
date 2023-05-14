import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-usuarios',
  templateUrl: './view-usuarios.component.html',
  styleUrls: ['./view-usuarios.component.css']
})
export class ViewUsuariosComponent implements OnInit {

  usuarios:any = [

  ]

  constructor(private userService:UserService) { }

  ngOnInit(): void {
    this.userService.listarUsuarios().subscribe(
      (dato:any) => {
        this.usuarios = dato;
        console.log(this.usuarios);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los usuarios','error');
      }
    )
  }

  /*eliminarUsuario(usuarioId:any){
    Swal.fire({
      title:'Eliminar usuario',
      text:'¿Estás seguro de eliminar el usuario?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor:'#d33',
      confirmButtonText:'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.userService.eliminarUsuario(usuarioId).subscribe(
          (data) => {
            this.usuarios = this.usuarios.filter((usuario:any) => usuario.usuarioId != usuarioId);
            Swal.fire('Usuario eliminado','El usuario ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar el usuario','error');
          }
        )
      }
    })
  }*/

}
