import { Component } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Plan } from 'src/app/models/Plan';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-planes',
  templateUrl: './admin-planes.component.html',
  styleUrls: ['./admin-planes.component.css']
})
export class AdminPlanesComponent {
  planes: Plan[];

  constructor(private appService: AppService,private router:Router){}

  ngOnInit(): void{
    this.obtenerPlanes();
  }

  actualizarPlan(id:number){
    this.router.navigate(['actualizar-planes',id]);
  }

  eliminarPlan(id: number){
    this.appService.eliminarPlan(id).subscribe(dato => {
      console.log(dato);
      this.obtenerPlanes();
    });
  }

  private obtenerPlanes(){
    this.appService.obtenerPlanes().subscribe(dato =>{
      this.planes = dato;
    });
  }
}
