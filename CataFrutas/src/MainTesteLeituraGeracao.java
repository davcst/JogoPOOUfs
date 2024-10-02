import elementos.*;
import elementos.solo.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;


public class MainTesteLeituraGeracao {

	public MainTesteLeituraGeracao(String path) throws IOException, NumberFormatException {
		// criar o gerador e ler o arquivo
		GeradorTerreno gerador = new GeradorTerreno();
		LineNumberReader reader = new LineNumberReader(new FileReader(path));
		while (reader.ready()) {
			String[] linha = reader.readLine().split(" ");
			switch (linha[0]) {
			case "dimensao":
				gerador.setDimensao(Integer.parseInt(linha[1]));
				break;
			case "pedras":
				gerador.setPedras(Integer.parseInt(linha[1]));
				break;
			//TODO: Continuar para ler os outros parâmetros do arquivo
			default:
				System.out.println("Item inválido ou não implementado: "+ linha[0]);
			}
		}
		reader.close();
		Terreno terreno = gerador.gerarTerreno();
		System.out.println("[TERRENO GERADO]");
		printarTerreno(terreno);
	}
	private void printarTerreno(Terreno t) {
		// Propósito de teste: Mostrar o chão como caractere no terminal
		for (int i = 0; i < t.getTamanho(); i++) {
			for (int j = 0; j < t.getTamanho(); j++)
				if (t.getCelula(i, j) instanceof Pedra) {
					System.out.print("*");
				}
				else {
					System.out.print(".");
				}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		try {
			String arquivo = "config";
			new MainTesteLeituraGeracao(arquivo);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
