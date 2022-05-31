import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { IFilmeRequest } from '../interfaces/filme-request';
import { IFilmeResponse } from '../interfaces/filme-response';

@Injectable({
  providedIn: 'root'
})
export class FilmeService {

  api = environment.api;
  endpoint = 'filmes';

  constructor(
    private http: HttpClient
  ) { }

  buscar(id: number | string, titulo: string): Observable<IFilmeResponse[]> {
    let params = new HttpParams();
    params = params.append('id', id);
    params = params.append('titulo', titulo);
    return this.http.get<IFilmeResponse[]>(`${this.api}/${this.endpoint}/`, {params: params});
  }

  cadastrar(dados: IFilmeRequest): Observable<IFilmeResponse> {
    return this.http.post<IFilmeResponse>(`${this.api}/${this.endpoint}`, dados);
  }

  editar(id: number, dados: IFilmeRequest): Observable<IFilmeResponse> {
    return this.http.put<IFilmeResponse>(`${this.api}/${this.endpoint}/${id}`, dados);
  }

  deletar(id: number) {
    return this.http.delete(`${this.api}/${this.endpoint}/${id}`);
  }

}
