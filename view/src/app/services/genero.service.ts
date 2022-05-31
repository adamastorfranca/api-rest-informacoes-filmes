import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { IGenero } from '../interfaces/genero';

@Injectable({
  providedIn: 'root'
})
export class GeneroService {

  api = environment.api;
  endpoint = 'generos';

  generos: IGenero[] = [];

  constructor(
    private http: HttpClient
  ) { }

  buscar(id: number | string, nome: string): Observable<IGenero[]> {
    let params = new HttpParams();
    params = params.append('id', id);
    params = params.append('nome', nome);
    return this.http.get<IGenero[]>(`${this.api}/${this.endpoint}`, {params: params});
  }
}
