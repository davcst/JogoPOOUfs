package elementos.solo;

/**
 * Classe do terreno do jogo como uma matriz que conterá o solo e em cada pedaço, seus itens
 * @author breno
 */
public class Terreno {
	private Chao solo[][];
	private int tamanho;
	
	/**
	 * Inicialização do terreno do jogo. Uma matriz quadrada de pedaços do chão
	 * @param tamanho Dimensão da matriz
	 */
	public Terreno(int tamanho) {
		this.tamanho = tamanho;
		solo = new Chao[tamanho][tamanho];
	}
		
	public Chao getCelula(int coluna, int linha) {
		return this.solo[coluna][linha];
	}

	public void setCelula(int coluna, int linha, Chao chao) {
		this.solo[coluna][linha] = chao;
	}
	public int getTamanho() {
		return this.tamanho;
	}
}
