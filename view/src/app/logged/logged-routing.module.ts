import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarEditarComponent } from './pages/filmes/cadastrar-editar/cadastrar-editar.component';
import { ExibirComponent } from './pages/filmes/exibir/exibir.component';
import { InicioComponent } from './pages/screen/inicio/inicio.component';
import { ScreenComponent } from './pages/screen/screen.component';

const routes: Routes = [
  {
    path:'', component: ScreenComponent,
    children: [
      { path: '', component: InicioComponent },
      { path: 'filmes/cadastrar', component: CadastrarEditarComponent },
      { path: 'filmes/editar/:id', component: CadastrarEditarComponent },
      { path: 'filmes/:id', component: ExibirComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoggedRoutingModule { }
