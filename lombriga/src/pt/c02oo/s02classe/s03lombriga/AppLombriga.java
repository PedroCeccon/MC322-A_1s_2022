package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      LombrigaAquario aquario1;
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++) {
         System.out.println(lombrigas[l]);
         aquario1 = new LombrigaAquario(lombrigas[l], tk);
         aquario1.executa();
      }
      
      tk.stop();
   }
}
