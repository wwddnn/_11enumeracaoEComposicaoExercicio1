package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //tenho que instanciar uma SimpleDateFormat pq ela sera usada mais a frente dentro do looping for.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Primeiro vou perguntar os dados do trabalhador, e vou registrar esses dados. Daí então vou instanciar um novo objeto Worker.
        System.out.print("Enter department's name ");
        String departmentName = sc.nextLine();
        System.out.println("Enter work data ");
        System.out.print("Name");
        String workerName = sc.nextLine();
        System.out.print("Level ");
        String workerLevel = sc.next();
        System.out.print("Base salary ");
        double baseSalary = sc.nextDouble();
        //agora já posso instanciar o meu trabalhador:
        //no atributo WorkerLevel tenho que fazer assim pq ele é um tipo enum, e depois coloco valueOf para criar uma instancia do enum, e como argumento ai sim recebe o tipo enum que escolher.
        //ja no caso do atributo department, ele é um outro objeto do tipo departament. tenho que instanciar ele com new. e depois sim passar o que foi perguntado la em cima que é o departmentName.
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        //O próximo passo é criar os contratos, então eu vou perguntar ao usuário quantos contratos o trabalhador tem, e depois ele digita a data do contrato, o valor por hora, e por fim a duração em horas desse contrato.
        System.out.print("How many contracts to this work ");
        int n = sc.nextInt();
        //dentro desse for, vou ter que ler uma data, e o tipo dela sera Date. mas antes, tenho que instanciar la fora, um SimpleDateFormat.
        //esse for vai se repetir varias vezes, ate instanciar todos os contratos com os trabalhadores.
        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + (i + 1) + "data " );
            System.out.print("Date (DD/MM/YYYY) ");
            //atencao ! aqui é uma variavel do tipo Date ! que vai ler a data que o usuario ira digitar.
            //entao, la em cima, tenho que criar um formato, que sera o SimpleDateFormat e criar um padrao customizado, que sera dd/MM/yyyy. o nome dele sera sdf e vou chamar ele aqui abaixo passando por dentro a data que foi digitada pelo usuario.
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours) ");
            int hours = sc.nextInt();
            //agora que ja tenho esses 3 dados, que sao o contractDate, o valuePerHour, e o hours, ja tenho condições de instanciar o meu contrato.
            //tenho que usar o new, pq é um novo objeto, que é um novo objeto HourContract.
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);

            //Agora, vou pegar esse trabalhador que foi criado lá em cima, e vou associar com esses contratos, que acabaram de ser criados.
            //pronto, agora para associar esse meu contrato, com o meu trabalhador Worker que foi instanciado no for de cima, vou chamar o meu Worker e adicionar o contrato...
            //isso faz o meu contrato ser associado com o trabalhador.
            //então agora todos os objetos de contratos criados HourContract, estarão associados ao meu trabalhador Worker.
            worker.addContract(contract);
        }

        //Agora por fim, o usuário vai entrar com o mês e o ano.
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY) ");
        //eu vou ler esse mês e ano, e vou recortar essa String manualmente.
        String monthAndYear = sc.next();
        //vou informar dentro do metodo subString, o inicio e o fim onde eu quero recortar a minha string. isso vai recortar o string gerando um substring com 2 digitos....
        //... a seguir eu tenho que converter esse meu substring, para um número inteiro, por isso uso o metodo Integer.parseInt
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        //com o ano vamos fazer a mesma coisa. declara uma variável ano, que recebe o monthAndYear, e agora vou colocar o método subString para recortar minha String, nesse caso eu quero da posição 3 em diante...
        //...agora que tenho esse string recortado, vou chamar o método Integer.parse para transformar em inteiro.
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name " + worker.getName());
        //repara abaixo na composicao de objetos, onde acesso o objeto worker. em seguida consigo acessar o objeto que esta dentro dele, que é o department.
        // ... e depois consigo acessar o metodo getName que esta dentro do objeto department.
        System.out.println("Department " + worker.getDepartment().getName());
        //vou chamar o monthAndYear que é o mes e ano que foi digitado. depois vou chamar o metodo income que esta dentro do objeto worker, passando o ano e mes que foi digitado pelo usuário e extraído separado o mes e ano.
        //e vou usar a mascara String.format para exibir 2 casas decimais.
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f",  worker.income(year, month) ));
        System.out.println();



        sc.close();
    }
}
