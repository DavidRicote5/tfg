import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EntrenadorService } from 'src/app/services/entrenador.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-quienes-somos',
  templateUrl: './quienes-somos.component.html',
  styleUrls: ['./quienes-somos.component.css']
})
export class QuienesSomosComponent implements OnInit {

  entrenadores:any = [

  ]

  constructor(private entrenadorService:EntrenadorService,private router:Router) { }

  ngOnInit(): void {
    this.entrenadorService.listarEntrenadores().subscribe(
      (dato:any) => {
        this.entrenadores = dato;
      },
      (error) => {
        console.log(error);
        Swal.fire('Advertencia !!','Debes iniciar sesion para ver todo el contenido','error');
        this.router.navigate(['/login']);
      }
    )
  }

 

  

}
