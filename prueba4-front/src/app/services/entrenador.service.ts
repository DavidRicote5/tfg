import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class EntrenadorService {

  constructor(private http:HttpClient) { }

  public guardarEntrenador(entrenador:any){
    return this.http.post(`${baserUrl}/entrenador/`,entrenador);
  }

  public eliminarEntrenador(entrenadorId:any){
    return this.http.delete(`${baserUrl}/entrenador/${entrenadorId}`);
  }

  public actualizarEntrenador(entrenador:any){
    return this.http.put(`${baserUrl}/entrenador/`,entrenador);
  }

  public obtenerEntrenador(entrenadorId:any){
    return this.http.get(`${baserUrl}/entrenador/${entrenadorId}`);
  }

  public listarEntrenadores(){
    return this.http.get(`${baserUrl}/entrenadores/`);
  }

}
