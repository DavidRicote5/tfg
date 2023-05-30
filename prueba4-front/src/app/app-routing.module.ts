import { StartComponent } from './pages/user/start/start.component';
import { InstruccionesComponent } from './pages/user/instrucciones/instrucciones.component';

import { ActualizarPreguntaComponent } from './pages/admin/actualizar-pregunta/actualizar-pregunta.component';
import { AddPreguntaComponent } from './pages/admin/add-pregunta/add-pregunta.component';
import { ViewExamenPreguntasComponent } from './pages/admin/view-examen-preguntas/view-examen-preguntas.component';
import { AddExamenComponent } from './pages/admin/add-examen/add-examen.component';
import { ViewExamenesComponent } from './pages/admin/view-examenes/view-examenes.component';
import { AddCategoriaComponent } from './pages/admin/add-categoria/add-categoria.component';
import { ViewCategoriasComponent } from './pages/admin/view-categorias/view-categorias.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { NormalGuard } from './services/normal.guard';
import { AdminGuard } from './services/admin.guard';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { HomeComponent } from './pages/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarExamenComponent } from './pages/admin/actualizar-examen/actualizar-examen.component';
import { AddEntrenadorComponent } from './pages/admin/entrenador/add-entrenador/add-entrenador.component';
import { ActualizarEntrenadorComponent } from './pages/admin/entrenador/actualizar-entrenador/actualizar-entrenador.component';
import { AddRutinaComponent } from './pages/admin/rutina/add-rutina/add-rutina.component';
import { ActualizarRutinaComponent } from './pages/admin/rutina/actualizar-rutina/actualizar-rutina.component';
import { AddEjercicioComponent } from './pages/admin/ejercicio/add-ejercicio/add-ejercicio.component';
import { ActualizarEjercicioComponent } from './pages/admin/ejercicio/actualizar-ejercicio/actualizar-ejercicio.component';
import { AddPlanComponent } from './pages/admin/plan/add-plan/add-plan.component';
import { ActualizarPlanComponent } from './pages/admin/plan/actualizar-plan/actualizar-plan.component';
import { ViewEntrenadoresComponent } from './pages/admin/entrenador/view-entrenadores/view-entrenadores.component';
import { ViewRutinasComponent } from './pages/admin/rutina/view-rutinas/view-rutinas.component';
import { ViewEjerciciosComponent } from './pages/admin/ejercicio/view-ejercicios/view-ejercicios.component';
import { ViewPlanesComponent } from './pages/admin/plan/view-planes/view-planes.component';
import { ActualizarUsuarioComponent } from './pages/admin/usuario/actualizar-usuario/actualizar-usuario.component';
import { ViewUsuariosComponent } from './pages/admin/usuario/view-usuarios/view-usuarios.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';
import { PlanesComponent } from './pages/planes/planes.component';
import { RutinasHomeComponent } from './pages/rutinas-home/rutinas-home.component';
import { ViewRutinasUserComponent } from './pages/user/view-rutinas-user/view-rutinas-user.component';
import { ViewEjerciciosUserComponent } from './pages/user/view-ejercicios-user/view-ejercicios-user.component';

const routes: Routes = [
  {
    path : '',
    component : HomeComponent,
    pathMatch : 'full'
  },
  {
    path : 'quienes-somos',
    component : QuienesSomosComponent
  },
  {
    path : 'rutinas',
    component : RutinasHomeComponent
  },
  {
    path : 'planes',
    component : PlanesComponent
  },
  {
    path : 'signup',
    component : SignupComponent,
    pathMatch : 'full'
  },
  {
    path : 'login',
    component : LoginComponent,
    pathMatch : 'full'
  },
  {
    //TODAS LAS RUTAS DE ADMIN
    path:'admin',
    component:DashboardComponent,
    canActivate:[AdminGuard],
    children:[
      {
        path:'profile',
        component:ProfileComponent
      },
      {
        path : '',
        component : WelcomeComponent
      },
      {
        path:'categorias',
        component:ViewCategoriasComponent
      },
      {
        path:'add-categoria',
        component:AddCategoriaComponent
      },
      {
        path:'examenes',
        component:ViewExamenesComponent
      },
      {
        path:'add-examen',
        component:AddExamenComponent
      },
      {
        path:'usuarios',
        component:ViewUsuariosComponent
      },
      {
        path:'usuario/:usuarioId',
        component:ViewUsuariosComponent
      },
      {
        path:'entrenadores',
        component:ViewEntrenadoresComponent
      },
      {
        path:'add-entrenador',
        component:AddEntrenadorComponent
      },
      {
        path:'entrenador/:entrenadorId',
        component:ActualizarEntrenadorComponent
      },
      {
        path:'rutinas',
        component:ViewRutinasComponent
      },
      {
        path:'add-rutina',
        component:AddRutinaComponent
      },
      {
        path:'rutina/:rutinaId',
        component:ActualizarRutinaComponent
      },
      {
        path:'ejercicios/:rutinaId/:nombre',
        component:ViewEjerciciosComponent
      },
      {
        path:'ejercicios',
        component:ViewEjerciciosComponent
      },
      {
        path:'add-ejercicio/:rutinaId/:nombre',
        component:AddEjercicioComponent
      },
      {
        path:'ejercicio/:ejercicioId',
        component:ActualizarEjercicioComponent
      },
      {
        path:'planes',
        component:ViewPlanesComponent
      },
      {
        path:'add-plan',
        component:AddPlanComponent
      },
      {
        path:'plan/:planId',
        component:ActualizarPlanComponent
      },
      {
        path:'examen/:examenId',
        component:ActualizarExamenComponent
      },
      {
        path:'ver-preguntas/:examenId/:titulo',
        component:ViewExamenPreguntasComponent
      },
      {
        path:'add-pregunta/:examenId/:titulo',
        component : AddPreguntaComponent
      },
      {
        path:'pregunta/:preguntaId',
        component:ActualizarPreguntaComponent
      },
      {
        path:'entrenador/:entrenadorId',
        component:ActualizarEntrenadorComponent
      },
      {
        path:'rutina/:rutinaId',
        component:ActualizarRutinaComponent
      },
      {
        path:'ejercicio/:ejercicioId',
        component:ActualizarEjercicioComponent
      },
      {
        path:'plan/:planId',
        component:ActualizarPlanComponent
      },
      {
        path:'usuarios/:username',
        component:ActualizarUsuarioComponent
      }
    ]
  },
  {
    path:'user-dashboard',
    component:UserDashboardComponent,
    canActivate:[NormalGuard],
    children : [
      {
        path:'',
        component:ProfileComponent
      },
      {
        path:'instrucciones/:examenId',
        component:InstruccionesComponent
      },
      {
        path:'view-rutinas-user',
        component:ViewRutinasUserComponent
      },
      {
        path:'view-ejercicios-user/:rutinaId/:nombre',
        component:ViewEjerciciosUserComponent
      },

    ]
  },
  {
    path:"start/:examenId",
    component:StartComponent,
    canActivate:[NormalGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
