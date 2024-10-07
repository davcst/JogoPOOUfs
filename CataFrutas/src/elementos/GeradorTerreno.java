package elementos;
import java.lang.Math;
import java.util.Map;
import java.util.HashMap;
import elementos.solo.*;
import elementos.frutas.*;

public class GeradorTerreno {
	
	private int dimensao;
	private int pedras;
	private int bichadas;
	private int capacidadeMochila;
	private Map<String, int[]> frutas;
	
	public GeradorTerreno() {
		frutas = new HashMap<>();
	}
	public void setDimensao(int d) {
		this.dimensao = d;
		return;
	}
	public void setPedras(int p) {
		this.pedras = p;
		return;
	}
	public void setFruta(String tipoFruta, int quantidadeArvores, int quantidadeInicial) {
		frutas.put(tipoFruta, new int[]{quantidadeArvores, quantidadeInicial});
	}
	
	public Terreno gerarTerreno() {
		Terreno t = new Terreno(this.dimensao);
		gerarPedras(this.pedras, t);
		gerarGrama(t);
		distribuirFrutas(this.frutas, t);
		return t;
	}
	
	private void gerarPedras(int numPedras, Terreno terreno) {
		
		int pedrasRestantes = numPedras;
		// distribuir pedras com a mesma chance e ir passando pelo terreno até colocar todas
		float chancePedra = ((float)numPedras / (float)(this.dimensao * this.dimensao));
		while (pedrasRestantes > 0) {
			loopMatriz:
			for (int i = 0; i < dimensao; i++) {
				for (int j = 0; j < dimensao; j++) {
					if (Math.random() < chancePedra) {
						terreno.setCelula(i, j, new Pedra());
						pedrasRestantes--;
						if (pedrasRestantes == 0)
							break loopMatriz;
					}
				}
			}
		}
		return;
	}
	private void gerarGrama(Terreno terreno) {
		for (int i = 0; i < dimensao; i++) {
			for (int j = 0; j < dimensao; j++) {
				if (!(terreno.getCelula(i, j) instanceof Pedra)) {
					//Grama onde não há pedra
					terreno.setCelula(i, j, new Grama());
				}
			}
		}
		return;
	}
	private void distribuirFrutas(Map<String, int[]> frutas, Terreno terreno) {
		for (Map.Entry<String, int[]> fruta: frutas.entrySet()) {
			
			int frutasRestantes = fruta.getValue()[1];
			Fruta novaFruta = null;
			// chance de uma fruta do início da partida estar numa célula da matriz M_n = 1 / n²;
			float chanceFruta = (float)fruta.getValue()[0] / (float)(this.dimensao * this.dimensao);
			switch (fruta.getKey()) {
			case "goiaba": //TODO: arrumar um jeito melhor pra isso
				novaFruta = new Goiaba();
				break;
			case "laranja":
				novaFruta = new Laranja();
				break;
			case "abacate":
				novaFruta = new Abacate();
				break;
			case "coco":
				novaFruta = new Coco();
				break;
			case "maracuja":
				novaFruta = new Maracuja();
				break;
			case "amora":
				novaFruta = new Amora();
				break;
			case "acerola":
				novaFruta = new Acerola();
				break;
			default:
				System.out.println("??? Não deveríamos ter chegado aqui. "+fruta.getKey());
			}
			
			while (frutasRestantes > 0) {
				loopMatriz:
				for (int i = 0; i < dimensao; i++) {
					for (int j = 0; j < dimensao; j++) {
						Chao solo = terreno.getCelula(i, j);
						if (solo instanceof Grama && ((Grama) solo).getFrutaPresente() == null && Math.random() < chanceFruta) {
							((Grama) solo).setFrutaPresente(novaFruta);
							frutasRestantes--;
							if (frutasRestantes == 0) {
								break loopMatriz;
							}
						}
					}
				}
			}
		}
	}
}
