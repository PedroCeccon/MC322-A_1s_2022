package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      Tabuleiro jogo = new Tabuleiro(tk);
	  Peca vetor_pecas[] = new Peca[32];
	  for (int i = 0; i < 32; i++) {
		  vetor_pecas[i] = new Peca(i, jogo);
	  }
	  tk.writeBoard("Tabuleiro inicial", jogo.board);
      String commands[] = tk.retrieveCommands();
      
      int peca_id;
      
      for (int l = 0; l < commands.length; l++) {
    	 peca_id = 0;
        System.out.println(commands[l]);
        while(!(vetor_pecas[peca_id].getPeca(commands[l])))
        	peca_id++;
        vetor_pecas[peca_id].movePeca(commands[l]);
      }
      
      tk.stop();
   }

}
