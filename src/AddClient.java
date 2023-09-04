//
//import javax.swing.*;
//import javax.swing.border.EtchedBorder;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//
//
//public class AddClient {
//
//
//
//    Color background;
//    Color foreground;
//
//    JFrame clientframe = new JFrame();
//
//    JLabel NameLabel = new JLabel();
//
//    JLabel AddressLabel = new JLabel();
//
//    JLabel ContactNoLabel = new JLabel();
//
//    JLabel LandlineLabel = new JLabel();
//
//    JLabel EmailLabel = new JLabel();
//
//    JLabel AccountHolder = new JLabel();
//
//
//    JTextField AddressTextfield = new JTextField();
//    JButton AddButton = new JButton();
//
//    JTextField NameTextField = new JTextField();
//
//
//    JTextField ContactNoTextfield = new JTextField();
//
//    JTextField LandlineTextfield = new JTextField();
//
//    JTextField EmailTextField = new JTextField();
//
//    JTextArea otherDescriptionTextarea = new JTextArea();
//    JScrollPane otherDescriptionScrollpane = new JScrollPane();
//
//    JButton BackButton = new JButton();
//
//    JTable Table = new JTable();
//
//    DefaultTableModel model=new DefaultTableModel();
//
//    JScrollPane Scroll;
//
//
//    public AddClient(Color Dark, Color textcolor,Font font)
//    {
//
//
//        ThemeCheck(Dark,textcolor,font);
//
//        clientframe.add(NameTextField);
//        clientframe.add(NameLabel);
//        clientframe.add(AccountHolder);
//        clientframe.add(AddressLabel);
//        clientframe.add(AddressTextfield);
//        clientframe.add(BackButton);
//        clientframe.add(ContactNoLabel);
//        clientframe.add(LandlineLabel);
//        clientframe.add(EmailLabel);
//        clientframe.add(ContactNoTextfield);
//        clientframe.add(LandlineTextfield);
//        clientframe.add(EmailTextField);
//        clientframe.add(Scroll);
//        clientframe.add(AddButton);
//        clientframe.add(otherDescriptionScrollpane);
//
//        clientframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        clientframe.setSize(1800,900);
//        clientframe.setLayout(null);
//        clientframe.setTitle("Add Client");
//        clientframe.setResizable(false);
//        clientframe.setLocationRelativeTo(null);
//        clientframe.setVisible(true);
//
//
//
//
//
//
//    }
//
//
//
//    void ThemeCheck(Color Dark,Color textcolor,Font font)
//    {
//
//        background=Dark;
//        foreground=textcolor;
//
//        DisplayTransactionDetail(font);
//
//    }
//
//
//    void DisplayTransactionDetail(Font font)
//    {
//
//        clientframe.getContentPane().setBackground(background);
//        clientframe.getContentPane().setForeground(foreground);
//
//
//
//        AddressLabel.setBounds(100, 80, 230, 35);
//        AddressLabel.setText("Address:");
//        AddressLabel.setFont(font);
//        AddressLabel.setForeground(foreground);
//
//        AddressTextfield.setBounds(300, 80, 300, 35);
//        AddressTextfield.setHorizontalAlignment(JLabel.CENTER);
//        AddressTextfield.setFont(font);
//        AddressTextfield.setForeground(foreground);
//        AddressTextfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
//        AddressTextfield.setBackground(background);
//        AddressTextfield.setEditable(true);
//
//        AddressTextfield.addKeyListener(new KeyAdapter() {
//            public void keyTyped(KeyEvent e) {
//
//                char c = e.getKeyChar();
//                if (!((c >= 'a') && (c <= 'z') || (c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {
//
//                    e.consume();
//                }
//
//            }
//            });
//
//
//
//        NameLabel.setBounds(100, 150, 230, 35);
//        NameLabel.setText("Name:");
//        NameLabel.setFont(font);
//        NameLabel.setForeground(foreground);
//
//        NameTextField.setBounds(300, 150, 300, 35);
//        NameTextField.setHorizontalAlignment(JLabel.CENTER);
//        NameTextField.setFont(font);
//        NameTextField.setForeground(foreground);
//        NameTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
//        NameTextField.setBackground(background);
//        NameTextField.setEditable(true);
//
//        NameTextField.addKeyListener(new KeyAdapter() {
//            public void keyTyped(KeyEvent e) {
//
//                char c = e.getKeyChar();
//                if (!((c >= 'a') && (c <= 'z') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_SPACE) )) {
//
//                    e.consume();
//                }
//
//            }
//        });
//
//
//
//        ContactNoLabel.setBounds(100, 220, 230, 35);
//        ContactNoLabel.setText("Contact No:");
//        ContactNoLabel.setFont(font);
//        ContactNoLabel.setForeground(foreground);
//
//        ContactNoTextfield.setBounds(300, 220, 300, 35);
//        ContactNoTextfield.setHorizontalAlignment(JLabel.CENTER);
//        ContactNoTextfield.setFont(font);
//        ContactNoTextfield.setForeground(foreground);
//        ContactNoTextfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
//        ContactNoTextfield.setBackground(background);
//        ContactNoTextfield.setEditable(true);
//
//        ContactNoTextfield.addKeyListener(new KeyAdapter() {
//            public void keyTyped(KeyEvent e) {
//
//                char c = e.getKeyChar();
//                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {
//
//
//                    e.consume();
//                }
//
//            }
//            });
//
//        LandlineLabel.setBounds(100, 290, 230, 35);
//        LandlineLabel.setText("Landline:");
//        LandlineLabel.setFont(font);
//        LandlineLabel.setForeground(foreground);
//
//        LandlineTextfield.setBounds(300, 290, 300, 35);
//        LandlineTextfield.setHorizontalAlignment(JLabel.CENTER);
//        LandlineTextfield.setFont(font);
//        LandlineTextfield.setForeground(foreground);
//        LandlineTextfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
//        LandlineTextfield.setBackground(background);
//        LandlineTextfield.setEditable(true);
//
//        LandlineTextfield.addKeyListener(new KeyAdapter() {
//            public void keyTyped(KeyEvent e) {
//
//                char c = e.getKeyChar();
//                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {
//
//                    e.consume();
//                }
//
//            }
//        });
//
//        EmailLabel.setBounds(100, 370, 230, 35);
//        EmailLabel.setText("Email:");
//        EmailLabel.setFont(font);
//        EmailLabel.setForeground(foreground);
//
//        EmailTextField.setBounds(300, 370, 550, 35);
//        EmailTextField.setHorizontalAlignment(JLabel.CENTER);
//        EmailTextField.setFont(font);
//        EmailTextField.setForeground(foreground);
//        EmailTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
//        EmailTextField.setBackground(background);
//        EmailTextField.setEditable(true);
//
//        otherDescriptionScrollpane.setBounds(100,450,400,200);
//        otherDescriptionScrollpane.setBorder(new TitledBorder(new EtchedBorder(), "[Other Description]"));
//        otherDescriptionTextarea.setLineWrap(true);
//        otherDescriptionScrollpane.getViewport().add(otherDescriptionTextarea);
//        otherDescriptionScrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//
//
//
//
//        AddButton.setBounds(1650, 800, 150, 50);
//        AddButton.setText("Add Client");
//        AddButton.setFont(font);
//        AddButton.setBackground(background);
//        AddButton.setForeground(foreground);
//        AddButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
//        AddButton.setFocusable(false);
//
//        AddButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
//            public void mouseEntered(MouseEvent evt) {
//                AddButton.setBackground(foreground);
//                AddButton.setForeground(background);
//                AddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//
//            }
//
//            public void mouseExited(MouseEvent evt) {
//                AddButton.setBackground(background);
//                AddButton.setForeground(foreground);
//                AddButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//
//            }
//
//            public void mouseClicked(MouseEvent e) {
//
//                if(NameTextField.getText().equals(""))
//                {
//                    JOptionPane.showMessageDialog(clientframe, "Name can not be empty ", "Name Field Empty! ", JOptionPane.INFORMATION_MESSAGE);
//                    return;
//                }
//
//                if(AddressTextfield.getText().equals(""))
//                {
//                    AddressTextfield.setText("-");
//                }
//
//                if(ContactNoTextfield.getText().equals(""))
//                {
//                    ContactNoTextfield.setText("-");
//                }
//
//                if(LandlineTextfield.getText().equals(""))
//                {
//                    LandlineTextfield.setText("-");
//                }
//
//                if(EmailTextField.getText().equals(""))
//                {
//                    EmailTextField.setText("-");
//                }
//
//                if(otherDescriptionTextarea.getText().equals(""))
//                {
//                    otherDescriptionTextarea.setText("-");
//                }
//
//                String[] Data =
//                        {
//                                AddressTextfield.getText(),
//                                NameTextField.getText(),
//                                ContactNoTextfield.getText(),
//                                LandlineTextfield.getText(),
//                                EmailTextField.getText(),
//                                otherDescriptionTextarea.getText()
//                        };
//
//                File folder = new File("client/"+Data[1]);
//                if (!folder.exists()) {
//                    if (folder.mkdir()) {
//                    } else {
//                        System.out.println("Error Adding Client.");
//                    }
//                }
//
//                FileWriter Name = null;
//                FileWriter email = null;
//                FileWriter otherDescription = null;
//                FileWriter landline = null;
//
//                try {
//                    Name = new FileWriter("client/"+Data[1] + "/Contact.txt");
//                    Name.write(Data[2]);
//                    Name.close();
//
//                    Name = new FileWriter("client/"+Data[1] + "/name.txt");
//                    Name.write(Data[1]);
//                    Name.close();
//
//                    Name = new FileWriter("client/"+Data[1] + "/address.txt");
//                    Name.write(Data[0]);
//                    Name.close();
//
//                    landline = new FileWriter("client/"+Data[1] + "/landline.txt");
//                    landline.write(Data[3]);
//                    landline.close();
//
//                    email = new FileWriter("client/"+Data[1] + "/email.txt");
//                    email.write(Data[4]);
//                    email.close();
//
//                    otherDescription = new FileWriter("client/"+Data[1] + "/otherDescription.txt");
//                    otherDescription.write(Data[5]);
//                    otherDescription.close();
//
//                    System.out.println("Added");
//
//                } catch (IOException ex) {
//
//                }
//
//                AddressTextfield.setText("");
//                NameTextField.setText("");
//                ContactNoTextfield.setText("");
//                LandlineTextfield.setText("");
//                EmailTextField.setText("");
//                otherDescriptionTextarea.setText("");
//
//                clientframe.dispose();
//                new AddClient(clientframe.getContentPane().getBackground(), clientframe.getContentPane().getForeground(),font);
//
//            }
//        });
//
//
//
//
//        BackButton.setBounds(0, 800, 150, 50);
//        BackButton.setText("Back");
//        BackButton.setFont(font);
//        BackButton.setBackground(background);
//        BackButton.setForeground(foreground);
//        BackButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
//        BackButton.setFocusable(false);
//
//        BackButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
//            public void mouseEntered(MouseEvent evt) {
//                BackButton.setBackground(foreground);
//                BackButton.setForeground(background);
//                BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//
//            }
//
//            public void mouseExited(MouseEvent evt) {
//                BackButton.setBackground(background);
//                BackButton.setForeground(foreground);
//                BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//
//            }
//
//            public void mouseClicked(MouseEvent e) {
//
//                if(e.getSource()==BackButton)
//                {
//
//                    clientframe.dispose();
//                    new MainMenu(clientframe.getContentPane().getBackground(), clientframe.getContentPane().getForeground(),font);
//                }
//            }
//        });
//
//
//        DisplayTable();
//
//
//
//    }
//
//
//    void DisplayTable()
//    {
//
//
//        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Table.getDefaultRenderer(Object.class);
//        renderer.setHorizontalAlignment( SwingConstants.CENTER );
//
//        String[] ColumnNames={"Address","Contact no","Email","Landline","Name","Other"};
//
//
//        Table.setBackground(background);
//        Table.setForeground(foreground);
//        Table.getTableHeader().setBackground(foreground);
//        Table.getTableHeader().setForeground(background);
//        Table.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,20));
//        Table.setBorder(BorderFactory.createLineBorder(foreground));
//        Table.setGridColor(foreground);
//        Table.setSelectionBackground(foreground);
//        Table.setSelectionForeground(background);
//        Table.setDefaultEditor(Object.class,null);
//
//
//
//
//
//        Scroll=new JScrollPane();
//        Scroll.setViewportView(Table);
//        Scroll.setBounds(900,10,800,550);
//        Scroll.getViewport().setBackground(background);
//        Scroll.setBorder(BorderFactory.createLineBorder(foreground));
//
//
//        Scroll.setOpaque(true);
//
//        model=(DefaultTableModel)Table.getModel();
//        model.setColumnIdentifiers(ColumnNames);
//
//        String mainFolderPath = "client";
//
//        File mainFolder = new File(mainFolderPath);
//        if (mainFolder.exists() && mainFolder.isDirectory()) {
//            File[] subfolders = mainFolder.listFiles();
//            if (subfolders != null) {
//                String[] data = new String[12];
//                for (File subfolder : subfolders) {
//                    if (subfolder.isDirectory()) {
//                        File[] textFiles = subfolder.listFiles(new FilenameFilter() {
//                            @Override
//                            public boolean accept(File dir, String name) {
//                                return name.toLowerCase().endsWith(".txt");
//                            }
//                        });
//                        if (textFiles != null) {
//
//                            int j=0;
//                            for (File textFile : textFiles) {
//                                try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
//                                    String line;
//
//                                    while ((line = reader.readLine()) != null) {
//                                        // Process the content of the text document
//                                        data[j]=line;
//                                        j++;
//                                    }
//
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                            model.addRow(data);
//
//
//                        }
//                    }
//                }
//
//            }
//        }
//
//
//
//
//
//
//    }
//
//
//
//}
