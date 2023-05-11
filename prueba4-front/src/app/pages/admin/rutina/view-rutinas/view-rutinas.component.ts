import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RutinaService } from 'src/app/services/rutina.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-rutinas',
  templateUrl: './view-rutinas.component.html',
  styleUrls: ['./view-rutinas.component.css']
})
export class ViewRutinasComponent implements OnInit {

  rutinas:any = [

  ]

  constructor(private rutinaService:RutinaService,private router:Router) { }

   ngOnInit(): void {
    this.rutinaService.listarRutinas().subscribe(
      (dato:any) => {
        this.rutinas = dato;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar las rutinas','error');
      }
    )
  }
  actualizarRutina(id:number){
    this.router.navigate(['actualizar-rutina',id]);
  }

}
