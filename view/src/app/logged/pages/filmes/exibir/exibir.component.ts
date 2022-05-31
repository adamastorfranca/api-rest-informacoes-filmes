import { Component, OnInit, PipeTransform, Sanitizer, SecurityContext } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { IFilmeResponse } from 'src/app/interfaces/filme-response';
import { FilmeService } from 'src/app/services/filme.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-exibir',
  templateUrl: './exibir.component.html',
  styleUrls: ['./exibir.component.css']
})
export class ExibirComponent implements OnInit {

  filme!: IFilmeResponse;

  constructor(
    private filmeService: FilmeService,
    private activedRoute: ActivatedRoute,
    private router: Router

  ) { }

  ngOnInit(): void {
    const id = Number(this.activedRoute.snapshot.paramMap.get('id'));
    this.filmeService.buscar(id, '').subscribe(result => {
      this.filme = result[0]
    })
  }

  deletar(id: number) {
    Swal.fire({
      title: 'Tem certeza que deseja remover este filme?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Remover',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.filmeService.deletar(id).subscribe();
      }
      Swal.fire({
        title: 'Filme removido com sucesso!',
        icon: 'success'
      }).then(() => this.router.navigate(['/admin']));
    });
  }
}
