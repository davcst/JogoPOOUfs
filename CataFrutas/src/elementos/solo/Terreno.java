package elementos.solo;

public class Terreno {
	private Chao solo[][];
	private int tamanho;

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
