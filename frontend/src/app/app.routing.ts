import {ModuleWithProviders} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsuarioComponent } from './pages/usuarios/usuario/usuario.component';
import { PlanComponent } from './pages/plan/plan.component';
import { EntrenadorComponent } from './pages/entrenadores/entrenador/entrenador.component';
import { RutinaComponent } from './pages/rutina/rutina.component';
import { EjercicioComponent } from './pages/ejercicios/ejercicio/ejercicio.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { RegistrarEntrenadorComponent } from './pages/entrenadores/registrar-entrenador/registrar-entrenador.component';
import { ActualizarEntrenadorComponent } from './pages/entrenadores/actualizar-entrenador/actualizar-entrenador.component';
import { RegistrarUsuarioComponent } from './pages/usuarios/registrar-usuario/registrar-usuario.component';
import { ActualizarUsuarioComponent } from './pages/usuarios/actualizar-usuario/actualizar-usuario.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';
import { AdminHomeComponent } from './pages/admin/admin-home/admin-home.component';
import { AdminUsuariosComponent } from './pages/admin/admin-usuarios/admin-usuarios.component';
import { AdminEntrenadoresComponent } from './pages/admin/admin-entrenadores/admin-entrenadores.component';
import { AdminPlanesComponent } from './pages/admin/admin-planes/admin-planes.component';
import { AdminRutinasComponent } from './pages/admin/admin-rutinas/admin-rutinas.component';
import { AdminEjerciciosComponent } from './pages/admin/admin-ejercicios/admin-ejercicios.component';
import { RegistrarEjercicioComponent } from './pages/ejercicios/registrar-ejercicio/registrar-ejercicio.component';
import { ActualizarEjercicioComponent } from './pages/ejercicios/actualizar-ejercicio/actualizar-ejercicio.component';

const appRoutes: Routes = [
    {path: "", component: HomeComponent},
    {path: "usuarios", component: UsuarioComponent},
    {path: "planes", component: PlanComponent},
    {path: "entrenadores", component: EntrenadorComponent},
    {path: "registrar-entrenadores", component: RegistrarEntrenadorComponent},
    {path: "actualizar-entrenadores/:id", component:ActualizarEntrenadorComponent},
    {path: "registrar-ejercicios", component: RegistrarEjercicioComponent},
    {path: "actualizar-ejercicios/:id", component:ActualizarEjercicioComponent},
    {path: "registrar-usuarios", component: RegistrarUsuarioComponent},
    {path: "actualizar-usuarios/:id", component:ActualizarUsuarioComponent},
    {path: "rutinas", component: RutinaComponent},
    {path: "ejercicios", component: EjercicioComponent},
    {path: "login", component: LoginComponent},
    {path: "register", component: RegisterComponent},
    {path: "quienes-somos", component: QuienesSomosComponent},
    {path: "admin", component: AdminHomeComponent},
    {path: "adminUsuarios", component: AdminUsuariosComponent},
    {path: "adminEntrenadores", component: AdminEntrenadoresComponent},
    {path: "adminPlanes", component: AdminPlanesComponent},
    {path: "adminRutinas", component: AdminRutinasComponent},
    {path: "adminEjercicios", component: AdminEjerciciosComponent},
    {path: '**', component: HomeComponent}
];

export const appRoutingProviders:any[]=[];
export const routing:ModuleWithProviders<any>=RouterModule.forRoot(appRoutes);