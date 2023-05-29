import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PlanService } from 'src/app/services/plan.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-planes',
  templateUrl: './planes.component.html',
  styleUrls: ['./planes.component.css']
})
export class PlanesComponent implements OnInit {

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
        Swal.fire('Advertencia !!','Debes iniciar sesion para ver todo el contenido','error');
        this.router.navigate(['/login']);
      }
    )
  }

}
