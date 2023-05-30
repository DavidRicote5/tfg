import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RutinaService } from 'src/app/services/rutina.service';

@Component({
  selector: 'app-add-rutina',
  templateUrl: './add-rutina.component.html',
  styleUrls: ['./add-rutina.component.css']
})
export class AddRutinaComponent implements OnInit {
  rutina = {

    nombre: '',
    descripcion: '',
    dificultad: '',
    duracion: null

  }

  constructor(private rutinaService: RutinaService, private snack: MatSnackBar, private router: Router) { }

  ngOnInit(): void {
  }

  formSubmit() {
    if (this.rutina.nombre.trim() == '' || this.rutina.nombre == null) {
      this.snack.open("El nombre es requerido !!", '', {
        duration: 3000
      })
      return;
    }

    this.rutinaService.guardarRutina(this.rutina).subscribe(
      (dato: any) => {
        this.rutina.nombre = '';
        this.rutina.descripcion = '';
        this.rutina.dificultad = '';
        this.rutina.duracion = null;
        Swal.fire('Rutina agregada', 'La rutina ha sido agregada con éxito', 'success');
        this.router.navigate(['/admin/rutinas']);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al guardar la rutina', 'error')
      }
    )
  }
}
