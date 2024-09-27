import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextField2 extends JFrame 
{
   private final JTextField textField2;

   public TextField2()
   {
      super("TextField2");
      setLayout(new FlowLayout());

      textField2 = new JTextField("Enter text here");
      add(textField2); 

      TextFieldHandler handler = new TextFieldHandler();

      textField2.addActionListener(handler);
   } 

   private class TextFieldHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         String string = "";

         if (event.getSource() == textField2) 
            string = String.format("textField2: %s",
               event.getActionCommand());
         
         JOptionPane.showMessageDialog(null, string); 
      } 
   } 
   public static void main(String[] args)
   
   { 
      TextField2 textField2 = new TextField2(); 
      
      textField2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textField2.setSize(350, 100); 
      textField2.setVisible(true); 
   } 
} 