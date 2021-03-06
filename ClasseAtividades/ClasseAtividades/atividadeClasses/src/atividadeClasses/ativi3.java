package atividadeClasses;

import java.io.*;
import java.util.Scanner;

class Eletrodomestico {
	private String nomeLoja;
	private double preco;
	private String numero;
	//coloquei as informa??es no construtor
	public Eletrodomestico(String [] info){
		nomeLoja = info[0]; //nome da loja no 0
		preco = Double.parseDouble(info[1]); //pre?o no 1
		numero = info[2]; //numero no 2
	}
	//retornei todos para o main
	public double getPreco() {
		return preco;
	}
	public String getNomeLoja() {
		return nomeLoja;
	}
	public String getNumero() {
		return numero;
	}
}
	
public class ativi3 {
	//metodo para calcular a media 
	public static double media (Eletrodomestico[]dados) {
		double conta=0;
		//pregando o pre?o e em i e salvando em conta
		for(int i=0;i < dados.length;i++) {
			conta += dados[i].getPreco();
		}
		//quant dividito pelo total
			conta/=15;
			//retornei
			return conta;
	}
	public static void main(String[] args)  {
		Scanner ent = new Scanner(System.in);
		double conta;
		String arquivoNome;
		//declarei o vetor
		Eletrodomestico[] dados = new Eletrodomestico[15];
		int i=0;

		//puxei os dados do arquivo
		try {
			File arq = new File("C:\\temp\\dados.txt");
			Scanner ler = new Scanner(arq);
			//li esse arquivo e salvei as linhas na varivael linha, separando com split
			while (ler.hasNextLine()) {
				String linha=ler.nextLine();
				String [] info = linha.split(";");
				dados[i]=new Eletrodomestico(info);
				i++;
			}

			ler.close();

		} catch (FileNotFoundException e) {
			System.out.println("Inv?lido.");
		}
		//chamei o metodo de media e salvei  na variavel conta
		conta=media(dados);
		//pedri o nome do arq
		System.out.println("Qual o nome do arquivo? ");
		arquivoNome = ent.nextLine();
		try {
			FileWriter arquivo = new FileWriter("C:\\temp\\"+ arquivoNome+".txt");
			arquivo.write("MEDIA ?: " + conta +"\n");
			arquivo.write("LOJAS ABAIXO DA MEDIA: " + "\n");

			//se o pre?o for menor que a media, vai salvar imprimir no arquivo o nome da loja, o pre?o e o numero dessa loja abaixo da media.
			for(int j = 0;j < 15; j++) {
				if(dados[j].getPreco()< conta) {
					arquivo.write( dados[j].getNomeLoja()+ "\n" + dados[j].getPreco()+ 
									"\n" + dados[j].getNumero() +"\n" );
				}
			}
			arquivo.close();
			ent.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
