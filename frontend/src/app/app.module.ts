import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { routing, appRoutingProviders } from './app.routing';

import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { UsuarioComponent } from './pages/usuarios/usuario/usuario.component';
import { PlanComponent } from './pages/planes/plan/plan.component';
import { EntrenadorComponent } from './pages/entrenadores/entrenador/entrenador.component';
import { RutinaComponent } from './pages/rutinas/rutina/rutina.component';
import { EjercicioComponent } from './pages/ejercicios/ejercicio/ejercicio.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { RegistrarEntrenadorComponent } from './pages/entrenadores/registrar-entrenador/registrar-entrenador.component';
import { ActualizarEntrenadorComponent } from './pages/entrenadores/actualizar-entrenador/actualizar-entrenador.component';
import { MenuHorizontalComponent } from './pages/menu-horizontal/menu-horizontal.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';
import { FooterComponent } from './pages/footer/footer.component';
import { AdminHomeComponent } from './pages/admin/admin-home/admin-home.component';
import { AdminUsuariosComponent } from './pages/admin/admin-usuarios/admin-usuarios.component';
import { AdminEntrenadoresComponent } from './pages/admin/admin-entrenadores/admin-entrenadores.component';
import { AdminPlanesComponent } from './pages/admin/admin-planes/admin-planes.component';
import { AdminRutinasComponent } from './pages/admin/admin-rutinas/admin-rutinas.component';
import { AdminEjerciciosComponent } from './pages/admin/admin-ejercicios/admin-ejercicios.component';
import { RegistrarUsuarioComponent } from './pages/usuarios/registrar-usuario/registrar-usuario.component';
import { ActualizarUsuarioComponent } from './pages/usuarios/actualizar-usuario/actualizar-usuario.component';
import { RegistrarRutinaComponent } from './pages/rutinas/registrar-rutina/registrar-rutina.component';
import { ActualizarRutinaComponent } from './pages/rutinas/actualizar-rutina/actualizar-rutina.component';
import { RegistrarPlanComponent } from './pages/planes/registrar-plan/registrar-plan.component';
import { ActualizarPlanComponent } from './pages/planes/actualizar-plan/actualizar-plan.component';
import { RegistrarEjercicioComponent } from './pages/ejercicios/registrar-ejercicio/registrar-ejercicio.component';
import { ActualizarEjercicioComponent } from './pages/ejercicios/actualizar-ejercicio/actualizar-ejercicio.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UsuarioComponent,
    PlanComponent,
    EntrenadorComponent,
    RutinaComponent,
    EjercicioComponent,
    LoginComponent,
    RegisterComponent,
    RegistrarEntrenadorComponent,
    ActualizarEntrenadorComponent,
    MenuHorizontalComponent,
    QuienesSomosComponent,
    FooterComponent,
    AdminHomeComponent,
    AdminUsuariosComponent,
    AdminEntrenadoresComponent,
    AdminPlanesComponent,
    AdminRutinasComponent,
    AdminEjerciciosComponent,
    RegistrarUsuarioComponent,
    ActualizarUsuarioComponent,
    RegistrarRutinaComponent,
    ActualizarRutinaComponent,
    RegistrarPlanComponent,
    ActualizarPlanComponent,
    RegistrarEjercicioComponent,
    ActualizarEjercicioComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    routing,
    HttpClientModule
  ],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
