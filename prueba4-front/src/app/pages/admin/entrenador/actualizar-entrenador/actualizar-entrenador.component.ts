import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EntrenadorService } from 'src/app/services/entrenador.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-actualizar-entrenador',
  templateUrl: './actualizar-entrenador.component.html',
  styleUrls: ['./actualizar-entrenador.component.css']
})
export class ActualizarEntrenadorComponent implements OnInit {

  constructor(
    private route:ActivatedRoute, 
    private entrenadorService:EntrenadorService, 
    private router:Router) { }

  entrenadorId = 0;
  entrenador:any;
  entrenadores:any;

  ngOnInit(): void {
    this.entrenadorId = this.route.snapshot.params['entrenadorId'];
    this.entrenadorService.obtenerEntrenador(this.entrenadorId).subscribe(
      (data) => {
        this.entrenador = data;
        console.log(this.entrenador);
      },
      (error) => {
        console.log(error);
      }
    )
  }

  public actualizarDatos(){
    this.entrenadorService.actualizarEntrenador(this.entrenador).subscribe(
      (data) => {
        Swal.fire('Entrenador actualizado','El entrenador ha sido actualizado con éxito','success').then(
          (e) => {
            this.router.navigate(['/admin/entrenadores']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se ha podido actualizar el entrenador','error');
        console.log(error);
      }
    )

  }

}
