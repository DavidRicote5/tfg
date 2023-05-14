import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EntrenadorService } from 'src/app/services/entrenador.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-view-entrenadores',
  templateUrl: './view-entrenadores.component.html',
  styleUrls: ['./view-entrenadores.component.css']
})
export class ViewEntrenadoresComponent implements OnInit {

  entrenadores:any = [

  ]

  constructor(private entrenadorService:EntrenadorService,private router:Router) { }

   ngOnInit(): void {
    this.entrenadorService.listarEntrenadores().subscribe(
      (dato:any) => {
        this.entrenadores = dato;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los entrenadores','error');
      }
    )
  }
  actualizarEntrenador(id:number){
    this.router.navigate(['actualizar-entrenador',id]);
  }

  eliminarEntrenador(entrenadorId:any){
    Swal.fire({
      title:'Eliminar entrenador',
      text:'¿Estás seguro de eliminar el entrenador?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor:'#d33',
      confirmButtonText:'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.entrenadorService.eliminarEntrenador(entrenadorId).subscribe(
          (data) => {
            this.entrenadores = this.entrenadores.filter((entrenador:any) => entrenador.entrenadorId != entrenadorId);
            Swal.fire('Entrenador eliminado','El entrenador ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar el entrenador','error');
          }
        )
      }
    })
  }

}
