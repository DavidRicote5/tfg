import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { RutinaService } from 'src/app/services/rutina.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-mis-rutinas-add',
  templateUrl: './mis-rutinas-add.component.html',
  styleUrls: ['./mis-rutinas-add.component.css']
})
export class MisRutinasAddComponent implements OnInit {
  
  usuarioId:any;
  nombre:any;
  rutina = {

    nombre: '',
    descripcion: '',
    dificultad: '',
    duracion: null

  }

  constructor(private rutinaService: RutinaService,private route:ActivatedRoute, private snack: MatSnackBar, private router: Router) { }


  ngOnInit(): void {
    this.usuarioId = this.route.snapshot.params['usuarioId'];
    this.nombre = this.route.snapshot.params['nombre'];
  }

  formSubmit() {
    if (this.rutina.nombre.trim() == '' || this.rutina.nombre == null) {
      this.snack.open("El nombre es requerido !!", '', {
        duration: 3000
      })
      return;
    }

    this.rutinaService.guardarRutinaDeUsuario(this.rutina,this.usuarioId).subscribe(
      (dato: any) => {
        this.rutina.nombre = '';
        this.rutina.descripcion = '';
        this.rutina.dificultad = '';
        this.rutina.duracion = null;
        Swal.fire('Rutina agregada', 'La rutina ha sido agregada con éxito', 'success');
        this.router.navigate(['/user-dashboard/mis-rutinas-view/'+this.usuarioId+'/'+this.nombre]);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al guardar la rutina', 'error')
      }
    )
  }

}
