import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class MainMenu {

    JFrame MenuFrame = new JFrame();


    JButton ProductDetailButton = new JButton();
    JButton ClientDetailButton = new JButton();
    JButton TransactionDetailButton = new JButton();
    JButton AddProduct = new JButton();
    JButton AddCleint = new JButton();
    JButton LogoutButton = new JButton();
    JButton ChangePassword = new JButton();
    JButton DashboardButton = new JButton();

    MainMenu(Color background,Color foreground,Font font)
    {

        MenuFrame.getContentPane().setBackground(background);
        MenuFrame.getContentPane().setForeground(foreground);

        MenuFrame.add(ProductDetailButton);
        MenuFrame.add(ClientDetailButton);
        MenuFrame.add(TransactionDetailButton);
        MenuFrame.add(LogoutButton);
        MenuFrame.add(ChangePassword);
        MenuFrame.add(AddCleint);
        MenuFrame.add(AddProduct);
        MenuFrame.add(DashboardButton);

        MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuFrame.setSize(1280,720);
        MenuFrame.setLayout(null);
        MenuFrame.setTitle("Main Menu");
        MenuFrame.setResizable(false);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setVisible(true);

        DashboardButton.setBounds(550,50,250,50);
        DashboardButton.setFont(font);
        DashboardButton.setText("Dashboard");
        DashboardButton.setForeground(foreground);
        DashboardButton.setBackground(background);
        DashboardButton.setBorder(BorderFactory.createLineBorder(background, 2,false));
        DashboardButton.setFocusable(false);

        DashboardButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                DashboardButton.setBackground(foreground);
                DashboardButton.setForeground(background);
                DashboardButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                DashboardButton.setBackground(background);
                DashboardButton.setForeground(foreground);
                DashboardButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }


            public void mouseClicked(MouseEvent e) {
                MenuFrame.dispose();
                new Dashboard(MenuFrame.getContentPane().getBackground(),MenuFrame.getContentPane().getForeground(),font);

            }
        });


        ProductDetailButton.setBounds(550,150,250,50);
        ProductDetailButton.setFont(font);
        ProductDetailButton.setText("Product Detail");
        ProductDetailButton.setForeground(foreground);
        ProductDetailButton.setBackground(background);
        ProductDetailButton.setBorder(BorderFactory.createLineBorder(background));
        ProductDetailButton.setFocusable(false);

        ProductDetailButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                ProductDetailButton.setBackground(foreground);
                ProductDetailButton.setForeground(background);
                ProductDetailButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                ProductDetailButton.setBackground(background);
                ProductDetailButton.setForeground(foreground);
                ProductDetailButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }


            public void mouseClicked(MouseEvent e) {
                MenuFrame.dispose();
                new ProductDetails(MenuFrame.getContentPane().getBackground(),MenuFrame.getContentPane().getForeground(),font);

            }
        });

        ClientDetailButton.setBounds(540,250,250,50);
        ClientDetailButton.setFont(font);
        ClientDetailButton.setText("Client Detail");
        ClientDetailButton.setForeground(foreground);
        ClientDetailButton.setBackground(background);
        ClientDetailButton.setBorder(BorderFactory.createLineBorder(background));
        ClientDetailButton.setFocusable(false);

        ClientDetailButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                ClientDetailButton.setBackground(foreground);
                ClientDetailButton.setForeground(background);
                ClientDetailButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                ClientDetailButton.setBackground(background);
                ClientDetailButton.setForeground(foreground);
                ClientDetailButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }


            public void mouseClicked(MouseEvent e) {

                MenuFrame.dispose();
                new ClientDetail(MenuFrame.getContentPane().getBackground(),MenuFrame.getContentPane().getForeground(),font);
            }
        });

        TransactionDetailButton.setBounds(550,350,250,50);
        TransactionDetailButton.setFont(font);
        TransactionDetailButton.setText("Transaction Detail");
        TransactionDetailButton.setForeground(foreground);
        TransactionDetailButton.setBackground(background);
        TransactionDetailButton.setBorder(BorderFactory.createLineBorder(background));
        TransactionDetailButton.setFocusable(false);

        TransactionDetailButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                TransactionDetailButton.setBackground(foreground);
                TransactionDetailButton.setForeground(background);
                TransactionDetailButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                TransactionDetailButton.setBackground(background);
                TransactionDetailButton.setForeground(foreground);
                TransactionDetailButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {

                MenuFrame.dispose();
                new TransactionDetail(MenuFrame.getContentPane().getBackground(),MenuFrame.getContentPane().getForeground(),font);

            }
        });

        AddProduct.setBounds(550,450,250,50);
        AddProduct.setFont(font);
        AddProduct.setText("Add Product");
        AddProduct.setForeground(foreground);
        AddProduct.setBackground(background);
        AddProduct.setBorder(BorderFactory.createLineBorder(background));
        AddProduct.setFocusable(false);

        AddProduct.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                AddProduct.setBackground(foreground);
                AddProduct.setForeground(background);
                AddProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                AddProduct.setBackground(background);
                AddProduct.setForeground(foreground);
                AddProduct.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {

                MenuFrame.dispose();
                new AddProduct(MenuFrame.getContentPane().getBackground(),MenuFrame.getContentPane().getForeground(),font);

            }
        });


        AddCleint.setBounds(550,550,250,50);
        AddCleint.setFont(font);
        AddCleint.setText("Add Client");
        AddCleint.setForeground(foreground);
        AddCleint.setBackground(background);
        AddCleint.setBorder(BorderFactory.createLineBorder(background));
        AddCleint.setFocusable(false);

        AddCleint.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                AddCleint.setBackground(foreground);
                AddCleint.setForeground(background);
                AddCleint.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                AddCleint.setBackground(background);
                AddCleint.setForeground(foreground);
                AddCleint.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {

                MenuFrame.dispose();
                new AddClient(MenuFrame.getContentPane().getBackground(),MenuFrame.getContentPane().getForeground(),font);

            }
        });


        LogoutButton.setBounds(5,620,120,50);
        LogoutButton.setFont(font);
        LogoutButton.setText("Logout");
        LogoutButton.setForeground(foreground);
        LogoutButton.setBackground(background);
        LogoutButton.setBorder(BorderFactory.createLineBorder(background));
        LogoutButton.setFocusable(false);

        LogoutButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                LogoutButton.setBackground(foreground);
                LogoutButton.setForeground(background);
                LogoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                LogoutButton.setBackground(background);
                LogoutButton.setForeground(foreground);
                LogoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }


            public void mouseClicked(MouseEvent e) {


                MenuFrame.dispose();
                new LoginPage(MenuFrame.getContentPane().getBackground(),MenuFrame.getContentPane().getForeground(),font);
            }
        });



        ChangePassword.setBounds(1080,620,180,50);
        ChangePassword.setFont(font);
        ChangePassword.setText("Change Password");
        ChangePassword.setForeground(foreground);
        ChangePassword.setBackground(background);
        ChangePassword.setBorder(BorderFactory.createLineBorder(background));
        ChangePassword.setFocusable(false);

        ChangePassword.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                ChangePassword.setBackground(foreground);
                ChangePassword.setForeground(background);
                ChangePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                ChangePassword.setBackground(background);
                ChangePassword.setForeground(foreground);
                ChangePassword.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }


            public void mouseClicked(MouseEvent e) {
                JTextField previousPassword = new JTextField(10);
                JTextField newPassword = new JTextField(10);
                JTextField confirmNewPassword = new JTextField(10);

                // Create the panel to hold the text fields
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 2));
                panel.add(new JLabel("Previous Password:"));
                panel.add(previousPassword);
                panel.add(new JLabel("New Password:"));
                panel.add(newPassword);
                panel.add(new JLabel("Confirm Password:"));
                panel.add(confirmNewPassword);

                // Show the JOptionPane with the custom panel
                int result = JOptionPane.showOptionDialog(null, panel, "Enter Values",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                // Handle the user's selection
                if (result == JOptionPane.OK_OPTION) {
                    String previousPassowrdString = previousPassword.getText();
                    String newPasswordString = newPassword.getText();
                    String confirmNewPasswordString = confirmNewPassword.getText();


                try {
                    Scanner passwordFromFile = new Scanner(new File("account/admin/password.txt"));
                    String password = passwordFromFile.next();
                    if(previousPassowrdString.equals(password))
                    {
                        if(newPasswordString.equals(confirmNewPasswordString)){
                            FileWriter changePassword = null;
                            try {

                                changePassword = new FileWriter("account/admin/password.txt");
                                changePassword.write(newPasswordString);
                                changePassword.close();
                                JOptionPane.showMessageDialog(MenuFrame, "Password Changed Succefully", "Password Changed", JOptionPane.INFORMATION_MESSAGE);
                            }catch (Exception Lund){
                                System.out.println();
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(MenuFrame, "Password Not Confirmed", "Invalid Information!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(MenuFrame,"Invalid Information","Invalid Information!",JOptionPane.INFORMATION_MESSAGE);
                    }

                    } catch (Exception E) {
                        JOptionPane.showMessageDialog(MenuFrame,"Invalid Information","Invalid Information!",JOptionPane.INFORMATION_MESSAGE);
                    }



                }
            }
        });



    }


 }
