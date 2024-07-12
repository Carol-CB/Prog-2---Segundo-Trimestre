package Aula19;

import java.util.Random;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ContaBancaria[] contas = new ContaBancaria[10];
        int numContas = 0;
        boolean sair = false;

        while (!sair) {
            System.out.print("Escolha: [c]Criar conta, [a]Acessar conta, [s]Sair: ");
            char opc = ler.next().toLowerCase().charAt(0);
            switch (opc) {
                case 'c' -> {
                    if (numContas < 10) {
                        contas[numContas] = new ContaBancaria();
                        ler.nextLine(); //consumir a nova linha deixada por next()
                        System.out.print("Qual o nome do titular: ");
                        String titular = ler.nextLine();
                        System.out.print("Qual a senha: ");
                        String senha = ler.nextLine();
                        System.out.print("Qual o deposito inicial: ");
                        float valor = ler.nextFloat();
                        contas[numContas].titular = titular;
                        contas[numContas].identificador = "conta" + new Random().nextInt(100, 400);
                        contas[numContas].senha = senha;
                        contas[numContas].depositar(valor);
                        System.out.println("Conta cadastrada no id: " + contas[numContas].identificador);
                        numContas++;
                    } else {
                        System.out.println("Número máximo de contas atingido.");
                    }
                }
                case 'a' -> {
                    ler.nextLine(); //consumir a nova linha deixada por next
                    System.out.print("Digite o identificador: ");
                    String identificador = ler.nextLine();
                    System.out.print("Digite a senha: ");
                    String senha = ler.nextLine();

                    ContaBancaria conta = null;
                    for (ContaBancaria c : contas) {
                        if (c != null && c.validar(identificador, senha)) {
                            conta = c;
                            break;
                        }
                    }

                    if (conta != null) {
                        boolean sairConta = false;
                        while (!sairConta) {
                            System.out.print("Escolha: [v]Verificar saldo, [d]Depositar, [s]Sacar, [e]Sair: ");
                            char opcConta = ler.next().toLowerCase().charAt(0);
                            switch (opcConta) {
                                case 'v' -> System.out.println(conta.verificar());
                                case 'd' -> {
                                    System.out.print("Qual valor deseja depositar: ");
                                    float valor = ler.nextFloat();
                                    conta.depositar(valor);
                                    System.out.println("Deposito realizado.");
                                }
                                case 's' -> {
                                    System.out.print("Qual valor deseja sacar: ");
                                    float valor = ler.nextFloat();
                                    if (conta.sacar(valor))
                                        System.out.println("Saque realizado.");
                                    else
                                        System.out.println("Saque insuficiente.");
                                }
                                case 'e' -> sairConta = true;
                            }
                        }
                    } else {
                        System.out.println("Os dados de acesso estão incorretos.");
                    }
                }
                case 's' -> sair = true;
                default -> System.out.println("Opção inválida.");
            }
        }
        ler.close();
    }
}
