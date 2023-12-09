package entities;

import java.util.Date;

public class HourContract {

    private Date date;
    private Double valuePerHour;
    private Integer hour;

    public HourContract(){
    }

    public HourContract(Date date, Double valuePerHour, Integer hour) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hour = hour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    //esse método vai me devolver o valor total do contrato. porque ele multiplica o valor por hora, vezes a quantidade de horas do contrato.
    //aqui entra o conceito de delegação. ou seja a classe responsável por saber o valor total do contrato, é a própria classe HourContract, nao pode ser a classe Worker.
    public  double totalValue() {
        return valuePerHour * hour;
    }


}
