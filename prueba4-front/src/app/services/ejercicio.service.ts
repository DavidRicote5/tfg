import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class EjercicioService {

  constructor(private http:HttpClient) { }

  public guardarEjercicio(ejercicio:any){
    return this.http.post(`${baserUrl}/ejercicio/`,ejercicio);
  }

  public eliminarEjercicio(ejercicioId:any){
    return this.http.delete(`${baserUrl}/ejercicio/${ejercicioId}`);
  }

  public actualizarEjercicio(ejercicio:any){
    return this.http.put(`${baserUrl}/ejercicio/`,ejercicio);
  }

  public obtenerEjercicio(ejercicioId:any){
    return this.http.get(`${baserUrl}/ejercicio/${ejercicioId}`);
  }

  public listarEjercicios(){
    return this.http.get(`${baserUrl}/ejercicio/`);
  }

}
