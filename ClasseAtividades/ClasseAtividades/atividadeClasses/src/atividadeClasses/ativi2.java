package atividadeClasses;

import java.io.*;
import java.util.Scanner;

class Pessoa2 {
	Scanner ler = new Scanner(System.in);
	private String nome, mes;
	private int dia;
	//construtores
	public Pessoa2(String nome, String mes, int dia) {
		this.nome = nome;
		this.mes = mes;
		this.dia = dia;
	}
	//retornando o mes, dia e nome
	public String getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public String getNome() {
		return nome;
	}
	//toString retornando o mes e dia daquela pessoa
	public String toString() {
		return "nome: " + nome + ", dia: " + dia + "\n";
	}
	
	
}

public class ativi2 {
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		//vetor com as 10 pessoas
		Pessoa2[] info = new Pessoa2[10];
		String nomeArq, nome = null, mes = null;
		//array com os meses
		String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro" };

		int dia = 0;

		try {
			//pedi nome do arquivo
			System.out.println("Nome do arquivo: ");
			nomeArq = ent.nextLine();
			FileWriter arq = new FileWriter("c:\\temp\\" + nomeArq + ".txt");
			
			//for pedindo as informações
			for(int i=0;i<10;i++){
				System.out.println("Nome: ");
				nome =ent.nextLine();

				System.out.println("Mês");
				mes = ent.nextLine();
				
				System.out.println("Dia");
				dia = ent.nextInt();
				ent.nextLine();

				//salvando no vetor as informações
				info[i] = new Pessoa2(nome, mes, dia);
				
			}
			//for percorrendo o vetor com o cadastro das pessoas
			for(int i=0;i<info.length;i++){
				//metodo getIndiceMes , pegando a informação de qual mes aquela pessoa faz aniversario, puxando
				//o toString com as informações de nome e dia daquela pessoa
				meses[getIndiceMes(info[i].getMes())] = meses[getIndiceMes(info[i].getMes())]+ "\n" + info[i].toString();
			}
			//for mandando os dados para o arquivo 
			for(int j=0;j<meses.length; j++) {
				arq.write(meses[j] + "\n");

			}
			
			ent.close();
			arq.close();
		} catch (IOException e) {
			System.out.println("Inválido.");
		}
		
	}
	//metodo para pegar o indice do Mes
	private static int getIndiceMes(String mes) {
		switch (mes) {
			case "janeiro": {
				return 0;
			}
			case "fevereiro": {
				return 1;
			}
			case "março": {
				return 2;
			}
			case "abril": {
				return 3;
			}
			case "maio": {
				return 4;
			}
			case "junho": {
				return 5;
			}
			case "julho": {
				return 6;
			}
			case "agosto": {
				return 7;
			}
			case "setembro": {
				return 8;
			}
			case "outubro": {
				return 9;
			}	
			case "novembro": {
				return 10;
			}
			default : {
				return 11;
			}
		}
	}
}
