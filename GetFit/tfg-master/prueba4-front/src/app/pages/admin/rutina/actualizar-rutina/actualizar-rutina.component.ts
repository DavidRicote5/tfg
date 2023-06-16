import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RutinaService } from 'src/app/services/rutina.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-actualizar-rutina',
  templateUrl: './actualizar-rutina.component.html',
  styleUrls: ['./actualizar-rutina.component.css']
})
export class ActualizarRutinaComponent implements OnInit {

  constructor(
    private route:ActivatedRoute, 
    private rutinaService:RutinaService, 
    private router:Router) { }

    rutinaId = 0;
    rutina:any;
    rutinas:any;

  ngOnInit(): void {
    this.rutinaId = this.route.snapshot.params['rutinaId'];
    this.rutinaService.obtenerRutina(this.rutinaId).subscribe(
      (data) => {
        this.rutina = data;
        console.log(this.rutina);
      },
      (error) => {
        console.log(error);
      }
    )
  }

  public actualizarDatos(){
    this.rutinaService.actualizarRutina(this.rutina).subscribe(
      (data) => {
        Swal.fire('Rutina actualizada','La rutina ha sido actualizada con éxito','success').then(
          (e) => {
            this.router.navigate(['/admin/rutinas']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se ha podido actualizar la rutina','error');
        console.log(error);
      }
    )

  }

}
