import javax.swing.JFrame;

public class MenuTest
{
   public static void main(String[] args)
   { 
      MenuFrame menuFrame = new MenuFrame(); 
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      menuFrame.setSize(600, 500); 
      menuFrame.setVisible(true);
   } 
}