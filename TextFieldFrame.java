

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

// 'extend' está herdando o componente JFrame
public class TextFieldFrame extends JFrame 
{
   // declarações de variáveis
   private final JTextField textField1; // text field with set size
   private final JTextField textField2; // text field with text
   private final JTextField textField3; // text field with text and size
   private final JPasswordField passwordField; // password field with text
   // fim das declarações das variáveis

    
   public TextFieldFrame()
   {
      // definição do texto do titulo da janela
      super("Testing JTextField and JPasswordField");
      setLayout(new FlowLayout());

      // declaração / atribuição de variável dentro do construtor
      textField1 = new JTextField(10); 
      add(textField1); 

      // declaração / atribuição de variável dentro do construtor
      textField2 = new JTextField("Enter text here");
      add(textField2); 

      
      textField3 = new JTextField("Uneditable text field", 21); 
      textField3.setEditable(false); // define o método como não podendo ser editado
      add(textField3); 

      
      passwordField = new JPasswordField("Hidden text");
      add(passwordField); // adiciona texto ao campo password criado

      // 'handler' serve como manipulador 
      TextFieldHandler handler = new TextFieldHandler();
      // 'addActionListener' é o escutador de ação (esperando receber uma ação)
      // invocam o mesmo método 
      textField1.addActionListener(handler); //'handler' deve ser um pbjeto, com auxilio do 'implements'
      textField2.addActionListener(handler);
      textField3.addActionListener(handler);
      passwordField.addActionListener(handler);
   } 

   // 'implements' injeta o objeto 'ActionListener' no 'TextFieldHandler'
   private class TextFieldHandler implements ActionListener 
   {
      // comando de alteração (@ não permite exibição de notificação 'warning')
      // sobrescrever 
      @Override


      public void actionPerformed(ActionEvent event)
      {
         String string = ""; // definição da 'string', atribuindo um texto vazio a ela
         
         // 'if' = se
         if (event.getSource() == textField1) // dois sinais '=', sinal de comparação (compara um lado ao outro)
            string = String.format("textField1: %s", // 'String.format' entrega o texto formatado 
            // %s caracter coringa para retornar uma 'string' (texto)                                 
               event.getActionCommand()); // pegar o comando da ação (o texto escrito pelo usuário)

         
         else if (event.getSource() == textField2)
            string = String.format("textField2: %s",
               event.getActionCommand());

         
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         
         JOptionPane.showMessageDialog(null, string); 
      } 
   } 
} 