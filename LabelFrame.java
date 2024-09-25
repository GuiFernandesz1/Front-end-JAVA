import java.awt.FlowLayout;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.Icon; 
import javax.swing.ImageIcon; 

// 'extends' está herdando o JFrame
public class LabelFrame extends JFrame 
{ // inciando bloco de códigos da classe LabelFrame
   private final JLabel label1; 
   private final JLabel label2; 
   private final JLabel label3; 
// 'private' não exporta a variável, apenas quem está dentro do bloco de códigos pode usar.
// 'final' serve para declarar uma variável somente de leitura.
// 'JLabel' é o tipo da variável.
// 'label1, 2, 3' é o nome da variável.

   // construtor (public) não pode ser privado, não pode ser static, não pode ser void, não precisa de parametros
   // nome deve ser igual ao nome da classe e do arquivo
   public LabelFrame()
   {
      // definindo o titulo da janela
      super("Testing JLabel");
      
      // responsável por como vai ficar o layout da janela
      setLayout(new FlowLayout());

      
      // está recebendo um novo objeot
      // aqui chamamos a variável definida anteriormente, 'label1'
      label1 = new JLabel("Label with text");
      // invocando um tool tip (dica), quando colocar o mouse em cima da escrita anterior (com a janela aberta e o programa rodando)
      label1.setToolTipText("This is label1");
      // adicionando o 'label1' dentro do frame do construtor, para que seja mostrado no layout.
      add(label1);

      
      Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
      // recebe um novo objeto 'JLabel' com um separador de parametros (virgula).
      label2 = new JLabel("Label with text and icon", bug, 
      
      // alinhamento espacial dento da janela
         SwingConstants.LEFT);
      label2.setToolTipText("This is label2");
      add(label2);

      label3 = new JLabel();

      // definindo texto
      label3.setText("Label with icon and text at bottom");

      // adicionando a variável 'icon'
      label3.setIcon(bug); 

      // definindo a posição do texto (horizontal), texto definido ao centro
      label3.setHorizontalTextPosition(SwingConstants.CENTER);

      // definindo a posição vertical do texto, onde o texto vai pra baixo e icone vai pra cima
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);

      
      label3.setToolTipText("This is label3");
      add(label3); 
   } 
} 