import { Component } from '@angular/core';
import { Entrenador } from '../../../models/Entrenador';
import { AppService } from 'src/app/app.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-actualizar-entrenador',
  templateUrl: './actualizar-entrenador.component.html',
  styleUrls: ['./actualizar-entrenador.component.css']
})
export class ActualizarEntrenadorComponent {
  id:number;
  entrenador:Entrenador = new Entrenador();
  constructor(private appService:AppService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.appService.obtenerEntrenadorPorId(this.id).subscribe(dato =>{
      this.entrenador = dato;
    },error => console.log(error));
  }

  irAlaListaDeEntrenadores(){
    this.router.navigate(['/adminEntrenadores']);
  }

  onSubmit(){
    this.appService.actualizarEntrenador(this.id,this.entrenador).subscribe(dato => {
      this.irAlaListaDeEntrenadores();
    },error => console.log(error));
  }
}
