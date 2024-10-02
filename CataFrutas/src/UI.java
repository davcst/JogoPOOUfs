import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    public int numeroComando = 0;
    public int tituloState = 0; //0 é o menu principal principal, 1 será o carregar jogo e 2 vai ser o gerar mapa
    int n, pedras, maracuja, frutas, arvores, bichada, mochila;
    
    public UI(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(new Font("Arial", Font.BOLD, 48));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.black);

        // Menu Inicial
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
    }

    private void drawTitleScreen() {
    	if(tituloState == 0) {
    		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String texto = "Cata Frutas";

            int x = valorXparaCentralizarNaTela(texto);
            int y = gp.SCREEN_ALTURA / 3;

            g2.drawString(texto, x, y);

            // Desenha o menu de opções
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

            texto = "NOVO JOGO";
            x = valorXparaCentralizarNaTela(texto);
            y += 100;
            g2.drawString(texto, x, y);
            if (numeroComando == 0) {
                g2.drawString(">", x - 40, y);
            }

            texto = "CARREGAR JOGO";
            x = valorXparaCentralizarNaTela(texto);
            y += 100;
            g2.drawString(texto, x, y);
            if (numeroComando == 1) {
                g2.drawString(">", x - 40, y);
            }

            texto = "CRIAR MAPA";
            x = valorXparaCentralizarNaTela(texto);
            y += 100;
            g2.drawString(texto, x, y);
            if (numeroComando == 2) {
                g2.drawString(">", x - 40, y);
            }

            texto = "SAIR";
            x = valorXparaCentralizarNaTela(texto);
            y += 100;
            g2.drawString(texto, x, y);
            if (numeroComando == 3) {
                g2.drawString(">", x - 40, y);
            }
    	}
    	else if(tituloState == 1) {
    		
    	}
    	else if(tituloState == 2) {
    		JFrame frame = new JFrame();
    		//g2.setColor(Color.green);
    		//g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
    		g2.setFont(g2.getFont().deriveFont(20F));
    		
    		String texto = "Selecione a dimensão da floresta (n >= 3)";
    		int x = valorXparaCentralizarNaTela(texto);
            int y = gp.SCREEN_ALTURA / 3;
            g2.drawString(texto, x, y);
            if (numeroComando == 0) {
                g2.drawString(">", x - 40, y);
            }
            
            
    		texto = "O número de pedras";
    		x = valorXparaCentralizarNaTela(texto);
            y += 60;
    		g2.drawString(texto, x, y);
//    		pedras = scanner.nextInt();
    		if (numeroComando == 1) {
                g2.drawString(">", x - 40, y);
            }
    		
    		texto = "O número total de Maracujás";
    		x = valorXparaCentralizarNaTela(texto);
            y += 60;
    		g2.drawString(texto, x, y);
//    		maracuja = scanner.nextInt();
    		if (numeroComando == 2) {
                g2.drawString(">", x - 40, y);
            }
    		
    		texto = "O número de frutas";
    		x = valorXparaCentralizarNaTela(texto);
            y += 60;
    		g2.drawString(texto, x, y);
//    		frutas = scanner.nextInt();
    		if (numeroComando == 3) {
                g2.drawString(">", x - 40, y);
            }
    		
    		texto = "O número de Árvores";
    		x = valorXparaCentralizarNaTela(texto);
            y += 60;
    		g2.drawString(texto, x, y);
//    		arvores = scanner.nextInt();
    		if (numeroComando == 4) {
                g2.drawString(">", x - 40, y);
            }
    		
    		texto = "A chance da fruta estar bichada";
    		x = valorXparaCentralizarNaTela(texto);
            y += 60;
    		g2.drawString(texto, x, y);
//    		bichada = scanner.nextInt();
    		if (numeroComando == 5) {
                g2.drawString(">", x - 40, y);
            }
    		
    		texto = "Capacidade da mochila";
    		x = valorXparaCentralizarNaTela(texto);
            y += 60;
    		g2.drawString(texto, x, y);
//    		mochila = scanner.nextInt();
    		if (numeroComando == 6) {
                g2.drawString(">", x - 40, y);
            }
    		
    		texto = "VOLTAR";
    		x = valorXparaCentralizarNaTela(texto);
            y += 60;
    		g2.drawString(texto, x, y);
    		if (numeroComando == 7) {
                g2.drawString(">", x - 40, y);
            }
    		
    	}
        
    }

    public int valorXparaCentralizarNaTela(String text) {
        int comprimento = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.SCREEN_LARGURA / 2 - comprimento / 2;
    }
}
