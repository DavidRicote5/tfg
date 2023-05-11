import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PlanService } from 'src/app/services/plan.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-planes',
  templateUrl: './view-planes.component.html',
  styleUrls: ['./view-planes.component.css']
})
export class ViewPlanesComponent implements OnInit {

  planes:any = [

  ]

  constructor(private planService:PlanService,private router:Router) { }

   ngOnInit(): void {
    this.planService.listarPlanes().subscribe(
      (dato:any) => {
        this.planes = dato;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los planes','error');
      }
    )
  }
  actualizarPlan(id:number){
    this.router.navigate(['actualizar-plan',id]);
  }

}
