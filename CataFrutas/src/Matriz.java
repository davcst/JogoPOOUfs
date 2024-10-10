
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Matriz extends JFrame {

    // Um array 3x3 para armazenar as imagens
    Image[][] matrizImagens = new Image[3][3];

    // Construtor da classe Matriz
    public Matriz() {
        // Carregar as imagens no array
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                // Caminho para cada imagem (ajuste se necessário)
            	String path = "imagens/comGrama/pedraGrama.jpg";  // Usando a mesma imagem para todas as células
                matrizImagens[linha][coluna] = new ImageIcon(getClass().getResource(path)).getImage();
            }
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

                // Desenha a imagem na posição calculada
                g.drawImage(matrizImagens[linha][coluna], posX, posY, larguraImagem, alturaImagem, this);
            }
        }
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        // Cria a janela e exibe a matriz de imagens
        new Matriz();
    }
}
