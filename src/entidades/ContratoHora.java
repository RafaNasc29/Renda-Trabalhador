package entidades;

import java.util.Date;

public class ContratoHora {

    private Date date;
    private Double valorPorHora;
    private Integer hours;

    public ContratoHora() {
    }

    public ContratoHora(Date date, Double valorPorHora, Integer hours) {
        this.date = date;
        this.valorPorHora = valorPorHora;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public Integer getHours() {
        return hours;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public double valorTotal(){
        return valorPorHora * hours;
    }
}
