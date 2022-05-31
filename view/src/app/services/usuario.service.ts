import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IUsuarioRequest } from '../interfaces/usuario-request';
import { IUsuarioResponse } from '../interfaces/usuario-response';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  usuarioCadastrado!: IUsuarioResponse;

  api = environment.api;
  endpoint = 'usuarios';

  constructor(
    private http: HttpClient
  ) { }

  cadastrar(dados: IUsuarioRequest): Observable<IUsuarioResponse> {
    return this.http.post<IUsuarioResponse>(`${this.api}/${this.endpoint}`, dados);
  }

  editar(id: number, dados: IUsuarioRequest): Observable<IUsuarioResponse>{
    return this.http.put<IUsuarioResponse>(`${this.api}/${this.endpoint}/${id}`, dados);
  }

  deletar(id: number) {
    return this.http.delete(`${this.api}/${this.endpoint}/${id}`);
  }

  buscar(id: number | string, nome: string, email: string): Observable<IUsuarioResponse[]> {
    let params = new HttpParams();
    params = params.append('id', id);
    params = params.append('nome', nome);
    params = params.append('email', email);
    return this.http.get<IUsuarioResponse[]>(`${this.api}/${this.endpoint}`, {params: params});
  }
}
