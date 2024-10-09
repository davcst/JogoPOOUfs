package elementos.solo;

import elementos.Jogador;
import elementos.arvores.Arvore;
import elementos.frutas.Fruta;

public class Grama extends Chao {
	private Jogador jogadorPresente;
	private Fruta frutaPresente;
	private Arvore arvorePresente;
	
	public Grama() {
		this.jogadorPresente = null;
		this.frutaPresente = null;
		this.arvorePresente = null;
	}
	
	public Jogador getJogadorPresente() {
		return this.jogadorPresente;
	}
	public void setJogadorPresente(Jogador jogador) {
		this.jogadorPresente = jogador;
	}
	
	public Fruta getFrutaPresente() {
		return this.frutaPresente;
	}
	public void setFrutaPresente(Fruta fruta) {
		this.frutaPresente = fruta;
	}
	
	public Arvore getArvorePresente() {
		return this.arvorePresente;
	}
	public void setArvorePresente(Arvore arvore) {
		this.arvorePresente = arvore;
	}

}
