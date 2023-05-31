import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RutinaService } from 'src/app/services/rutina.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-mis-rutinas-view',
  templateUrl: './mis-rutinas-view.component.html',
  styleUrls: ['./mis-rutinas-view.component.css']
})
export class MisRutinasViewComponent implements OnInit {

  usuarioId:any;
  nombre:any;
  rutinas:any = [

  ];

  constructor(private rutinaService:RutinaService,private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.usuarioId = this.route.snapshot.params['usuarioId'];
    this.nombre = this.route.snapshot.params['nombre'];
    this.rutinaService.listarRutinasDeUsuario(this.usuarioId).subscribe(
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
    this.router.navigate(['mis-rutinas-actualizar',id]);
  }

  eliminarEjercicio(rutinaId:any){
    Swal.fire({
      title:'Eliminar ejercicio',
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
            Swal.fire('Rutina eliminada','La rutina ha sido eliminada de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar la rutina','error');
          }
        )
      }
    })
  }

}
