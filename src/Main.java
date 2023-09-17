import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Worker;
import entidades.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("informe o nome do departamento: ");
        String nomeDepartamento = sc.nextLine();

        System.out.print("informe o nome do trabalhador: ");
        String nomeTrabalhador = sc.nextLine();

        System.out.print("Nivel: ");
        String nivelTrabalhador = sc.nextLine();

        System.out.print("Salario Base: ");
        double salarioBase = sc.nextDouble();

        Worker worker = new Worker(nomeTrabalhador, WorkerLevel.valueOf(nivelTrabalhador), salarioBase, new Departamento(nomeDepartamento));

        System.out.print("Quantos contratos esse trabalhador tem? ");
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            System.out.println("Contrato: #" + i + " dados:");
            System.out.print("Data (DD/MM/YYYY): ");
            Date dataContrato = sdf.parse(sc.next());

            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();

            System.out.print("Duracao (horas): ");
            int horas = sc.nextInt();

            ContratoHora contrato = new ContratoHora(dataContrato, valorPorHora, horas);
            worker.addContrato(contrato);
            System.out.println();
        }

        System.out.print("Entre com Mes e ano (MM/YYYY): ");
        String mesAno = sc.next();

        int mes = Integer.parseInt(mesAno.substring(0,2));
        int ano = Integer.parseInt(mesAno.substring(3));

        System.out.println("Nome:" + worker.getName());
        System.out.println("Departamento:" + worker.getDepartamento().getName());
        System.out.println("Renda em " + mesAno + ": " + String.format("%.2f", worker.renda(ano, mes)));

        sc.close();
    }
}