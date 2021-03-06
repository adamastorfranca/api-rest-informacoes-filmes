import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { HomeComponent } from './pages/home/home.component';
import { InicioComponent } from './pages/home/inicio/inicio.component';
import { LoginComponent } from './pages/login/login.component';

const routes: Routes = [
  {
    path:'', component: HomeComponent,
    children: [
      { path: '', component: InicioComponent },
      { path: 'cadastro', component: CadastroComponent },
      { path: 'login', component: LoginComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
