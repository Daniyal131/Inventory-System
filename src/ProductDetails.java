import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



public class ProductDetails {


        Color background;
        Color foreground;

        JFrame Productframe = new JFrame();


        JLabel SerialNoLabel = new JLabel();

        JLabel ProductNameLabel = new JLabel();

        JLabel ModelLabel = new JLabel();

        JLabel QuantityLabel = new JLabel();

        JLabel CostLabel = new JLabel();

        JLabel AccountHolder = new JLabel();

        JLabel BarcodeLabel = new JLabel();
        JLabel PriceLabel = new JLabel();


        JTextField BarcodeField = new JTextField();


        JTextField ProductNameField = new JTextField();

        JTextField SerialNoField = new JTextField();


        JTextField ModelField = new JTextField();

        JTextField QuantityField = new JTextField();

        JTextField CostField = new JTextField();
        JTextField PriceField = new JTextField();

        JTextField searchPrductDetailfield = new JTextField();


        JButton BackButton = new JButton();


        JTable Table = new JTable();

        JLabel SeachAccountLabel = new JLabel();

        DefaultTableModel model;

        JScrollPane Scroll;

        JPanel BrandPanel = new JPanel();
        JPanel CategoryPanel = new JPanel();
        JPanel panelPaintShade = new JPanel();

        JTextField BrandTextField = new JTextField();


        JTextField CategoryTextField = new JTextField();


        JPanel ImagePanel = new JPanel();

        JPanel RadioPanel = new JPanel();
    JRadioButton yesRadioButton = new JRadioButton("Yes");
    JRadioButton noRadioButton = new JRadioButton("No");

    JLabel RadioButtonLabel = new JLabel();

        JScrollPane DescriptionScrollpane = new JScrollPane();
        JScrollPane RemarksScrollpane = new JScrollPane();

        JTextArea DescriptionTextarea = new JTextArea();
        JTextArea RemarksTextarea = new JTextArea();

        Boolean CheckIfEdit = false;

    String previousname;
    String previousprice;
    String previousquantity;
    String previouscost;


        public ProductDetails(Color Dark, Color textcolor,Font font)
        {


            ThemeCheck(Dark,textcolor,font);

            Productframe.add(SerialNoField);
            Productframe.add(SerialNoLabel);
            Productframe.add(AccountHolder);
            Productframe.add(ProductNameLabel);
            Productframe.add(ProductNameField);
            Productframe.add(BackButton);
            Productframe.add(ModelLabel);
            Productframe.add(QuantityLabel);
            Productframe.add(CostLabel);
            Productframe.add(ModelField);
            Productframe.add(QuantityField);
            Productframe.add(CostField);
            Productframe.add(PriceField);
            Productframe.add(searchPrductDetailfield);
            Productframe.add(PriceLabel);
            Productframe.add(BarcodeField);
            Productframe.add(BarcodeLabel);
            Productframe.add(RemarksScrollpane);
            Productframe.add(RadioPanel);
            Productframe.add(RadioButtonLabel);
            Productframe.add(SeachAccountLabel);
            Productframe.add(panelPaintShade);
            Productframe.add(CategoryPanel);
            Productframe.add(BrandPanel);
            Productframe.add(DescriptionScrollpane);
            Productframe.add(ImagePanel);
            Productframe.add(Scroll);

            Productframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Productframe.setSize(1800,900);
            Productframe.setLayout(null);
            Productframe.setTitle("Product Detail Panel");
            Productframe.setResizable(false);
            Productframe.setLocationRelativeTo(null);
            Productframe.setVisible(true);





        }



        void ThemeCheck(Color Dark,Color textcolor,Font font)
        {

            background=Dark;
            foreground=textcolor;

            DisplayTransactionDetail(font);

        }


        void DisplayTransactionDetail(Font font)
        {


            Productframe.getContentPane().setBackground(background);
            Productframe.getContentPane().setForeground(foreground);

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

            ProductNameField.setBounds(300, 80, 300, 35);
            ProductNameField.setHorizontalAlignment(JLabel.CENTER);
            ProductNameField.setFont(font);
            ProductNameField.setForeground(foreground);
            ProductNameField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
            ProductNameField.setBackground(background);
            ProductNameField.setEditable(false);



            SerialNoLabel.setBounds(100, 150, 230, 35);
            SerialNoLabel.setText("Serial No:");
            SerialNoLabel.setFont(font);
            SerialNoLabel.setForeground(foreground);

            SerialNoField.setBounds(300, 150, 300, 35);
            SerialNoField.setHorizontalAlignment(JLabel.CENTER);
            SerialNoField.setFont(font);
            SerialNoField.setForeground(foreground);
            SerialNoField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
            SerialNoField.setBackground(background);
            SerialNoField.setEditable(false);



            ModelLabel.setBounds(100, 220, 230, 35);
            ModelLabel.setText("Model:");
            ModelLabel.setFont(font);
            ModelLabel.setForeground(foreground);

            ModelField.setBounds(300, 220, 300, 35);
            ModelField.setHorizontalAlignment(JLabel.CENTER);
            ModelField.setFont(font);
            ModelField.setForeground(foreground);
            ModelField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
            ModelField.setBackground(background);
            ModelField.setEditable(false);

            QuantityLabel.setBounds(100, 290, 230, 35);
            QuantityLabel.setText("Quantity:");
            QuantityLabel.setFont(font);
            QuantityLabel.setForeground(foreground);

            QuantityField.setBounds(300, 290, 300, 35);
            QuantityField.setHorizontalAlignment(JLabel.CENTER);
            QuantityField.setFont(font);
            QuantityField.setForeground(foreground);
            QuantityField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
            QuantityField.setBackground(background);
            QuantityField.setEditable(false);

            CostLabel.setBounds(100, 360, 230, 35);
            CostLabel.setText("Cost:");
            CostLabel.setFont(font);
            CostLabel.setForeground(foreground);

            CostField.setBounds(300, 360, 300, 35);
            CostField.setHorizontalAlignment(JLabel.CENTER);
            CostField.setFont(font);
            CostField.setForeground(foreground);
            CostField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
            CostField.setBackground(background);
            CostField.setEditable(false);

            PriceLabel.setBounds(100, 430, 230, 35);
            PriceLabel.setText("Price:");
            PriceLabel.setFont(font);
            PriceLabel.setForeground(foreground);

            PriceField.setBounds(300, 430, 300, 35);
            PriceField.setHorizontalAlignment(JLabel.CENTER);
            PriceField.setFont(font);
            PriceField.setForeground(foreground);
            PriceField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
            PriceField.setBackground(background);
            PriceField.setEditable(false);


            SeachAccountLabel.setBounds(650, 150, 230, 35);
            SeachAccountLabel.setText("Search :");
            SeachAccountLabel.setFont(font);
            SeachAccountLabel.setForeground(foreground);

            searchPrductDetailfield.setBounds(750,150,1000,30);
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
                        Table.getSelectionModel().clearSelection();
                        System.out.println(searchPrductDetailfield.getText());
                        int rowCount =  model.getRowCount();

                        for(int tabletrav = rowCount-1;tabletrav>=0;tabletrav--)
                        {
                            model.removeRow(tabletrav);
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
//                                String[] data = new String[7];
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
                                                    model.addRow(data);
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


            BrandTextField.setEditable(false);
            BrandTextField.setSize(300, BrandTextField.getPreferredSize().height);
            BrandPanel.setBounds(630,2,200,50);
            BrandPanel.setLayout(new BorderLayout());
            BrandPanel.setBorder(new TitledBorder(new EtchedBorder(), "[Brand]"));
            BrandPanel.add(BrandTextField, BorderLayout.CENTER);


            CategoryTextField.setEditable(false);
            CategoryTextField.setSize(300, CategoryTextField.getPreferredSize().height);
            CategoryPanel.setBounds(830,2,200,50);
            CategoryPanel.setLayout(new BorderLayout());
            CategoryPanel.setBorder(new TitledBorder(new EtchedBorder(), "[Category]"));
            CategoryPanel.add(CategoryTextField, BorderLayout.CENTER);



            DescriptionScrollpane.setBounds(1050,2,300,100);
            DescriptionScrollpane.setBorder(new TitledBorder(new EtchedBorder(), "[Description]"));
            DescriptionTextarea.setLineWrap(true);
            DescriptionScrollpane.getViewport().add(DescriptionTextarea);
            DescriptionScrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);



            RadioButtonLabel.setBounds(730,50,200,33);
            RadioButtonLabel.setText("Tested / Configured:");
            RadioButtonLabel.setFont(font);
            RadioButtonLabel.setForeground(foreground);


            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(yesRadioButton);
            buttonGroup.add(noRadioButton);

            // Add the radio buttons to the panel
            RadioPanel.setBounds(760,80,100,33);
            RadioPanel.add(yesRadioButton);
            RadioPanel.add(noRadioButton);

            RemarksScrollpane.setBounds(1350,2,300,100);
            RemarksScrollpane.setBorder(new TitledBorder(new EtchedBorder(), "[Remarks]"));
            RemarksTextarea.setLineWrap(true);
            RemarksScrollpane.getViewport().add(RemarksTextarea);
            RemarksScrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


            ImagePanel.setBounds(100,470,320,320);
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

                        Productframe.dispose();
                        new MainMenu(Productframe.getContentPane().getBackground(), Productframe.getContentPane().getForeground(),font);
                    }
                }
            });


            DisplayTable(font);



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


                                    model.addRow(data);




                            }
                        }
                    }

                }
            }
        }

        void DisplayTable(Font font)
        {
//            boolean visited ;


            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Table.getDefaultRenderer(Object.class);
            renderer.setHorizontalAlignment( SwingConstants.CENTER );

            String[] ColumnNames={"Barcode","Brand","Category","Cost","Description","Model","Name","Price","Quantity","Remarks","Serial","Tested"};


            Table.setBackground(background);
            Table.setForeground(foreground);
            Table.getTableHeader().setBackground(foreground);
            Table.getTableHeader().setForeground(background);
            Table.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,20));
            Table.setBorder(BorderFactory.createLineBorder(foreground));
            Table.setGridColor(foreground);
            Table.setSelectionBackground(foreground);
            Table.setSelectionForeground(background);




            Scroll=new JScrollPane();
            Scroll.setViewportView(Table);
            Scroll.setBounds(650,200,1100,650);
            Scroll.getViewport().setBackground(background);
            Scroll.setBorder(BorderFactory.createLineBorder(foreground));
            Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            Scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


            Scroll.setOpaque(true);



            model=(DefaultTableModel)Table.getModel();
            model.setColumnIdentifiers(ColumnNames);


            AddDataToProductTableFromDatabase();




            Table.getSelectionModel().addListSelectionListener(event -> {

                ImagePanel.removeAll();
                int i = Table.getSelectedRow();
                BarcodeField.setText(model.getValueAt(i,0).toString());
                BrandTextField.setText(model.getValueAt(i,1).toString());
                CategoryTextField.setText(model.getValueAt(i,2).toString());
                CostField.setText(model.getValueAt(i,3).toString());
                DescriptionTextarea.setText(model.getValueAt(i,4).toString());
                ModelField.setText(model.getValueAt(i,5).toString());
                ProductNameField.setText(model.getValueAt(i,6).toString());
                PriceField.setText(model.getValueAt(i,7).toString());
                QuantityField.setText(model.getValueAt(i,8).toString());
                RemarksTextarea.setText(model.getValueAt(i,9).toString());
                SerialNoField.setText(model.getValueAt(i,10).toString());
                if(model.getValueAt(i,11).toString().equals("yes"))
                {
                    yesRadioButton.setSelected(true);
                }
                else
                {
                    noRadioButton.setSelected(true);
                }

                String filepath = model.getValueAt(i,6).toString();


                try {
                    // Load the image

                    BufferedImage originalImage = ImageIO.read(new File("product/"+filepath+"/logo.png"));
                    Dimension panelSize = ImagePanel.getSize();
                    Image scaledImage = originalImage.getScaledInstance(panelSize.width, panelSize.height, Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(scaledImage);
                    JLabel label = new JLabel(imageIcon);
                    ImagePanel.add(label);
                    ImagePanel.revalidate();

                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }

                int r= Table.getSelectedRow();
                previousname = model.getValueAt(r,6).toString();
                previousprice= model.getValueAt(r,7).toString();
                previouscost = model.getValueAt(r,3).toString();
                previousquantity = model.getValueAt(r,8).toString();

//                System.out.println("this is previous name:"+previousname);

            });



            Table.getModel().addTableModelListener(e -> {


                int row = e.getFirstRow();
                int column = e.getColumn();


                int k = Table.getSelectedRow();

                if(k!=-1)
                {
                String pname = model.getValueAt(k, 6).toString();
                String Pprice = model.getValueAt(k, 7).toString();
                String Pcost = model.getValueAt(k, 3).toString();
                String Pquantity = model.getValueAt(k, 8).toString();
                String Pbarcode = model.getValueAt(k, 0).toString();
                String Pbrand = model.getValueAt(k, 1).toString();
                String Pcategory = model.getValueAt(k, 2).toString();
                String Pdescription = model.getValueAt(k, 4).toString();
                String Premarks = model.getValueAt(k, 9).toString();
                String Pserial = model.getValueAt(k, 10).toString();
                String Pmodel = model.getValueAt(k, 5).toString();
                String Ptested = model.getValueAt(k, 11).toString();

                if (pname.equals("")) {
                    JOptionPane.showMessageDialog(Productframe, "Name can not be null ", "Name field null! ", JOptionPane.INFORMATION_MESSAGE);
                    model.setValueAt(previousname, k, 6);

                    return;
                }

                if (Pprice.equals("")) {
                    JOptionPane.showMessageDialog(Productframe, "Price can not be null ", "Name field null! ", JOptionPane.INFORMATION_MESSAGE);
                    model.setValueAt(previousprice, k, 7);

                    return;
                }

                if (Pcost.equals("")) {
                    JOptionPane.showMessageDialog(Productframe, "Cost can not be null ", "Name field null! ", JOptionPane.INFORMATION_MESSAGE);
                    model.setValueAt(previouscost, k, 3);

                    return;
                }

                if (Pquantity.equals("")) {
                    JOptionPane.showMessageDialog(Productframe, "Quantity can not be null ", "Name field null! ", JOptionPane.INFORMATION_MESSAGE);
                    model.setValueAt(previousquantity, k, 8);
                    return;
                }

                if (Pbarcode.equals("")) {
                    model.setValueAt("-", k, 0);

                }

                if (Pbrand.equals("")) {
                    model.setValueAt("-", k, 1);

                }

                if (Pcategory.equals("")) {
                    model.setValueAt("-", k, 2);

                }

                if (Pmodel.equals("")) {
                    model.setValueAt("-", k, 5);

                }

                if (Premarks.equals("")) {
                    model.setValueAt("-", k, 9);

                }

                if (Pserial.equals("")) {
                    model.setValueAt("-", k, 10);

                }

                if (Pdescription.equals("")) {
                    model.setValueAt("-", k, 4);

                }

                if (Ptested.equals("")) {
                    model.setValueAt("-", k, 11);

                }
            }



                if (row >= 0 && column >= 0) {
                    boolean visited = false;

                    TableModel model = (TableModel) e.getSource();


                    // Use the edited value as needed

                    BarcodeField.setText(model.getValueAt(row,0).toString());
                    BrandTextField.setText(model.getValueAt(row,1).toString());
                    CategoryTextField.setText(model.getValueAt(row,2).toString());
                    CostField.setText(model.getValueAt(row,3).toString());
                    DescriptionTextarea.setText(model.getValueAt(row,4).toString());
                    ModelField.setText(model.getValueAt(row,5).toString());
                    ProductNameField.setText(model.getValueAt(row,6).toString());
                    PriceField.setText(model.getValueAt(row,7).toString());
                    QuantityField.setText(model.getValueAt(row,8).toString());
                    RemarksTextarea.setText(model.getValueAt(row,9).toString());
                    SerialNoField.setText(model.getValueAt(row,10).toString());

                    if(model.getValueAt(row,11).toString().equals("yes"))
                    {
                        yesRadioButton.setSelected(true);
                    }
                    else
                    {
                        noRadioButton.setSelected(true);
                    }
                    CheckIfEdit=true;


//                    if(CheckIfEdit)
//                    {
                        int selection = Table.getSelectedRow();
                        String option;

                        if(model.getValueAt(selection,11).toString().equals("yes"))
                        {
                            option="yes";
                        }
                        else
                        {
                            option="no";
                        }
                        String[] TextFieldData =
                                {

                                        BarcodeField.getText(),
                                        BrandTextField.getText(),
                                        CategoryTextField.getText(),
                                        CostField.getText(),
                                        DescriptionTextarea.getText(),
                                        ModelField.getText(),
                                        ProductNameField.getText(),
                                        PriceField.getText(),
                                        QuantityField.getText(),
                                        RemarksTextarea.getText(),
                                        SerialNoField.getText(),
                                        option
                                };

//                        System.out.println(ProductNameField.getText()+"product naam dekh rhe ");

                        String path = model.getValueAt(selection,6).toString();

                        File folder = new File("product/"+path);
//                        boolean visited = false;
                        if (!folder.exists()) {
                            visited=true;
                            if (folder.mkdir()) {


                                FileWriter Barcode = null;
                                FileWriter Model = null;
                                FileWriter quantity = null;
                                FileWriter SerialNumber = null;
                                FileWriter cost = null;
                                FileWriter price = null;
                                FileWriter name = null;
                                FileWriter brand = null;
                                FileWriter category = null;
                                FileWriter remarks = null;
                                FileWriter description = null;
                                FileWriter tested = null;

                                try {

                                    Barcode = new FileWriter("product/"+path + "/Barcode.txt");
                                    Barcode.write(TextFieldData[0]);
                                    Barcode.close();

                                    SerialNumber = new FileWriter("product/"+path + "/SerialNumber.txt");
                                    SerialNumber.write(TextFieldData[10]);
                                    SerialNumber.close();

                                    Model = new FileWriter("product/"+path + "/Model.txt");
                                    Model.write(TextFieldData[5]);
                                    Model.close();

                                    quantity = new FileWriter("product/"+path + "/quantity.txt");
                                    quantity.write(TextFieldData[8]);
                                    quantity.close();

                                    cost = new FileWriter("product/"+path + "/cost.txt");
                                    cost.write(TextFieldData[3]);
                                    cost.close();

                                    price = new FileWriter("product/"+path + "/price.txt");
                                    price.write(TextFieldData[7]);
                                    price.close();

                                    brand = new FileWriter("product/"+path + "/brand.txt");
                                    brand.write(TextFieldData[1]);
                                    brand.close();

                                    category = new FileWriter("product/"+path + "/category.txt");
                                    category.write(TextFieldData[2]);
                                    category.close();

                                    tested = new FileWriter("product/"+path + "/tested.txt");
                                    tested.write(TextFieldData[11]);
                                    tested.close();

                                    description = new FileWriter("product/"+path + "/description.txt");
                                    description.write(TextFieldData[4]);
                                    description.close();

                                    remarks = new FileWriter("product/"+path + "/remarks.txt");
                                    remarks.write(TextFieldData[9]);
                                    remarks.close();

                                    name = new FileWriter("product/"+path + "/name.txt");
                                    name.write(TextFieldData[6]);
                                    name.close();

                                    System.out.println("Added");

                                } catch (IOException ex) {

                                }

                                String previousimagepath = "product/"+ previousname +"/logo.png";
//                                System.out.println("previous image name was:"+ previousname);

                                Path sourcePath = Path.of(previousimagepath);
                                Path destinationPath = Path.of("product/"+path+"/logo.png");

                                try {
                                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                    System.out.println("Image file transferred successfully.");
                                } catch (IOException E) {
                                    System.out.println("An error occurred while transferring the image file: " + E.getMessage());
                                }

                                Path folderPath = Paths.get("product/"+ previousname);

                                try {
                                    Files.walk(folderPath)
                                            .sorted(java.util.Comparator.reverseOrder())
                                            .map(Path::toFile)
                                            .forEach(java.io.File::delete);
                                    System.out.println("Folder deleted successfully.");
                                } catch (IOException E) {
                                    System.out.println("An error occurred while deleting the folder: " + E.getMessage());
                                }



                            }
                            else {
                                System.out.println("Error Adding Client.");
                            }
//                            Productframe.dispose();
//                            new ProductDetails(Productframe.getContentPane().getBackground(), Productframe.getContentPane().getForeground(),font);

                        }
                        else {
                            visited=false;
                            System.out.println(visited+":checking");
                            FileWriter Barcode = null;
                            FileWriter Model = null;
                            FileWriter quantity = null;
                            FileWriter SerialNumber = null;
                            FileWriter cost = null;
                            FileWriter price = null;
                            FileWriter name = null;
                            FileWriter brand = null;
                            FileWriter category = null;
                            FileWriter remarks = null;
                            FileWriter description = null;
                            FileWriter tested = null;

                            try {

                                Barcode = new FileWriter("product/"+path + "/Barcode.txt");
                                Barcode.write(TextFieldData[0]);
                                Barcode.close();

                                SerialNumber = new FileWriter("product/"+path + "/SerialNumber.txt");
                                SerialNumber.write(TextFieldData[10]);
                                SerialNumber.close();

                                Model = new FileWriter("product/"+path + "/Model.txt");
                                Model.write(TextFieldData[5]);
                                Model.close();

                                quantity = new FileWriter("product/"+path + "/quantity.txt");
                                quantity.write(TextFieldData[8]);
                                quantity.close();

                                cost = new FileWriter("product/"+path + "/cost.txt");
                                cost.write(TextFieldData[3]);
                                cost.close();

                                price = new FileWriter("product/"+path + "/price.txt");
                                price.write(TextFieldData[7]);
                                price.close();

                                brand = new FileWriter("product/"+path + "/brand.txt");
                                brand.write(TextFieldData[1]);
                                brand.close();

                                category = new FileWriter("product/"+path + "/category.txt");
                                category.write(TextFieldData[2]);
                                category.close();

                                tested = new FileWriter("product/"+path + "/tested.txt");
                                tested.write(TextFieldData[11]);
                                tested.close();

                                description = new FileWriter("product/"+path + "/description.txt");
                                description.write(TextFieldData[4]);
                                description.close();

                                remarks = new FileWriter("product/"+path + "/remarks.txt");
                                remarks.write(TextFieldData[9]);
                                remarks.close();

                                name = new FileWriter("product/"+path + "/name.txt");
                                name.write(TextFieldData[6]);
                                name.close();

                                System.out.println("Added");

                            } catch (IOException ex) {

                            }

                        }
                        if(visited)
                        {

                            Productframe.dispose();
                           new ProductDetails(Productframe.getContentPane().getBackground(), Productframe.getContentPane().getForeground(),font);

                        }




//                    }



                }
            });




        }


        }






