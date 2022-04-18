package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	public char board[][] = {
	         {' ', ' ', '*', '*', '*', ' ', ' '},
	         {' ', ' ', '*', '*', '*', ' ', ' '},
	         {'*', '*', '*', '*', '*', '*', '*'},
	         {'*', '*', '*', '-', '*', '*', '*'},
	         {'*', '*', '*', '*', '*', '*', '*'},
	         {' ', ' ', '*', '*', '*', ' ', ' '},
	         {' ', ' ', '*', '*', '*', ' ', ' '}
	      };
	public Toolkit tk;
	
	Tabuleiro(Toolkit tk){
		this.tk = tk;
	}

	public char getPosicao(int posicao_x, int posicao_y) {
		return board[posicao_y][posicao_x];
	}
	
	public void setPosicao(int posicao_x, int posicao_y, char caracter) {
		board[posicao_y][posicao_x] = caracter;
	}
	
	public void printBoard(String source, String target) {
		tk.writeBoard("source: " + source + "; target: " + target, board);
	}
	
	public void novoTabuleiro(int x_inicial, int x_final, int y_inicial, int y_final) {
		if(x_inicial != x_final) {
			setPosicao(x_inicial, y_inicial, '-');
			setPosicao((x_inicial+x_final)/2, y_inicial, '-');
			setPosicao(x_final, y_inicial, 'P');
		}
		else {
			setPosicao(x_inicial, y_inicial, '-');
			setPosicao(x_inicial, (y_inicial+y_final)/2, '-');
			setPosicao(x_inicial, y_final, 'P');
		}
	}
}
