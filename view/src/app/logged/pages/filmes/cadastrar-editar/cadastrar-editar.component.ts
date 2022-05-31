import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { IFilmeRequest } from 'src/app/interfaces/filme-request';
import { IGenero } from 'src/app/interfaces/genero';
import { FilmeService } from 'src/app/services/filme.service';
import { GeneroService } from 'src/app/services/genero.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastrar-editar.component.html',
  styleUrls: ['./cadastrar-editar.component.css']
})
export class CadastrarEditarComponent implements OnInit {

  generos: IGenero[] = [];

  filmeTemp: IFilmeRequest = {
    titulo: '',
    anoLancamento: null,
    duracaoMinutos: null,
    sinopse: '',
    urlImagem: '',
    urlTrailler: '',
    idGenero: null
  }

  formulario: FormGroup = this.preencherFormGroup(this.filmeTemp);
  id: number = 0;

  constructor(
    private generoService: GeneroService,
    private filmeService: FilmeService,
    private router: Router,
    private activedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.generos = this.generoService.generos;
    this.id = Number(this.activedRoute.snapshot.paramMap.get('id'));
    if (this.id) {
      this.filmeService.buscar(this.id, '').subscribe((result) => {
        this.filmeTemp.titulo = result[0].titulo,
        this.filmeTemp.anoLancamento = result[0].anoLancamento,
        this.filmeTemp.duracaoMinutos = result[0].duracaoMinutos,
        this.filmeTemp.sinopse = result[0].sinopse,
        this.filmeTemp.urlImagem = result[0].urlImagem,
        this.filmeTemp.urlTrailler = result[0].urlTrailler,
        this.filmeTemp.idGenero = result[0].idGenero
        this.formulario = this.preencherFormGroup(this.filmeTemp);
      })
    }
  }

  enviar() {
    const dados = this.formulario.value;
    if (this.id === 0) {
      this.filmeService.cadastrar(dados).subscribe((result) => {
        Swal.fire('Filme cadastrado com sucesso!', '', 'success').then(() => this.router.navigate(['/admin']));
      })
    } else {
      this.filmeService.editar(this.id, dados).subscribe((result) => {
        Swal.fire('Sucesso', 'Editado com sucesso!', 'success').then(() => this.router.navigate(['/admin/filmes', this.id]));
      })
    }
  }

  preencherFormGroup(dados: IFilmeRequest): FormGroup {
    return new FormGroup({
      titulo: new FormControl(dados.titulo, Validators.required),
      anoLancamento: new FormControl(dados.anoLancamento, Validators.required),
      duracaoMinutos: new FormControl(dados.duracaoMinutos, Validators.required),
      sinopse: new FormControl(dados.sinopse, Validators.required),
      urlImagem: new FormControl(dados.urlImagem, Validators.required),
      urlTrailler: new FormControl(dados.urlTrailler, Validators.required),
      idGenero: new FormControl(dados.idGenero, Validators.required),
    });
  }

  estaEditando() {
    return this.id !== 0;
  }
}
