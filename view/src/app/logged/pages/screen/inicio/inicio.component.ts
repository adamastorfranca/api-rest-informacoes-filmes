import { Component, OnInit } from '@angular/core';
import { IFilmeResponse } from 'src/app/interfaces/filme-response';
import { IGenero } from 'src/app/interfaces/genero';

import { FilmeService } from 'src/app/services/filme.service';
import { GeneroService } from 'src/app/services/genero.service';
@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  generos: IGenero[] = [];
  filmes: IFilmeResponse[] = [];

  constructor(
    private generoService: GeneroService,
    private filmeService: FilmeService
  ) { }

  ngOnInit(): void {
    this.buscarGeneros();
    this.buscarFilmes();
  }

  buscarFilmes() {
    this.filmeService.buscar('', '').subscribe(result => {
      this.filmes = result;
    });
  }

  buscarGeneros(){
    this.generoService.buscar('', '').subscribe(result => {
      this.generoService.generos = result;
      this.generos = result;
    });
  }

}
