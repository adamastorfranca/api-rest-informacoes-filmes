INSERT INTO PLANOS(ID_PLANO, DS_NOME, DS_PLANO, NU_VALOR) VALUES(1, 'ROLE_BÁSICO', 'Resolução 480p', 25.90);
INSERT INTO PLANOS(ID_PLANO, DS_NOME, DS_PLANO, NU_VALOR) VALUES(2, 'ROLE_PADRÃO', 'Resolução 1080P', 39.90);
INSERT INTO PLANOS(ID_PLANO, DS_NOME, DS_PLANO, NU_VALOR) VALUES(3, 'ROLE_PREMIUM', 'Resolução 4K', 55.90);
INSERT INTO PLANOS(ID_PLANO, DS_NOME, DS_PLANO, NU_VALOR) VALUES(4, 'ROLE_ADMINISTRADOR', '', 0);

INSERT INTO CARTOES(ID_CARTAO, NU_CODIGO, NU_CPF, DS_MODALIDADE, DS_NOME_TITULAR, NU_CARTAO, DT_VALIDADE) 
VALUES(1, '987', '08353297477', 'DÉBITO', 'ADAMASTOR LINS FRANCA NETTO', '0000111122223333', '2028-05-31');

INSERT INTO FAVORITOS(ID_FAVORITO) VALUES(1);

INSERT INTO USUARIOS(ID_USUARIO, BL_ATIVO, DT_NASCIMENTO, DS_EMAIL, DS_NOME, SENHA, FK_CARTAO, FK_FAVORITO)
VALUES(1, TRUE, '1992-05-01', 'adamastor@email.com', 'ADAMASTOR LINS FRANCA NETTO', '$2a$10$VP03yn4YG5vmn8w9zZ.bo.RJNODOEoZyB15CZ2AwwauULHNQYI7Be', 1, 1);

INSERT INTO USUARIOS_PLANO(USUARIO_ID_USUARIO, PLANO_ID_PLANO) VALUES(1, 4);

INSERT INTO GENEROS(ID_GENERO, DS_NOME) VALUES(1, 'Ação');
INSERT INTO GENEROS(ID_GENERO, DS_NOME) VALUES(2, 'Ficção científica');

INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(1, 2022, 131, 'Na sequência de Top Gun: Ases Indomáveis, acompanhamos a história de Pete “Maverick” Mitchell (Tom Cruise), um piloto à moda antiga da Marinha que coleciona muitas condecorações, medalhas de combate e grande reconhecimento pela quantidade de aviões inimigos abatidos nos últimos 30 anos. Entretanto, nada disso foi suficiente para sua carreira decolar, visto que ele deixou de ser um capitão e tornou-se um instrutor. A explicação para esse declínio é simples: Ele continua sendo o mesmo piloto rebelde de sempre, que não hesita em romper os limites e desafiar a morte. Nesta nova aventura, Maverick precisa provar que o fator humano ainda é fundamental no mundo contemporâneo das guerras tecnológicas.', 
'TOP GUN: MAVERICK', 
'https://br.web.img3.acsta.net/c_310_420/pictures/19/12/16/15/00/5548914.jpg',
'https://www.youtube.com/embed/qSqVVswa420', 1);

INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(2, 2022, 126, 'Em Doutor Estranho no Multiverso da Loucura, após derrotar Dormammu e enfrentar Thanos nos eventos de Vingadores: Ultimato, o Mago Supremo, Stephen Strange (Benedict Cumberbatch), e seu parceiro Wong (Benedict Wong), continuam suas pesquisas sobre a Joia do Tempo. Mas um velho amigo que virou inimigo coloca um ponto final nos seus planos e faz com que Strange desencadeie um mal indescritível, o obrigando a enfrentar uma nova e poderosa ameaça. O longa se conecta com a série do Disney+ WandaVision e tem relação também com Loki. O longa pertence a fase 4 do MCU onde a realidade do universo pode entrar em colapso por causa do mesmo feitiço que trouxe os vilões do Teioso para o mundo dos Vingadores e o Mago Supremo precisará contar com a ajuda de Wanda (Elizabeth Olsen), que vive isolada desde os eventos de WandaVision.', 
'DOUTOR ESTRANHO NO MULTIVERSO DA LOUCURA', 
'https://br.web.img3.acsta.net/c_310_420/pictures/22/02/14/18/29/1382589.png',
'https://www.youtube.com/embed/X23XCFgdh2M', 2);

INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(3, 2022, 177, 'Batman  segue o segundo ano de Bruce Wayne (Robert Pattinson) como o herói de Gotham, causando medo nos corações dos criminosos da sombria cidade. Com apenas alguns aliados de confiança - Alfred Pennyworth (Andy Serkis) e o tenente James Gordon (Jeffrey Wright) - entre a rede corrupta de funcionários e figuras importantes do distrito, o vigilante solitário se estabeleceu como a única personificação da vingança entre seus concidadãos. Durante uma de suas investigações, Bruce acaba envolvendo a si mesmo e Gordon em um jogo de gato e rato, ao investigar uma série de maquinações sádicas em uma trilha de pistas enigmáticas estabelecida pelo vilão Charada. Quando o trabalho acaba o levando a descobrir uma onda de corrupção que envolve o nome de sua família, pondo em risco a própria integridade e as memórias que tinha sobre seu pai, Thomas Wayne, as evidências começam a chegar mais perto de casa, precisando, Batman, forjar novos relacionamentos, para assim desmascarar o culpado e fazer justiça ao abuso de poder e à corrupção que há muito tempo assola Gotham City.', 
'BATMAN', 
'https://br.web.img2.acsta.net/c_310_420/pictures/22/03/02/19/26/3666027.jpg',
'https://www.youtube.com/embed/rsQEor4y2hg', 1);

INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(4, 2021, 157, 'Eternos são seres super dotados com características como imortalidade e manipulação de energia cósmica, e eles são frutos de experiências fracassadas de seu próprio criador, o Celestial Arishem, desde a criação da Terra há milhões de anos. Destinados a salvar o mundo e a raça humana dos Deviantes, seres também criados pelo Celestial, os Eternos então derrotam tais seres e seguem caminhos diferentes, esperando que seu criador volte com boas novas. Mas após séculos e milênios aguardando ele, o grupo de heróis imortais agora precisa se preparar para uma nova ameaça, e precisam lutar contra os Deviantes novamente para garantir a segurança da humanidade. Muitos conflitos internos podem surgir, entre o amor que sentem pela Terra e a necessidade de protegê-la acima de tudo, e a fé naquilo que está acima deles. Cada um deverá lutar pelo o que acredita, e defender o que for mais importante.', 
'ETERNOS', 
'https://br.web.img3.acsta.net/c_310_420/pictures/21/05/24/16/48/4639391.jpg',
'https://www.youtube.com/embed/PJza3ZaFeAU', 2);

INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(5, 2022, 137, 'Baseado na obra de Shakespeare, Hamelt e a lenda viking de Amelth, O Homem do Norte segue uma história de vingança e loucura de um príncipe. Se passando no ápice da Landnámsöld, no ano de 914, o príncipe Amleth (Alexander Skarsgård) está prestes atingir maioridade e ocupar o espaço de seu pai, o rei Horvendill (Ethan Hawke), que acaba sendo brutalmente assassinado. Amelth acaba descobrindo que seu tio é o culpado, mas sem sequestrar a mãe de Amleth primeiro. O menino então jura que um dia voltaria para vingar seu pai e matar seu tio. Vinte anos depois, agora Amleth, um homem viking que sobrevive ao saquear aldeias eslavas, conhece uma vidente. Ela por sua vez o lembra que chegou a hora de cumprir a promessa que fez há muito tempo atrás: salvar sua mãe, matar o tio e vingar o pai. O ex-príncipe então parte para uma odisseia em busca do tio.', 
'O HOMEM DO NORTE', 
'https://br.web.img2.acsta.net/c_310_420/pictures/22/05/02/18/58/1004817.jpg',
'https://www.youtube.com/embed/59iAzYuo2Qk', 1);

INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(6, 2021, 148, 'Em Homem-Aranha: Sem Volta para Casa, Peter Parker (Tom Holland) precisará lidar com as consequências da sua identidade como o herói mais querido do mundo após ter sido revelada pela reportagem do Clarim Diário, com uma gravação feita por Mysterio (Jake Gyllenhaal) no filme anterior. Incapaz de separar sua vida normal das aventuras de ser um super-herói, além de ter sua reputação arruinada por acharem que foi ele quem matou Mysterio e pondo em risco seus entes mais queridos, Parker pede ao Doutor Estranho (Benedict Cumberbatch) para que todos esqueçam sua verdadeira identidade. Entretanto, o feitiço não sai como planejado e a situação torna-se ainda mais perigosa quando vilões de outras versões de Homem-Aranha de outro universos acabam indo para seu mundo. Agora, Peter não só deter vilões de suas outras versões e fazer com que eles voltem para seu universo original, mas também aprender que, com grandes poderes vem grandes responsabilidades como herói.', 
'HOMEM ARANHA: SEM VOLTA PARA CASA', 
'https://br.web.img3.acsta.net/c_310_420/pictures/21/11/08/16/02/3963914.png',
'https://www.youtube.com/embed/FDNNHh7TRN0', 2);

INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(7, 2021, 152, 'Em 007 - Sem Tempo Para Morrer, depois de sair do serviço ativo da MI6, James Bond (Daniel Craig) vive tranquilamente na Jamaica, mas como nem tudo dura pouco, a vida do espião 007 é agitada mais uma vez. Felix Leiter (Jeffrey Wright) é um velho amigo da CIA que procura o inglês para um pequeno favor de ajudá-lo em uma missão secreta. O que era pra ser apenas uma missão de resgate de um grupo de cientistas acaba sendo mais traiçoeira do que o esperado, levando o agente inglês 007 ao misterioso vilão, Safin (Rami Malek), que utiliza de novas armas de tecnologia avançada e extremamente perigosa. O que o ex-agente não esperava era que ele tivesse que ajudar mais uma vez a MI6 para impedir que o mundo sofra nas mãos desse novo vilão. Se isso não bastasse, o agente secreto ainda acaba descobrindo que uma pessoa de sua vida passada acaba voltando e com segredos que ele nunca imaginava.', 
'007 - SEM TEMPO PARA MORRER', 
'https://br.web.img3.acsta.net/c_310_420/pictures/19/10/05/16/20/4518067.jpg',
'https://www.youtube.com/embed/kCyjw0z-5KI', 1);

INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(8, 2021, 152, 'Em Shang-Chi e a Lenda dos Dez Anéis, Shang-Chi (Simu Liu) é um jovem chinês que abandonou seu país e seu pai, que lhe treinou desde criança nas artes marciais para ser um assassino ao seu dispor. Seu pai porta Dez Anéis que lhe dão poderes e longevidade, vivendo por séculos. Porém ao conhecer a mãe de Shang-Chi, ele se apaixona e tenta mudar sua vida, mas ela morre anos depois de dar a luz para a irmã mais nova de Shang-Chi, voltando causar tumulto na China. Após completar 18 anos, Shang-chi foge de seu pai em uma missão que vingaria a morte de sua mãe, mas o passado segue Shang-Chi e agora seu pai está atrás do colar que poderia resgatar sua falecida mãe. Mas o que o pai de Shang-Chi não sabe é que o mal está à espreita e ele está caindo na armadilha de um antigo e poderoso mal.', 
'SHANG-CHI E A LENDA DOS DEZ ANÉIS', 
'https://br.web.img2.acsta.net/c_310_420/pictures/21/08/05/20/13/2818037.jpg',
'https://www.youtube.com/embed/AfHiUtxrmiY', 2);


INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(9, 2030, 1, 'Sinopse teste.', 
'FILME TESTE 1', 
'/assets/img/branco.jpg',
'https://www.youtube.com/embed/sbsSlx87zxc', 1);

INSERT INTO FILMES(ID_FILME, NU_ANO_LANCAMENTO, NU_DURACAO, DS_SINOPSE, DS_TITULO, DS_URL_IMAGEM, DS_URL_TRAILLER, FK_GENERO)
VALUES(10, 2040, 2, 'Sinopse teste', 
'FILME TESTE 2', 
'/assets/img/branco.jpg',
'https://www.youtube.com/embed/DdA1RHa7dUM', 2);