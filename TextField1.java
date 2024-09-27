

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;


public class TextField1 extends JFrame 
{
   
   private final JTextField textField1; 
       
   public TextField1()
   {
      
      super("TextField1");
      setLayout(new FlowLayout());

     
      textField1 = new JTextField(10); 
      add(textField1); 
  
     
      TextFieldHandler handler = new TextFieldHandler();
      
      textField1.addActionListener(handler);
   } 

   
   private class TextFieldHandler implements ActionListener 
   {
     
      @Override
      public void actionPerformed(ActionEvent event)
      {
         String string = ""; 
         
         if (event.getSource() == textField1) 
            string = String.format("textField1: %s",                                  
               event.getActionCommand()); 
         
         JOptionPane.showMessageDialog(null, string); 
      } 
   } 
   public static void main(String[] args)
   
   { 
      TextField1 textField1 = new TextField1(); 
      
      textField1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textField1.setSize(350, 100); 
      textField1.setVisible(true); 
   } 
} 