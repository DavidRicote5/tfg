import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PlanService } from 'src/app/services/plan.service';

@Component({
  selector: 'app-add-plan',
  templateUrl: './add-plan.component.html',
  styleUrls: ['./add-plan.component.css']
})
export class AddPlanComponent implements OnInit {

  plan = {

    nombre : '',
    descripcion : '',
    duracion:0,
    precio:0

  }

  constructor(private planService:PlanService,private snack:MatSnackBar,private router:Router) { }

  ngOnInit(): void {
  }

  formSubmit(){
    if(this.plan.nombre.trim() == '' || this.plan.nombre == null){
      this.snack.open("El nombre es requerido !!",'',{
        duration:3000
      })
      return ;
    }

    this.planService.guardarPlan(this.plan).subscribe(
      (dato:any) => {
        this.plan.nombre = '';
        this.plan.descripcion = '';
        this.plan.duracion = 0;
        this.plan.precio = 0;
        Swal.fire('Plan agregado','El plan ha sido agregada con éxito','success');
        this.router.navigate(['/admin/planes']);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al guardar el plan','error')
      }
    )
  }
}

