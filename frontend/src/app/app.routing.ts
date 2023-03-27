import {ModuleWithProviders} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsuarioComponent } from './usuario/usuario.component';
import { PlanComponent } from './plan/plan.component';
import { EntrenadorComponent } from './entrenador/entrenador.component';
import { RutinaComponent } from './rutina/rutina.component';
import { EjercicioComponent } from './ejercicio/ejercicio.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const appRoutes: Routes = [
    {path: "", component: HomeComponent},
    {path: "usuarios", component: UsuarioComponent},
    {path: "planes", component: PlanComponent},
    {path: "entrenadores", component: EntrenadorComponent},
    {path: "rutinas", component: RutinaComponent},
    {path: "ejercicios", component: EjercicioComponent},
    {path: "login", component: LoginComponent},
    {path: "register", component: RegisterComponent},
    {path: '**', component: HomeComponent}
];

export const appRoutingProviders:any[]=[];
export const routing:ModuleWithProviders<any>=RouterModule.forRoot(appRoutes);