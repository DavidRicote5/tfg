import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Ejercicio } from 'src/app/models/Ejercicio';

@Component({
  selector: 'app-ejercicio',
  templateUrl: './ejercicio.component.html',
  styleUrls: ['./ejercicio.component.css']
})
export class EjercicioComponent {

  ejercicios: Ejercicio[];

  constructor(private appService: AppService,private router:Router){}

  ngOnInit(): void{
    this.obtenerEjercicios();
  }

  actualizarEjercicios(id:number){
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
