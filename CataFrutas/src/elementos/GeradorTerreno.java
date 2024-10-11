package elementos;
import java.lang.Math;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import elementos.solo.*;
import elementos.frutas.*;
import elementos.arvores.*;

/**
 * Classe para gerar o terreno do jogo, podendo ser usada para configurar definir a partir de um arquivo ou da GUI
 * @author breno
 */
public class GeradorTerreno {
	
	private int dimensao;
	private int pedras;
	private int bichadas;			   // nao implementado ainda
	private int capacidadeMochila;	   // nao implementado ainda
	private Map<String, int[]> frutas; // "goiaba": [3, 1]
	private Set<String> frutasValidas;
	
	public GeradorTerreno() {
		frutas = new HashMap<>();
		frutasValidas = new HashSet<>();
		frutasValidas.add("maracuja");
		frutasValidas.add("laranja");
		frutasValidas.add("abacate");
		frutasValidas.add("coco");
		frutasValidas.add("acerola");
		frutasValidas.add("amora");
		frutasValidas.add("goiaba");	
	}
	
	/**
	 * definir a dimensão do terreno do jogo
	 */
	public void setDimensao(int d) {
		if (d < 0) {
			throw new IllegalArgumentException("Quantidade inválida: "+ d);
		}
		this.dimensao = d;
		return;
	}
	/**
	 * definir quantas pedras terá no terreno
	 * @param p quantidade de pedras
	 */
	public void setPedras(int p) {
		if (p < 0) {
			throw new IllegalArgumentException("Quantidade inválida: "+ p);
		}
		this.pedras = p;
		return;
	}
	/**
	 * Define uma das frutas e suas configurações
	 * @param tipoFruta Qual fruta definir. ex: "goiaba"
	 * @param quantidadeArvores Quantas árvores que darão essa fruta existirá no jogo
	 * @param quantidadeInicial Quantas dessa fruta estarão no chão no inicio
	 */
	public void setFruta(String tipoFruta, int quantidadeArvores, int quantidadeInicial) {
		if (this.frutasValidas.contains(tipoFruta))
			frutas.put(tipoFruta, new int[]{quantidadeArvores, quantidadeInicial});
		else
			System.err.println("Argumento inválido: " + tipoFruta);
	}
	
	/**
	 * Feito as definições dos parâmetros, gerar o terreno com as configurações
	 * @return O terreno pronto
	 */
	public Terreno gerarTerreno() {
		Terreno t = new Terreno(this.dimensao);
		gerarPedras(this.pedras, t);
		gerarGrama(t);
		distribuirArvores(this.frutas, t);
		distribuirFrutas(this.frutas, t);
		return t;
	}
	
	/**
	 * Distribuir as pedras aleatoriamente pelo terreno
	 * @param numPedras
	 * @param terreno
	 */
	private void gerarPedras(int numPedras, Terreno terreno) {
		
		int pedrasRestantes = numPedras;
		while (pedrasRestantes > 0) {
			int linhaRandom = (int)  (Math.random() * (double) dimensao);
			int colunaRandom = (int) (Math.random() * (double) dimensao);
			if (!(terreno.getCelula(colunaRandom, linhaRandom) instanceof Pedra)) {
				terreno.setCelula(colunaRandom, linhaRandom, new Pedra());
				pedrasRestantes--;
			}
		}
	}
	/**
	 * Colocar a grama em todas as células onde não foram colocadas as pedras.
	 * @param terreno
	 */
	private void gerarGrama(Terreno terreno) {
		for (int i = 0; i < dimensao; i++) {
			for (int j = 0; j < dimensao; j++) {
				if (!(terreno.getCelula(i, j) instanceof Pedra)) {
					terreno.setCelula(i, j, new Grama());
				}
			}
		}
		return;
	}
	/**
	 * Gerar as arvores das frutas para distribuir no terreno
	 * @param frutas
	 * @param terreno
	 */
	private void distribuirArvores(Map<String, int[]> frutas, Terreno terreno) {
		for (Map.Entry<String, int[]> fruta: frutas.entrySet()) {
			int arvoresRestantes = fruta.getValue()[0];
			Arvore novaArvore = null;
			switch (fruta.getKey()) {
			case "maracuja": // Sem arvore de maracuja; pular.
				continue;
			case "goiaba":
				novaArvore = new Goiabeira();
				break;
			case "laranja":
				novaArvore = new Laranjeira();
				break;
			case "abacate":
				novaArvore = new Abacateiro();
				break;
			case "coco":
				novaArvore = new Coqueiro();
				break;
			case "amora":
				novaArvore = new Amoreira();
				break;
			case "acerola":
				novaArvore = new Aceroleira();
				break;
			default:
				System.out.println("??? Não deveríamos ter chegado aqui. "+fruta.getKey());
			}
			
			while (arvoresRestantes > 0) {
				int linhaRandom = (int)  (Math.random() * (double) dimensao);
				int colunaRandom = (int) (Math.random() * (double) dimensao);
				Chao solo = terreno.getCelula(linhaRandom, colunaRandom);
				if (solo instanceof Grama && ((Grama) solo).getFrutaPresente() == null && ((Grama) solo).getArvorePresente() == null) {
					((Grama) solo).setArvorePresente(novaArvore);
					arvoresRestantes--;
				}
			}
		}
	}
	/**
	 * Gerar as frutas e distribuir pelo terreno, garantindo que nao fique no mesmo lugar de uma arvore
	 * @param frutas
	 * @param terreno
	 */
	private void distribuirFrutas(Map<String, int[]> frutas, Terreno terreno) {
		for (Map.Entry<String, int[]> fruta: frutas.entrySet()) {
			
			int frutasRestantes = fruta.getValue()[1];
			Fruta novaFruta = null;
			switch (fruta.getKey()) {
			case "goiaba":
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
				int linhaRandom = (int)  (Math.random() * (double) dimensao);
				int colunaRandom = (int) (Math.random() * (double) dimensao);
				Chao solo = terreno.getCelula(linhaRandom, colunaRandom);
				if (solo instanceof Grama && ((Grama) solo).getFrutaPresente() == null && ((Grama) solo).getArvorePresente() == null) {
					((Grama) solo).setFrutaPresente(novaFruta);
					frutasRestantes--;
				}
			}
		}
	}
}
