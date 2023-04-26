import { Component } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Rutina } from 'src/app/models/Rutina';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-rutinas',
  templateUrl: './admin-rutinas.component.html',
  styleUrls: ['./admin-rutinas.component.css']
})
export class AdminRutinasComponent {
  rutinas: Rutina[];

  constructor(private appService: AppService,private router:Router){}

  ngOnInit(): void{
    this.obtenerRutinas();
  }

  actualizarRutina(id:number){
    this.router.navigate(['actualizar-rutinas',id]);
  }

  eliminarRutina(id: number){
    this.appService.eliminarRutina(id).subscribe(dato => {
      console.log(dato);
      this.obtenerRutinas();
    });
  }

  private obtenerRutinas(){
    this.appService.obtenerRutinas().subscribe(dato =>{
      this.rutinas = dato;
    });
  }
}
