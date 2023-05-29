import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EjercicioService } from 'src/app/services/ejercicio.service';

@Component({
  selector: 'app-add-ejercicio',
  templateUrl: './add-ejercicio.component.html',
  styleUrls: ['./add-ejercicio.component.css']
})
export class AddEjercicioComponent implements OnInit {

  rutinaId:any;
  nombre:any;
  ejercicio:any = {
    rutina : {},
    nombre: '',
    descripcion: '',
    grupomuscular: '',
    equiponecesario: '',
    series:0,
    repeticiones:0,
    peso:0

  }

  constructor(
    private ejercicioService: EjercicioService,
    private snack: MatSnackBar,
    private route:ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.rutinaId = this.route.snapshot.params['rutinaId'];
    this.nombre = this.route.snapshot.params['nombre'];
    this.ejercicio.rutina['rutinaId'] = this.rutinaId;
  }

  formSubmit() {
    if (this.ejercicio.nombre.trim() == '' || this.ejercicio.nombre == null) {
      this.snack.open("El nombre es requerido !!", '', {
        duration: 3000
      })
      return;
    }

    this.ejercicioService.guardarEjercicio(this.ejercicio).subscribe(
      (dato: any) => {
        this.ejercicio.nombre = '';
        this.ejercicio.descripcion = '';
        this.ejercicio.grupomuscular = '';
        this.ejercicio.equiponecesario = '';
        this.ejercicio.series=0;
        this.ejercicio.repeticiones=0;
        this.ejercicio.peso = 0;
        Swal.fire('Ejercicio agregado', 'La ejercicio ha sido agregada con éxito', 'success');
        this.router.navigate(['/admin/ejercicios/'+ this.rutinaId+ '/'+ this.nombre]);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al guardar la ejercicio', 'error')
      }
    )
  }
}
