import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; 
   private final JLabel label; 

   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])),  // linhas separadas por vírgulas para indicar os próximos vetores
      new ImageIcon(getClass().getResource(names[1])),   // linhas que declaram novos objetos (os ícones) / transformando um texto em imagem
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};  // ponto vírgula para indicar final da declaração dos vetores

   
   public ComboBoxFrame()  // construtor (nome igual ao nome do arquivo)
   {
      super("Testing JComboBox");  // título na parte superior da janela
      setLayout(new FlowLayout()); 

      imagesJComboBox = new JComboBox<String>(names);  // variavel 'imagesJComboBox' recebe um novo objeto 
      imagesJComboBox.setMaximumRowCount(3);  // declara a quantidade de linhas que serão mostradas ao clicar e entrar nas setinhas janela

      imagesJComboBox.addItemListener( 
         new ItemListener() 
         {
            @Override
            public void itemStateChanged(ItemEvent event)  // 'itemStateChanged' vai receber o parametro 'event' do item 'ItemEvent'
            {
               if (event.getStateChange() == ItemEvent.SELECTED)  // se selecionar o icone que ja estava selecionado o 'if' vai reconhecer e ignorar
                  label.setIcon(icons[
                     imagesJComboBox.getSelectedIndex()]);
            } 
         } 
      ); 

      add(imagesJComboBox); 
      label = new JLabel(icons[0]); 
      add(label); 
   }
}


// selecionar texto todo e usar format selection (Ctrl + K Ctrl + F), coloca o código todo em formatação