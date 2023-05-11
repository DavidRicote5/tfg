import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EntrenadorService } from 'src/app/services/entrenador.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-view-entrenadores',
  templateUrl: './view-entrenadores.component.html',
  styleUrls: ['./view-entrenadores.component.css']
})
export class ViewEntrenadoresComponent implements OnInit {

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
        Swal.fire('Error !!','Error al cargar los usuarios','error');
      }
    )
  }
  actualizarEntrenador(id:number){
    this.router.navigate(['actualizar-entrenador',id]);
  }

}
