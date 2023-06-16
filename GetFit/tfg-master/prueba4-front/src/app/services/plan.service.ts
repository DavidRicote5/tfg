import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class PlanService {

  constructor(private http:HttpClient) { }

  public guardarPlan(plan:any){
    return this.http.post(`${baserUrl}/plan/`,plan);
  }

  public eliminarPlan(planId:any){
    return this.http.delete(`${baserUrl}/plan/${planId}`);
  }

  public actualizarPlan(plan:any){
    return this.http.put(`${baserUrl}/plan/`,plan);
  }

  public obtenerPlan(planId:any){
    return this.http.get(`${baserUrl}/plan/${planId}`);
  }

  public listarPlanes(){
    return this.http.get(`${baserUrl}/plan/`);
  }

}