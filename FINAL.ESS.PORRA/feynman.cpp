/*
CHAPTER 7 

AGILE:
user stories: cenarios para elicitar requisitos funcionais
UI storyboards : elicitar requisitos de User Interface
Pontos: para estimar o custo de tempo relacionado à implementacao de cada cenário.
Velocidade: para medir e estimar a velocidade de trebalho de equipe
cucumber: programa usado para transformar user stories em testes de aceitacao.
usar programas como pivotal tracker/zenhub ou até features do prórpio github para
manter registro do progresso, agendar prazos e alocar tarefas aos membros da equipe.

Agile, BDD:
é um dos pilares da abordagem agile a consulta frequente com os stakeholders.
É comum as equipes agile se reunirem (desenvolvedores e stakeholders) de duas em duas semanas
para crirar novos cenários e checar com os stakeholder que o que foi criado até então
está como eles imaginaram(validacao).

a cada iteracao (chamada de sprint) os stakeholders são consultudos sobre quais novas features eles queem mplementados
e tambem para verificar se as features ja presentes se comportam como
eles esperavam.

o ciclo de vida agile começa tem como base fazer perguntas sobre o comportamento do sistema, antes e durante o seu desenvolvimento
ao stakeholder para ter certeza se o que ele pediu está de fato sendo implementado.

Como escrever uma user story:
As a [stakeholder]
So that I can [acheive some goal]
I want to [do some task]

Feature: add a comment
    As a sistem user
    So that others can see my comment and repond to it
    I want to write a comment on a post

os cenários são passados para os desenvolvedores com cada desenvolvedor  
atribuindo uma quantia de pontos a sua user story afim de estimar o quanto
tempo levaria para implementar-la e e assim ajudar a estimar um porazo para
a conculsao do projeto.

como fazer uma boa user story: suar o acronimo SMART
Specific,Measurable,Relevant,Timeboxed



specific: stories devem ser específicos, afim de explicitar melhor seu comportamento
e tambem com a finalidade de rodar mais facilmente os testes.

Feature: a user can search for an event (vague)
Feature: a user can search for an event by the event name.

measurable: 

Feature: When adding a new client, I should have a fast response time.
Feature: When adding a new client, I should have a response time
of under 2 seconds.

o primeiro requisito nao pode ser testado aprorieadamente pois seus parametros
de teste são muito vagos.

acheivable: uma story deve ser implementada em uma iteracao. Caso isso nao seja
possivel, ela deve ser quebrada em stories menores cada uma implementada
em uma iteracao.

relevent: uma story deve apresentar valor para pelo menos um stakeholder.
Uma boa estratégia para decidir se uma story é relevante ou não é ficar 
perguntando "porque" até que seja atingido um valor relevante.

timeboxed: deve se estabelecer um limite de tempo para
comcluir uma story, caso esse limite for extrapolado, a story abandonada
ou dividida em stories menores atribuindo novas pontuacoes a elas.

Estimativa de custo

a estimativa de custo será definida em reunioes com os
stakeholders aonde será definido o escopo do projeto.

user story é a combinacao de feature com seus cenários.

a ferramenta cucumber possibillita que rodemos testes automatizados
a partir de nossos cenários.

a vantegem de o de cenarios é que porribilitam que os stakeholders e desevolvedores
estejam falando a mesma lingua, usando passo a passo com linguagem simples.
Outra vantagem dos user stories é que permitem qu os testes sejam automitazados
com o uso de expressoes regulares. esses testes servem para verificar o 
sistema. (validacao é o stakeholder que faz).

podemos ter dois tipos de cenarios, cenarios de GUI e cenarios de serviço, 
cenarios de GUI sao referentes ao comportamento do sistema que o usuário vê 
ocorrendo na tela. essse tpo de cenário verifica o funcoinameto
visual da operacao, nao é referente à algo por exemplo, que está sendo armazenado
no servidor ou em algum banco de dados

cenarios de serviço são cenarios mais relacionados ao back-end do sistema,
se os objetos corretos estao sendo armazenados no banco de dados, se o sistema
por "traz das telas" excluindo a parte de interface com usuário está rodando da 
forma como deve. (cenario de API por exemplo).Se o serviço nao possur uma API,
ou seja, uma forma que o ssietam se comunique com o banco de dados
pela interface do cliente, entao nao será necessario criar cenarios de serviço.
cenários de GUI ja bastariam.

idealmente as features incluem cenarios de sucesso e cenarios de falha.
deve-se focar a cobrir os cenarois de uso mais relevantes.

o foco dos cenarios deve ser sempre em requisitos funcionais, ja que requisitos
nao funcionais como robustez e escabilidade nao podem ser testados.

PARAMETRIZAR os passos do cenario: colocar os itens específicos em aspas"".

sempre usar o When para especificar ações, nunca nao-açoes ou ações vazias tais como:
When eu espero ou When eu nao faço nada.

usar cenarios de alto nivel (cenarios declarativos) ex:
When eu seleciono a opcao "PDF" e pressiono o botao "enviar" (imperativo)
When eu envio um arquivo pdf (declarativo)
cenarios declarativos soa mais preferidos pois a implementaco do sistema está
sempre sujetito à mudanças.

focar apenas na situacao que você quer testar, por exemplo, no passo given: faça com que
com que ja seja verdade a condicao, e nao faça com que o teste crie toda a situacao
que faça com que a condicao seja verdade.

cenarios declarativos oferecem maior abstracao, fanzo com que a criacao de testes
se torne mais viavel assim comodescrever o cenário pelo seu comportamento ao
invez de passos específicos.

cenarios explicitos focam mais nos passos que sao esperados pelo stakeholder
cenarios implicitos sao referentes a passos que são esperados do sistema porem 
que nao condiz ao comportamento que o stakeholder explicitou do sistema.

CHAPTER 10

pra que serve o git merge: caso dois desenvolvedores mexerem no mesmo arquivo
de forma conflitante (nas mesmas linhas de codigo) o git permite que as
mudanças sejam integradas de forma que o desenvolvedor que está exectando o
merge possa decidir quais parte serao mantida e quais serao removidas.

para experimentar com novas funcionalidades sem mexer em codigo ja funcionando
é pratico usar do recurso branch.

local repo: repositorio local do desenvolvedor aonde ele pode
puxar as mudanças feitas do repositorio remoto (pull) pode modificar seu codigo
e empurarr para o repositorio remoto (push) aonde os outros integrantes podem
ter acesso às suas mudanças.

git status -> nos lista o conjunto de arquivos que foram modificados mas que ainda nao
sofreram commit. Tambem nos informa da situacao do nosso branch local (se ele está
atás do repo remoto ou "up to date" (em dia)).

o commando git add adiciona aquivos modificados para sofrerem commit.

commit: quando se dá um commit você cria uma versao do projeto que contem todos
os arquivos rastreados e pode ser acessado por qualquer integrante depois que
dado um push. Os commits sao salvos  e você pode acessar à commits anteriores
caso houve um erro numa nova versao ou por qualquer outra razao.

branch: 
branches sao criadas para desenvolver features em paralelo eao codigo principal 
sem prejudicar codigo estavel. Branches permitem que nós experimentamos
com novas funcionalidades do nosso projeto ao mesmo tempo que os outros integrantes
continuem trabalhando na branch principal.

merge: um merge mesca as mudanças de duas branches por exemplo: caso você crie
mudanças em uma nova branch e quiser integrar na branch principal, você
dá merge da branch na branch principal, se nao houver conflito o merge apenas
integrará as mudanças, caso contrario o desenvolvedor escolherá quais linhas de código
serão sobreescritas.

git push empurra as mudanças feitas no seu repositorio local ao repositoroio rmeoto.
é uma boa pratica sempre dar um pull para integrar quaiquer mudanças feitas 
pelos seus colega antes de dar push. Quando pull é dado,pode ser que ocorram
conflitos de merge, resolva-os e em purre a sua nova versao ao repositorio remoto.

git pull é uma combinacao das instrucoes git fetch e git merge, ele busca as
mudancas feitas no repositorio remoto e depois mescla elas.

boas praticas: **sempre dê commit antes de dar pull. sempre dê pull antes de dar push

dar commit  antes de dar push garante que seu trabalho está registrado e nao serpa perdido.
dar pull antes de dar push garante que você esstará empurrando a versao mais atualizada
(na vdd o git nem deixa você dar push em uma versao desuatualizada).

nós usamos fork quando criamos ramificações de um projeto existente mas para
a nossa propria conta do github. Nós damos fork quano nao temos acesso
ao projeto original aí o fork cria uma copia do projeto e salva no nosso
repositorio github.

o pull request é feito quando queremos integrar as mudanças realizadas no nosso fork ao 
repositorio original.

rebase: uma alternativa para o merge quando se quer manter  o historico
de commits da branch na qual você esta dando o commando rebase

ex:

branchTeste     master
commit2         m2    
commit1         m1
c               c
sendo c o commit que foi criado a branch teste...
na master: git rebase branchTeste

novo historico na master: 
commit2
commit1
m1
m2
m

squash: usado para unir varios commits
o squash tem o inuito de diminuir o numero de commits afim de melhor representar
ohistorico de desenvolvimento do projeto.
*/


