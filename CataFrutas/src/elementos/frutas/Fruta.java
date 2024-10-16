package elementos.frutas;

import elementos.Jogador;

/**
 * Classe mãe das frutas que serão instanciadas no jogo
 * @author breno
 */
public abstract class Fruta {
	private boolean bichada;
	public Fruta() {
		this.bichada = false; // TODO: Aleatorizar a possibilidade de ser bichada.
							  // Necessário saber onde colocar a lógica e onde encontrar a chance de ser bichada.
	}
	/**
	 * @return bichada
	 */
	public boolean getBichada() {
		return bichada;
	}
	
	public abstract void aplicarEfeito(Jogador jogador);
}
