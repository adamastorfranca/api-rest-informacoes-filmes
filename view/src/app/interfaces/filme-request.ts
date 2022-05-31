export interface IFilmeRequest {
  titulo: string;
  anoLancamento: number | null;
  duracaoMinutos: number | null;
  sinopse: string;
  urlImagem: string;
  urlTrailler: string;
  idGenero: number | null;
}
