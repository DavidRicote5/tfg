import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Entrenador } from '../../../models/Entrenador';

@Component({
  selector: 'app-registrar-entrenador',
  templateUrl: './registrar-entrenador.component.html',
  styleUrls: ['./registrar-entrenador.component.css']
})
export class RegistrarEntrenadorComponent implements OnInit {

  entrenador: Entrenador = new Entrenador();
  constructor(private appService: AppService, private router: Router){}

  ngOnInit():void {
    
  }

  guardarEntrenador(){
    this.appService.registrarEntrenadores(this.entrenador).subscribe(dato => {
      console.log(dato);
      this.irListaEntrenadores();
    }, error => console.log(error))
  }

  irListaEntrenadores(){
    this.router.navigate(['/adminEntrenadores']);
  }
  onSubmit(){
    this.guardarEntrenador();
  }
}
