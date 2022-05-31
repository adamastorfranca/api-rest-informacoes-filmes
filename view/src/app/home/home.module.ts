import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { HomeRoutingModule } from './home-routing.module';
import { ComponentsModule } from '../components/components.module';
import { HomeComponent } from './pages/home/home.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { InicioComponent } from './pages/home/inicio/inicio.component';
import { LoginComponent } from './pages/login/login.component';


@NgModule({
  declarations: [
    HomeComponent,
    CadastroComponent,
    InicioComponent,
    LoginComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    HomeRoutingModule,
    ComponentsModule
  ]
})
export class HomeModule { }
