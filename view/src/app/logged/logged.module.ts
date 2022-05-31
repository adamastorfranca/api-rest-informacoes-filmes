import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoggedRoutingModule } from './logged-routing.module';
import { ScreenComponent } from './pages/screen/screen.component';
import { ComponentsModule } from '../components/components.module';
import { CadastrarEditarComponent } from './pages/filmes/cadastrar-editar/cadastrar-editar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InicioComponent } from './pages/screen/inicio/inicio.component';
import { ExibirComponent } from './pages/filmes/exibir/exibir.component';
import { SafePipe } from './pages/filmes/exibir/safe.pipe';


@NgModule({
  declarations: [
    ScreenComponent,
    CadastrarEditarComponent,
    InicioComponent,
    ExibirComponent,
    SafePipe
  ],
  imports: [
    CommonModule,
    LoggedRoutingModule,
    ComponentsModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class LoggedModule { }
