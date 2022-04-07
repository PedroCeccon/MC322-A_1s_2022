package pt.c02oo.s02classe.s03lombriga;

public class LombrigaAquario {
	int aquario_tamanho, lombriga_tamanho, lombriga_posicao;
	char lombriga_direcao;
	String comandos;
	AnimaLombriga aquario;

	LombrigaAquario(String entrada, Toolkit tk){
		aquario_tamanho = Integer.parseInt(entrada.substring(0, 2));
		lombriga_tamanho = Integer.parseInt(entrada.substring(2, 4));
		lombriga_posicao = Integer.parseInt(entrada.substring(4, 6));
		lombriga_direcao = 'E';
		comandos = entrada.substring(6);
		
		if(lombriga_tamanho > aquario_tamanho) {
			lombriga_tamanho = aquario_tamanho;
			lombriga_posicao = 1;
		}
		else if(lombriga_posicao + lombriga_tamanho > aquario_tamanho) {
			lombriga_posicao = 1;
		}
		
		aquario = new AnimaLombriga(aquario_tamanho, lombriga_tamanho, lombriga_posicao, tk);
	}
	
	void executa() {
		aquario.apresenta();
		for (int i = 0; i < comandos.length(); i++) {
			if (comandos.charAt(i) == 'C')
				aquario.crescer();
			else if(comandos.charAt(i) == 'M')
				aquario.passo();
			else
				aquario.virar();
			aquario.atualiza();
			aquario.apresenta();
		}
	}
}
