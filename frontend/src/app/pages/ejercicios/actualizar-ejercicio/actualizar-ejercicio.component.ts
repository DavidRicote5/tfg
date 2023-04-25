import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Ejercicio } from 'src/app/models/Ejercicio';

@Component({
  selector: 'app-actualizar-ejercicio',
  templateUrl: './actualizar-ejercicio.component.html',
  styleUrls: ['./actualizar-ejercicio.component.css']
})
export class ActualizarEjercicioComponent {
  id:number;
  ejercicio:Ejercicio = new Ejercicio();
  constructor(private appService:AppService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.appService.obtenerEjercicioPorId(this.id).subscribe(dato =>{
      this.ejercicio = dato;
    },error => console.log(error));
  }

  irAlaListaDeEjercicios(){
    this.router.navigate(['/adminEjercicios']);
  }

  onSubmit(){
    this.appService.actualizarEjercicio(this.id,this.ejercicio).subscribe(dato => {
      this.irAlaListaDeEjercicios();
    },error => console.log(error));
  }
}
