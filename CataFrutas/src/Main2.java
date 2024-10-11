import elementos.solo.Terreno2;  // Certifique-se de ajustar o caminho correto do pacote
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 * Classe de teste de criação da interface grafica
 * @author alisson
 */
public class Main2 extends JFrame {

    // Terreno contendo a matriz de imagens
    private Terreno2 terreno;

    // Construtor da classe Matriz
    public Main2() {
        // Caminho da imagem
        String caminhoBase = "src/imagens/comGrama/";  
        // Inicializa o terreno com 3x3 e o caminho
        // os valores de dimenção entram no lugar do 3
        terreno = new Terreno2(3, 3, caminhoBase);
        

        // Configurações da janela
        this.setTitle("Matriz de Imagens");
        this.setSize(400, 400); // Tamanho da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no "X"
        this.setLocationRelativeTo(null); // Centraliza a janela na tela
        this.setVisible(true); // Exibe a janela
    }

    // Sobrescreve o método paint() do JFrame para desenhar as imagens
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Limpa a tela antes de desenhar

        // Tamanho de cada imagem
        int larguraImagem = 100;
        int alturaImagem = 100;

        // Percorre a matriz do terreno e desenha cada imagem
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                // Pega a imagem da posição (linha, coluna) no terreno para ser desenhada em seguida
                BufferedImage imagem = terreno.getImagem(linha, coluna);

                // Calcula a posição X e Y para cada imagem na tela
                int posX = 50 + coluna * larguraImagem;
                int posY = 50 + linha * alturaImagem;

                // Desenha a imagem na posição calculada (se a imagem for válida)
                if (imagem != null) {
                    g.drawImage(imagem, posX, posY, larguraImagem, alturaImagem, this);
                }
            }
        }
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        // Cria a janela e exibe a matriz de imagens
        new Main2();
    }
}