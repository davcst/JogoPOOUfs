import elementos.*;
import elementos.solo.*;
import elementos.frutas.*;
import elementos.arvores.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe de teste para conferir se o terreno está sendo gerado certo
 * @author breno
 */
public class MainTesteLeituraGeracao {

	public MainTesteLeituraGeracao(String path) throws IOException, NumberFormatException {
		// criar o gerador e ler o arquivo
		GeradorTerreno gerador = new GeradorTerreno();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		while (reader.ready()) {
			String[] linha = reader.readLine().split(" "); // "goiaba 3 1" => ["goiaba", "3", "1"]
			switch (linha[0]) {
			case "dimensao":
				gerador.setDimensao(Integer.parseInt(linha[1]));
				break;
			case "pedras":
				gerador.setPedras(Integer.parseInt(linha[1]));
				break;
			case "bichadas":
				// nao implementado
				break;
			case "mochila":
				// nao implementado
				break;
			default:
				gerador.setFruta(linha[0], Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
				break;
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
					else if (((Grama)t.getCelula(i, j)).getArvorePresente() instanceof Goiabeira) {
						System.out.print(" G ");
					}
					else if (((Grama)t.getCelula(i, j)).getArvorePresente() instanceof Laranjeira) {
						System.out.print(" L ");
					}
					else if (((Grama)t.getCelula(i, j)).getArvorePresente() instanceof Abacateiro) {
						System.out.print(" A ");
					}
					else if (((Grama)t.getCelula(i, j)).getArvorePresente() instanceof Coqueiro) {
						System.out.print(" C ");
					}					
					else if (((Grama)t.getCelula(i, j)).getArvorePresente() instanceof Amoreira) {
						System.out.print(" O ");
					}
					else if (((Grama)t.getCelula(i, j)).getArvorePresente() instanceof Aceroleira) {
						System.out.print(" E ");
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
