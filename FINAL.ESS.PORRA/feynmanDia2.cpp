/*
feynmanDia2

cucumber: ferramenta para transformar cenarios em testes de aceitacao.
com o uso de expressoes regulares

zenhub: ferramenta para registrar progresso do grupos alocar atividade aos desenvolvedores e estabelecer prazos.

seguinda as abordagens propostas pela agile, a equipe deveria se reuinicade 2 em duas
semanas com os stakeholders para ciarr novos requisitos e procurar validacao
dos stakeholders que o que foi criado até entao está correto.

o ciclo de vida da agile começa perguntando ao stakeholder o que ele espera
do sistema.

feature: 
As a [stakeholder]
So that I can [achieve some goal]
I want to [do some task]

os desenvolvedores atribuem pontos à suas user stories para estimar o tempo
que levaria para concluir sua implementacao. de acordo com quantos pontos uma equipe
faz por iteracao, poderá se estimar uma velocidade.

guia para se criar uma boa user story:
Specific : uma user story deve ser especifica afim de expliciar melhor seu comportamento.
ex:

Um cliente deve poder buscar um filme. (vago)
Um cliente deve poder buscar um filme pelo titulo do filme. (especifico)

Measurable: 

AO buscar um filme, um cliente deve ser um tempo de resposta rapido. (nao-mensuravel)
AO buscar um filme, um clietne deve ter um tempo de resposta de menos de 2 segundos. (mensuravel)

o primeiro story nao pode ser testado pois seus parametros de testes sao vagos.

Acheivable: uma user story deve poder ser implementado em uma interacao. Caso isso nao
seja possivel, deve-se quebrar ela em storeis menores que sejam atingiveis.

Relevant: uma user story deve apresentar algum valor para pelo menos um stakeholder
uma boa estrategia de se verificar se uma story é ralavante é fica se
perguntando "porque" até que se atinga um valor relevante.

Timeboxed: Deve poder estabeceler um tempo de implemenacao da story.

estimativa de custo:
a estimativa de custo será definido em reunioes com os stakehlders onde será definido
o escopo do projeto.

a ferramenta cucumber possibilita que criemos testes automatizados a partir
dos cenários usando expressoes regulares.

qual a vantagem de o uso de cenarios?

Cenários possibilitam que integrantes tecnicos e nao tecnocios estejam falando a mesma lingua, 
pois cenários usam de linguagem simples e comum ao explicitar o comportamento
do sistema em uma situacao especifica. Outra vantagem do usso s cenários
é que ao usar as expressoes regulares podemos integrar-los ao cucumber e rodar testes
automatizados. O testes automizatizados verificam o sistema. Os stakeholders
validam o sistema.

cenarios de GUI sao cenarios referentes ao comportamento do sistema que o usuario consegue
ver na tela. cenarios de serviço sao referentes ao comportamento back-end
do sistema (coisas feito banco de dados).

geralmente features incluem cenários de sucesso e cenários de falha.
Os primeiros cenários que a equipe deve-se focar são os ceários mais relevantes.
e não investir tempo de requisitos secundários.

o foco dos cenários deve-se ser com os requisitos funcionais. Os requisitos nao funcionais
nao podem ser testados tao facilmente, e assim nao devem ser o principal foco
na hora da criacao de cenarios.

Parametrizar os passos do cenário:
o que significa parametrizar os passos do cenários?
devemos colocar em aspas " as palavras chave dos cenários para faciltar a 
futura implementacao de testes.

API -> uma forma que o sistema se comunique com o banco de dados.

cenário de API -> cenarios de API afzem parte do conjeunto de cenários de serviço. cenários
de API sao cenarios aonde a interface do cliente se comunica com o banco de dados (back -end)
ou servidor do sistema.

ao criar um passo When de um cenário use-o para explicitar uma acao. Cuidado 
ao usar o When para nao usar-lo em uma "nao-acao" ou uma acao vazia
ex: When eu aguardo o sistema responder.
ex: When eu nao faço nada.

prefira usar cenarios declarativos à cenarios imperativos, pois os cenarios
declarativos focarm mais na parte do comportamento. Cenarios declarativos
podem tambem ser descritos como cenários de alto nivel.

cenario imperativo:
When clico no botao "criar pdf" e depois clico no botao "enviar"
cenario declarativo:
When eu crio um pdf e envio.

cenario imperativo:
When eu ciclo na caixa de dialogo e insiro onome "joao"
And clico na caixa de dialogo do cpf e digito "683" 
And clico em "aidicionar cliente"

cenario declarativo:
When eu adiciono o cliente com nome "joao" e cpf "683".

ao testar um ceario queremos testar um passo por vez, nao queremos que o cenario
ou o passo seja dependente de outros cenarios para que funcione. Crie uma situacao
para rodar especificamente aquele passo.

cenarios declarativos sse focam mais no comportamento do sistema. cenarios declarativos
oferecem maior abstracao nos seus passos, facilitanto o entendimento do
stakehloder e tambem facilitanto a implementacao de testes, ja que testa algo
imperativo (descrvevendo passos específicos) não é tão viavel pois a implementacao
dos cenários pode estar sujeito a mudanças.

cennarios explicitos excplicitam os passos descritos pelo stakeholder.

cenário implicito descreve todos os passos nos quais os cenários explicitos implicam, ou seja
todos os passos que o sistema necessita que ocorra para que ocorram os passos dos cenarios
explicitos.

CHAPTER 10

pra que serve o git merge?
digamos que você queira mesclas as mudanças de duas ramificacoes do projeto.

pra que serve o recurso branch?
se você quer experimentar com novas funcionalidades ou tentar resolver um bug
sem comporoeter codigo estável você pode criar uma ramificacao do seu projeto,
que seria uma cópia exata do momento em que você fez a ramificacao.

local repo: o repositorio local é a copia do projeto que fica na sua máquina
nela você pode trabalhar no projeto, empurrar as mudanças (push) para o 
repositorio compartilhada, ou puxar as modificações da mesma para o seu repositorio local.

git status: lista o conjutno de arquivos modificados mas que nao sofreram commits,
diz o estado desses arquivos, se estao sendo rastreados ou nao (add), e nos infora do
estado atual da nosa branch local, se está atrás, em dia, o n commits na frente da nossa branch remota.

git add adiciona arquivos modificados para sofrerem commit.

commit: qunado se dá um cmmit se salva uma versao do projeto com todos os arquivo 
rastreados. esse commit pode ser visualizado por qualquer integrante apos ser
empurrado para o repositorio remoto, essa versao do projeto repesentado pelo commit
pode ser acessada e o projeto retornará a essa versao caso isso for o desejado.

pra que serve o commit?
para slavar as nossos mudanças em nossa branch local.

branch: caso queriamos testar uma nova funcionalidade ou tentar corrigir um bug
sem comprometer codigo que está estavel, criamos uma ramificacao do projeto
atual usando branch.

fork: caso nao temos autorizacao para trabalharmos em um projeto, criamos uma copia
do mesmo em nossa prórpia conta do github usando fork.

rebase: uma alternativa ao merge, quando queremos mesclas as mudanças
de uma nova branch mas tambem preservar o seu histórico de commits.

squash: tem o proposito de unir varios commits. Unir commits é uma boa prática
porque assim podem deixar o nosso histórico mais limpo e que 
representa melhor o a história do desenvolvimento do projeto.

PROVAS ANTIGAS

os passos When poderiam estar mais declarativos e em geral
os Given, WHen e Then poderiam estar mais especificos e parametrizados.

o cenário todo poderia ser reescrito da seguinte forma:

Given eu loguei no sistema com um login "gui123" e uma senha "655"
And estou na página "disciplinas ministradas este semestre"
When eu seleciono a opçao de "nota unica"
And preencho a nota do aluno "Guilherme" com a nota "9.5"
Then a nota "9.5" do aluno "Guilherme" é gravada no sistema e o login "gui123" é associado à ela.

o cenário a seguir está imperativo, com passos demais e o foco do comporatamento
principal o qual queremos descrever se perde.

o cenario todo poderia ser reescrito da seguinte forma:

Given I am on the RottenPoPatoes "home" page
When I add "Zorro" with rating "PG"
And I add "Apocalypse now" with rating "R"
Then I should see "Apocalypse now" before "zorro" on the ROttenPOtatoes "home" page

3-
(a) - uma branch é uma ramificacao do projeto. É uma copia do codigo do momento
aonde foi criado a branch.

(b) - caso eu queira experimentar com alguma nova funcionalidade  sem
comprometer o funcionamento do codigo ja existente ou tentar consertar um bug
sem mexer em codigo ja eixxistente. É uma forma segura de implementar novas
mudanças sem comprometer o que ja foi feito ou atraplhar aqueles que estao trabalhando em
paralelo com você.

(c) - a operacao merge tem a intencao de unir as modificacoes de duas branches.
pode ser usado em diversar situacoes. se uma branch foi criada para testar
uma nova funcionalidade e agora queremos integrar na branch principal.

4- sim, qualquer branch pode fazer merge com quaklquer outra desde que eles tenham um
commit em commum que sirva como ancestral em commum.

QUESTIONS FROM PREVIOUS EXAMS

Cenario: matricula de uma disciplina da UFPE aonde há vaga.

Given estou na pagina de "matricula"
When eu tento matricular uma disciplina "ESS"
And confirmo minha matricula
Then vejo uma mensagem de confirmacao.
And vejo a disicplina "ESS" na pagina de "horarios"


