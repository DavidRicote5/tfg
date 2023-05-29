import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlanService } from 'src/app/services/plan.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-actualizar-plan',
  templateUrl: './actualizar-plan.component.html',
  styleUrls: ['./actualizar-plan.component.css']
})
export class ActualizarPlanComponent implements OnInit {

  constructor(
    private route:ActivatedRoute, 
    private planService:PlanService, 
    private router:Router) { }

    planId = 0;
    plan:any;
    planes:any;

  ngOnInit(): void {
    this.planId = this.route.snapshot.params['planId'];
    this.planService.obtenerPlan(this.planId).subscribe(
      (data) => {
        this.plan = data;
        console.log(this.plan);
      },
      (error) => {
        console.log(error);
      }
    )
  }

  public actualizarDatos(){
    this.planService.actualizarPlan(this.plan).subscribe(
      (data) => {
        Swal.fire('Plan actualizado','El plan ha sido actualizado con éxito','success').then(
          (e) => {
            this.router.navigate(['/admin/planes']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se ha podido actualizar el plan','error');
        console.log(error);
      }
    )

  }

}
