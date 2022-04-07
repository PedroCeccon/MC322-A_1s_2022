package pt.c02oo.s02classe.s03lombriga;

public class AnimaLombriga {
	int aquario_tamanho, lombriga_tamanho, lombriga_posicao;
	char lombriga_direcao;
	String aquario;
	Toolkit tk;
	
	AnimaLombriga (int aquario_tamanho, int lombriga_tamanho, int lombriga_posicao, Toolkit tk){
		this.tk = tk;
		aquario = "";
		this.aquario_tamanho = aquario_tamanho;
		this.lombriga_tamanho = lombriga_tamanho;
		this.lombriga_posicao = lombriga_posicao;
		lombriga_direcao = 'E';
		for (int i = 1; i < lombriga_posicao; i++)
			aquario += "#";
		aquario += "O";
		for (int i = 1; i < lombriga_tamanho; i++)
			aquario += "@";
		for (int i = 0; i <= (aquario_tamanho - lombriga_posicao - lombriga_tamanho); i++)
			aquario += "#";
		tk.gravaPasso("=====");
	}
	
	void apresenta(){
		tk.gravaPasso(aquario);
	}
	
	void atualiza() {
		aquario = "";
		for (int i = 1; i < lombriga_posicao; i++)
			aquario += "#";
		for (int i = 0; i < lombriga_tamanho; i++)
			aquario += "@";
		for (int i = 0; i < (aquario_tamanho - lombriga_posicao - lombriga_tamanho + 1); i++)
			aquario += "#";
		if (lombriga_direcao == 'E')
			aquario = aquario.substring(0, lombriga_posicao-1) + "O" + aquario.substring(lombriga_posicao);
		else
			aquario = aquario.substring(0, lombriga_posicao+lombriga_tamanho-2) + "O" + aquario.substring(lombriga_posicao + lombriga_tamanho-1);
	}
	
	void crescer(){
		if(lombriga_direcao == 'E' && lombriga_posicao + lombriga_tamanho <= aquario_tamanho)
			lombriga_tamanho ++;
		if(lombriga_direcao == 'D' && lombriga_posicao>1) {
			lombriga_posicao --;
			lombriga_tamanho ++;
		}
	}
	
	void virar() {
		if (lombriga_direcao == 'E')
			lombriga_direcao = 'D';
		else
			lombriga_direcao = 'E';
	}
	
	void passo() {
		if(lombriga_direcao == 'E') {
			if(lombriga_posicao == 1)
				virar();
			else
				lombriga_posicao --;
		}
		else {
			if(lombriga_posicao + lombriga_tamanho > aquario_tamanho)
				virar();
			else
				lombriga_posicao ++;
		}
	}
}