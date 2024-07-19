package Aula24;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    public static void gravaContasCorrentes(ArrayList<ContaCorrente> lista) {
        File caminho = new File("C:/Users/carol/Documents/aula24_tarde");
        if (!caminho.exists()) {
            System.out.print("Criando...");
            caminho.mkdirs();
            System.out.println("Pronto!");
        }
        File arquivo = new File(caminho, "contas_correntes.db");
        try {
            ObjectOutputStream objEscrita = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));
            objEscrita.writeObject(lista);
            objEscrita.close();
            System.out.println("Contas correntes salvas.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado ou não pode ser criado!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar contas correntes: " + e.getMessage());
        }
    }

    public static void gravaContasPoupancas(ArrayList<ContaPoupanca> lista) {
        File caminho = new File("C:/Users/carol/Documents/aula24_tarde");
        if (!caminho.exists()) {
            System.out.print("Criando...");
            caminho.mkdirs();
            System.out.println("pronto.");
        }
        File arquivo = new File(caminho, "contas_poupancas.db");
        try {
            ObjectOutputStream objEscrita = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));
            objEscrita.writeObject(lista);
            objEscrita.close();
            System.out.println("Contas poupanças salvas!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado ou não pode ser criado!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar contas poupanças: " + e.getMessage());
        }
    }

    public static ArrayList<ContaCorrente> leContasCorrentes() {
        File caminho = new File("C:/Users/carol/Documents/aula24_tarde");
        File arquivo = new File(caminho, "contas_correntes.db");
        try {
            ObjectInputStream objLeitura = new ObjectInputStream(new FileInputStream(arquivo.getAbsolutePath()));
            ArrayList<ContaCorrente> lista = (ArrayList<ContaCorrente>) objLeitura.readObject();
            objLeitura.close();
            return lista;
        } catch (IOException e) {
            System.out.println("Erro ao ler contas correntes: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao localizar a classe: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static ArrayList<ContaPoupanca> leContasPoupancas() {
        File caminho = new File("C:/Users/carol/Documents/aula24_tarde");
        File arquivo = new File(caminho, "contas_poupancas.db");
        try {
            ObjectInputStream objLeitura = new ObjectInputStream(new FileInputStream(arquivo.getAbsolutePath()));
            ArrayList<ContaPoupanca> lista = (ArrayList<ContaPoupanca>) objLeitura.readObject();
            objLeitura.close();
            return lista;
        } catch (IOException e) {
            System.out.println("Erro ao ler contas poupanças: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao localizar a classe: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static String leString(String mensagem) {
        Scanner ler = new Scanner(System.in);
        System.out.print(mensagem + ": ");
        return ler.nextLine();
    }

    public static float leFloat(String mensagem) {
        Scanner ler = new Scanner(System.in);
        System.out.print(mensagem + ": ");
        return ler.nextFloat();
    }

    public static ContaCorrente acessaCC(ContaCorrente c1) {
        String opc;
        System.out.println("Acessando a conta " + c1.getIdentificador());
        System.out.println("Bem-vindo, " + c1.getTitular());
        do {
            System.out.println("Selecione uma opção");
            System.out.println("d - realizar um depósito");
            System.out.println("s - realizar um saque");
            System.out.println("v - verificar o saldo");
            System.out.println("a - alterar a senha");
            System.out.println("e - sair");
            opc = leString("").toLowerCase();
            switch (opc) {
                case "d" -> {
                    float valor = leFloat("Qual valor deseja depositar");
                    c1.depositar(valor);
                    System.out.println("Depósito realizado!");
                }
                case "s" -> {
                    float valor = leFloat("Qual o valor do saque");
                    if (c1.sacar(valor))
                        System.out.println("Saque realizado");
                    else
                        System.out.println("Saldo mais limite insuficientes");
                }
                case "v" -> System.out.println(c1.verificaSaldo());
                case "a" -> {
                    String senha = leString("Qual a nova senha");
                    c1.setSenha(senha);
                }
            }
        } while (!opc.equals("e"));
        return c1;
    }

    public static ContaPoupanca acessaCP(ContaPoupanca c1) {
        String opc;
        System.out.println("Acessando a conta " + c1.getIdentificador());
        System.out.println("Bem-vindo, " + c1.getTitular());
        do {
            System.out.println("Selecione uma opção");
            System.out.println("d - realizar um depósito");
            System.out.println("s - realizar um saque");
            System.out.println("v - verificar o saldo");
            System.out.println("a - alterar a senha");
            System.out.println("e - sair");
            opc = leString("").toLowerCase();
            switch (opc) {
                case "d" -> {
                    float valor = leFloat("Qual valor deseja depositar");
                    c1.depositar(valor);
                    System.out.println("Depósito realizado!");
                }
                case "s" -> {
                    float valor = leFloat("Qual o valor do saque");
                    if (c1.sacar(valor))
                        System.out.println("Saque realizado");
                    else
                        System.out.println("Saldo insuficiente");
                }
                case "v" -> System.out.println(c1.verificaSaldo());
                case "a" -> {
                    String senha = leString("Qual a nova senha");
                    c1.setSenha(senha);
                }
            }
        } while (!opc.equals("e"));
        return c1;
    }

    public static ContaCorrente cadastraCC() {
        String titular = leString("Qual o titular da conta");
        String senha = leString("Qual a senha");
        float limite = leFloat("Qual o limite inicial");
        ContaCorrente c1 = new ContaCorrente(titular, senha, limite);
        System.out.println("Conta cadastrada com o identificador " + c1.getIdentificador());
        return c1;
    }

    public static ContaPoupanca cadastraCP() {
        String titular = leString("Qual o titular da conta");
        String senha = leString("Qual a senha");
        float deposito = leFloat("Qual valor depositar");
        ContaPoupanca c1 = new ContaPoupanca(titular, senha, deposito);
        System.out.println("Conta cadastrada com o identificador " + c1.getIdentificador());
        return c1;
    }

    public static void main(String[] args) {
        ArrayList<ContaCorrente> listaCC = leContasCorrentes();
        ArrayList<ContaPoupanca> listaCP = leContasPoupancas();
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
                case "cc" -> listaCC.add(cadastraCC());
                case "cp" -> listaCP.add(cadastraCP());
                case "ac" -> {
                    String identificador = leString("Qual o identificador");
                    String senha = leString("Qual a senha");
                    ContaCorrente conta = listaCC.stream()
                            .filter(cc -> cc.validaAcesso(identificador, senha))
                            .findFirst()
                            .orElse(null);
                    if (conta != null) {
                        acessaCC(conta);
                    } else {
                        System.out.println("Conta inexistente ou senha incorreta!");
                    }
                }
                case "ap" -> {
                    String identificador = leString("Qual o identificador");
                    String senha = leString("Qual a senha");
                    ContaPoupanca conta = listaCP.stream()
                            .filter(cp -> cp.validaAcesso(identificador, senha))
                            .findFirst()
                            .orElse(null);
                    if (conta != null) {
                        acessaCP(conta);
                    } else {
                        System.out.println("Conta inexistente ou senha incorreta!");
                    }
                }
            }
        } while (!opc.equals("e"));


        //só grava ao sair, não sei como fazer para ir editando....
        gravaContasCorrentes(listaCC);
        gravaContasPoupancas(listaCP);
    }
}
