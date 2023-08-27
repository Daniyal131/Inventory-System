
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class TransactionDetail {

    boolean flag = false;



    Color background;
    Color foreground;

    JFrame Transactionframe = new JFrame();

    JLabel QuantityLabel = new JLabel();


    JLabel ProductNameLabel = new JLabel();

    JLabel CostLabel = new JLabel();

    JLabel PriceLabel = new JLabel();

    JLabel SerialLabel = new JLabel();

    JLabel AccountHolder = new JLabel();

    JLabel SearchProductLabel = new JLabel();

    JLabel ModelLabel = new JLabel();
    JLabel BrandLabel = new JLabel();
    JLabel CategoryLabel = new JLabel();

    JLabel TransactionDTLabel = new JLabel();
    JLabel ShipmentDTLabel = new JLabel();
    JLabel AmountLabel = new JLabel();
    JLabel DiscountLabel = new JLabel();

    JTextField TransactionDTField = new JTextField();
    JTextField ShipmentDTField = new JTextField();
    JTextField AmountField = new JTextField();
    JTextField DiscountField = new JTextField();

    JTextField ModelField = new JTextField();
    JTextField BrandField = new JTextField();
    JTextField CategoryField = new JTextField();

    JPanel ImagePanel = new JPanel();
    JLabel Imagelabel = new JLabel();

    JTextField searchPrductDetailfield = new JTextField();


    JTextField ProductNamefield = new JTextField();

    JTextField QuantityField = new JTextField();


    JTextField CostField = new JTextField();

    JTextField PriceField = new JTextField();

    JTextField SerialField = new JTextField();

    JLabel BarcodeLabel = new JLabel();
    JTextField BarcodeField = new JTextField();

    JButton AddButton = new JButton();
    JButton PrintBillButton = new JButton();



    JButton BackButton = new JButton();



    JTable MainTable = new JTable();

    DefaultTableModel Mainmodel =new DefaultTableModel();

    JScrollPane MainScroll;

    JTable CartTable = new JTable();

    DefaultTableModel Cartmodel =new DefaultTableModel();

    JScrollPane Cartscroll;







    public TransactionDetail(Color Dark, Color textcolor, Font font)
    {


        ThemeCheck(Dark,textcolor,font);

        Transactionframe.add(QuantityField);
        Transactionframe.add(QuantityLabel);
        Transactionframe.add(AccountHolder);
        Transactionframe.add(ProductNameLabel);
        Transactionframe.add(ProductNamefield);
        Transactionframe.add(BackButton);
        Transactionframe.add(CostLabel);
        Transactionframe.add(PriceLabel);
        Transactionframe.add(SerialLabel);
        Transactionframe.add(CostField);
        Transactionframe.add(PriceField);
        Transactionframe.add(SerialField);
        Transactionframe.add(searchPrductDetailfield);
        Transactionframe.add(SearchProductLabel);
        Transactionframe.add(MainScroll);
        Transactionframe.add(Cartscroll);
        Transactionframe.add(ModelLabel);
        Transactionframe.add(ModelField);
        Transactionframe.add(BrandLabel);
        Transactionframe.add(BrandField);
        Transactionframe.add(CategoryLabel);
        Transactionframe.add(CategoryField);
        Transactionframe.add(ImagePanel);
        Transactionframe.add(TransactionDTLabel);
        Transactionframe.add(TransactionDTField);
        Transactionframe.add(ShipmentDTLabel);
        Transactionframe.add(ShipmentDTField);
        Transactionframe.add(AmountLabel);
        Transactionframe.add(AmountField);
        Transactionframe.add(DiscountLabel);
        Transactionframe.add(DiscountField);
        Transactionframe.add(BarcodeLabel);
        Transactionframe.add(BarcodeField);
        Transactionframe.add(AddButton);
        Transactionframe.add(PrintBillButton);

        Transactionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Transactionframe.setSize(1800,900);
        Transactionframe.setLayout(null);
        Transactionframe.setTitle("Transaction Detail Panel");
        Transactionframe.setResizable(false);
        Transactionframe.setLocationRelativeTo(null);
        Transactionframe.setVisible(true);






    }



    void ThemeCheck(Color Dark,Color textcolor,Font font)
    {

        background=Dark;
        foreground=textcolor;

        DisplayTransactionDetail(font);

    }


    void DisplayTransactionDetail(Font font)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar cal = Calendar.getInstance();
        String time = sdf.format(cal.getTime());
        String date = sdf2.format(cal.getTime());
        String fororder = date+" " +time;
        System.out.println(fororder);

        Transactionframe.getContentPane().setBackground(background);
        Transactionframe.getContentPane().setForeground(foreground);

        SearchProductLabel.setBounds(650, 10, 230, 35);
        SearchProductLabel.setText("Search Product:");
        SearchProductLabel.setFont(font);
        SearchProductLabel.setForeground(foreground);

        searchPrductDetailfield.setBounds(800,10,950,30);
        searchPrductDetailfield.setHorizontalAlignment(JLabel.CENTER);
        searchPrductDetailfield.setFont(font);
        searchPrductDetailfield.setForeground(foreground);
        searchPrductDetailfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        searchPrductDetailfield.setBackground(background);
        searchPrductDetailfield.setEditable(true);

        searchPrductDetailfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    System.out.println(searchPrductDetailfield.getText());
                    int rowCount =  Mainmodel.getRowCount();

                    for(int tabletrav = rowCount-1;tabletrav>=0;tabletrav--)
                    {
                        Mainmodel.removeRow(tabletrav);
                    }
                    String mainFolderPath = "product";

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
                                        for(int trav=0;trav<12;trav++)
                                        {

                                            if((data[trav].startsWith(searchPrductDetailfield.getText())) && !(searchPrductDetailfield.getText().equals("")))
                                            {
                                                Mainmodel.addRow(data);
                                                break;
                                            }
                                        }




                                    }
                                }
                            }

                        }
                    }
                    if(searchPrductDetailfield.getText().equals(""))
                    {
                        AddDataToProductTableFromDatabase();
                    }
                }

            }
        });


        BarcodeLabel.setBounds(100, 10, 230, 35);
        BarcodeLabel.setText("Barcode:");
        BarcodeLabel.setFont(font);
        BarcodeLabel.setForeground(foreground);

        BarcodeField.setBounds(300, 10, 300, 35);
        BarcodeField.setHorizontalAlignment(JLabel.CENTER);
        BarcodeField.setFont(font);
        BarcodeField.setForeground(foreground);
        BarcodeField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        BarcodeField.setBackground(background);


        ProductNameLabel.setBounds(100, 80, 230, 35);
        ProductNameLabel.setText("Product Name:");
        ProductNameLabel.setFont(font);
        ProductNameLabel.setForeground(foreground);

        ProductNamefield.setBounds(300, 80, 300, 35);
        ProductNamefield.setHorizontalAlignment(JLabel.CENTER);
        ProductNamefield.setFont(font);
        ProductNamefield.setForeground(foreground);
        ProductNamefield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        ProductNamefield.setBackground(background);
        ProductNamefield.setEditable(false);



        PriceLabel.setBounds(100, 150, 230, 35);
        PriceLabel.setText("Price:");
        PriceLabel.setFont(font);
        PriceLabel.setForeground(foreground);


        PriceField.setBounds(300, 150, 300, 35);
        PriceField.setHorizontalAlignment(JLabel.CENTER);
        PriceField.setFont(font);
        PriceField.setForeground(foreground);
        PriceField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        PriceField.setBackground(background);
        PriceField.setEditable(false);


        CostLabel.setBounds(100, 290, 230, 35);
        CostLabel.setText("Total Price:");
        CostLabel.setFont(font);
        CostLabel.setForeground(foreground);

        CostField.setBounds(300, 290, 300, 35);
        CostField.setHorizontalAlignment(JLabel.CENTER);
        CostField.setFont(font);
        CostField.setForeground(foreground);
        CostField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        CostField.setBackground(background);
        CostField.setEditable(false);



        QuantityLabel.setBounds(100, 220, 230, 35);
        QuantityLabel.setText("Quantity:");
        QuantityLabel.setFont(font);
        QuantityLabel.setForeground(foreground);


        QuantityField.setBounds(300, 220, 300, 35);
        QuantityField.setHorizontalAlignment(JLabel.CENTER);
        QuantityField.setFont(font);
        QuantityField.setForeground(foreground);
        QuantityField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        QuantityField.setBackground(background);
        QuantityField.setEditable(false);

        QuantityField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String filepath = ProductNamefield.getText();
                try {
                    Scanner balance = new Scanner(new File("product/"+filepath+"/quantity.txt"));
                    String inputting = balance.next();
                    int convertedBalance = Integer.parseInt(String.valueOf(inputting));
                    int abToHoJaoBhai = Integer.parseInt(QuantityField.getText());
                    System.out.println("original quantity " + convertedBalance);
                    System.out.println("inputed quantity"+ abToHoJaoBhai);
                    if(abToHoJaoBhai > convertedBalance)
                    {
                        String currentText = QuantityField.getText();
                        if (currentText.length() > 0) {
                            QuantityField.setText(currentText.substring(0, currentText.length() - 1));
                        }
                    }

                } catch (Exception E) {
                    System.out.println("Account Doesn't Exist");
                }

                if(QuantityField.getText().equals(""))
                {
                    CostField.setText("");
                    return;
                }
                int result = Integer.parseInt(QuantityField.getText())*Integer.parseInt(PriceField.getText());
                String todisplay = String.valueOf(result);
                CostField.setText(todisplay);
            }
        });



        AddButton.setBounds(100, 370, 200, 50);
        AddButton.setText("Add To Cart");
        AddButton.setFont(font);
        AddButton.setBackground(background);
        AddButton.setForeground(foreground);
        AddButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        AddButton.setFocusable(false);

        AddButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                AddButton.setBackground(foreground);
                AddButton.setForeground(background);
                AddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                AddButton.setBackground(background);
                AddButton.setForeground(foreground);
                AddButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {
                String[] Data = {BarcodeField.getText(),CostField.getText(),ProductNamefield.getText(),PriceField.getText(),QuantityField.getText()};
            Cartmodel.addRow(Data);

                flag = true;

                if(
                        BarcodeField.getText().equals("") ||
                        ProductNamefield.getText().equals("") ||
                        CostField.getText().equals("") ||
                        PriceField.getText().equals("") ||
                        QuantityField.getText().equals("")

                )
                {
                    JOptionPane.showMessageDialog(Transactionframe, "Enter Complete Information", "Incomplete Information error!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                String[] data = {
                        BarcodeField.getText(),
                        ProductNamefield.getText(),
                        CostField.getText(),
                        PriceField.getText(),
                        QuantityField.getText()
                };


                File folder = new File("order/"+fororder);
                if (!folder.exists()) {
                    if (folder.mkdir()) {
                    } else {
                        System.out.println("Error Adding Client.");
                    }
                }

                BufferedWriter Barcode = null;
                BufferedWriter Model = null;
                BufferedWriter quantity = null;
                BufferedWriter SerialNumber = null;
                BufferedWriter cost = null;
                FileWriter price = null;
                FileWriter name = null;



                try {



                    Barcode = new BufferedWriter(new FileWriter("order/"+fororder + "/barcode.txt",true));
                    Barcode.write(data[0]);
                    Barcode.newLine();
                    Barcode.close();

                    SerialNumber = new BufferedWriter(new FileWriter("order/"+fororder+ "/productname.txt",true));
                    SerialNumber.write(data[1]);
                    SerialNumber.newLine();
                    SerialNumber.close();

                    Model = new BufferedWriter(new FileWriter("order/"+fororder + "/cost.txt",true));
                    Model.write(data[2]);
                    Model.newLine();
                    Model.close();

                    quantity = new BufferedWriter(new FileWriter("order/"+fororder+ "/price.txt",true));
                    quantity.write(data[3]);
                    quantity.newLine();
                    quantity.close();

                    cost = new BufferedWriter(new FileWriter("order/"+fororder + "/quantity.txt",true));
                    cost.write(data[4]);
                    cost.newLine();
                    cost.close();

                    QuantityField.setEditable(false);



                    System.out.println("Added");

                } catch (IOException ex) {

                }

                        Imagelabel.setIcon(null);
                        ImagePanel.removeAll();
                     ImagePanel.repaint();

                         BarcodeField.setText("");
                        ProductNamefield.setText("");
                        CostField.setText("");
                        PriceField.setText("");
                        QuantityField.setText("");


            }
        });


        PrintBillButton.setBounds(400, 370, 200, 50);
        PrintBillButton.setText("Generate Bill");
        PrintBillButton.setFont(font);
        PrintBillButton.setBackground(background);
        PrintBillButton.setForeground(foreground);
        PrintBillButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        PrintBillButton.setFocusable(false);

        PrintBillButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                PrintBillButton.setBackground(foreground);
                PrintBillButton.setForeground(background);
                PrintBillButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                PrintBillButton.setBackground(background);
                PrintBillButton.setForeground(foreground);
                PrintBillButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {


                if(BarcodeField.getText().equals("") && flag == false)
                {
                    JOptionPane.showMessageDialog(Transactionframe, "Cart is empty and incomplete information ", "Incomplete Information error!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                if (!(BarcodeField.getText().equals("") && CostField.getText().equals("")) )
                {
                    String[] data = {
                            BarcodeField.getText(),
                            ProductNamefield.getText(),
                            CostField.getText(),
                            PriceField.getText(),
                            QuantityField.getText()
                    };

                    File folder = new File("order/"+fororder);
                    if (!folder.exists()) {
                        if (folder.mkdir()) {
                        } else {
                            System.out.println("Error Adding Client.");
                        }
                    }

                    BufferedWriter Barcode = null;
                    BufferedWriter Model = null;
                    BufferedWriter quantity = null;
                    BufferedWriter SerialNumber = null;
                    BufferedWriter cost = null;
                    FileWriter price = null;
                    FileWriter name = null;



                    try {

                        Barcode = new BufferedWriter(new FileWriter("order/"+fororder + "/barcode.txt",true));
                        Barcode.write(data[0]);
                        Barcode.newLine();
                        Barcode.close();

                        SerialNumber = new BufferedWriter(new FileWriter("order/"+fororder+ "/productname.txt",true));
                        SerialNumber.write(data[1]);
                        SerialNumber.newLine();
                        SerialNumber.close();

                        Model = new BufferedWriter(new FileWriter("order/"+fororder + "/cost.txt",true));
                        Model.write(data[2]);
                        Model.newLine();
                        Model.close();

                        quantity = new BufferedWriter(new FileWriter("order/"+fororder+ "/price.txt",true));
                        quantity.write(data[3]);
                        quantity.newLine();
                        quantity.close();

                        cost = new BufferedWriter(new FileWriter("order/"+fororder + "/quantity.txt",true));
                        cost.write(data[4]);
                        cost.newLine();
                        cost.close();



                        System.out.println("Added");

                    } catch (IOException ex) {

                    }
                }
                if ((!(BarcodeField.getText().equals(""))) && CostField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(Transactionframe, "Please provide valid information ", "Incomplete Information error!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                Transactionframe.dispose();
                new GenerateBill(Transactionframe.getContentPane().getBackground(), Transactionframe.getContentPane().getForeground(),font , fororder);




            }
        });




        ImagePanel.setBounds(150,450,350,350);
        ImagePanel.setBorder(new TitledBorder(new EtchedBorder(), "[Image]"));






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

                    Transactionframe.dispose();
                    new MainMenu(Transactionframe.getContentPane().getBackground(), Transactionframe.getContentPane().getForeground(),font);
                }
            }
        });







        DisplayTable();



    }


    void AddDataToProductTableFromDatabase()
    {
        String mainFolderPath = "product";

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


                            Mainmodel.addRow(data);




                        }
                    }
                }

            }
        }
    }

    void DisplayTable()
    {


        DefaultTableCellRenderer Mainrenderer = (DefaultTableCellRenderer) MainTable.getDefaultRenderer(Object.class);
        Mainrenderer.setHorizontalAlignment( SwingConstants.CENTER );

        DefaultTableCellRenderer Cartrenderer = (DefaultTableCellRenderer) CartTable.getDefaultRenderer(Object.class);
        Cartrenderer.setHorizontalAlignment( SwingConstants.CENTER );

        String[] MainColumnNames={"Barcode","Brand","Category","Cost","Description","Model","Name","Price","Quantity","Remarks","Serial","Tested"};
        String[] CartColumnNames={"Barcode","Total Price","Name","Cost","Quantity"};




        MainTable.setBackground(background);
        MainTable.setForeground(foreground);
        MainTable.getTableHeader().setBackground(foreground);
        MainTable.getTableHeader().setForeground(background);
        MainTable.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,20));
        MainTable.setBorder(BorderFactory.createLineBorder(foreground));
        MainTable.setGridColor(foreground);
        MainTable.setSelectionBackground(foreground);
        MainTable.setSelectionForeground(background);
        MainTable.setDefaultEditor(Object.class,null);

        MainScroll =new JScrollPane();
        MainScroll.setViewportView(MainTable);
        MainScroll.setBounds(650,50,1100,380);
        MainScroll.getViewport().setBackground(background);
        MainScroll.setBorder(new TitledBorder(new EtchedBorder(), "Main Table"));

        MainScroll.setOpaque(true);
        Mainmodel =(DefaultTableModel) MainTable.getModel();
        Mainmodel.setColumnIdentifiers(MainColumnNames);


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
                            Mainmodel.addRow(maindata);


                        }
                    }
                }

            }
        }


        CartTable.setBackground(background);
        CartTable.setForeground(foreground);
        CartTable.getTableHeader().setBackground(foreground);
        CartTable.getTableHeader().setForeground(background);
        CartTable.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,20));
        CartTable.setBorder(BorderFactory.createLineBorder(foreground));
        CartTable.setGridColor(foreground);
        CartTable.setSelectionBackground(foreground);
        CartTable.setSelectionForeground(background);
        CartTable.setDefaultEditor(Object.class,null);

        Cartscroll =new JScrollPane();
        Cartscroll.setViewportView(CartTable);
        Cartscroll.setBounds(650,450,1100,380);
        Cartscroll.getViewport().setBackground(background);
        Cartscroll.setBorder(new TitledBorder(new EtchedBorder(), "Cart Table"));


        Cartscroll.setOpaque(true);
        Cartmodel =(DefaultTableModel) CartTable.getModel();
        Cartmodel.setColumnIdentifiers(CartColumnNames);





        MainTable.getSelectionModel().addListSelectionListener(event -> {



            QuantityField.requestFocus();
            ImagePanel.removeAll();
            ImagePanel.repaint();
            QuantityField.setEditable(true);
            QuantityField.setText("");
            CostField.setText("");

            int i = MainTable.getSelectedRow();
            ProductNamefield.setText(Mainmodel.getValueAt(i,6).toString());
            PriceField.setText(Mainmodel.getValueAt(i,7).toString());
            BarcodeField.setText(Mainmodel.getValueAt(i,0).toString());

            String filepath = Mainmodel.getValueAt(i,6).toString();


            try {
                // Load the image

                BufferedImage originalImage = ImageIO.read(new File("product/"+filepath+"/logo.png"));
                Dimension panelSize = ImagePanel.getSize();
                Image scaledImage = originalImage.getScaledInstance(panelSize.width, panelSize.height, Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(scaledImage);

                Imagelabel.setIcon(imageIcon);
                ImagePanel.add(Imagelabel);
                ImagePanel.revalidate();
                Imagelabel.revalidate();

            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }


        });




    }



}
