import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {


    constructor(private httpClient: HttpClient) { }

    public añadirUsuario(user:any){
      return this.httpClient.post(`${baserUrl}/usuarios/`,user);
    }

    public listarUsuarios(){
      return this.httpClient.get(`${baserUrl}/usuarios/`);
    }

    public eliminarUsuario(usuarioId:any){
      return this.httpClient.delete(`${baserUrl}/usuarios/${usuarioId}`);
    }
  
    public actualizarUsuario(user:any){
      return this.httpClient.put(`${baserUrl}/usuarios/`,user);
    }

    public obtenerUsuario(username:any){
      return this.httpClient.get(`${baserUrl}/usuarios/${username}`);
    }

}