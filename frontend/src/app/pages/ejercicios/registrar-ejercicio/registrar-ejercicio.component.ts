import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Ejercicio } from 'src/app/models/Ejercicio';

@Component({
  selector: 'app-registrar-ejercicio',
  templateUrl: './registrar-ejercicio.component.html',
  styleUrls: ['./registrar-ejercicio.component.css']
})
export class RegistrarEjercicioComponent implements OnInit{
  
  ejercicio: Ejercicio = new Ejercicio();
  constructor(private appService: AppService, private router: Router){}

  ngOnInit():void {
    
  }

  guardarEjercicio(){
    this.appService.registrarEjercicios(this.ejercicio).subscribe(dato => {
      console.log(dato);
      this.irListaEjercicios();
    }, error => console.log(error))
  }

  irListaEjercicios(){
    this.router.navigate(['/adminEjercicios']);
  }
  onSubmit(){
    this.guardarEjercicio();
  }
}
