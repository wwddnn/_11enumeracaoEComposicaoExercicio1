package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level; //associacao com a classe WorkLevel do tipo enum.
    private Double baseSalary;
    //vou colocar a primeira associacao, que é da classe Worker com a classe Department. é de 1 para 1.
    private Department department;
    //vou colocar a outra associacao, que é da classe Worker com a classe HourContract. é de 1 pra muitos. como esses contratos sao muitos, entao teremos uma lista.
    //e já vou instanciar a minha lista por padrao na minha classe. a lista tem que ser instanciada por padrao. atencao !!!
    //essa lista de contratos vai começar vazia, e toda vez que eu chamar o metodo addContract, um contrato sera incluído nessa lista.
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    //atencao !!!!  nesse contrutor, eu nao vou marcar qualquer atributo que seja lista. nesse caso os contracts. ou seja vou gerar o meu construtor sem a minha lista.
    // atencao !!!! quando tivermos uma composicao tem muitos. nesse caso uma lista. nao incluimos ele no construtor. vou instanciar essa lista vazia ali em cima.
    public Worker (String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    //atencao !!!! lembrar de excluir o metodo setContracts(). isso porque so vamos acessar a lista atraves dos metodos addContract, e pelo metodo removeContract().
    //metodo para adicionar um contrato na lista. ele recebe um contrato como argumento.
    //esse metodo vai pegar a lista de contratos, e adicionar esse contrato que veio agora como argumento. usamos add()
    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    //de forma igual ao metodo de cima de adicionar, agora vamos fazer o metodo remover contratos da lista de contratos. usamos remove()
    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    //esse metodo calcula quanto a pessoa ganhou, baseado em um determinado ano e mês. ou seja esse método vai ser a soma do salaryBase mais o tanto que ele ganhou nos contratos daquele mesmo mês.
    //esse contrato tem uma data, e a partir dessa data eu posso pegar o ano e mês dessa data.
    //vou definir um calendario. depois dentro do loop for, cada data desse contrato c, eu vou setar nesse calendario a data do contrato c. ou seja eu peguei a data do meu contrato com c.getDate()...
    // e defini como sendo a data do meu calendario em cal.setTime().
    //depois peguei somente o ano daquela data que defini no calendario. e por fim peguei o mês da data que defini no calendario.
    //o '1 +' é porque o mês do calendar começa com zero.
    //por fim no comando if, vou comparar se o ano e mes que estou digitando for igual ao ano e mes desse contrato... caso sim, ai o valor desse contrato vai entrar na soma.
    public double income(int year, int month) {
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 +cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }

}
