// import javax.swing.JFrame; ou
import javax.swing.*;

public class RadioButtonTest  // nome da classe deve sempre ser igual ao nome do arquivo
{
   public static void main(String[] args)
   {
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame(); // new sempre cria um novo objeto
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      radioButtonFrame.setSize(300, 150); 
      radioButtonFrame.setVisible(true); 
   } 
} 