import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EjercicioService } from 'src/app/services/ejercicio.service';

@Component({
  selector: 'app-add-ejercicio',
  templateUrl: './add-ejercicio.component.html',
  styleUrls: ['./add-ejercicio.component.css']
})
export class AddEjercicioComponent implements OnInit {

  ejercicio = {

    nombre: '',
    descripcion: '',
    grupomuscular: '',
    equiponecesario: ''

  }

  constructor(private ejercicioService: EjercicioService, private snack: MatSnackBar, private router: Router) { }

  ngOnInit(): void {
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
        Swal.fire('Ejercicio agregado', 'La ejercicio ha sido agregada con éxito', 'success');
        this.router.navigate(['/admin/ejercicios']);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al guardar la ejercicio', 'error')
      }
    )
  }
}
