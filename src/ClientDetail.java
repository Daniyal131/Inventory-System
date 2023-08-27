
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class ClientDetail {



    Color background;
    Color foreground;

    JFrame clientframe = new JFrame();

    JLabel NameLabel = new JLabel();

    JLabel AddressLabel = new JLabel();

    JLabel ContactNoLabel = new JLabel();

    JLabel LandlineLabel = new JLabel();

    JLabel EmailLabel = new JLabel();

    JLabel AccountHolder = new JLabel();

    JLabel SearchClientLabel = new JLabel();

    JTextField SearchClientTextfield = new JTextField();


    JTextField AddressTextfield = new JTextField();

    JTextField NameTextField = new JTextField();


    JTextField ContactNoTextfield = new JTextField();

    JTextField LandlineTextfield = new JTextField();

    JTextField EmailTextField = new JTextField();


    JButton BackButton = new JButton();


    JTextArea clientdescriptionarea = new JTextArea();
    JScrollPane clientdescriptionpane = new JScrollPane();
    JTable Table = new JTable();

    DefaultTableModel model=new DefaultTableModel();

    JScrollPane Scroll;



    public ClientDetail(Color Dark, Color textcolor,Font font)
    {


        ThemeCheck(Dark,textcolor,font);

        clientframe.add(NameTextField);
        clientframe.add(NameLabel);
        clientframe.add(AccountHolder);
        clientframe.add(AddressLabel);
        clientframe.add(AddressTextfield);
        clientframe.add(BackButton);
        clientframe.add(ContactNoLabel);
        clientframe.add(LandlineLabel);
        clientframe.add(EmailLabel);
        clientframe.add(ContactNoTextfield);
        clientframe.add(LandlineTextfield);
        clientframe.add(EmailTextField);
        clientframe.add(clientdescriptionpane);
        clientframe.add(SearchClientTextfield);
        clientframe.add(SearchClientLabel);
        clientframe.add(Scroll);

        clientframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientframe.setSize(1800,900);
        clientframe.setLayout(null);
        clientframe.setTitle("Client Detail");
        clientframe.setResizable(false);
        clientframe.setLocationRelativeTo(null);
        clientframe.setVisible(true);





    }



    void ThemeCheck(Color Dark,Color textcolor,Font font)
    {

        background=Dark;
        foreground=textcolor;

        DisplayTransactionDetail(font);

    }


    void DisplayTransactionDetail(Font font)
    {

        clientframe.getContentPane().setBackground(background);
        clientframe.getContentPane().setForeground(foreground);

        SearchClientLabel.setBounds(900, 10, 230, 35);
        SearchClientLabel.setText("Search Client:");
        SearchClientLabel.setFont(font);
        SearchClientLabel.setForeground(foreground);

        SearchClientTextfield.setBounds(1030, 10, 670, 35);
        SearchClientTextfield.setHorizontalAlignment(JLabel.CENTER);
        SearchClientTextfield.setFont(font);
        SearchClientTextfield.setForeground(foreground);
        SearchClientTextfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        SearchClientTextfield.setBackground(background);

        SearchClientTextfield.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {


                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    System.out.println(SearchClientTextfield.getText());
                    int rowCount =  model.getRowCount();

                    for(int tabletrav = rowCount-1;tabletrav>=0;tabletrav--)
                    {
                        model.removeRow(tabletrav);
                    }
                    String mainFolderPath = "client";

                    File mainFolder = new File(mainFolderPath);
                    if (mainFolder.exists() && mainFolder.isDirectory()) {
                        File[] subfolders = mainFolder.listFiles();
                        if (subfolders != null) {
                            String[] data = new String[12];
                            for (File subfolder : subfolders) {
                                if (subfolder.isDirectory()) {
                                    File[] textFiles = subfolder.listFiles(new FilenameFilter() {
                                        @Override
                                        public boolean accept(File dir, String name) {
                                            return name.toLowerCase().endsWith(".txt");
                                        }
                                    });
                                    if (textFiles != null) {

                                        int j = 0;
                                        for (File textFile : textFiles) {
                                            try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
                                                String line;


                                                while ((line = reader.readLine()) != null) {
                                                    // Process the content of the text document
                                                    data[j] = line;
                                                    j++;
                                                }

                                            } catch (IOException f) {
                                                f.printStackTrace();
                                            }
                                        }
                                        for(int trav=0;trav<6;trav++)
                                        {

                                            if((data[trav].startsWith(SearchClientTextfield.getText())) && !(SearchClientTextfield.getText().equals("")))
                                            {
                                                model.addRow(data);
                                                break;
                                            }
                                        }




                                    }
                                }
                            }

                        }
                    }
                    if(SearchClientTextfield.getText().equals(""))
                    {
                        AddDataToProductTableFromDatabase();

                    }
                }



            }

        });



        AddressLabel.setBounds(100, 80, 230, 35);
        AddressLabel.setText("Address:");
        AddressLabel.setFont(font);
        AddressLabel.setForeground(foreground);

        AddressTextfield.setBounds(300, 80, 300, 35);
        AddressTextfield.setHorizontalAlignment(JLabel.CENTER);
        AddressTextfield.setFont(font);
        AddressTextfield.setForeground(foreground);
        AddressTextfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AddressTextfield.setBackground(background);
        AddressTextfield.setEditable(false);



        NameLabel.setBounds(100, 150, 230, 35);
        NameLabel.setText("Name:");
        NameLabel.setFont(font);
        NameLabel.setForeground(foreground);

        NameTextField.setBounds(300, 150, 300, 35);
        NameTextField.setHorizontalAlignment(JLabel.CENTER);
        NameTextField.setFont(font);
        NameTextField.setForeground(foreground);
        NameTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        NameTextField.setBackground(background);
        NameTextField.setEditable(false);



        ContactNoLabel.setBounds(100, 220, 230, 35);
        ContactNoLabel.setText("Contact No:");
        ContactNoLabel.setFont(font);
        ContactNoLabel.setForeground(foreground);

        ContactNoTextfield.setBounds(300, 220, 300, 35);
        ContactNoTextfield.setHorizontalAlignment(JLabel.CENTER);
        ContactNoTextfield.setFont(font);
        ContactNoTextfield.setForeground(foreground);
        ContactNoTextfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        ContactNoTextfield.setBackground(background);
        ContactNoTextfield.setEditable(false);

        LandlineLabel.setBounds(100, 290, 230, 35);
        LandlineLabel.setText("Landline:");
        LandlineLabel.setFont(font);
        LandlineLabel.setForeground(foreground);

        LandlineTextfield.setBounds(300, 290, 300, 35);
        LandlineTextfield.setHorizontalAlignment(JLabel.CENTER);
        LandlineTextfield.setFont(font);
        LandlineTextfield.setForeground(foreground);
        LandlineTextfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        LandlineTextfield.setBackground(background);
        LandlineTextfield.setEditable(false);

        EmailLabel.setBounds(100, 370, 230, 35);
        EmailLabel.setText("Email:");
        EmailLabel.setFont(font);
        EmailLabel.setForeground(foreground);

        EmailTextField.setBounds(300, 370, 550, 35);
        EmailTextField.setHorizontalAlignment(JLabel.CENTER);
        EmailTextField.setFont(font);
        EmailTextField.setForeground(foreground);
        EmailTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        EmailTextField.setBackground(background);
        EmailTextField.setEditable(false);

        clientdescriptionpane.setBounds(100,450,400,200);
        clientdescriptionpane.setBorder(new TitledBorder(new EtchedBorder(), "[Client Description]"));
        clientdescriptionarea.setLineWrap(true);
        clientdescriptionpane.getViewport().add(clientdescriptionarea);
        clientdescriptionpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);



        BackButton.setBounds(0, 800, 150, 50);
        BackButton.setText("Back");
        BackButton.setFont(font);
        BackButton.setBackground(background);
        BackButton.setForeground(foreground);
        BackButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        BackButton.setFocusable(false);

        BackButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                BackButton.setBackground(foreground);
                BackButton.setForeground(background);
                BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                BackButton.setBackground(background);
                BackButton.setForeground(foreground);
                BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {

                if(e.getSource()==BackButton)
                {

                    clientframe.dispose();
                    new MainMenu(clientframe.getContentPane().getBackground(), clientframe.getContentPane().getForeground(),font);
                }
            }
        });


        DisplayTable();



    }

    void AddDataToProductTableFromDatabase()
    {
        String mainFolderPath = "client";

        File mainFolder = new File(mainFolderPath);
        if (mainFolder.exists() && mainFolder.isDirectory()) {
            File[] subfolders = mainFolder.listFiles();
            if (subfolders != null) {
                String[] data = new String[12];
                for (File subfolder : subfolders) {
                    if (subfolder.isDirectory()) {
                        File[] textFiles = subfolder.listFiles(new FilenameFilter() {
                            @Override
                            public boolean accept(File dir, String name) {
                                return name.toLowerCase().endsWith(".txt");
                            }
                        });
                        if (textFiles != null) {

                            int j=0;
                            for (File textFile : textFiles) {
                                try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
                                    String line;

                                    while ((line = reader.readLine()) != null) {
                                        // Process the content of the text document
                                        data[j]=line;
                                        j++;
                                    }

                                }
                                catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }


                            model.addRow(data);




                        }
                    }
                }

            }
        }
    }


    void DisplayTable()
    {


        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Table.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment( SwingConstants.CENTER );

        String[] ColumnNames={"Address","Contact No","Email","Landline","Name","Other"};


        Table.setBackground(background);
        Table.setForeground(foreground);
        Table.getTableHeader().setBackground(foreground);
        Table.getTableHeader().setForeground(background);
        Table.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,20));
        Table.setBorder(BorderFactory.createLineBorder(foreground));
        Table.setGridColor(foreground);
        Table.setSelectionBackground(foreground);
        Table.setSelectionForeground(background);
        Table.setDefaultEditor(Object.class,null);





        Scroll=new JScrollPane();
        Scroll.setViewportView(Table);
        Scroll.setBounds(900,50,800,650);
        Scroll.getViewport().setBackground(background);
        Scroll.setBorder(BorderFactory.createLineBorder(foreground));


        Scroll.setOpaque(true);

        model=(DefaultTableModel)Table.getModel();
        model.setColumnIdentifiers(ColumnNames);

        String mainFolderPath = "client";

        File mainFolder = new File(mainFolderPath);
        if (mainFolder.exists() && mainFolder.isDirectory()) {
            File[] subfolders = mainFolder.listFiles();
            if (subfolders != null) {
                String[] data = new String[10];
                for (File subfolder : subfolders) {
                    if (subfolder.isDirectory()) {
                        File[] textFiles = subfolder.listFiles(new FilenameFilter() {
                            @Override
                            public boolean accept(File dir, String name) {
                                return name.toLowerCase().endsWith(".txt");
                            }
                        });
                        if (textFiles != null) {

                            int j=0;
                            for (File textFile : textFiles) {
                                try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
                                    String line;

                                    while ((line = reader.readLine()) != null) {
                                        // Process the content of the text document
                                        data[j]=line;
                                        j++;
                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            model.addRow(data);


                        }
                    }
                }

            }
        }


        Table.getSelectionModel().addListSelectionListener(event -> {
            int i = Table.getSelectedRow();
            NameTextField.setText(model.getValueAt(i,0).toString());
            AddressTextfield.setText(model.getValueAt(i,1).toString());
            ContactNoTextfield.setText(model.getValueAt(i,2).toString());
            LandlineTextfield.setText(model.getValueAt(i,3).toString());
            EmailTextField.setText(model.getValueAt(i,4).toString());
            clientdescriptionarea.setText(model.getValueAt(i,5).toString());
        });




    }



}
