import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class KeyHandler implements KeyListener{
	
	int dimensao, pedras, Totalmaracujas,  Chaomaracujas, laranja, Pelaranja, abacate, Peabacate, coco,  Pecoco, acerola,  Peacerola, amora,  Peamora, goiaba,  Pegoiaba, bichada, mochila;
	
	GamePanel gp;
	public KeyHandler(GamePanel gp) {
        this.gp = gp; // Inicializa o GamePanel
    }
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int tecla = e.getKeyCode();
		
		//config no menu
		if(gp.gameState == gp.titleState) {
			if(gp.ui.tituloState == 0) {
				
				if(tecla == KeyEvent.VK_W) {
					gp.ui.numeroComando--;
					if(gp.ui.numeroComando < 0) {
						gp.ui.numeroComando = 3;
					}
				}
				if(tecla == KeyEvent.VK_S) {
					gp.ui.numeroComando++;
					if(gp.ui.numeroComando > 3) {
					gp.ui.numeroComando = 0;
					}
				}
				
				if(tecla == KeyEvent.VK_UP) {
					gp.ui.numeroComando--;
					if(gp.ui.numeroComando < 0) {
						gp.ui.numeroComando = 3;
					}
				}
				if(tecla == KeyEvent.VK_DOWN) {
					gp.ui.numeroComando++;
					if(gp.ui.numeroComando > 3) {
					gp.ui.numeroComando = 0;
					}
				}
				
				if(tecla == KeyEvent.VK_ENTER) {
					if(gp.ui.numeroComando == 0) {
						//gp.gameState = gp.gameStart; A SER IMPLEMENTADO
					}
				
					if(gp.ui.numeroComando == 1) {
						//gp.gameState = gp.gameContinue; A SER IMPLEMENTADO
					}
				
					if(gp.ui.numeroComando == 2) {
						gp.ui.tituloState = 2;
						gp.ui.numeroComando = 0;
						//gp.gameState = gp.gameMap; A SER IMPLEMENTADO
					}
				
					if(gp.ui.numeroComando == 3) {
						System.exit(0);
					}
				}
			}
			
			if(gp.ui.tituloState == 2) {
				
				
				if(tecla == KeyEvent.VK_W || tecla == KeyEvent.VK_UP) {
					gp.ui.numeroComando--;
					if(gp.ui.numeroComando < 0) {
						gp.ui.numeroComando = 8;
					}
				}
				if(tecla == KeyEvent.VK_S || tecla == KeyEvent.VK_DOWN) {
					gp.ui.numeroComando++;
					if(gp.ui.numeroComando > 8) {
					gp.ui.numeroComando = 0;
					}
				}
				
						
				
		
				if(tecla == KeyEvent.VK_ENTER) {
					
					if(gp.ui.numeroComando == 0) {
						boolean valorValido = false;
						
						while(!valorValido) {
							String temp = JOptionPane.showInputDialog("Dimensão >= 3: ");
							try {
								dimensao = Integer.parseInt(temp);
								
								if(dimensao >= 3) {
									valorValido = true;
								}
								else {
									JOptionPane.showMessageDialog(null, "O valor deve ser maior ou igual a 3. Tente novamente.");
								}
							}catch(NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
					}
					
	                  
					
					if(gp.ui.numeroComando == 1) {
						boolean valorValido = false;
						
						while(!valorValido) {
							String temp = JOptionPane.showInputDialog("Pedras: ");
							try {
								valorValido = true;
								pedras = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
					}
					
					if(gp.ui.numeroComando == 2) {
						boolean valorValido1 = false;
						boolean valorValido2 = false;
						
						while(!valorValido1) {
							String temp = JOptionPane.showInputDialog("Maracujás totais: ");
							try {
								valorValido1 = true;
								Totalmaracujas = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido1 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						while(!valorValido2) {
							String temp = JOptionPane.showInputDialog("Maracujás no chão: ");
							try {
								valorValido2 = true;
								Totalmaracujas = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido2 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
					}
					
					if(gp.ui.numeroComando == 3) {
						boolean valorValido1 = false;
						boolean valorValido2 = false;
						boolean valorValido3 = false;
						boolean valorValido4 = false;
						boolean valorValido5 = false;
						boolean valorValido6 = false;
						
						
						
						while(!valorValido1) {
							String temp = JOptionPane.showInputDialog("Laranjas: ");
							try {
								valorValido1 = true;
								laranja = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido1 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						
						while(!valorValido2) {
							String temp = JOptionPane.showInputDialog("Abacates: ");
							try {
								valorValido2 = true;
								abacate = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido2 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						
						while(!valorValido3) {
							String temp = JOptionPane.showInputDialog("Cocos: ");
							try {
								valorValido3 = true;
								coco = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido3 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						
						while(!valorValido4) {
							String temp = JOptionPane.showInputDialog("Acerolas: ");
							try {
								valorValido4 = true;
								acerola = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido4 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						
						while(!valorValido5) {
							String temp = JOptionPane.showInputDialog("Amoras: ");
							try {
								valorValido5 = true;
								amora = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido5 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
					
						while(!valorValido6) {
							String temp = JOptionPane.showInputDialog("Goiabas: ");
							try {
								valorValido6 = true;
								goiaba = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido6 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
					}
					
					if(gp.ui.numeroComando == 4) {
						boolean valorValido1 = false;
						boolean valorValido2 = false;
						boolean valorValido3 = false;
						boolean valorValido4 = false;
						boolean valorValido5 = false;
						boolean valorValido6 = false;
						boolean valorValido = false;
						
						while(!valorValido1) {
							String temp = JOptionPane.showInputDialog("Laranjeiras: ");
							try {
								valorValido1 = true;
								Pelaranja = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido1 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						while(!valorValido2) {
							String temp = JOptionPane.showInputDialog("Abacateiras: ");
							try {
								valorValido2 = true;
								Peabacate = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido2 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						while(!valorValido3) {
							String temp = JOptionPane.showInputDialog("Coqueiros: ");
							try {
								valorValido3 = true;
								Pecoco = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido3 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						while(!valorValido4) {
							String temp = JOptionPane.showInputDialog("Pés de acerola: ");
							try {
								valorValido4 = true;
								Peacerola = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido4 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						while(!valorValido5) {
							String temp = JOptionPane.showInputDialog("Amoreiras: ");
							try {
								valorValido5 = true;
								Peamora = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido5 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						while(!valorValido6) {
							String temp = JOptionPane.showInputDialog("Goiabeiras: ");
							try {
								valorValido6 = true;
								Pegoiaba = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido6 = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
						
					}
					
					if(gp.ui.numeroComando == 5) {
						boolean valorValido = false;
						
						while(!valorValido) {
							String temp = JOptionPane.showInputDialog("Bichada(O valor corresponderá a porcentagem. Ex: 2 = 2%): ");
							try {
								valorValido = true;
								bichada = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
					}
					
					if(gp.ui.numeroComando == 6) {
						boolean valorValido = false;
						
						while(!valorValido) {
							String temp = JOptionPane.showInputDialog("Mochila: ");
							try {
								valorValido = true;
								mochila = Integer.parseInt(temp);
								
							}catch(NumberFormatException e1) {
								valorValido = false;
								JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
							}
						}
					}
					
					if(gp.ui.numeroComando == 7) {
						if(gp.ui.numeroComando == 7) {
						    try {
						        // Cria o diretório "game_data" se não existir
//						        File pasta = new File("game_data");
//						        if (!pasta.exists()) {
//						            pasta.mkdir();
//						        }
						        //CASO NÃO ESTEJA SALVANDO TIRAR O COMENTARIO ACIMA!!!
						    	
						        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
						        
						        // Caminho do arquivo com timestamp
						        String file = "game_data/valores_" + timestamp + ".txt";
						        
						        
						        // Escreve os valores no arquivo
						        FileWriter writer = new FileWriter(file);
						        writer.write("dimensao " + dimensao + "\n");
						        writer.write("pedras " + pedras + "\n");
						        writer.write("maracuja " + Totalmaracujas + " " +Chaomaracujas + "\n");
						        writer.write("laranja " + Pelaranja + " " + laranja+ "\n");
						        writer.write("abacate " + Peabacate + " " + abacate+ "\n");
						        writer.write("coco " + Pecoco + " " + coco + "\n");
						        writer.write("acareola " + Peacerola + " " + acerola + "\n");
						        writer.write("amora " + Peamora + " " + amora + "\n");
						        writer.write("goiaba " + Pegoiaba + " " + goiaba + "\n");
						        writer.write("Bichada: " + bichada + "\n");
						        writer.write("Mochila: " + mochila + "\n");
						        writer.close();
						        
						        JOptionPane.showMessageDialog(null, "Valores salvos com sucesso");
						    } catch (IOException ex) {
						        JOptionPane.showMessageDialog(null, "Erro ao salvar os valores: " + ex.getMessage());
						        ex.printStackTrace();
						    }
						}
					}
					
					if(gp.ui.numeroComando == 8) {
						gp.ui.tituloState = 0;
						gp.ui.numeroComando = 0;
					}
				}
			}
			
		
		}
		
//		if(tecla == KeyEvent.VK_W) {
//			upPressed = true;
//		}
//		if(tecla == KeyEvent.VK_S) {
//			downPressed = true;
//		}
//		if(tecla == KeyEvent.VK_A) {
//			leftPressed = true;
//		}
//		if(tecla == KeyEvent.VK_D) {
//			rightPressed = true;
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int tecla = e.getKeyCode();
		
		if(tecla == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(tecla == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(tecla == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(tecla == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
		if(tecla == KeyEvent.VK_ENTER) {
			enterPressed = false;
		}
		
		if(tecla == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if(tecla == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if(tecla == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if(tecla == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
	}
	
//	private void salvarValoresEmArquivo() {
//	    String nomeDoArquivo = "valores.txt";
//	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeDoArquivo))) {
//	        writer.write("Dimensão: " + dimensao);
//	        writer.newLine();
//	        writer.write("Pedras: " + pedras);
//	        writer.newLine();
//	        writer.write("Maracujás: " + maracujas);
//	        writer.newLine();
//	        writer.write("Frutas: " + frutas);
//	        writer.newLine();
//	        writer.write("Árvores: " + arvores);
//	        writer.newLine();
//	        writer.write("Bichada: " + bichada);
//	        writer.newLine();
//	        writer.write("Mochila: " + mochila);
//	        writer.newLine();
//	        writer.flush();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        JOptionPane.showMessageDialog(null, "Erro ao salvar os valores no arquivo.");
//	    }
//	}

}
