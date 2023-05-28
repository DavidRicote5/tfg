import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EjercicioService } from 'src/app/services/ejercicio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-ejercicios-user',
  templateUrl: './view-ejercicios-user.component.html',
  styleUrls: ['./view-ejercicios-user.component.css']
})
export class ViewEjerciciosUserComponent implements OnInit {

  rutinaId:any;
  nombre:any;
  ejercicios:any = [

  ];

  constructor(private ejercicioService:EjercicioService,private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.rutinaId = this.route.snapshot.params['rutinaId'];
    this.nombre = this.route.snapshot.params['nombre'];
    this.ejercicioService.listarEjerciciosDeRutina(this.rutinaId).subscribe(
      (dato:any) => {
        this.ejercicios = dato;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los ejercicios','error');
      }
    )
  }

  actualizarEjercicio(id:number){
    this.router.navigate(['actualizar-ejercicio',id]);
  }

  eliminarEjercicio(ejercicioId:any){
    Swal.fire({
      title:'Eliminar ejercicio',
      text:'¿Estás seguro de eliminar el ejercicio?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor:'#d33',
      confirmButtonText:'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.ejercicioService.eliminarEjercicio(ejercicioId).subscribe(
          (data) => {
            this.ejercicios = this.ejercicios.filter((ejercicio:any) => ejercicio.ejercicioId != ejercicioId);
            Swal.fire('Ejercicio eliminado','El ejercicio ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar el ejercicio','error');
          }
        )
      }
    })
  }

}
