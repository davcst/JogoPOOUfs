/**
 * 
 */
package elementos.frutas;

import elementos.Jogador;

/**
 * 
 */
public abstract class Fruta {
	private boolean bichada;
	public Fruta() {
		this.bichada = false; // TODO: aleatorizar a possibilidade de ser bichada?
	}
	/**
	 * @return bichada
	 */
	public boolean getBichada() {
		return bichada;
	}
	
	public abstract void aplicarEfeito(Jogador jogador);
}
