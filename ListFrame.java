import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrame extends JFrame // classe principal que tem o mesmo nome do arquivo
// JFrame vai permitir reenderizar a janela do programa (importante)
{
   private final JList<String> colorJList; // private é o uso exclusivo da classe somente de leitura 'final'
   // JList é o objeto (quadrao de interação com o usuário da janela)
   // <String> está entre tags, pois não comporta apenas textos
   private static final String[] colorNames = {"Black", "Blue", "Cyan",   // exclusiva que não pode ser alterada (static) / String[] é a matriz / colorNames é a variável 
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
      "Orange", "Pink", "Red", "White", "Yellow"}; // nomes das cores são os vetores
   private static final Color[] colors = {Color.BLACK, Color.BLUE,
      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW};
   private final JList<String> sizeJList;
   private static final String[] sizeNames = {"Small", "Medium", "Big"};
   

   public ListFrame() // método construtor
   {
      super("List Test");
      setLayout(new FlowLayout()); 

      colorJList = new JList<String>(colorNames);  // definindo um novo objeto / aqui estamos enviando a matriz de string criada anteriormente com os nomes das cores
      colorJList.setVisibleRowCount(5);  // definindo quantas linhas ficam visíveis ao abrir a janela de interação com usuário dentro da janela principal
      
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // definição do modo de seleção

      
      add(new JScrollPane(colorJList));  // novo objeto do tipo JScrollPane (janela de interação com usuário dentro da janela principal)

      colorJList.addListSelectionListener(  // adicionando um escutador de lista de seleção (quando o usuário interagir (clicar), lançará o vetor selecionado)
         new ListSelectionListener()
         {   
            @Override
            public void valueChanged(ListSelectionEvent event)  // event refere a tudo que o usuário pode fazer para interagir com a janela, onde vai ser recebido pelo valueChanged
            {
               getContentPane().setBackground(  // setBackground recebe o vetor selecionado e define a cor do fundo, de acordo com a lista de vetores
                  colors[colorJList.getSelectedIndex()]);
            } 
         } 
      );

      sizeJList = new JList<String>(sizeNames);
      sizeJList.setVisibleRowCount(3);

      sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      add(new JScrollPane(sizeJList));

      sizeJList.addListSelectionListener(
         new ListSelectionListener()
         {
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               switch (sizeJList.getSelectedIndex()) {
                  case 0:
                     setSize(350,150);
                     break;
               
                  case 1:
                     setSize(550,350);
                     break;
               
                  case 2:
                     setSize(750,550);
                     break;
               default:
                  setSize(350,150);
                  break;
               }
            }
         }
      );
   }
}              
   
   
         


