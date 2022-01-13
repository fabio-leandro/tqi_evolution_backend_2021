# Repositório para viver a realidade TQI


<h3>Solução</h3>
A solução proposta foi uma API REST/RESTFUL com spring. Houve um questionamento sobre iniciar a aplicação com a estrutura Spring MVC ou WebFlux. Ambas as soluções foram vistas no Bootcamp. A solução escolhida foi a MVC que opera de maneira síncrona, já que não se imagina requisições com grande volume de dados e cada cliente consumiria dados particulares. Não teríamos por exemplo, vários clientes fazendo a mesma requisição.

Imagina-se um cenário hipotético onde essa solução faz parte de um ecossistema com outras APIs que será exposta para consumo. Isso porque entende-se que o desafio proposto é um primeiro contato com o cliente e a empresa tem como atividade a análise de crédito. A solucão de API engloba os requisitos propostos no desafio.
        
 <h3>História</h3>
O cliente acessa o front-end pela primeira vez e para continuar precisa fazer o seu cadastro com dados pessoais e informações de login. Feito o cadastro o cliente poderá solicitar um empréstimo, listar todos os empréstimos que ele solicitou e detalhar um empréstimo solicitado. Tem a possibilidade de conferir e atualizar os dados pessoais, tão como cancelar e recuperar a senha. Depois de cadastratado o cliente terá um acesso com email e senha.

  <h3>Entidades</h3>
  <img src="https://github.com/fabio-leandro/tqi_evolution_backend_2021/blob/main/MODELAGEM%20LOAN.png" alt="Entidades">
  
  <h3>i. Cadastro de clientes</h3>
  
 O cliente faz um POST enviando no corpo da requição DTOs de Customer, Address e Login. Será salvo no banco de dados em cascata. Essa requisição cai no Controller de Customers que chama o servço na camada service, o serviço acessa o repository, e o repository é responsável por finalizar a persistência no banco de dados.
 
 <h3>ii. Login</h3>
 A autenticação e autorização foi feita utilizando o Spring Secuirty. Foram criadas duas roles, ROLE_CUSTOMER e ROLE_ADMIN. Quando cliente envia a requisição POST referente a cadastro, a role que controla as autorizações de cliente também é salva. A senha é salva no banco de dados criptografada. O cliente pode atualizar seus dados de login.
 
 <h3>iii. Solicitação de empréstimo</h3>
 É possível solicitar um empréstimo através do método POST. O cliente envia no corpo da requisição um DTO da entidade cliente, nesse envio temos o valor, quantidade de parcelas  e a data para o pagamento da primeira parcela.
 A quantidade máxima de parcelas está sendo validada com o Bean Validation do Spring.
 O prazo máximo para a primeira parcela de pagamento do empréstimo está sendo validada na camada de serviço, lançando uma exception personalizada caso a data seja inválida.
 
 <h3>iv. Acompanhamento das solicitações de empréstimo</h3>
 Para listar todos os empréstimos referente a um cliente é possível fazendo uma requisição GET e enviando como parâmetro o código do cliente.
 Para detalhar um empréstimo especifico do clientes foi criado um DTO (DetailsLoanDto). Nessa requisição GET é necssário enviar como parâmetro os códigos do cliente e o código do empréstimo.
 
 <h3>Exceptions e Validações</h3>
 
 Com a classe ExceptionHandler em conjunto com mensagens de erros customizadas é possível inteceptar os erros de BAD_REQUEST validados com o BeanValidation do Spring.
 
 Foram criadas exceptions e mensagens customizados para requisições que não encontram objetos no banco de dados.
 
 <h3>Ferramentas</h3>
 <dl>
        <li>Java 11</li>
        <li>Maven</li>
        <li>Spring Boot</li>
        <li>docker</li>
        <li>Postgres SQL</li>
        <li>WSL2 e UBUNTU</li>
        <li>Postman</li>
        <li>Swagger</li>
        <li>intellij</li>
</dl>

<h3>Bibliotecas Auxiliares</h3>
 <dl>
        <li>Lombok - Auxlia na otimização de códigos</li>
        <li>ModelMapper - Auxilia no mapeamento de objetos. Possiblitou copiar propriedades entre as Entidades e os seus DTOs</li>
        
</dl>

#tqi_evolution_avaliacao
 

 
 
 
