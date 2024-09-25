// a linha a seguir importa o componente JFrame do módulo swing da biblioteca (pacote) javax
import javax.swing.JFrame;

// a linha abaixo declara a classe LabelTest
public class LabelTest 
{
   // abaixo é declarado o código 'main'
   public static void main(String[] args)
   { 
      // está declarando a variável LabelFrame, do tipo LabelFrame
      LabelFrame labelFrame = new LabelFrame(); 
      
      // o ponto invoca o método (a direita do ponto)
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // a linha abaixo vai setar (set) o tamanho
      labelFrame.setSize(260, 180); 

      // a linha abaixo vai solicitar ao JAVA que mostre/reenderize/torne visível
      labelFrame.setVisible(true); 
   } // encerrando bloco de códigos do método

} // encerrando bloco de códigos da classe

// LabelFrame (começando com letra maiuscula) é o tipo.
// Já a labelframe (letra minúscula) é a variável.