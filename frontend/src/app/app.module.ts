import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { routing, appRoutingProviders } from './app.routing';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { PlanComponent } from './plan/plan.component';
import { EntrenadorComponent } from './entrenador/entrenador.component';
import { RutinaComponent } from './rutina/rutina.component';
import { EjercicioComponent } from './ejercicio/ejercicio.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { RegistrarEntrenadorComponent } from './registrar-entrenador/registrar-entrenador.component';


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
    RegistrarEntrenadorComponent
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
