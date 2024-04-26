package EnumeracoesComposicao;

import java.text.ParseException; // Importa a classe ParseException do pacote java.text para lidar com exceções relacionadas a análise de texto.
import java.text.SimpleDateFormat; // Importa a classe SimpleDateFormat do pacote java.text para formatar datas.
import java.util.Date; // Importa a classe Date do pacote java.util para trabalhar com datas.
import java.util.Locale; // Importa a classe Locale do pacote java.util para lidar com localização.
import java.util.Scanner; // Importa a classe Scanner do pacote java.util para entrada de dados.

import entities.composicao.Department; // Importa a classe Department do pacote entities.composicao.
import entities.composicao.HourContract; // Importa a classe HourContract do pacote entities.composicao.
import entities.composicao.Worker; // Importa a classe Worker do pacote entities.composicao.
import entities.enums.WorkerLevel; // Importa a enumeração WorkerLevel do pacote entities.enums.

public class Composition1 {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US); // Define o local padrão como US (Estados Unidos) para formatação de números.
        Scanner sc = new Scanner(System.in); // Cria um objeto Scanner para entrada de dados.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Cria um objeto SimpleDateFormat para formatar datas no formato "dd/MM/yyyy".

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine(); // Lê o nome do departamento fornecido pelo usuário.

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine(); // Lê o nome do trabalhador fornecido pelo usuário.

        System.out.print("Level: ");
        String workerLevel = sc.nextLine(); // Lê o nível do trabalhador fornecido pelo usuário.
        System.out.print("Base salary: ");
        
        double baseSalary = sc.nextDouble(); // Lê o salário base fornecido pelo usuário.
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName)); // Cria um objeto Worker com os dados fornecidos.

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt(); // Lê o número de contratos fornecido pelo usuário.

        for (int i = 1; i <= n; i++) {
            
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next()); // Lê a data do contrato fornecida pelo usuário e a converte para um objeto Date.

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble(); // Lê o valor por hora fornecido pelo usuário.
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt(); // Lê a duração do contrato em horas fornecida pelo usuário.
            
            HourContract contract = new HourContract(contractDate, valuePerHour, hours); // Cria um objeto HourContract com os dados fornecidos.
            worker.addContract(contract); // Adiciona o contrato ao trabalhador.
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        
        String monthAndYear = sc.next(); // Lê o mês e o ano fornecidos pelo usuário.
        int month = Integer.parseInt(monthAndYear.substring(0, 2)); // Extrai o mês da string fornecida.
        int year = Integer.parseInt(monthAndYear.substring(3)); // Extrai o ano da string fornecida.
        
        System.out.println("Name: " + worker.getName()); // Exibe o nome do trabalhador.
        System.out.println("Department: " + worker.getDepartment().getName()); // Exibe o nome do departamento do trabalhador.
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month))); // Calcula e exibe a renda do trabalhador para o mês e ano fornecidos.

        sc.close(); // Fecha o objeto Scanner.
    }
}