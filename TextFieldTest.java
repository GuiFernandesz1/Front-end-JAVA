// importando componente 'JFrame', módulo 'swing', biblioteca 'javax'
import javax.swing.JFrame;

// declaração da classe 'TextFieldTest' (mesmo nome do arquivo.)
public class TextFieldTest

// inicio do bloco de códigos da classe acima.
{
   // declaração do método executor 'main' 
   public static void main(String[] args)
   
   // inicio do bloco de códigos do método
   { 
      // declaração da variável
      TextFieldFrame textFieldFrame = new TextFieldFrame(); 
      
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textFieldFrame.setSize(350, 100); 
      textFieldFrame.setVisible(true); 
   } 
} 