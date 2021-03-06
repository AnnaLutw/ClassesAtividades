package atividadeClasses;

import java.io.*;
import java.util.Scanner;

class Pessoa {
	//declarei as variaveis
	private String nome, endereco, complemento;
	private int codigo, idade, numero;
	//chamei o construtor
	public Pessoa(String nome, int idade, int codigo, int numero, String endereco, String complemento) {
		this.nome=nome;
		this.idade=idade;
		this.codigo=codigo;
		this.numero=numero;
		this.endereco=endereco;
		this.complemento=complemento;
	}

	
	// para todas as informações retornando para o main

	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	int getCodigo() {
		return codigo;
	}
	int getNumero() {
		return numero;
	}

	String getEndereco() {
		return endereco;
	}
	String getComplemento() {
		return complemento;
	}


}

public class ativi1 {
	//main
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		//declarei o vetor
		Pessoa[] pessoas = new Pessoa[50];

		//declarei as variaveis
			int p, codigo, numero, idade;
			String nome, endereco, complemento, arquivoNome;
			//pedi quantidade de pessoas
			System.out.println("Quantas pessoas");
			p = ent.nextInt();
			ent.nextLine();
			//for para todas as perguntas
			for (int i = 0; i < p; i++) {
				//pedi o nome do arquivo para cada pessoa cadastrada
				System.out.println("Qual o nome do arquivo? ");
				arquivoNome = ent.nextLine();
			try {	
				//declarei o diretorio 
				FileWriter arq = new FileWriter("c:\\temp\\" + arquivoNome+".txt");
				//pedi as informações
				System.out.println("nome: ");
				nome = ent.nextLine();

				System.out.println("Endereço: ");
				endereco = ent.nextLine();

				System.out.println("Codigo: ");
				codigo = ent.nextInt();
				ent.nextLine();

				System.out.println("Idade: ");
				idade = ent.nextInt();
				ent.nextLine();

				System.out.println("Numero: ");
				numero = ent.nextInt();
				ent.nextLine();
				
				System.out.println("Complemento: ");
				complemento = ent.nextLine();
				
				pessoas[i] = new Pessoa(nome, idade, codigo, numero, endereco, complemento);

				//passei os dados para o arquivo				
				arq.write("Nome: " + pessoas[i].getNome()+ "\n");
				arq.write("Idade: " +pessoas[i].getIdade()+ "\n");
				arq.write("codigo: " +pessoas[i].getCodigo()+ "\n");
				arq.write("numero: " +pessoas[i].getNumero()+ "\n");
				arq.write("Endereco: " +pessoas[i].getEndereco()+ "\n");
				arq.write("Complemento: " +pessoas[i].getComplemento());

				
				arq.close();
			}
			catch (IOException e) {
			    System.out.println("Inválido.");
			}
			ent.close();
			}
	}
}
