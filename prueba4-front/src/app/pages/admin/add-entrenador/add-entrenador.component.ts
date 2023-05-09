import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EntrenadorService } from 'src/app/services/entrenador.service';

@Component({
  selector: 'app-add-entrenador',
  templateUrl: './add-entrenador.component.html',
  styleUrls: ['./add-entrenador.component.css']
})
export class AddEntrenadorComponent implements OnInit {

  entrenador = {

    nombre : '',
    correo : '',
    especializacion:'',
    anosexperiencia:0

  }

  constructor(private entrenadorService:EntrenadorService,private snack:MatSnackBar,private router:Router) { }

  ngOnInit(): void {
  }

  formSubmit(){
    if(this.entrenador.nombre.trim() == '' || this.entrenador.nombre == null){
      this.snack.open("El nombre es requerido !!",'',{
        duration:3000
      })
      return ;
    }

    this.entrenadorService.guardarEntrenador(this.entrenador).subscribe(
      (dato:any) => {
        this.entrenador.nombre = '';
        this.entrenador.correo = '';
        this.entrenador.especializacion = '';
        this.entrenador.anosexperiencia = 0;
        Swal.fire('Entrenador agregado','El entrenador ha sido agregada con éxito','success');
        this.router.navigate(['/admin/entrenadores']);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al guardar el entrenador','error')
      }
    )
  }
}
