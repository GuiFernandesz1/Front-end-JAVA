

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class PasswordField extends JFrame 
{
   private final JPasswordField passwordField; 
   

    
   public PasswordField()
   {
    
      super("PasswordField");
      setLayout(new FlowLayout());

    
      passwordField = new JPasswordField("Hidden text");
      add(passwordField); 

      
      TextFieldHandler handler = new TextFieldHandler();
      
      passwordField.addActionListener(handler);
   } 

   private class TextFieldHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         String string = ""; 

         if (event.getSource() == passwordField) 
            string = String.format("PasswordField: %s",                                 
               event.getActionCommand()); 


                  JOptionPane.showMessageDialog(null, string); 
      } 
   } 
   public static void main(String[] args)
   
   
   { 
      PasswordField passwordField = new PasswordField(); 
      
      passwordField.setDefaultCloseOperation(JPasswordField.EXIT_ON_CLOSE);
      passwordField.setSize(350, 100); 
      passwordField.setVisible(true); 
   } 
} 