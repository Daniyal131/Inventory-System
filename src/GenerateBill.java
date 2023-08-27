import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

public class GenerateBill {

    int totalPrice = 0;
    Color background;
    Color foreground;
    JFrame GeneratebillFrame = new JFrame();
    JButton BackButton = new JButton();
    JButton ConfirmButton = new JButton();

    JLabel SearchClientLabel = new JLabel();
    JTextField searchClientDetailfield = new JTextField();
    JTable Table = new JTable();

    DefaultTableModel model=new DefaultTableModel();

    JLabel  AddressLabel= new JLabel();
    JLabel ClientNameLabel = new JLabel();
    JLabel  EmailLabel= new JLabel();
    JLabel Discount = new JLabel();
    JLabel amount = new JLabel();
    JTextField amountField = new JTextField();
    JTextField DiscountTextFiled = new JTextField();

    JTextField  AddressTextfield= new JTextField();
    JTextField ClientNameField = new JTextField();
    JTextField  EmailTextField= new JTextField();

    JScrollPane Scroll;

    String orderDetail;



    GenerateBill(Color Dark, Color textcolor,Font font, String orderdetail)
    {
        this.orderDetail = orderdetail;

        ThemeCheck(Dark,textcolor,font);

        GeneratebillFrame.getContentPane().setBackground(background);
        GeneratebillFrame.getContentPane().setForeground(foreground);

        GeneratebillFrame.add(BackButton);
        GeneratebillFrame.add(ConfirmButton);
        GeneratebillFrame.add(searchClientDetailfield);
        GeneratebillFrame.add(SearchClientLabel);
        GeneratebillFrame.add(Scroll);
        GeneratebillFrame.add(AddressLabel);
        GeneratebillFrame.add(ClientNameLabel);
        GeneratebillFrame.add(EmailLabel);
        GeneratebillFrame.add(AddressTextfield);
        GeneratebillFrame.add(ClientNameField);
        GeneratebillFrame.add(EmailTextField);
        GeneratebillFrame.add(Discount);
        GeneratebillFrame.add(DiscountTextFiled);
        GeneratebillFrame.add(amount);
        GeneratebillFrame.add(amountField);



        GeneratebillFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GeneratebillFrame.setSize(1800,900);
        GeneratebillFrame.setLayout(null);
        GeneratebillFrame.setTitle("Generate Bill");
        GeneratebillFrame.setResizable(false);
        GeneratebillFrame.setLocationRelativeTo(null);
        GeneratebillFrame.setVisible(true);




    }

    void ThemeCheck(Color Dark,Color textcolor,Font font)
    {

        background=Dark;
        foreground=textcolor;

        DisplayTransactionDetail(font);

    }

    void DisplayTransactionDetail(Font font)
    {
        SearchClientLabel.setBounds(900, 10, 230, 35);
        SearchClientLabel.setText("Search Client:");
        SearchClientLabel.setFont(font);
        SearchClientLabel.setForeground(foreground);

        searchClientDetailfield.setBounds(1030, 10, 670, 35);
        searchClientDetailfield.setHorizontalAlignment(JLabel.CENTER);
        searchClientDetailfield.setFont(font);
        searchClientDetailfield.setForeground(foreground);
        searchClientDetailfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        searchClientDetailfield.setBackground(background);
        searchClientDetailfield.setEditable(true);

        searchClientDetailfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

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

                                            if((data[trav].startsWith(searchClientDetailfield.getText())) && !(searchClientDetailfield.getText().equals("")))
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
                    if(searchClientDetailfield.getText().equals(""))
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

        ClientNameLabel.setBounds(100, 150, 230, 35);
        ClientNameLabel.setText("Client Name:");
        ClientNameLabel.setFont(font);
        ClientNameLabel.setForeground(foreground);

        ClientNameField.setBounds(300, 150, 300, 35);
        ClientNameField.setHorizontalAlignment(JLabel.CENTER);
        ClientNameField.setFont(font);
        ClientNameField.setForeground(foreground);
        ClientNameField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        ClientNameField.setBackground(background);
        ClientNameField.setEditable(false);

        EmailLabel.setBounds(100, 220, 230, 35);
        EmailLabel.setText("Email:");
        EmailLabel.setFont(font);
        EmailLabel.setForeground(foreground);

        EmailTextField.setBounds(300, 220, 550, 35);
        EmailTextField.setHorizontalAlignment(JLabel.CENTER);
        EmailTextField.setFont(font);
        EmailTextField.setForeground(foreground);
        EmailTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        EmailTextField.setBackground(background);
        EmailTextField.setEditable(false);

        amount.setBounds(100, 360, 230, 35);
        amount.setText("Total Amount:");
        amount.setFont(font);
        amount.setForeground(foreground);

        amountField.setBounds(300, 360, 550, 35);
        amountField.setHorizontalAlignment(JLabel.CENTER);
        amountField.setFont(font);
        amountField.setForeground(foreground);
        amountField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        amountField.setBackground(background);
        amountField.setEditable(false);

        String filePath = "order/"+orderDetail+"/cost.txt";
        int priceOfTheOrder = 0;

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line: " + line);
                priceOfTheOrder += Integer.parseInt(line);
            }


            scanner.close();
        } catch (FileNotFoundException E) {
            System.out.println("File not found: " + filePath);
        }
        amountField.setText(String.valueOf(priceOfTheOrder));




        Discount.setBounds(100, 290, 230, 35);
        Discount.setText("Discount:");
        Discount.setFont(font);
        Discount.setForeground(foreground);

        DiscountTextFiled.setBounds(300, 290, 550, 35);
        DiscountTextFiled.setHorizontalAlignment(JLabel.CENTER);
        DiscountTextFiled.setFont(font);
        DiscountTextFiled.setForeground(foreground);
        DiscountTextFiled.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        DiscountTextFiled.setBackground(background);
        DiscountTextFiled.setEditable(true);
        DiscountTextFiled.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) )) {
                    e.consume();
                }

                if(c == KeyEvent.VK_ENTER){
                    String filePath = "order/"+orderDetail+"/cost.txt";
                    int priceOfTheOrder = 0;

                    try {
                        File file = new File(filePath);
                        Scanner scanner = new Scanner(file);

                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println("Line: " + line);
                            priceOfTheOrder += Integer.parseInt(line);
                        }


                        scanner.close();
                    } catch (FileNotFoundException E) {
                        System.out.println("File not found: " + filePath);
                    }

                    double finalPriceOfTheOrderf = (double)priceOfTheOrder - ((double)Integer.parseInt(DiscountTextFiled.getText()));
                    amountField.setText(String.valueOf(finalPriceOfTheOrderf));

                }
            }


        });

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

                    GeneratebillFrame.dispose();
                    new TransactionDetail(GeneratebillFrame.getContentPane().getBackground(), GeneratebillFrame.getContentPane().getForeground(),font);
                }
            }
        });


        ConfirmButton.setBounds(1640, 800, 150, 50);
        ConfirmButton.setText("Confirm Order");
        ConfirmButton.setFont(font);
        ConfirmButton.setBackground(background);
        ConfirmButton.setForeground(foreground);
        ConfirmButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        ConfirmButton.setFocusable(false);

        ConfirmButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                ConfirmButton.setBackground(foreground);
                ConfirmButton.setForeground(background);
                ConfirmButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                ConfirmButton.setBackground(background);
                ConfirmButton.setForeground(foreground);
                ConfirmButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {
                if(ClientNameField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(GeneratebillFrame, "client name can't be empty", "client name field error!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String Connformationtoclient1 = "client/"+ClientNameField.getText()+"/order";

                File folder1 = new File(Connformationtoclient1);
                if (!folder1.exists()) {
                    if (folder1.mkdir()) {
                    } else {
                        System.out.println("Error Adding Client.");
                    }
                }

                String Connformationtoclient = "client/"+ClientNameField.getText()+"/order/"+orderDetail;

                File folder = new File(Connformationtoclient);
                if (!folder.exists()) {
                    if (folder.mkdir()) {
                    } else {
                        System.out.println("Error Adding Client.");
                    }
                }

                String[] Data =
                        {
                                ClientNameField.getText(),
                                AddressTextfield.getText(),
                                EmailTextField.getText(),
                                DiscountTextFiled.getText(),
                                amountField.getText(),

                         };

                if(Data[3].equals(""))
                {
                    Data[3]="no";
                }

                FileWriter SendingToClient = null;

                try {
                    SendingToClient = new FileWriter(Connformationtoclient+"/name.txt");
                    SendingToClient.write(Data[0]);
                    SendingToClient.close();

                    SendingToClient = new FileWriter(Connformationtoclient+"/address.txt");
                    SendingToClient.write(Data[1]);
                    SendingToClient.close();

                    SendingToClient = new FileWriter(Connformationtoclient+"/email.txt");
                    SendingToClient.write(Data[2]);
                    SendingToClient.close();

                    SendingToClient = new FileWriter(Connformationtoclient+"/discount.txt");
                    SendingToClient.write(Data[3]);
                    SendingToClient.close();

                    SendingToClient = new FileWriter(Connformationtoclient+"/amount.txt");
                    SendingToClient.write(Data[4]);
                    SendingToClient.close();
                }
                catch (Exception c)
                {
                    System.out.println("order client k paas nhi gya");
                }




                if(e.getSource()==ConfirmButton)
                {

                    String filePath = "order/"+orderDetail+"/quantity.txt";
                    String filePathPrice = "order/"+orderDetail+"/price.txt";
                    String filePathName = "order/"+orderDetail+"/productname.txt";
                    try {
                        File file = new File(filePath);
                        Scanner scanner = new Scanner(file);
                        File fileName = new File(filePathName);
                        Scanner scannerName = new Scanner(fileName);
                        File fileTotalPrice = new File(filePathPrice);
                        Scanner scannerTotalPrice = new Scanner(fileTotalPrice);
                        int lineCount = 0;
                        while (scanner.hasNextLine()) {
                            scanner.nextLine();
                            lineCount++;
                        }

                        int[] quantity = new int[lineCount];
                        String[] names = new String[lineCount];
                        int i = 0;
                        scanner = new Scanner(file);
                        while (scannerName.hasNextLine()) {
                            String line = scanner.nextLine();
                            String lineName = scannerName.nextLine();
                            String nameoftheproductforthefiletotakecostfromthat = "order/"+orderDetail+"/price.txt";
                            File forrealpriceoftheproductinwhichpurchasedfromthefactoryfile = new File("product/"+lineName+"/price.txt");
                            Scanner scannerforrealprice = new Scanner(forrealpriceoftheproductinwhichpurchasedfromthefactoryfile);
                            String scannedPrice = scannerforrealprice.nextLine();
                            totalPrice = totalPrice + (Integer.parseInt(scannedPrice) * Integer.parseInt(line));


                            names[i] = lineName;
                            quantity[i] = Integer.parseInt(line);
                            i++;

                        }
                        scanner.close();
                        scannerName.close();
                        scannerTotalPrice.close();

                        FileWriter TotalPriceSending = null;

                        try {
                            TotalPriceSending = new FileWriter("order/"+orderDetail+"/mate.txt");
                            TotalPriceSending.write(String.valueOf(totalPrice));
                            TotalPriceSending.close();
                        }catch(Exception TETE){

                        }

                        String[] ReadingQuantity = new String[quantity.length];
                        String[] SubtractedQuantity = new String[quantity.length];

                        for(i = 0 ; i < quantity.length ; i++){
                            ReadingQuantity[i]="product/"+names[i]+"/quantity.txt";
                            try {
                                File forquantity = new File(ReadingQuantity[i]);
                                Scanner in = new Scanner(forquantity);
                                SubtractedQuantity[i] = in.nextLine();
                                SubtractedQuantity[i] = String.valueOf(Integer.parseInt(SubtractedQuantity[i])-quantity[i]);

                            }
                            catch (Exception j)
                            {
                                System.out.println("quantity se khelne me phat gya");
                            }


                        }

                        for(i = 0 ; i < quantity.length ; i++) {

                            FileWriter Quantity = null;
                            try {

                                Quantity = new FileWriter("product/" + names[i] + "/quantity.txt");
                                Quantity.write(SubtractedQuantity[i]);
                                Quantity.close();

                            }
                            catch (Exception l)
                            {
                                System.out.println("quantity wapis nhi gai");
                            }

                        }


//                        String filePathForInitialQuantityOftheProductFromDataBase = "product/"+names[0]+"/quantity.txt";



                    } catch (FileNotFoundException E) {
                        System.out.println("File not found: " + filePath);
                    }

                    String rasta = "order/"+orderDetail;

                    FileWriter SendingRasta = null;

                    try {
                        SendingRasta = new FileWriter(rasta + "/date.txt");
                        SendingRasta.write(orderDetail);
                        SendingRasta.close();

                        SendingRasta = new FileWriter(rasta + "/clientname.txt");
                        SendingRasta.write(ClientNameField.getText());
                        SendingRasta.close();
                    }
                    catch (Exception el)
                    {
                        System.out.println("Rasta Nhi mil Rha");
                    }

                    GeneratebillFrame.dispose();
                    new MainMenu(GeneratebillFrame.getContentPane().getBackground(), GeneratebillFrame.getContentPane().getForeground(),font);
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
            AddressTextfield.setText(model.getValueAt(i,0).toString());
            EmailTextField.setText(model.getValueAt(i,2).toString());
            ClientNameField.setText(model.getValueAt(i,4).toString());
        });


        String filePathprice = "order/"+orderDetail+"/cost.txt";
        String filePathcost = "order/"+orderDetail+"/price.txt";
        int priceOfTheOrder = 0;
        int costOfTheOrder = 0;

        try {
            File fileprice = new File(filePathprice);
            Scanner scannerprice = new Scanner(fileprice);

            File filecost = new File(filePathcost);
            Scanner scannercost = new Scanner(filecost);

            while (scannerprice.hasNextLine()) {
                String lineprice = scannerprice.nextLine();
                System.out.println("Lineprice: " + lineprice);
                priceOfTheOrder += Integer.parseInt(lineprice);

                String linecost = scannercost.nextLine();
                System.out.println("Linecost: " + linecost);
                costOfTheOrder += Integer.parseInt(linecost);

            }

            FileWriter brand = null;
            try {

                brand = new FileWriter(filePathprice);
                brand.write(String.valueOf(priceOfTheOrder));
                brand.close();

                brand = new FileWriter(filePathcost);
                brand.write(String.valueOf(costOfTheOrder));
                brand.close();

            }catch (Exception b) {
                System.out.println("Total price nhi ja rhi database me");
            }

            scannerprice.close();
            scannercost.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " );
        }




        BufferedWriter Amount = null;
        String clientname = ClientNameField.getText();

        try {
            Amount = new BufferedWriter(new FileWriter("client/" + clientname + "/Amount.txt",true));
            Amount.write(priceOfTheOrder);
            Amount.newLine();
            Amount.close();
        }
        catch (Exception e)
        {
            System.out.println("file nhi bani");
        }




    }


}
