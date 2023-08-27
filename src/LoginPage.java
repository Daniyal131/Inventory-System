import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;

public class LoginPage {

    JFrame LoginFrame = new JFrame();
    JButton LoginButton = new JButton("Login");
    JButton Reset = new JButton("Reset");

    JMenuBar menuBar = new JMenuBar();

    JMenuItem exit = new JMenuItem();
    JMenuItem TextColor = new JMenuItem();
    JMenuItem BackgroundColor = new JMenuItem();


    JMenu FileMenu = new JMenu("File");
    JMenu ViewMenu = new JMenu("View");


    JMenu ThemeMenu = new JMenu();



    JButton updatePassword = new JButton("Update Password");

    JLabel UserLabel = new JLabel("Username:");

    JLabel PasswordLabel = new JLabel("Password:");

    JLabel Message = new JLabel();

    JPasswordField PasswordField = new JPasswordField();
    JTextField UserIdField = new JTextField();
    LoginPage(Color backgroundcolor, Color textcolor,Font font)
    {

        CheckPanelColor(backgroundcolor,textcolor);
        Theme(font);

        LoginFrame.add(UserLabel);
        LoginFrame.add(PasswordLabel);
        LoginFrame.add(UserIdField);
        LoginFrame.add(PasswordField);
        LoginFrame.add(LoginButton);
        LoginFrame.add(updatePassword);
        LoginFrame.add(Message);
        LoginFrame.add(Reset);

        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginFrame.setSize(1280,720);
        LoginFrame.setLayout(null);
        LoginFrame.setTitle("Login");
        LoginFrame.setResizable(false);
        LoginFrame.setLocationRelativeTo(null);
        LoginFrame.setJMenuBar(menuBar);
        LoginFrame.setVisible(true);



    }

    void CheckPanelColor(Color backgroundcolor, Color textcolor)
    {


        SetBackgroundColor(backgroundcolor);
        SetTextColor(textcolor);

    }

    void SetTextColor(Color textcolor)
    {
        LoginFrame.getContentPane().setForeground(textcolor);

        FileMenu.setForeground(textcolor);
        ViewMenu.setForeground(textcolor);
        exit.setForeground(textcolor);
        TextColor.setForeground(textcolor);
        BackgroundColor.setForeground(textcolor);

        UserLabel.setForeground(textcolor);
        PasswordLabel.setForeground(textcolor);

        UserIdField.setForeground(textcolor);
        UserIdField.setSelectionColor(textcolor);
        UserIdField.setBorder(BorderFactory.createLineBorder(textcolor, 2, true));
        UserIdField.setCaretColor(textcolor);

        PasswordField.setForeground(textcolor);
        PasswordField.setSelectionColor(textcolor);
        PasswordField.setBorder(BorderFactory.createLineBorder(textcolor, 2, true));
        PasswordField.setCaretColor(textcolor);



        Reset.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {


                Reset.setBackground(textcolor);
                Reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


            }

            public void mouseExited(MouseEvent evt) {

                Reset.setForeground(textcolor);

            }
        });


        LoginButton.setForeground(textcolor);
        LoginButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {

                LoginButton.setBackground(textcolor);
                LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {

                LoginButton.setForeground(textcolor);
            }



        });


    }
    void SetBackgroundColor(Color backgroundcolor)
    {
        LoginFrame.getContentPane().setBackground(backgroundcolor);

        menuBar.setBackground(backgroundcolor);

        FileMenu.setBackground(backgroundcolor);

        ViewMenu.setBackground(backgroundcolor);

        exit.setBackground(backgroundcolor);

        TextColor.setBackground(backgroundcolor);

        BackgroundColor.setBackground(backgroundcolor);


        UserIdField.setBackground(backgroundcolor);

        PasswordField.setBackground(backgroundcolor);

        LoginButton.setBackground(backgroundcolor);
        LoginButton.setBorder(BorderFactory.createLineBorder(backgroundcolor, 2, false));

        LoginButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {


                LoginButton.setForeground(backgroundcolor);


            }

            public void mouseExited(MouseEvent evt) {

                LoginButton.setBackground(backgroundcolor);

            }
    });

        Reset.setBackground(backgroundcolor);
        Reset.setBorder(BorderFactory.createLineBorder(backgroundcolor, 2, false));

        Reset.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {


                Reset.setForeground(backgroundcolor);


            }

            public void mouseExited(MouseEvent evt) {

                Reset.setBackground(backgroundcolor);

            }
        });


}

void Theme(Font font)
{

    KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);

    menuBar.add(FileMenu);
    menuBar.add(ViewMenu);
    exit.setText("exit");
    exit.setAccelerator(keyStrokeToOpen);


    TextColor.setText("Text Color");
    BackgroundColor.setText("Background Color");
    ThemeMenu.setText("Theme");

    FileMenu.add(exit);

    ViewMenu.add(ThemeMenu);
    ThemeMenu.add(TextColor);
    ThemeMenu.add(BackgroundColor);


    BackgroundColor.addActionListener(e -> {

        Color BackgroundColor1 =JColorChooser.showDialog(null,"Choose Background Color",Color.white);
        SetBackgroundColor(BackgroundColor1);

    });

    TextColor.addActionListener(e -> {

        Color TextColor1 =JColorChooser.showDialog(null,"Choose Text Color",Color.BLACK);
        SetTextColor(TextColor1);

    });


    exit.addActionListener(e -> System.exit(0));


    UserLabel.setBounds(430, 200, 200, 50);
    UserLabel.setFont(font);


    PasswordLabel.setBounds(430, 280, 200, 50);
    PasswordLabel.setFont(font);





    UserIdField.setBounds(600, 200, 200, 35);
    UserIdField.setFont(font);
    UserIdField.setHorizontalAlignment(JTextField.CENTER);
    UserIdField.requestFocus();
    String len=String.valueOf(UserIdField.getText());


    UserIdField.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            char c = e.getKeyChar();

            UserIdField.setEditable(Character.isLetter(c) || Character.isISOControl(c));

            if(e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_DOWN )
            {
                PasswordField.requestFocus();
            }

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if(len.length()>15)
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(LoginFrame,"Username is More than 15 Characters","Username too long error!",JOptionPane.INFORMATION_MESSAGE);
                e.consume();
            }
        }
    });

    PasswordField.setBounds(600, 280, 200, 35);
    PasswordField.setFont(font);
    PasswordField.setHorizontalAlignment(JTextField.CENTER);
    PasswordField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if(c == KeyEvent.VK_ENTER && !(UserIdField.getText().equals(""))){
                if(UserIdField.getText().equals("") || PasswordField.getText().equals("")){
                    JOptionPane.showMessageDialog(LoginFrame,"Please provide complete information","Incomplete Information!",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String filepath = UserIdField.getText();
                try {
                    Scanner passwordFromFile = new Scanner(new File("account/"+filepath+"/password.txt"));
                    String password = passwordFromFile.next();
                    if(PasswordField.getText().equals(password))
                    {
                        LoginFrame.dispose();
                        new MainMenu(LoginFrame.getContentPane().getBackground(),LoginFrame.getContentPane().getForeground(),font);
                    }
                    else{
                        PasswordField.setText("");
                        PasswordField.requestFocus();
                        JOptionPane.showMessageDialog(LoginFrame,"Incorrect Password","Incorrect Information!",JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (Exception E) {
                    UserIdField.setText("");
                    UserIdField.requestFocus();
                    JOptionPane.showMessageDialog(LoginFrame,"Incorrect Username","Incorrect Information!",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    });


    Reset.setBounds(650, 350, 150, 50);
    Reset.setFont(font);
    Reset.setFocusable(false);
    Reset.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            UserIdField.setText("");
            PasswordField.setText("");
        }

    });

    LoginButton.setBounds(430, 350, 150, 50);
    LoginButton.setFont(font);
    LoginButton.setFocusable(false);

    LoginButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(UserIdField.getText().equals("") || PasswordField.getText().equals("")){
                JOptionPane.showMessageDialog(LoginFrame,"Please provide complete information","Incomplete Information!",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            String filepath = UserIdField.getText();
            try {
                Scanner passwordFromFile = new Scanner(new File("account/"+filepath+"/password.txt"));
                String password = passwordFromFile.next();
                if(PasswordField.getText().equals(password))
                {
                    LoginFrame.dispose();
                    new MainMenu(LoginFrame.getContentPane().getBackground(),LoginFrame.getContentPane().getForeground(),font);
                }
                else{
                    PasswordField.setText("");
                    PasswordField.requestFocus();
                    JOptionPane.showMessageDialog(LoginFrame,"Incorrect Password","Incorrect Information!",JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception E) {
                UserIdField.setText("");
                UserIdField.requestFocus();
                JOptionPane.showMessageDialog(LoginFrame,"Incorrect Username","Incorrect Information!",JOptionPane.INFORMATION_MESSAGE);
            }




        }
    });

}



}
