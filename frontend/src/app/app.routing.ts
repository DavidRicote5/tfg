import {ModuleWithProviders} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsuarioComponent } from './pages/usuario/usuario.component';
import { PlanComponent } from './pages/plan/plan.component';
import { EntrenadorComponent } from './pages/entrenador/entrenador.component';
import { RutinaComponent } from './pages/rutina/rutina.component';
import { EjercicioComponent } from './pages/ejercicio/ejercicio.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { RegistrarEntrenadorComponent } from './pages/registrar-entrenador/registrar-entrenador.component';
import { ActualizarEntrenadorComponent } from './pages/actualizar-entrenador/actualizar-entrenador.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';

const appRoutes: Routes = [
    {path: "", component: HomeComponent},
    {path: "usuarios", component: UsuarioComponent},
    {path: "planes", component: PlanComponent},
    {path: "entrenadores", component: EntrenadorComponent},
    {path: "registrar-entrenadores", component: RegistrarEntrenadorComponent},
    {path: "actualizar-entrenadores/:id", component:ActualizarEntrenadorComponent},
    {path: "rutinas", component: RutinaComponent},
    {path: "ejercicios", component: EjercicioComponent},
    {path: "login", component: LoginComponent},
    {path: "register", component: RegisterComponent},
    {path: "quienes-somos", component: QuienesSomosComponent},
    {path: '**', component: HomeComponent}
];

export const appRoutingProviders:any[]=[];
export const routing:ModuleWithProviders<any>=RouterModule.forRoot(appRoutes);