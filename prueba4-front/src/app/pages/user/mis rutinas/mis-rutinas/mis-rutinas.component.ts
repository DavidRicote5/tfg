import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-mis-rutinas',
  templateUrl: './mis-rutinas.component.html',
  styleUrls: ['./mis-rutinas.component.css']
})
export class MisRutinasComponent implements OnInit {

  usuarios:any = [

  ]

  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
    this.userService.listarUsuarios().subscribe(
      (dato:any) => {
        this.usuarios = dato;
        console.log(dato);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los usuarios','error');
      }
    )

  }

}
