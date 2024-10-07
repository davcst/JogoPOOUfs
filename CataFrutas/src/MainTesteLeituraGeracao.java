import elementos.*;
import elementos.solo.*;
import elementos.frutas.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;


public class MainTesteLeituraGeracao {

	public MainTesteLeituraGeracao(String path) throws IOException, NumberFormatException {
		// criar o gerador e ler o arquivo
		GeradorTerreno gerador = new GeradorTerreno();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		while (reader.ready()) {
			String[] linha = reader.readLine().split(" "); // "goiaba 1 1" => ["goiaba", "3", "1"]
			switch (linha[0]) {
			case "dimensao":
				gerador.setDimensao(Integer.parseInt(linha[1]));
				break;
			case "pedras":
				gerador.setPedras(Integer.parseInt(linha[1]));
				break;
			case "goiaba":
				gerador.setFruta("goiaba", Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
				break;
			case "laranja":
				gerador.setFruta("laranja", Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
				break;
			case "abacate":
				gerador.setFruta("abacate", Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
				break;
			case "coco":
				gerador.setFruta("coco", Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
				break;
			case "maracuja":
				gerador.setFruta("maracuja", Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
				break;
			case "amora":
				gerador.setFruta("amora", Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
				break;
			case "acerola":
				gerador.setFruta("acerola", Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
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
					System.out.print(" P ");
				}
				else {
					if (((Grama)t.getCelula(i, j)).getFrutaPresente() instanceof Goiaba) {
						System.out.print(" g ");
					}
					else if (((Grama)t.getCelula(i, j)).getFrutaPresente() instanceof Laranja) {
						System.out.print(" l ");
					}
					else if (((Grama)t.getCelula(i, j)).getFrutaPresente() instanceof Abacate) {
						System.out.print(" a ");
					}
					else if (((Grama)t.getCelula(i, j)).getFrutaPresente() instanceof Coco) {
						System.out.print(" c ");
					}
					else if (((Grama)t.getCelula(i, j)).getFrutaPresente() instanceof Maracuja) {
						System.out.print(" m ");
					}
					else if (((Grama)t.getCelula(i, j)).getFrutaPresente() instanceof Amora) {
						System.out.print(" o ");
					}
					else if (((Grama)t.getCelula(i, j)).getFrutaPresente() instanceof Acerola) {
						System.out.print(" e ");
					}
					else {
						System.out.print(" * ");
					}
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
