package e_commerce;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window2 extends JFrame  implements ActionListener {
	JComboBox[] products;
    int nProducts;
    JButton next;
    ImageIcon logo;
    JLabel page2;
    JPanel panel,panel2;
    Product[] productsArr;
    Product[] selectedProducts;
    String name,address;
	int ID;
   
    public Window2(int nProducts, String address,String name, int ID) {
        this.nProducts = nProducts;
        this.address=address;
		this.name=name;
	    this.ID=ID;

        logo = new ImageIcon("e-c.png");
        Border logoBorder = BorderFactory.createLineBorder(Color.ORANGE, 10);

        page2 = new JLabel();
        page2.setText("select products to add to your cart:");
        page2.setIcon(logo);
        page2.setHorizontalTextPosition(JLabel.CENTER);
        page2.setVerticalTextPosition(JLabel.BOTTOM);
        page2.setIconTextGap(-100);
        page2.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
        page2.setBorder(logoBorder);
        page2.setHorizontalAlignment(JLabel.CENTER);
        page2.setVerticalAlignment(JLabel.CENTER);
        page2.setBounds(100, 100, 150, 150);
        
        next = new JButton("Place an order");
        next.addActionListener(this);

        ElectronicProduct phone =new ElectronicProduct("Samsung",1,1,599.9f,"Smartphone");
        ClothingProduct tShirt=new ClothingProduct("medium","cotton",2,19.99f,"T-shirt");
        BookProduct book=new BookProduct("O'Reilly","X Publicatiions",3,39.99f,"oop book");
        productsArr = new Product [3];
        productsArr[0]=phone;
        productsArr[1]= tShirt;
        productsArr[2]=book;
        
        products = new JComboBox [nProducts];
        selectedProducts = new Product[nProducts];
        panel = new JPanel();
        for (int i = 0; i < nProducts; i++) {
            products[i] = new JComboBox<>(productsArr);
            products[i].addActionListener(this);
            panel.add(products[i]);
        }
        
        panel2 = new JPanel();
        panel2.add(panel);
        panel2.add(next);

        this.setTitle("E-Commerce System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(page2, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < nProducts; i++) {
            if (e.getSource() == products[i]) {
                selectedProducts[i] = (Product) products[i].getSelectedItem();
            }
        }

        if (e.getSource() == next) {
            this.dispose();
            new Order(this.selectedProducts,this.address,this.name,this.ID);
           
            }
        }
}
    