# Repositório para viver a realidade TQI


<h3>Solução</h3>
A solução proposta foi uma API REST/RESTFUL com spring. Houve um questionamento sobre iniciar a aplicação com a estrutura Spring MVC ou WebFlux. Ambas as soluções foram vistas no Bootcamp. A solução escolhida foi a MVC que opera de maneira síncrona, já que não imagina requisições com grande volume de dados e cada cliente consumiria dados particulares. Não teríamos por exemplo, vários clientes fazendo a mesma requisição.

Imagina-se um cenário hipotético onde essa solução faz parte de um ecossistema com outras APIs que será exposta para consumo. Isso porque entende-se que o desafio proposto é um primeiro contato com o cliente e a empresa tem como atividade a análise de crédito. A solucão de API engloba os requisitos propostos no desafio.
        
 <h3>História</h3>
O cliente acessa o front-end pela primeira vez e para continuar precisa fazer o seu cadastro com dados pessoais e informações de login. Feito o cadastro o cliente poderá solicitar um empréstimo, listar todos os empréstimos que ele solicitou e detalhar um empréstimo solicitado. Tem a possibilidade de conferir e atualizar os dados pessoais, tão como cancelar e recuperar a senha. Depois de cadastratado o cliente terá um acesso com email e senha.

  <h3>Entidades</h3>
 "https://drive.google.com/file/d/1m6EfFbJcygwYhWJ-ALDPYBiQ8gC0Fb_A/view?usp=sharing"
