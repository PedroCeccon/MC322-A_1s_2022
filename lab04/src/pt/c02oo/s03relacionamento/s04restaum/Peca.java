package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	public int id;
	public int posicao_x, posicao_y;
	public Tabuleiro jogo;
	
	Peca(int id, Tabuleiro jogo){
		this.id = id;
		this.jogo = jogo;
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if (jogo.getPosicao(i, j) == '*') {
					jogo.setPosicao(i, j, 'P');
					posicao_x = i;
					posicao_y = j;
					i = 10;
					j = 10;
				}
			}
		}
	}
	
	public boolean getPeca(String comando) {
		int x = (int) comando.charAt(0) - 97;
		int y = (int) comando.charAt(1) - 49;
		if(x == posicao_x && y == posicao_y)
			return true;
		else
			return false;
	}
	
	public void movePeca(String comando){
		int x_inicial = (int) comando.charAt(0) - 97;
		int x_final = (int) comando.charAt(3) - 97;
		int y_inicial = (int) comando.charAt(1) - 49;
		int y_final = (int) comando.charAt(4) - 49;
		if (x_inicial != x_final)
			posicao_x = x_final;
		else
			posicao_y = y_final;
		jogo.novoTabuleiro(x_inicial, x_final, y_inicial, y_final);
		jogo.printBoard(comando.substring(0, 2), comando.substring(3));
	}
}
