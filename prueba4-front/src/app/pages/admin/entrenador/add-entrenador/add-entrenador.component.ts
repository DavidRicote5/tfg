import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EntrenadorService } from 'src/app/services/entrenador.service';
import { RutinaService } from 'src/app/services/rutina.service';

@Component({
  selector: 'app-add-entrenador',
  templateUrl: './add-entrenador.component.html',
  styleUrls: ['./add-entrenador.component.css']
})
export class AddEntrenadorComponent implements OnInit {

  rutinas:any = [];

  entrenador = {
    nombre : '',
    correo : '',
    especializacion:'',
    anosexperiencia:null,
    rutina:{
      rutinaId:''
    }
  }

  constructor(
    private entrenadorService:EntrenadorService,
    private snack:MatSnackBar,
    private rutinaService:RutinaService,
    private router:Router) { }

  ngOnInit(): void {
    this.rutinaService.listarRutinas().subscribe(
      (dato:any) => {
        this.rutinas = dato;
        console.log(this.rutinas);
      },(error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los datos','error');
      }
    )
  }

  formSubmit(){
    if(this.entrenador.nombre.trim() == '' || this.entrenador.nombre == null){
      this.snack.open("El nombre es requerido !!",'',{
        duration:3000
      })
      return ;
    }

    this.entrenadorService.guardarEntrenador(this.entrenador).subscribe(
      (dato) => {
        Swal.fire('Entrenador agregado','El entrenador ha sido agregada con éxito','success');
        this.entrenador = {
          nombre : '',
          correo : '',
          especializacion : '',
          anosexperiencia : null,
          rutina:{
            rutinaId:''
          }
        }
        this.router.navigate(['/admin/entrenadores']);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al guardar el entrenador','error')
      }
    )
  }
}
