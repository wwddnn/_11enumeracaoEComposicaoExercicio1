/*
exercicio:
**Ler os dados de um trabalhador com N contratos. Obs o usuário é que vai dizer quantos contratos o trabalhador tem. Depois o usuário vai solicitar um mês, e então...
o programa vai mostrar o salário do funcionário nesse mês escolhido. 
Segue a resolução:
teremos 3 classes e 1 classe enum. 
a classe Worker esta associada com HourContract, onde a relacao é de um para muitos. ou seja um trabalhador pode ter vários contratos.
A classe Worker esta associada com Department, onde a relacao é de 1 para 1. ou seja um trabalhador pode estar em 1 departamento.
obs comecamos implementando a classe Department, dentro do pacote entities.
obs na sequencia vamos implementar a classe HourContract, dentro do pacote entities.
obs agora vamos implementar a classe enum, que é WorkerLevel, e dentro do pacote entities.enums
obs agora por fim vou criar a classe Worker. essa classe tem duas associacoes. um é com a classe Department que é uma relacao de 1 para 1
, e a outra associacao é com a classe HourContract, que é uma relacao de 1 para muitos. obs apos criar a classe Worker e seus atributos, agora é a vez de eu imlementar as...
associacoes, nesse caso ela tem 2 associacoes. a primeira associacao sera assim ''private Department department''. obs ja na outra associacao que é de Worker com HourContract, é
uma relacao de 1 para muitos, ou seja um Worker tem 1 ou mais HourContract, entao eu tenho que representar isso na hora de implementar, como uma lista, e ja nesse momento que
to declarando a minha lista com o ArrayList ja tenho que instanciá-la com o uso do comando ''new''. nesse caso eu ja to iniciando minha lista vazia aqui mesmo, entao eu nao
vou coloca´la no contrutor.
obs pronto, agora na classe Worker, terminamos de fazer tanto os atributos basicos quanto as associacoes. isso é uma '''composicao de objetos'''.  
obs atencao para quando for colocar o construtor da classe Worker, nao marcar os atributos que sejam listas!!!!!! nesse exemplo nao vou marcar o atributo 'contracts'.
obs agora por fim vou gerar os metodos get e set da classe Worker. e tb implementar os metodos dessa classe Worker, dessa forma temos que adicionar os metodos
addContract e removeContract, e tbm temos que apagar o metodo setContract que tinha sido criado automaticamente no get e set..... justamente pq somente com os metodos
addContract e removeContract é que poderemos adicionar ou remover contratos da lista de contratos. 
obs e por fim na classe Worker vou implementar o metodo income() que é o quanto ele ganhou de salario base mais os ganhos nos contratos do mes.

as 3 classes sao:
//a classe worker tem 2 associacoes. ela tem uma associacao com a classe Department, e tem outra associacao com a classe hourContract.
- Worker
    private String name;
    private WorkLevel level;
    private Double baseSalary;
    metodos:
    addContract() ...é o metodo para adicionar um contrato.
    removeContract() ...é o metodo para remover um contrato.
    income() .. é o metodo para dizer quanto ele ganhou naquele mês.

- HourContract
    private Date date;
    private Double valuePerHour;
    private Integer hours;
    metodo:
    totalValue()

- Department
    private String name;

- classe enum:
WorkLevel
    JUNIOR
    MID_LEVEL
    SENIOR

*/