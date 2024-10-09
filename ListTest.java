import javax.swing.JFrame;

public class ListTest 
{
   public static void main(String[] args) // exportação estática nula principal de matriz de texto
   { 
      ListFrame listFrame = new ListFrame(); 
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      listFrame.setSize(350, 150); // tamanho da janela
      listFrame.setVisible(true); // para mostrar a janela (true)
   } 
}