import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class Dashboard {

    int totalcostfieldvalue = 0;
    int totalcost = 0;
    Color background;
    Color foreground;
    JFrame DashboardFrame = new JFrame();
    JButton BackButton = new JButton();


    JTextField SearchField = new JTextField();
    JTextField TotalCostField = new JTextField();
    JTextField realTotalCostField = new JTextField();
    JTextField TotalProfitField = new JTextField();

    JLabel SearchLabel = new JLabel();
    JLabel TotalCostLabel = new JLabel();
    JLabel realTotalCostLabel = new JLabel();
    JLabel TotalProfitLabel = new JLabel();

    JTable ProductTable = new JTable();
    DefaultTableModel Productmodel;

    JScrollPane ProductScroll;

    JTable ClientTable = new JTable();

    DefaultTableModel Clientmodel;

    JScrollPane Clientscroll;

    JTable TransactionTable = new JTable();

    DefaultTableModel Transactionmodel;

    JScrollPane Transactionscroll;
    int counter=0;

    Dashboard(Color Dark, Color textcolor, Font font) {


        ThemeCheck(Dark,textcolor,font);

        DashboardFrame.getContentPane().setForeground(foreground);
        DashboardFrame.getContentPane().setBackground(background);

        DashboardFrame.add(BackButton);
        DashboardFrame.add(ProductScroll);
        DashboardFrame.add(Clientscroll);
        DashboardFrame.add(Transactionscroll);
        DashboardFrame.add(SearchField);
        DashboardFrame.add(SearchLabel);
        DashboardFrame.add(TotalCostField);
        DashboardFrame.add(TotalCostLabel);
        DashboardFrame.add(realTotalCostField);
        DashboardFrame.add(realTotalCostLabel);
        DashboardFrame.add(TotalProfitField);
        DashboardFrame.add(TotalProfitLabel);


        DashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DashboardFrame.setSize(1800,900);
        DashboardFrame.setLayout(null);
        DashboardFrame.setTitle("Dashboard");
        DashboardFrame.setResizable(false);
        DashboardFrame.setLocationRelativeTo(null);
        DashboardFrame.setVisible(true);







    }

    void ThemeCheck(Color Dark,Color textcolor,Font font)
    {

        background=Dark;
        foreground=textcolor;

        DisplayDashboardDetail(font);

    }

    void DisplayDashboardDetail(Font font)
    {
        SearchLabel.setBounds(50, 360, 230, 35);
        SearchLabel.setText("Search Transaction:");
        SearchLabel.setFont(font);
        SearchLabel.setForeground(foreground);

        TotalCostLabel.setBounds(50, 50, 230, 35);
        TotalCostLabel.setText("Total Price:");
        TotalCostLabel.setFont(font);
        TotalCostLabel.setForeground(foreground);

        realTotalCostLabel.setBounds(50, 150, 230, 35);
        realTotalCostLabel.setText("Total Cost:");
        realTotalCostLabel.setFont(font);
        realTotalCostLabel.setForeground(foreground);

        TotalProfitLabel.setBounds(50, 250, 230, 35);
        TotalProfitLabel.setText("Total Profit:");
        TotalProfitLabel.setFont(font);
        TotalProfitLabel.setForeground(foreground);

        SearchField.setBounds(250,360,650,30);
        SearchField.setHorizontalAlignment(JLabel.CENTER);
        SearchField.setFont(font);
        SearchField.setForeground(foreground);
        SearchField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        SearchField.setBackground(background);
        SearchField.setEditable(true);

        TotalCostField.setBounds(250,50,650,30);
        TotalCostField.setHorizontalAlignment(JLabel.CENTER);
        TotalCostField.setFont(font);
        TotalCostField.setForeground(foreground);
        TotalCostField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        TotalCostField.setBackground(background);
        TotalCostField.setEditable(false);

        realTotalCostField.setBounds(250,150,650,30);
        realTotalCostField.setHorizontalAlignment(JLabel.CENTER);
        realTotalCostField.setFont(font);
        realTotalCostField.setForeground(foreground);
        realTotalCostField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        realTotalCostField.setBackground(background);
        realTotalCostField.setEditable(false);

        TotalProfitField.setBounds(250,250,650,30);
        TotalProfitField.setHorizontalAlignment(JLabel.CENTER);
        TotalProfitField.setFont(font);
        TotalProfitField.setForeground(foreground);
        TotalProfitField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        TotalProfitField.setBackground(background);
        TotalProfitField.setEditable(false);


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

                    DashboardFrame.dispose();
                    new MainMenu(DashboardFrame.getContentPane().getBackground(), DashboardFrame.getContentPane().getForeground(),font);
                }
            }
        });
        DisplayTable();
    }

    void DisplayTable()
    {

        DefaultTableCellRenderer Mainrenderer = (DefaultTableCellRenderer) ProductTable.getDefaultRenderer(Object.class);
        Mainrenderer.setHorizontalAlignment( SwingConstants.CENTER );

        DefaultTableCellRenderer Cartrenderer = (DefaultTableCellRenderer) ClientTable.getDefaultRenderer(Object.class);
        Cartrenderer.setHorizontalAlignment( SwingConstants.CENTER );

        String[] MainColumnNames={"Barcode","Brand","Category","Cost","Description","Model","Name","Price","Quantity","Remarks","Serial","Tested"};
        String[] CartColumnNames={"Address","Contact No","Email","Landline","Name","Other"};
        String[] TransactionColumnNames={"Order No","Client Name","Total Price","Date/Time","Total Cost"};





        ProductTable.setBackground(background);
        ProductTable.setForeground(foreground);
        ProductTable.getTableHeader().setBackground(foreground);
        ProductTable.getTableHeader().setForeground(background);
        ProductTable.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,20));
        ProductTable.setBorder(BorderFactory.createLineBorder(foreground));
        ProductTable.setGridColor(foreground);
        ProductTable.setSelectionBackground(foreground);
        ProductTable.setSelectionForeground(background);
        ProductTable.setDefaultEditor(Object.class,null);

        ProductScroll =new JScrollPane();
        ProductScroll.setViewportView(ProductTable);
        ProductScroll.setBounds(910,10,850,380);
        ProductScroll.getViewport().setBackground(background);
        ProductScroll.setBorder(new TitledBorder(new EtchedBorder(), "Product Table"));

        ProductScroll.setOpaque(true);
        Productmodel =(DefaultTableModel) ProductTable.getModel();
        Productmodel.setColumnIdentifiers(MainColumnNames);

        ProductTable.setEnabled(false);


        String mainFolderPath = "product";

        File mainFolder = new File(mainFolderPath);
        if (mainFolder.exists() && mainFolder.isDirectory()) {
            File[] subfolders = mainFolder.listFiles();
            if (subfolders != null) {
                String[] maindata = new String[12];
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
                                        maindata[j]=line;
                                        j++;
                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            Productmodel.addRow(maindata);


                        }
                    }
                }

            }
        }





        ClientTable.setBackground(background);
        ClientTable.setForeground(foreground);
        ClientTable.getTableHeader().setBackground(foreground);
        ClientTable.getTableHeader().setForeground(background);
        ClientTable.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,20));
        ClientTable.setBorder(BorderFactory.createLineBorder(foreground));
        ClientTable.setGridColor(foreground);
        ClientTable.setSelectionBackground(foreground);
        ClientTable.setSelectionForeground(background);
        ClientTable.setDefaultEditor(Object.class,null);

        Clientscroll =new JScrollPane();
        Clientscroll.setViewportView(ClientTable);
        Clientscroll.setBounds(910,410,850,380);
        Clientscroll.getViewport().setBackground(background);
        Clientscroll.setBorder(new TitledBorder(new EtchedBorder(), "Client Table"));


        Clientscroll.setOpaque(true);
        Clientmodel =(DefaultTableModel) ClientTable.getModel();
        Clientmodel.setColumnIdentifiers(CartColumnNames);

        ClientTable.setEnabled(false);


        String ClientFolderPath = "client";

        File clientFolder = new File(ClientFolderPath);
        if (clientFolder.exists() && clientFolder.isDirectory()) {
            File[] subfolders = clientFolder.listFiles();
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
                            Clientmodel.addRow(data);


                        }
                    }
                }

            }
        }



        TransactionTable.setBackground(background);
        TransactionTable.setForeground(foreground);
        TransactionTable.getTableHeader().setBackground(foreground);
        TransactionTable.getTableHeader().setForeground(background);
        TransactionTable.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,20));
        TransactionTable.setBorder(BorderFactory.createLineBorder(foreground));
        TransactionTable.setGridColor(foreground);
        TransactionTable.setSelectionBackground(foreground);
        TransactionTable.setSelectionForeground(background);
        TransactionTable.setDefaultEditor(Object.class,null);

        Transactionscroll =new JScrollPane();
        Transactionscroll.setViewportView(TransactionTable);
        Transactionscroll.setBounds(50,410,850,380);
        Transactionscroll.getViewport().setBackground(background);
        Transactionscroll.setBorder(new TitledBorder(new EtchedBorder(), "Transaction Table"));


        Transactionscroll.setOpaque(true);
        Transactionmodel =(DefaultTableModel) TransactionTable.getModel();
        Transactionmodel.setColumnIdentifiers(TransactionColumnNames);

        TransactionTable.setEnabled(false);





        String TransactionFolderPath = "order";
        File TransactionFolder = new File(TransactionFolderPath);
        if (TransactionFolder.exists() && TransactionFolder.isDirectory()) {
            File[] subfolders = TransactionFolder.listFiles();
            if (subfolders != null) {
                counter=0;
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

                            String[] data = new String[10];
                            String[] datatobesent = new String[10];
                            for (File textFile : textFiles) {
                                try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
                                    String line = reader.readLine();
                                    if (line != null) {

                                        data[j] = line;
                                        j++;

                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }



                            for (int k=0;k<4;k++)
                            {

                                datatobesent[k+1] = data[k+1];
                            }
                            counter++;
                            datatobesent[0]=String.valueOf(counter);
                            totalcostfieldvalue = totalcostfieldvalue + Integer.parseInt(datatobesent[2]);
                            totalcost = totalcost + Integer.parseInt(datatobesent[4]);
                            Transactionmodel.addRow(datatobesent);
                        }
                    }

                }
                TotalCostField.setText(String.valueOf(totalcostfieldvalue));
                realTotalCostField.setText(String.valueOf(totalcost));
                TotalProfitField.setText(String.valueOf(Integer.parseInt(TotalCostField.getText()) - Integer.parseInt(realTotalCostField.getText())));
            }
        }



    }


}
