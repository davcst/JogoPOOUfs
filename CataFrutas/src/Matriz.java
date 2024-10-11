import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


/**
 * Classe de matriz de imagens para apresentar na UI
 * @author alisson
 */
public class Matriz extends JFrame {

    // Um array 3x3 para armazenar as imagens
    BufferedImage[][] matrizImagens = new BufferedImage[3][3];

    // Construtor da classe Matriz
    public Matriz() {
        // Carregar as imagens no array
        try {
            for (int linha = 0; linha < 3; linha++) {
                for (int coluna = 0; coluna < 3; coluna++) {
                    // Caminho para cada imagem (ajuste se necessário)
                    String path = "src/imagens/comGrama/pedraGrama.jpg";  // Ajuste o caminho conforme necessário
                    matrizImagens[linha][coluna] = ImageIO.read(new File(path));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar imagem: " + e.getMessage());
        }

        // Configurações da janela
        this.setTitle("Matriz de Imagens");
        this.setSize(400, 400); // Tamanho da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no "X"
        this.setVisible(true); // Exibe a janela
        this.setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    // Sobrescreve o método paint() do JFrame para desenhar as imagens
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Limpa a tela antes de desenhar

        // Tamanho de cada imagem
        int larguraImagem = 100;
        int alturaImagem = 100;

        // Percorre a matriz e desenha cada imagem
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                // Calcula a posição X e Y para cada imagem na tela
                int posX = 50 + coluna * larguraImagem;
                int posY = 50 + linha * alturaImagem;

                // Desenha a imagem na posição calculada (se a imagem for válida)
                if (matrizImagens[linha][coluna] != null) {
                    g.drawImage(matrizImagens[linha][coluna], posX, posY, larguraImagem, alturaImagem, this);
                }
            }
        }
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        // Cria a janela e exibe a matriz de imagens
        new Matriz();
    }
}
