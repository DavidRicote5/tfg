import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Entrenador } from './models/Entrenador';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private baseURL = 'http://localhost:8080';

  constructor(private httpClient : HttpClient) { }

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
}
