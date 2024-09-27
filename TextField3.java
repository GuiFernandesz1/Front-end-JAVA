

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextField3 extends JFrame 
{
   private final JTextField textField3; 
    
   public TextField3()
   {
      super("TestField3");
      setLayout(new FlowLayout());
     
      textField3 = new JTextField("Uneditable text field", 21); 
      textField3.setEditable(false);
      add(textField3); 

      TextFieldHandler handler = new TextFieldHandler();
      textField3.addActionListener(handler);
   } 

   private class TextFieldHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         String string = ""; 
         if (event.getSource() == textField3)
            string = String.format("textField3: %s",
                                          
               event.getActionCommand());
         
         JOptionPane.showMessageDialog(null, string); 
      } 
   } 
   public static void main(String[] args)
   
   { 
      TextField3 textField3 = new TextField3(); 
      
      textField3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textField3.setSize(350, 100); 
      textField3.setVisible(true); 
   } 
} 