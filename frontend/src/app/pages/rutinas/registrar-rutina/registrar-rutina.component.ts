import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Rutina } from 'src/app/models/Rutina';

@Component({
  selector: 'app-registrar-rutina',
  templateUrl: './registrar-rutina.component.html',
  styleUrls: ['./registrar-rutina.component.css']
})
export class RegistrarRutinaComponent implements OnInit {

  rutina: Rutina = new Rutina();
  constructor(private appService: AppService, private router: Router){}

  ngOnInit():void {
    
  }

  guardarRutina(){
    this.appService.registrarRutinas(this.rutina).subscribe(dato => {
      console.log(dato);
      this.irListaRutinas();
    }, error => console.log(error))
  }

  irListaRutinas(){
    this.router.navigate(['/adminRutinas']);
  }
  onSubmit(){
    this.guardarRutina();
  }
}