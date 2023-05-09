import { Component, OnInit } from '@angular/core';
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

  constructor(private entrenadorService:EntrenadorService) { }

   ngOnInit(): void {
    this.entrenadorService.listarEntrenadores().subscribe(
      (dato:any) => {
        this.entrenadores = dato;
        console.log(this.entrenadores);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los usuarios','error');
      }
    )
  }

}
