import { Component } from '@angular/core';
import { AppService } from '../app.service';
import { Entrenador } from '../models/Entrenador';

@Component({
  selector: 'app-entrenador',
  templateUrl: './entrenador.component.html',
  styleUrls: ['./entrenador.component.css']
})
export class EntrenadorComponent {

  entrenadores: Entrenador[];

  constructor(private appService: AppService){}

  ngOnInit(): void{
    this.obtenerEntrenadores();
  }

  private obtenerEntrenadores(){
    this.appService.obtenerEntrenadores().subscribe(dato =>{
      this.entrenadores = dato;
    });
  }

}
