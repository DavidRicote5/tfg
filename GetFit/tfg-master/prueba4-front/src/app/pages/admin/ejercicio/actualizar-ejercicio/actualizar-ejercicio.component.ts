import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EjercicioService } from 'src/app/services/ejercicio.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-actualizar-ejercicio',
  templateUrl: './actualizar-ejercicio.component.html',
  styleUrls: ['./actualizar-ejercicio.component.css']
})
export class ActualizarEjercicioComponent implements OnInit {

  constructor(
    private route:ActivatedRoute, 
    private ejercicioService:EjercicioService, 
    private router:Router) { }

    ejercicioId = 0;
    ejercicio:any;
    ejercicios:any;

  ngOnInit(): void {
    this.ejercicioId = this.route.snapshot.params['ejercicioId'];
    this.ejercicioService.obtenerEjercicio(this.ejercicioId).subscribe(
      (data) => {
        this.ejercicio = data;
        console.log(this.ejercicio);
      },
      (error) => {
        console.log(error);
      }
    )
  }

  public actualizarDatos(){
    this.ejercicioService.actualizarEjercicio(this.ejercicio).subscribe(
      (data) => {
        Swal.fire('Ejercicio actualizado','El ejercicio ha sido actualizado con éxito','success').then(
          (e) => {
            this.router.navigate(['/admin/rutinas']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se ha podido actualizar el ejercicio','error');
        console.log(error);
      }
    )

  }

}
