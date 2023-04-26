import { Component } from '@angular/core';
import { Plan } from 'src/app/models/Plan';
import { AppService } from 'src/app/app.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-actualizar-plan',
  templateUrl: './actualizar-plan.component.html',
  styleUrls: ['./actualizar-plan.component.css']
})
export class ActualizarPlanComponent {
  id:number;
  plan:Plan = new Plan();
  constructor(private appService:AppService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.appService.obtenerPlanPorId(this.id).subscribe(dato =>{
      this.plan = dato;
    },error => console.log(error));
  }

  irAlaListaDePlanes(){
    this.router.navigate(['/adminPlanes']);
  }

  onSubmit(){
    this.appService.actualizarPlan(this.id,this.plan).subscribe(dato => {
      this.irAlaListaDePlanes();
    },error => console.log(error));
  }
}
