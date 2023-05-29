import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class RutinaService {

  constructor(private http:HttpClient) { }

  public guardarRutina(rutina:any){
    return this.http.post(`${baserUrl}/rutina/`,rutina);
  }

  public eliminarRutina(rutinaId:any){
    return this.http.delete(`${baserUrl}/rutina/${rutinaId}`);
  }

  public actualizarRutina(rutina:any){
    return this.http.put(`${baserUrl}/rutina/`,rutina);
  }

  public obtenerRutina(rutinaId:any){
    return this.http.get(`${baserUrl}/rutina/${rutinaId}`);
  }

  public listarRutinas(){
    return this.http.get(`${baserUrl}/rutina/`);
  }

}
