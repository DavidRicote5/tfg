import  Swal  from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public user = {
    username : '',
    password : '',
    nombre : '',
    correo : '',
    genero : '',
    altura : null,
    peso:null,
    numtarjeta:'',
    fechavalidez:'',
    numsecretotarjeta:null
  }

  constructor(private userService:UserService,private snack:MatSnackBar) { }

  ngOnInit(): void {
  }

  formSubmit(){
    console.log(this.user);
    if(this.user.username == '' || this.user.username == null){
      this.snack.open('El nombre de usuario es requerido !!','Aceptar',{
        duration : 3000,
        verticalPosition : 'top',
        horizontalPosition : 'right'
      });
      return;
    }

    this.userService.añadirUsuario(this.user).subscribe(
      (data) => {
        console.log(data);
        
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Usuario Registrado',
          showConfirmButton: false,
          timer: 1500
        })
      },(error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!','Aceptar',{
          duration : 3000
        });
      }
    )
  }

  formatCreditCardNumber(event: any) {
    // Eliminar cualquier espacio en blanco existente
    let value = event.target.value.replace(/\s/g, '');
  
    // Dividir el número en bloques de 4 caracteres
    let blocks = [];
    for (let i = 0; i < value.length; i += 4) {
      blocks.push(value.substr(i, 4));
    }
  
    // Agregar espacios después de cada bloque de 4 caracteres
    event.target.value = blocks.join(' ');
  
    // Recortar el número a un máximo de 16 dígitos
    if (event.target.value.length > 19) {
      event.target.value = event.target.value.substr(0, 19);
    }
  }
  
  
  

  
}
