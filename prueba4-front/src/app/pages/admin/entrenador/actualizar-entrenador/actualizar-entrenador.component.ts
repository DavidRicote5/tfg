import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EntrenadorService } from 'src/app/services/entrenador.service';

@Component({
  selector: 'app-actualizar-entrenador',
  templateUrl: './actualizar-entrenador.component.html',
  styleUrls: ['./actualizar-entrenador.component.css']
})
export class ActualizarEntrenadorComponent implements OnInit {

  constructor(private route:ActivatedRoute, private entrenadorService:EntrenadorService) { }

  entrenadorId:number = 0;
  entrenador:any;

  ngOnInit(): void {
    this.entrenador = this.route.snapshot.params['id'];
    this.entrenadorService.obtenerEntrenador(this.entrenadorId).subscribe(
      (data) => {
        this.entrenador = data;
        console.log(this.entrenador);
      },
      (error) => {
        console.log(error);
      }
    )
  }

}
