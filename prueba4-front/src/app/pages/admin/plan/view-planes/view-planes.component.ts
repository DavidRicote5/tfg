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

  eliminarPlan(planId:any){
    Swal.fire({
      title:'Eliminar plan',
      text:'¿Estás seguro de eliminar el plan?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor:'#d33',
      confirmButtonText:'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.planService.eliminarPlan(planId).subscribe(
          (data) => {
            this.planes = this.planes.filter((plan:any) => plan.planId != planId);
            Swal.fire('Plan eliminado','El plan ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar el plan','error');
          }
        )
      }
    })
  }

}
