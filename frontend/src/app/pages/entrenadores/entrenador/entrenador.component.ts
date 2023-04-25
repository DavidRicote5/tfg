import { Component } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Entrenador } from '../../../models/Entrenador';
import { Router } from '@angular/router';

@Component({
  selector: 'app-entrenador',
  templateUrl: './entrenador.component.html',
  styleUrls: ['./entrenador.component.css']
})
export class EntrenadorComponent {

  entrenadores: Entrenador[];

  constructor(private appService: AppService,private router:Router){}

  ngOnInit(): void{
    this.obtenerEntrenadores();
  }

  actualizarEntrenador(id:number){
    this.router.navigate(['actualizar-entrenadores',id]);
  }

  eliminarEntrenador(id: number){
    this.appService.eliminarEntrenador(id).subscribe(dato => {
      console.log(dato);
      this.obtenerEntrenadores();
    });
  }

  private obtenerEntrenadores(){
    this.appService.obtenerEntrenadores().subscribe(dato =>{
      this.entrenadores = dato;
    });
  }

}
