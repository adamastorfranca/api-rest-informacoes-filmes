import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ILoginRequest } from '../interfaces/login';
import { IUsuarioResponse } from '../interfaces/usuario-response';

@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService {

  usuarioLogado!: IUsuarioResponse;

  constructor(
    private http: HttpClient
  ) { }

  autenticar(dados: ILoginRequest) {
    return this.http.post<ILoginRequest>('http://localhost:8080/auth/', dados);
  }
}
