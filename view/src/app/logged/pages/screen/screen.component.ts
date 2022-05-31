import { Component, OnInit } from '@angular/core';

import { AutenticacaoService } from 'src/app/services/autenticacao.service';

@Component({
  selector: 'app-screen',
  templateUrl: './screen.component.html',
  styleUrls: ['./screen.component.css']
})
export class ScreenComponent implements OnInit {

  usuarioLogado: string = '';

  constructor(
    private authService: AutenticacaoService
  ) { }

  ngOnInit(): void {

  }
}
