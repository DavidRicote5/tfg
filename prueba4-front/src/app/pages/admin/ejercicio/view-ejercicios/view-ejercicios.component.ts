import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EjercicioService } from 'src/app/services/ejercicio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-ejercicios',
  templateUrl: './view-ejercicios.component.html',
  styleUrls: ['./view-ejercicios.component.css']
})
export class ViewEjerciciosComponent implements OnInit {

  ejercicios:any = [

  ]

  constructor(private ejercicioService:EjercicioService,private router:Router) { }

   ngOnInit(): void {
    this.ejercicioService.listarEjercicios().subscribe(
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

}