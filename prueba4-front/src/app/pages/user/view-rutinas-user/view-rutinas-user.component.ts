import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { RutinaService } from 'src/app/services/rutina.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-rutinas-user',
  templateUrl: './view-rutinas-user.component.html',
  styleUrls: ['./view-rutinas-user.component.css']
})
export class ViewRutinasUserComponent implements OnInit {

  rutinas:any = [

  ]

  constructor(private rutinaService:RutinaService,private router:Router) { }

  ngOnInit(): void {
    this.rutinaService.listarRutinas().subscribe(
      (dato:any) => {
        this.rutinas = dato;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar las rutinas','error');
      }
    )
  }

  actualizarRutina(id:number){
    this.router.navigate(['actualizar-rutina',id]);
  }

  eliminarRutina(rutinaId:any){
    Swal.fire({
      title:'Eliminar rutina',
      text:'¿Estás seguro de eliminar la rutina?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor:'#d33',
      confirmButtonText:'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.rutinaService.eliminarRutina(rutinaId).subscribe(
          (data) => {
            this.rutinas = this.rutinas.filter((rutina:any) => rutina.rutinaId != rutinaId);
            Swal.fire('Rutina eliminada','La rutina ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar la rutina','error');
          }
        )
      }
    })
  }

}
