import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Plan } from 'src/app/models/Plan';

@Component({
  selector: 'app-registrar-plan',
  templateUrl: './registrar-plan.component.html',
  styleUrls: ['./registrar-plan.component.css']
})
export class RegistrarPlanComponent implements OnInit {

  plan: Plan = new Plan();
  constructor(private appService: AppService, private router: Router){}

  ngOnInit():void {
    
  }

  guardarPlan(){
    this.appService.registrarPlanes(this.plan).subscribe(dato => {
      console.log(dato);
      this.irListaPlanes();
    }, error => console.log(error))
  }

  irListaPlanes(){
    this.router.navigate(['/adminPlanes']);
  }
  onSubmit(){
    this.guardarPlan();
  }
}