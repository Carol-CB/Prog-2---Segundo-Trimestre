package Aula2;

import Aula1.ContaBancaria;

import java.util.Random;
import java.util.Scanner;

public class Banco {
	static Scanner ler = new Scanner(System.in);
	public static String leString(String mensagem){
		Scanner ler = new Scanner(System.in);
		System.out.print(mensagem+": ");
		return ler.nextLine();
	}

	public static float leFloat(String mensagem){
		Scanner ler = new Scanner(System.in);
		System.out.print(mensagem+": ");
		return ler.nextFloat();
	}

	public static Corrente acessaCC(Corrente c1){
		char opc;
		System.out.println("Acessando a conte "+c1.getIdentificador());
		do {
			System.out.println("Selecione uma opção");
			System.out.println("v - verificar saldo");
			System.out.println("d - depositar");
			System.out.println("s - sacar");
			System.out.println("e - sair");
			opc = leString("").toLowerCase().charAt(0);
			switch (opc){
				case 'v'-> System.out.println(c1.verificar());
				case 'd'->{
					float valor = leFloat("Qual valor deseja depositar: ");
					c1.depositar(valor);
					System.out.println("Deposito realizado");
				}
				case 's'->{
					float valor = leFloat("Qual valor deseja sacar: ");
					if(c1.sacar(valor))
						System.out.println("Saque realizado");
					else
						System.out.println("Saldo insuficiente");
				}
			}
		}
		while(opc!='e');
		return c1;
	}

	public static Poupanca acessaCP(Poupanca c1){
		char opc;
		do {
			System.out.println("Selecione uma opção");
			System.out.println("v - verificar saldo");
			System.out.println("d - depositar");
			System.out.println("s - sacar");
			System.out.println("e - sair");
			opc = leString("").toLowerCase().charAt(0);
			switch (opc){
				case 'v'-> System.out.println(c1.verificar());
				case 'd'->{
					float valor = leFloat("Qual valor deseja depositar: ");
					c1.depositar(valor);
					System.out.println("Deposito realizado");
				}
				case 's'->{
					float valor = leFloat("Qual valor deseja sacar: ");
					if(c1.sacar(valor))
						System.out.println("Saque realizado");
					else
						System.out.println("Saldo insuficiente");
				}
			}
		}
		while(opc!='e');
		return c1;
	}
	
	public static void main(String[] args) {
		Corrente[] listaCC = new Corrente[20];
		Poupanca[] listaCP = new Poupanca[20];
		int contCC = 0;
		int contCP = 0;
		String opc;
		do {
			System.out.println("Selecione uma opção");
			System.out.println("cc - cadastrar conta corrente");
			System.out.println("cp - cadastrar conta poupança");
			System.out.println("ac - acessar conta corrente");
			System.out.println("ap - acessar conta poupança");
			System.out.println("e - sair");
			opc = leString("");
			switch (opc) {
				case "cc" -> {
					if (contCC < 20) {
						System.out.print("Qual o nome do titular: ");
						String titular = ler.nextLine();
						System.out.print("Qual a senha: ");
						String senha = ler.nextLine();
						System.out.print("Qual o limite da conta: ");
						float limite = ler.nextFloat();

						listaCC[contCC] = new Corrente(titular, senha, limite);

						System.out.println("Conta cadastrada no ID: " + listaCC[contCC].getIdentificador());
						contCC++;
					}
					else {
						System.out.println("Número máximo de contas atingido.");
					}
				}

				case "cp" -> {
					if (contCP < 20) {
						System.out.print("Qual o nome do titular: ");
						String titular = ler.nextLine();
						System.out.print("Qual a senha: ");
						String senha = ler.nextLine();
						System.out.print("Qual o depósito inicial: ");
						float valor = ler.nextFloat();

						listaCP[contCP] = new Poupanca(titular, senha, valor);

						System.out.println("Conta cadastrada no ID: " + listaCP[contCP].getIdentificador());
						contCC++;
					}
					else {
						System.out.println("Número máximo de contas atingido.");
					}
				}

				/*case "ac" ->{
					System.out.print("Digite o identificador: ");
					String identificador = ler.nextLine();
					System.out.print("Digite a senha: ");
					String senha = ler.nextLine();

					Corrente c1 = null;
					for (Corrente c : contas) {
						if (c != null && c.validar(identificador, senha)) {
							conta = c;
							break;
						}
				}*/
			}
		} while(!opc.equals("e"));
	}
}
