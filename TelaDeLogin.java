import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeLogin extends JFrame 
{
    private final JLabel lblLogin; 
    private final JTextField txtLoginBox;
    private final JLabel lblPassword;
    private final JPasswordField txtPassBox;
    private final JButton btnLogar;
    private final JLabel lblNotificacoes;

    public TelaDeLogin(){
        super("Tela de Login");
        setLayout(new FlowLayout());

        lblLogin = new JLabel("Login");
        add(lblLogin);

        txtLoginBox = new JTextField(10);
        add(txtLoginBox);

        lblPassword = new JLabel("Password");
        add(lblPassword);

        txtPassBox = new JPasswordField(10);
        add(txtPassBox);

        btnLogar = new JButton("Logar");
        add(btnLogar);

        lblNotificacoes = new JLabel("Notificações");
        add(lblNotificacoes);

        ButtonHandler buttonHandler = new ButtonHandler();
        btnLogar.addActionListener(buttonHandler);

        txtPassBox.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (String.valueOf(txtPassBox.getPassword()).trim().length() > 0) {
                        if (e.getKeyCode() == 10) {
                            System.out.println("Você teclou Enter");
                            logar();
                        }
                    }
                }
            }
        );
    }

    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            logar();
        }
    }

    public void logar() {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where email = '" +
            txtLoginBox.getText() + "' and senha = '" + String.valueOf(txtPassBox.getPassword()) + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()) {
                notificarUsuario("Login realizado com sucesso!");
                // aqui notificamos o usuário que seu login e senha foram encontrados
            } else {
                notificarUsuario("Não foi possível realizar o login, verifique seu usuário e senha e tente novamente.");

                // já aqui notificamos o usuário que seu login e senha não foram identificados
            }
        } catch (Exception e) {
            System.err.println("Ops, algo está errado, confira novamente as informações: " + e);

        }
    }

    public String setHtmlFormat(String txt) {
        return "<html><body>" + txt + "</body></html>";
    }

    public void notificarUsuario(String strTexto) {
        lblNotificacoes.setText(setHtmlFormat(strTexto));
    }

    public static void main(String[] args) {
        TelaDeLogin appTelaDeLogin = new TelaDeLogin();
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        appTelaDeLogin.setSize(150,200);
        appTelaDeLogin.setVisible(true);
    }
}
