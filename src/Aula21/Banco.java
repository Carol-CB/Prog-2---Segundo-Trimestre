package Aula21;

import java.util.Scanner;

public class Banco {
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

	public static Corrente cadastraCC(){
		String titular = leString("Qual o nome do titular");
		String senha = leString("Qual a senha");
		float limite = leFloat("Qual o limite inicial");
		Corrente c1 = new Corrente(titular, senha, limite);
		System.out.println("Conta cadastrada com o id: "+c1.getIdentificador());
		return c1;
	}

	public static Poupanca cadastraCP(){
		String titular = leString("Qual o nome do titular");
		String senha = leString("Qual a senha");
		float deposito = leFloat("Qual o depósito inicial");
		Poupanca c1 = new Poupanca(titular, senha, deposito);
		System.out.println("Conta cadastrada com o id: "+c1.getIdentificador());
		return c1;
	}

	public static Corrente acessaCC(Corrente c1){
		char opc;
		System.out.println("Acessando a conta "+c1.getIdentificador());
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
					listaCC[contCC] = cadastraCC();
					contCC++;
				}
				case "cp" -> {
					listaCP[contCP] = cadastraCP();
					contCP++;
				}

				case "ac" ->{
					String identificador = leString("Digite o identificador: ");
					String senha = leString("Digite a senha: ");
					int posicao = -1;
					for(int i=0; i<contCC; i++){
						if(listaCC[i].validar(identificador, senha)){
							posicao = i;
						}
					}
					if(posicao>=0){
						listaCC[posicao] = acessaCC(listaCC[posicao]);
					}
					else{
						System.out.println("Informações de acesso inválidas.");
					}
				}
				case "ap" ->{
					String identificador = leString("Digite o identificador: ");
					String senha = leString("Digite a senha: ");
					int posicao = -1;
					for(int i=0; i<contCP; i++){
						if(listaCP[i].validar(identificador, senha)){
							posicao = i;
						}
					}
					if(posicao>=0){
						listaCP[posicao] = acessaCP(listaCP[posicao]);
					}
					else{
						System.out.println("Informações de acesso inválidas.");
					}
				}
			}
		} while(!opc.equals("e"));
	}
}
