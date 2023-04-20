import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { routing, appRoutingProviders } from './app.routing';

import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { PlanComponent } from './pages/plan/plan.component';
import { EntrenadorComponent } from './pages/entrenador/entrenador.component';
import { RutinaComponent } from './pages/rutina/rutina.component';
import { EjercicioComponent } from './pages/ejercicio/ejercicio.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { RegistrarEntrenadorComponent } from './pages/registrar-entrenador/registrar-entrenador.component';
import { ActualizarEntrenadorComponent } from './pages/actualizar-entrenador/actualizar-entrenador.component';
import { MenuHorizontalComponent } from './pages/menu-horizontal/menu-horizontal.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';
import { FooterComponent } from './pages/footer/footer.component';


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
    FooterComponent
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
