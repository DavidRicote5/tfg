import { Component } from '@angular/core';
import { Rutina } from 'src/app/models/Rutina';
import { AppService } from 'src/app/app.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-actualizar-rutina',
  templateUrl: './actualizar-rutina.component.html',
  styleUrls: ['./actualizar-rutina.component.css']
})
export class ActualizarRutinaComponent {
  id:number;
  rutina:Rutina = new Rutina();
  constructor(private appService:AppService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.appService.obtenerRutinaPorId(this.id).subscribe(dato =>{
      this.rutina = dato;
    },error => console.log(error));
  }

  irAlaListaDeRutinas(){
    this.router.navigate(['/adminRutinas']);
  }

  onSubmit(){
    this.appService.actualizarRutina(this.id,this.rutina).subscribe(dato => {
      this.irAlaListaDeRutinas();
    },error => console.log(error));
  }
}
