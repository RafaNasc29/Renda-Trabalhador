package entidades;

import entidades.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double salarioBase;

    private Departamento departamento;
    private List<ContratoHora> contratos = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double salarioBase, Departamento departamento) {
        this.name = name;
        this.level = level;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
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

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoHora> getContratos() {
        return contratos;
    }

    public void addContrato(ContratoHora contrato){
        contratos.add(contrato);
    }

    public void removerContrato(ContratoHora contrato){
        contratos.remove(contrato);
    }

    public double renda(int ano, int mes){
        double sum = salarioBase;
        Calendar cal = Calendar.getInstance();

        for(ContratoHora c : contratos){
            cal.setTime(c.getDate());

            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = 1 + cal.get(Calendar.MONTH);

            if(c_ano == ano && c_mes == mes){
                sum+= c.valorTotal();
            }
        }

        return sum;
    }
}
