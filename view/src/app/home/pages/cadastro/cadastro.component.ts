import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  formCadastro: FormGroup = new FormGroup({
    nomeCompleto: new FormControl('', Validators.required),
    dataNascimento: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    senha: new FormControl('', Validators.required),
    senhaConfirmar: new FormControl('', Validators.required),
    idPlano: new FormControl('', Validators.required),
    numeroCartao: new FormControl('', Validators.required),
    validade: new FormControl('', Validators.required),
    codigoSeguranca: new FormControl('', Validators.required),
    nomeTitular: new FormControl('', Validators.required),
    cpf: new FormControl('', Validators.required),
    modalidade: new FormControl('', Validators.required),
  });

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  realizarCadastro() {
    const dados = this.formCadastro.value;
    this.usuarioService.cadastrar(dados).subscribe(
      result => {
      Swal.fire({
        title: 'Bem vindo, ' + result.nomeCompleto.split(' ')[0],
        text: 'Sua assinatura na UNIESPFLIX foi realizado com sucesso!',
        showConfirmButton: false,
        showDenyButton: true,
        showCancelButton: true,
        denyButtonText: 'Entrar',
        cancelButtonText: 'Página inicial'
      }).then((result) => {
        if (result.isDenied) {
          this.router.navigate(['/login']);
        } else {
          this.router.navigate(['']);
        }
      })
    }, erro => {
      Swal.fire({
        title: 'Erro ao cadastrar usuário!',
        icon: 'warning',
        confirmButtonText: 'Voltar',
      })
    });
  }

}
