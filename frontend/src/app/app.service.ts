import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Entrenador } from './models/Entrenador';
import { Usuario } from './models/Usuario';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private baseURL = 'http://localhost:8080';

  constructor(private httpClient : HttpClient) { }

  //ENTRENADORES
  obtenerEntrenadores():Observable<Entrenador[]>{
    return this.httpClient.get<Entrenador[]>(this.baseURL+"/entrenador/r");
  }

  registrarEntrenadores(entrenador: Entrenador):Observable<Object>{
    return this.httpClient.post(this.baseURL+"/entrenador/c", entrenador);
  }

  actualizarEntrenador(id: number, entrenador: Entrenador): Observable<Object>{
    return this.httpClient.put(this.baseURL+"/entrenador/u/"+id, entrenador);
  }

  obtenerEntrenadorPorId(id: number):Observable<Entrenador>{
    return this.httpClient.get<Entrenador>(this.baseURL+"/entrenador/u/"+id);
  }

  eliminarEntrenador(id: number): Observable<Object>{
    return this.httpClient.delete(this.baseURL+"/entrenador/d/"+id);
  }

  //USUARIOS
  obtenerUsuarios():Observable<Usuario[]>{
    return this.httpClient.get<Usuario[]>(this.baseURL+"/usuario/r");
  }

  registrarUsuarios(usuario: Usuario):Observable<Object>{
    return this.httpClient.post(this.baseURL+"/usuario/c", usuario);
  }

  actualizarUsuario(id: number, usuario: Usuario): Observable<Object>{
    return this.httpClient.put(this.baseURL+"/usuario/u/"+id, usuario);
  }

  obtenerUsuarioPorId(id: number):Observable<Usuario>{
    return this.httpClient.get<Usuario>(this.baseURL+"/usuario/u/"+id);
  }

  eliminarUsuario(id: number): Observable<Object>{
    return this.httpClient.delete(this.baseURL+"/usuario/d/"+id);
  }
}
