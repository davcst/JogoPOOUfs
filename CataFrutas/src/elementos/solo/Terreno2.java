package elementos.solo;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Terreno2 {	
    private BufferedImage[][] matrizImagens;

    //Construtor
    public Terreno2(int linhas, int colunas, String caminho) {
        matrizImagens = new BufferedImage[linhas][colunas];
        carregarImagens(caminho);
    }

    // Exemplo de método responsável por carregar as imagens no terreno com imagem repetida
    // Modificar para entrar as imagens dos arquivos
    // Guarda o Valor das imagens, para ser posteriormente exibidas
    // Renomear imagens(não acho que funcione) ou fazer condicional
    private void carregarImagens(String caminhoBase) {
        try {
            for (int i = 0; i < matrizImagens.length; i++) {
                for (int j = 0; j < matrizImagens[i].length; j++) {
                   
                    String caminhoImagem = caminhoBase + "pedraGrama" + ".jpg";
                    matrizImagens[i][j] = ImageIO.read(new File(caminhoImagem));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar imagens do terreno: " + e.getMessage());
        }
    }
    
    public BufferedImage getImagem(int linha, int coluna) {
        if (linha >= 0 && linha < matrizImagens.length && coluna >= 0 && coluna < matrizImagens[0].length) {
            return matrizImagens[linha][coluna];
        } else {
            System.err.println("Posição fora dos limites da matriz.");
            return null;
        }
    }
}

