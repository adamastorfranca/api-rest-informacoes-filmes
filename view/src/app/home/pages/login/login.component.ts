import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AutenticacaoService } from 'src/app/services/autenticacao.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formLogin: FormGroup = new FormGroup({
    email: new FormControl('', Validators.required),
    senha: new FormControl('', Validators.required)
  });

  constructor(
    private auth: AutenticacaoService,
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  verificarAutenticacao() {
    const login = this.formLogin.value;
    const email = this.formLogin.get('email')?.value;
    this.auth.autenticar(login).subscribe(
      () => {
        this.usuarioService.buscar('', '', email).subscribe(result => {
          this.auth.usuarioLogado = result[0];
        });
        this.router.navigate(['/admin']);
    },() => {
      Swal.fire({
        title: 'E-mail ou senha inválida!',
        icon: 'warning',
        confirmButtonText: 'Voltar'
      });
      this.formLogin.reset();
    });
  }

}
