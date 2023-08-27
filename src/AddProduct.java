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
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class AddProduct {


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

    JButton AddButton = new JButton();


    JTextField ProductNameField = new JTextField();

    JTextField SerialNoField = new JTextField();


    JTextField ModelField = new JTextField();

    JTextField QuantityField = new JTextField();

    JTextField CostField = new JTextField();
    JTextField PriceField = new JTextField();


    JButton BackButton = new JButton();

    JButton uploadimagebutton = new JButton();

    JButton AddDropdownMenuButton = new JButton();

    JButton DeleteDropdownMenuButton = new JButton();


    JTable Table = new JTable();

    DefaultTableModel model=new DefaultTableModel();

    JScrollPane Scroll;

    JPanel BrandPanel = new JPanel();
    JPanel CategoryPanel = new JPanel();
    JPanel panelPaintShade = new JPanel();

    JTextField Add_DelMenuitemField = new JTextField();

    JComboBox BrandDropdownlist;

    JComboBox CategoryDropdownlist;


    JPanel ImagePanel = new JPanel();

    JLabel Imagelabel = new JLabel();

    JPanel Add_DelMenuItemPanel = new JPanel();

    JPanel RadioPanel = new JPanel();
    JRadioButton yesRadioButton = new JRadioButton("Yes");
    JRadioButton noRadioButton = new JRadioButton("No");

    JRadioButton BrandRadioButton = new JRadioButton("Brand");
    JRadioButton CategorydRadioButton = new JRadioButton("Category");

    JLabel RadioButtonLabel = new JLabel();

    JScrollPane DescriptionScrollpane = new JScrollPane();
    JScrollPane RemarksScrollpane = new JScrollPane();

    JTextArea DescriptionTextarea = new JTextArea();
    JTextArea RemarksTextarea = new JTextArea();

    String pdfpath;



    public AddProduct(Color Dark, Color textcolor, Font font)
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
        Productframe.add(PriceLabel);
        Productframe.add(BarcodeField);
        Productframe.add(BarcodeLabel);
        Productframe.add(uploadimagebutton);
        Productframe.add(Add_DelMenuItemPanel);
        Productframe.add(RemarksScrollpane);
        Productframe.add(RadioPanel);
        Productframe.add(RadioButtonLabel);
        Productframe.add(AddButton);
        Productframe.add(panelPaintShade);
        Productframe.add(CategoryPanel);
        Productframe.add(BrandPanel);
        Productframe.add(DescriptionScrollpane);
        Productframe.add(ImagePanel);
        Productframe.add(Scroll);

        Productframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Productframe.setSize(1800,900);
        Productframe.setLayout(null);
        Productframe.setTitle("Add Product");
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

        BarcodeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {


                    e.consume();
                }

            }
        });




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
        ProductNameField.setEditable(true);

        ProductNameField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();
                if (!((c >= 'a') && (c <= 'z') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_SPACE) )) {


                    e.consume();
                }

            }
        });



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
        SerialNoField.setEditable(true);

        SerialNoField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {


                    e.consume();
                }

            }
        });



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
        ModelField.setEditable(true);

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
        QuantityField.setEditable(true);

        QuantityField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {


                    e.consume();
                }

            }
        });

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
        CostField.setEditable(true);

        CostField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {


                    e.consume();
                }

            }
        });

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
        PriceField.setEditable(true);

        PriceField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {


                    e.consume();
                }

            }
        });





        String BrandmainFolderPath = "brand";
        File BrandmainFolder = new File(BrandmainFolderPath);
        if (BrandmainFolder.exists() && BrandmainFolder.isDirectory()) {
            File[] textFiles = BrandmainFolder.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            });
            if (textFiles != null) {



                String[] data = new String[textFiles.length];
                int j = 0;
                for (File textFile : textFiles) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Process the content of the text document
                            data[j] = line;

                            j++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String[] brandData =new String[textFiles.length+1];
                brandData[0]="brand";
                for(int i = 0;i< textFiles.length;i++)
                {
                    brandData[i+1]=data[i];

                }

                BrandDropdownlist =new JComboBox(brandData);
                BrandDropdownlist.setSelectedIndex(0);
                BrandDropdownlist.setToolTipText("select a brand");
                BrandDropdownlist.setSize(300, BrandDropdownlist.getPreferredSize().height);
                BrandPanel.setBounds(630,2,200,50);
                BrandPanel.setLayout(new BorderLayout());
                BrandPanel.setBorder(new TitledBorder(new EtchedBorder(), "[Brand]"));
                BrandPanel.add(BrandDropdownlist, BorderLayout.CENTER);

            }
        }




        String CategorymainFolderPath = "category";
        File CategorymainFolder = new File(CategorymainFolderPath);
        if (CategorymainFolder.exists() && CategorymainFolder.isDirectory()) {
            File[] textFiles = CategorymainFolder.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            });
            if (textFiles != null) {

                String[] data = new String[textFiles.length];
                int j = 0;
                for (File textFile : textFiles) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Process the content of the text document
                            data[j] = line;
                            j++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String[] CategoryData =new String[textFiles.length+1];
                CategoryData[0]="category";
                for(int i = 0;i< textFiles.length;i++)
                {
                    CategoryData[i+1]=data[i];

                }

                CategoryDropdownlist =new JComboBox(CategoryData);

                CategoryDropdownlist.setSelectedIndex(0);
                CategoryDropdownlist.setToolTipText("select a Category");
                CategoryDropdownlist.setSize(300, CategoryDropdownlist.getPreferredSize().height);
                CategoryPanel.setBounds(830,2,200,50);
                CategoryPanel.setLayout(new BorderLayout());
                CategoryPanel.setBorder(new TitledBorder(new EtchedBorder(), "[Category]"));
                CategoryPanel.add(CategoryDropdownlist, BorderLayout.CENTER);
            }
        }



        DescriptionScrollpane.setBounds(1050,2,300,100);
        DescriptionScrollpane.setBorder(new TitledBorder(new EtchedBorder(), "[Description]"));
        DescriptionTextarea.setLineWrap(true);
        DescriptionScrollpane.getViewport().add(DescriptionTextarea);
        DescriptionScrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);



        RadioButtonLabel.setBounds(640,120,200,33);
        RadioButtonLabel.setText("Tested / Configured:");
        RadioButtonLabel.setFont(font);
        RadioButtonLabel.setForeground(foreground);


        ButtonGroup YesNobuttonGroup = new ButtonGroup();
        YesNobuttonGroup.add(yesRadioButton);
        YesNobuttonGroup.add(noRadioButton);

        // Add the radio buttons to the panel
        RadioPanel.setBounds(850,120,100,33);
        RadioPanel.add(yesRadioButton);
        RadioPanel.add(noRadioButton);

        Add_DelMenuItemPanel.setBounds(630,60,400,55);
        Add_DelMenuItemPanel.setBorder(new TitledBorder(new EtchedBorder(), "[Add/Delete Brand,Category]"));
        Add_DelMenuItemPanel.setLayout(new BoxLayout(Add_DelMenuItemPanel, BoxLayout.X_AXIS));

        ButtonGroup Brand_CategoryButtonGroup = new ButtonGroup();
        Brand_CategoryButtonGroup.add(BrandRadioButton);
        Brand_CategoryButtonGroup.add(CategorydRadioButton);

        Add_DelMenuitemField.setPreferredSize(new Dimension(50,25));
        Add_DelMenuItemPanel.add(Add_DelMenuitemField);
        Add_DelMenuItemPanel.add(Box.createHorizontalStrut(5));
        Add_DelMenuItemPanel.add(BrandRadioButton);
        Add_DelMenuItemPanel.add(CategorydRadioButton);
        Add_DelMenuItemPanel.add(Box.createHorizontalStrut(5));
        Add_DelMenuItemPanel.add(AddDropdownMenuButton);
        Add_DelMenuItemPanel.add(Box.createHorizontalStrut(5));
        Add_DelMenuItemPanel.add(DeleteDropdownMenuButton);


        AddDropdownMenuButton.setPreferredSize(new Dimension(70,30));
        AddDropdownMenuButton.setText("Add");
        AddDropdownMenuButton.setFont(font);
        AddDropdownMenuButton.setBackground(background);
        AddDropdownMenuButton.setForeground(foreground);
        AddDropdownMenuButton.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AddDropdownMenuButton.setFocusable(false);

        AddDropdownMenuButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                AddDropdownMenuButton.setBackground(foreground);
                AddDropdownMenuButton.setForeground(background);
                AddDropdownMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                AddDropdownMenuButton.setBackground(background);
                AddDropdownMenuButton.setForeground(foreground);
                AddDropdownMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {
                String item = Add_DelMenuitemField.getText();
                if(BrandRadioButton.isSelected())
                {

                    FileWriter brand = null;
                    try {

                        brand = new FileWriter("brand/"  + item+".txt");
                        brand.write(item);
                        brand.close();
                    }catch (Exception b)
                    {
                        System.out.println("brand database me nhi gya");
                    }




                    BrandDropdownlist.addItem(item);
                    Add_DelMenuitemField.setText("");
                    Brand_CategoryButtonGroup.clearSelection();
                }
                else if (CategorydRadioButton.isSelected()) {

                    FileWriter brand = null;
                    try {

                        brand = new FileWriter("category/"  + item+".txt");
                        brand.write(item);
                        brand.close();
                    }catch (Exception b)
                    {
                        System.out.println("category database me nhi gya");
                    }


                    CategoryDropdownlist.addItem(item);
                    Add_DelMenuitemField.setText("");
                    Brand_CategoryButtonGroup.clearSelection();
                }
                else
                {
                    JOptionPane.showMessageDialog(Productframe, "Select a option ", "Add/Delete Error! ", JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });


        DeleteDropdownMenuButton.setPreferredSize(new Dimension(70,30));
        DeleteDropdownMenuButton.setText("Delete");
        DeleteDropdownMenuButton.setFont(font);
        DeleteDropdownMenuButton.setBackground(background);
        DeleteDropdownMenuButton.setForeground(foreground);
        DeleteDropdownMenuButton.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        DeleteDropdownMenuButton.setFocusable(false);

        DeleteDropdownMenuButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                DeleteDropdownMenuButton.setBackground(foreground);
                DeleteDropdownMenuButton.setForeground(background);
                DeleteDropdownMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                DeleteDropdownMenuButton.setBackground(background);
                DeleteDropdownMenuButton.setForeground(foreground);
                DeleteDropdownMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {

                String BrandselectedItem =(String)BrandDropdownlist.getSelectedItem();
                String CategoryselectedItem =(String)CategoryDropdownlist.getSelectedItem();

                if(BrandRadioButton.isSelected())
                {
                    File brand = new File("brand/"+ BrandselectedItem + ".txt");
                    brand.delete();
                    BrandDropdownlist.removeItem(BrandselectedItem);
                    Add_DelMenuitemField.setText("");
                    Brand_CategoryButtonGroup.clearSelection();
                }
                else if (CategorydRadioButton.isSelected())
                {

                    File category = new File("category/"+ CategoryselectedItem + ".txt");
                    category.delete();
                    CategoryDropdownlist.removeItem(CategoryselectedItem);
                    Add_DelMenuitemField.setText("");
                    Brand_CategoryButtonGroup.clearSelection();
                }
                else
                {
                    JOptionPane.showMessageDialog(Productframe, "Select a option ", "Add/Delete Error! ", JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });

        RemarksScrollpane.setBounds(1350,2,300,100);
        RemarksScrollpane.setBorder(new TitledBorder(new EtchedBorder(), "[Remarks]"));
        RemarksTextarea.setLineWrap(true);
        RemarksScrollpane.getViewport().add(RemarksTextarea);
        RemarksScrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        ImagePanel.setBounds(100,470,320,320);
        ImagePanel.setBorder(BorderFactory.createLineBorder(foreground));

        uploadimagebutton.setBounds(450, 800, 150, 50);
        uploadimagebutton.setText("Upload Image");
        uploadimagebutton.setFont(font);
        uploadimagebutton.setBackground(background);
        uploadimagebutton.setForeground(foreground);
        uploadimagebutton.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        uploadimagebutton.setFocusable(false);



        uploadimagebutton.addMouseListener(new MouseAdapter() {
            boolean flag=false;

            //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                uploadimagebutton.setBackground(foreground);
                uploadimagebutton.setForeground(background);
                uploadimagebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                uploadimagebutton.setBackground(background);
                uploadimagebutton.setForeground(foreground);
                uploadimagebutton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(Productframe);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    pdfpath = selectedFile.getAbsolutePath();
                    flag=true;

                }
                if(flag)
                {




                    try {
                        // Load the image

                        BufferedImage originalImage = ImageIO.read(new File(pdfpath));
                        Dimension panelSize = ImagePanel.getSize();
                        Image scaledImage = originalImage.getScaledInstance(panelSize.width, panelSize.height, Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(scaledImage);
                        Imagelabel.setIcon(imageIcon);

                        ImagePanel.add(Imagelabel);
                        ImagePanel.revalidate();


                    }
                    catch (IOException j) {
                        throw new RuntimeException(j);
                    }
                }


            }

        });


        AddButton.setBounds(1650, 800, 150, 50);
        AddButton.setText("Add Product");
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

                if(
                        ProductNameField.getText().equals("") ||
                        QuantityField.getText().equals("") ||
                        CostField.getText().equals("") ||
                        PriceField.getText().equals("")
                )
                {
                    JOptionPane.showMessageDialog(Productframe,"Enter complete information ","Incomplete Information Error!",JOptionPane.INFORMATION_MESSAGE);
                    return;

                }

                if(BarcodeField.getText().equals(""))
                {
                    BarcodeField.setText("-");
                }

                if(SerialNoField.getText().equals(""))
                {
                    SerialNoField.setText("-");
                }

                if(ModelField.getText().equals(""))
                {
                    ModelField.setText("-");
                }

                if(DescriptionTextarea.getText().equals(""))
                {
                    DescriptionTextarea.setText("-");
                }

                if(RemarksTextarea.getText().equals(""))
                {
                    RemarksTextarea.setText("-");
                }





//                String mainFolderPath = "product";
//                File mainFolder = new File(mainFolderPath);
//
//                if (mainFolder.exists() && mainFolder.isDirectory()) {
//                    File[] subfolders = mainFolder.listFiles(File::isDirectory);
//
//                    if (subfolders != null) {
//                        int subfolderCount = subfolders.length;
//                        Set<String> set = new HashSet<String>(){{
//                            for (int i =0;i<subfolderCount;i++)
//                            {
//                                try {
//                                    String filepath = (String) model.getValueAt(i,6);
//
//                                    Scanner balance = new Scanner(new File("product/"+filepath+"/Barcode.txt"));
//                                    add(balance.next());
//
//
//
//                                } catch (Exception E) {
//                                    System.out.println("Account Doesn't Exist");
//                                }
//
//                            }
//
//                        }};
//
//                        if(set.contains(BarcodeField.getText()))
//                        {
//                            JOptionPane.showMessageDialog(Productframe,"Barcode Already Exists","Barcode error!",JOptionPane.INFORMATION_MESSAGE);
//                            BarcodeField.setText("");
//                            return;
//                        }
//                    } else {
//                        System.out.println("No subfolders found.");
//                    }
//                } else {
//                    System.out.println("Main folder does not exist or is not a directory.");
//                }




                String yes_no_option;
                if(yesRadioButton.isSelected())
                {
                    yes_no_option="yes";
                }
                else
                {
                    yes_no_option="no";
                }

                String[] TextFieldData =
                        {
                                BarcodeField.getText(),
                                ProductNameField.getText(),
                                SerialNoField.getText(),
                                ModelField.getText(),
                                QuantityField.getText(),
                                CostField.getText(),
                                PriceField.getText(),
                                BrandDropdownlist.getSelectedItem().toString(),
                                CategoryDropdownlist.getSelectedItem().toString(),
                                yes_no_option,
                                DescriptionTextarea.getText(),
                                RemarksTextarea.getText()

                        };

                String Description = DescriptionTextarea.getText();
                String Remarks= RemarksTextarea.getText();
                String brand = (String) BrandDropdownlist.getSelectedItem();
                String category = (String) CategoryDropdownlist.getSelectedItem();
                boolean yesRadiobutton = yesRadioButton.isSelected();


                File folder = new File("product/"+TextFieldData[1]);
                if (!folder.exists()) {
                    if (folder.mkdir()) {
                    } else {
                        System.out.println("Error Adding Client.");
                    }
                }

                FileWriter Barcode = null;
                FileWriter Model = null;
                FileWriter quantity = null;
                FileWriter SerialNumber = null;
                FileWriter cost = null;
                FileWriter price = null;
                FileWriter name = null;
                try {

                    Barcode = new FileWriter("product/"+TextFieldData[1] + "/Barcode.txt");
                    Barcode.write(TextFieldData[0]);
                    Barcode.close();

                    SerialNumber = new FileWriter("product/"+TextFieldData[1] + "/SerialNumber.txt");
                    SerialNumber.write(TextFieldData[2]);
                    SerialNumber.close();

                    Model = new FileWriter("product/"+TextFieldData[1] + "/Model.txt");
                    Model.write(TextFieldData[3]);
                    Model.close();

                    quantity = new FileWriter("product/"+TextFieldData[1] + "/quantity.txt");
                    quantity.write(TextFieldData[4]);
                    quantity.close();

                    cost = new FileWriter("product/"+TextFieldData[1] + "/cost.txt");
                    cost.write(TextFieldData[5]);
                    cost.close();

                    price = new FileWriter("product/"+TextFieldData[1] + "/price.txt");
                    price.write(TextFieldData[6]);
                    price.close();

                    price = new FileWriter("product/"+TextFieldData[1] + "/brand.txt");
                    price.write(TextFieldData[7]);
                    price.close();

                    price = new FileWriter("product/"+TextFieldData[1] + "/category.txt");
                    price.write(TextFieldData[8]);
                    price.close();

                    price = new FileWriter("product/"+TextFieldData[1] + "/tested.txt");
                    price.write(TextFieldData[9]);
                    price.close();

                    price = new FileWriter("product/"+TextFieldData[1] + "/description.txt");
                    price.write(TextFieldData[10]);
                    price.close();

                    price = new FileWriter("product/"+TextFieldData[1] + "/remarks.txt");
                    price.write(TextFieldData[11]);
                    price.close();

                    name = new FileWriter("product/"+TextFieldData[1] + "/name.txt");
                    name.write(TextFieldData[1]);
                    name.close();

                    System.out.println("Added");

                } catch (IOException ex) {

                }


                int width = ImagePanel.getWidth();
                int height = ImagePanel.getHeight();
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                Graphics2D graphics = image.createGraphics();
                ImagePanel.paint(graphics);
                graphics.dispose();

                String filePath = "product/"+TextFieldData[1] + "/logo.png";

                // Create the file object
                File outputFile = new File(filePath);

                // Save the image as a file
                try {
                    ImageIO.write(image, "png", outputFile);
                    System.out.println("Image saved successfully.");
                } catch (IOException j) {
                    j.printStackTrace();
                }

                Productframe.dispose();
                new AddProduct(Productframe.getContentPane().getBackground(), Productframe.getContentPane().getForeground(),font);


                BarcodeField.setText("");
                ProductNameField.setText("");
                SerialNoField.setText("");
                ModelField.setText("");
                QuantityField.setText("");
                CostField.setText("");
                PriceField.setText("");
                DescriptionTextarea.setText("");
                RemarksTextarea.setText("");
                BrandDropdownlist.setSelectedIndex(0);
                CategoryDropdownlist.setSelectedIndex(0);
                YesNobuttonGroup.clearSelection();
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

                    Productframe.dispose();
                    new MainMenu(Productframe.getContentPane().getBackground(), Productframe.getContentPane().getForeground(),font);
                }
            }
        });


        DisplayTable();



    }


    void DisplayTable()
    {


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
        Table.setDefaultEditor(Object.class,null);




        Scroll=new JScrollPane();
        Scroll.setViewportView(Table);
        Scroll.setBounds(650,200,1100,600);
        Scroll.getViewport().setBackground(background);
        Scroll.setBorder(BorderFactory.createLineBorder(foreground));
        Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


        Scroll.setOpaque(true);

        model=(DefaultTableModel)Table.getModel();
        model.setColumnIdentifiers(ColumnNames);

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





    }



}


