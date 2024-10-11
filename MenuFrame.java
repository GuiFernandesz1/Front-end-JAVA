import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame // classe com mesmo nome do arquivo herdando JFrame
{ // 'private' uso exclusivo a classe, 'final' somente leitura, '[]' matriz
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};   // vetores
   private final JRadioButtonMenuItem[] colorItems; 
   private final JRadioButtonMenuItem[] fonts;  
   private final JCheckBoxMenuItem[] styleItems; 
   private final JLabel displayJLabel; 
   private final ButtonGroup fontButtonGroup; 
   private final ButtonGroup colorButtonGroup; 
   private int style; 

   public MenuFrame()
   {
      super("Using JMenus");     

      JMenu fileMenu = new JMenu("File"); 
      fileMenu.setMnemonic('F'); // Mnemonic utilizado para abrir determinada opção usando o teclado, no exemplo a tecla F
      // Mnemonic utilizado para tecla de atalhos

      JMenuItem aboutItem = new JMenuItem("About..."); 
      aboutItem.setMnemonic('A'); // Mnemonic
      fileMenu.add(aboutItem); 
      aboutItem.addActionListener(
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(MenuFrame.this,  // virgula esta separando os parametros
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 
 
      JMenuItem exitItem = new JMenuItem("Exit"); 
      exitItem.setMnemonic('x'); // Mnemonic utilizado para tecla de atalho novamente
      fileMenu.add(exitItem); 
      exitItem.addActionListener(
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0); 
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // criação da barra de menu
      setJMenuBar(bar); 
      bar.add(fileMenu); // adicionando os menus à barra

      JMenu formatMenu = new JMenu("Format"); 
      formatMenu.setMnemonic('r'); 

      String[] colors = {"Black", "Blue", "Red", "Green"}; // matriz das cores

      JMenu colorMenu = new JMenu("Color"); 
      colorMenu.setMnemonic('C'); // Mnemonic criado novamente (botão de atalho no teclado)

      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); 
      ItemHandler itemHandler = new ItemHandler(); // manipulador recebendo novo objeto

      for (int count = 0; count < colors.length; count++) 
      { // declaração da variável 'count' (tipo int);
       // enquanto o contador for menor que a quantidade de vetores da matriz colors;
      // some mais um
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); 
         colorMenu.add(colorItems[count]); 
         colorButtonGroup.add(colorItems[count]); 
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true); 

      formatMenu.add(colorMenu); 
      formatMenu.addSeparator(); 

      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};  // matriz de string com 3 vetores
      JMenu fontMenu = new JMenu("Font");  // criação do menu de fontes
      fontMenu.setMnemonic('n'); // Mnemonic
      // a letra do Mnemonico deve estar presente na palavra criada: ex: Font = Mnemonic 'n'. deve ser igual (maiuscula ou minuscula)
      fonts = new JRadioButtonMenuItem[fontNames.length]; // RadioButton = botões redondos
      fontButtonGroup = new ButtonGroup(); 

      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]); 
         fontButtonGroup.add(fonts[count]); 
         fonts[count].addActionListener(itemHandler); 
      } 

      fonts[0].setSelected(true); 
      fontMenu.addSeparator(); 

      String[] styleNames = {"Bold", "Italic"}; 
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); 

      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); 
         fontMenu.add(styleItems[count]); 
         styleItems[count].addItemListener(styleHandler); 
      }

      formatMenu.add(fontMenu); 
      bar.add(formatMenu); 
     
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

      getContentPane().setBackground(Color.CYAN); 
      add(displayJLabel, BorderLayout.CENTER); 
   } 

   private class ItemHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72));
            }
         }

         repaint(); 
      } 
   }
   
   private class StyleHandler implements ItemListener 
   {
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); 
         Font font; 

         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);
         repaint(); 
      } 
   } 
} 