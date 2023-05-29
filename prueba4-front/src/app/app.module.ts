import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';

import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';

import {MatSelectModule} from '@angular/material/select';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatButtonModule} from '@angular/material/button';
import {MatListModule} from '@angular/material/list';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { authInterceptorProviders } from './services/auth.interceptor';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SidebarComponent } from './pages/admin/sidebar/sidebar.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { ViewCategoriasComponent } from './pages/admin/view-categorias/view-categorias.component';
import { AddCategoriaComponent } from './pages/admin/add-categoria/add-categoria.component';
import { ViewExamenesComponent } from './pages/admin/view-examenes/view-examenes.component';
import { AddExamenComponent } from './pages/admin/add-examen/add-examen.component';
import { ActualizarExamenComponent } from './pages/admin/actualizar-examen/actualizar-examen.component';
import { ViewExamenPreguntasComponent } from './pages/admin/view-examen-preguntas/view-examen-preguntas.component';
import { AddPreguntaComponent } from './pages/admin/add-pregunta/add-pregunta.component';
import { ActualizarPreguntaComponent } from './pages/admin/actualizar-pregunta/actualizar-pregunta.component';
import { SidebarComponent as UserSidebar} from './pages/user/sidebar/sidebar.component';

import { InstruccionesComponent } from './pages/user/instrucciones/instrucciones.component';
import { StartComponent } from './pages/user/start/start.component';
import { NgxUiLoaderModule , NgxUiLoaderHttpModule } from "ngx-ui-loader";
import { AddEntrenadorComponent } from './pages/admin/entrenador/add-entrenador/add-entrenador.component';
import { AddRutinaComponent } from './pages/admin/rutina/add-rutina/add-rutina.component';
import { AddEjercicioComponent } from './pages/admin/ejercicio/add-ejercicio/add-ejercicio.component';
import { AddPlanComponent } from './pages/admin/plan/add-plan/add-plan.component';
import { ActualizarEntrenadorComponent } from './pages/admin/entrenador/actualizar-entrenador/actualizar-entrenador.component';
import { ActualizarRutinaComponent } from './pages/admin/rutina/actualizar-rutina/actualizar-rutina.component';
import { ActualizarEjercicioComponent } from './pages/admin/ejercicio/actualizar-ejercicio/actualizar-ejercicio.component';
import { ActualizarPlanComponent } from './pages/admin/plan/actualizar-plan/actualizar-plan.component';
import { ViewUsuariosComponent } from './pages/admin/usuario/view-usuarios/view-usuarios.component';
import { ViewEntrenadoresComponent } from './pages/admin/entrenador/view-entrenadores/view-entrenadores.component';
import { ViewRutinasComponent } from './pages/admin/rutina/view-rutinas/view-rutinas.component';
import { ViewEjerciciosComponent } from './pages/admin/ejercicio/view-ejercicios/view-ejercicios.component';
import { ViewPlanesComponent } from './pages/admin/plan/view-planes/view-planes.component';
import { ActualizarUsuarioComponent } from './pages/admin/usuario/actualizar-usuario/actualizar-usuario.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';
import { PlanesComponent } from './pages/planes/planes.component';
import { RutinasHomeComponent } from './pages/rutinas-home/rutinas-home.component';
import { ViewRutinasUserComponent } from './pages/user/view-rutinas-user/view-rutinas-user.component';
import { ViewEjerciciosUserComponent } from './pages/user/view-ejercicios-user/view-ejercicios-user.component';

import {MatDatepickerModule } from '@angular/material/datepicker';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    DashboardComponent,
    UserDashboardComponent,
    ProfileComponent,
    SidebarComponent,
    WelcomeComponent,
    ViewCategoriasComponent,
    AddCategoriaComponent,
    ViewExamenesComponent,
    AddExamenComponent,
    ActualizarExamenComponent,
    ViewExamenPreguntasComponent,
    AddPreguntaComponent,
    ActualizarPreguntaComponent,
    UserSidebar,
    
    InstruccionesComponent,
    StartComponent,
    AddEntrenadorComponent,
    AddRutinaComponent,
    AddEjercicioComponent,
    AddPlanComponent,
    ActualizarEntrenadorComponent,
    ActualizarRutinaComponent,
    ActualizarEjercicioComponent,
    ActualizarPlanComponent,
    ViewUsuariosComponent,
    ViewEntrenadoresComponent,
    ViewRutinasComponent,
    ViewEjerciciosComponent,
    ViewPlanesComponent,
    ActualizarUsuarioComponent,
    QuienesSomosComponent,
    PlanesComponent,
    RutinasHomeComponent,
    ViewRutinasUserComponent,
    ViewEjerciciosUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatProgressSpinnerModule,
    NgxUiLoaderModule,
    NgxUiLoaderHttpModule.forRoot({
      showForeground:true
    }),
    MatDatepickerModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
