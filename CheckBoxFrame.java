import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.font.*;
import java.util.*;


// delcaração da classe
public class CheckBoxFrame extends JFrame 
{
   private final JTextField textField; 
   private final JCheckBox boldJCheckBox; 
   private final JCheckBox italicJCheckBox; 
   private final JCheckBox underlineCheckBox;

   // exportação do construtor
   public CheckBoxFrame()
   {
      super("JCheckBox Test"); // título
      setLayout(new FlowLayout());

      textField = new JTextField("Watch the font style change", 20);
      textField.setFont(new Font("Serif", Font.PLAIN, 14));
      add(textField); 

      boldJCheckBox = new JCheckBox("Bold"); 
      italicJCheckBox = new JCheckBox("Italic"); 
      add(boldJCheckBox); 
      add(italicJCheckBox); 
      underlineCheckBox = new JCheckBox("Underline");
      add(underlineCheckBox);
      


      CheckBoxHandler handler = new CheckBoxHandler();
      boldJCheckBox.addItemListener(handler);
      italicJCheckBox.addItemListener(handler);
      underlineCheckBox.addItemListener(handler);
   } 

   private class CheckBoxHandler implements ItemListener 
   {
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         Font font = null;

         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
         else if (boldJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD, 14);
         else if (italicJCheckBox.isSelected())
            font = new Font("Serif", Font.ITALIC, 14);
         else
            font = new Font("Serif", Font.PLAIN, 14);

         textField.setFont(font);
         
         
         if (underlineCheckBox.isSelected()) {
            font = textField.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            textField.setFont(font.deriveFont(attributes));
            font = new Font(attributes);
         }
      } 
   }
} 