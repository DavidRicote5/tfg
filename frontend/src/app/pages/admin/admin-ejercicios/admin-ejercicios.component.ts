import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Ejercicio } from 'src/app/models/Ejercicio';

@Component({
  selector: 'app-admin-ejercicios',
  templateUrl: './admin-ejercicios.component.html',
  styleUrls: ['./admin-ejercicios.component.css']
})
export class AdminEjerciciosComponent {
  ejercicios: Ejercicio[];

  constructor(private appService: AppService,private router:Router){}

  ngOnInit(): void{
    this.obtenerEjercicios();
  }

  actualizarEjercicio(id:number){
    this.router.navigate(['actualizar-ejercicios',id]);
  }

  eliminarEjercicio(id: number){
    this.appService.eliminarEjercicio(id).subscribe(dato => {
      console.log(dato);
      this.obtenerEjercicios();
    });
  }

  private obtenerEjercicios(){
    this.appService.obtenerEjercicios().subscribe(dato =>{
      this.ejercicios = dato;
    });
  }
}
