package e_commerce;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Order extends JFrame {
	Object[] selectedProducts;
    String name,address;
	int ID;
    
   Order(Product [] selectedProducts,String address,String name, int ID){
	   this.address=address;
	   this.name=name;
	   this.ID=ID; 
		 
	   ImageIcon logo = new ImageIcon("e-c.png");
       Border logoBorder = BorderFactory.createLineBorder(Color.ORANGE, 10);
       JLabel page4= new JLabel();
       page4 = new JLabel();
       page4.setText("Thanks for shopping at E-Commerce System! ");
       page4.setIcon(logo);
       page4.setHorizontalTextPosition(JLabel.CENTER);
       page4.setVerticalTextPosition(JLabel.BOTTOM);
       page4.setIconTextGap(-100);
       page4.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
       page4.setBorder(logoBorder);
       page4.setHorizontalAlignment(JLabel.CENTER);
       page4.setVerticalAlignment(JLabel.CENTER);
       page4.setBounds(100, 100, 150, 150);
       
       
       JLabel title =new JLabel("Order Summary :");
        title.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
       		
       JPanel panel = new JPanel();
       panel.setLayout(new GridLayout(selectedProducts.length, 1));
       float totalPrice=0f;
       for (Product product : selectedProducts) {
           JLabel productLabel = new JLabel(product.toString());
           productLabel.setHorizontalAlignment(SwingConstants.LEFT);
           productLabel.setFont(new Font("Bernard MT Condensed", Font.LAYOUT_LEFT_TO_RIGHT, 20));
           totalPrice+=product.getPrice();
           panel.add(productLabel);
       }
       JTextArea orderDetails= new JTextArea("total price = "+totalPrice+"$  \n"+
                                              "Customer name: "+this.name+"\n"+
    		   								  "Customer ID: "+this.ID+"\n"+
                                               "Address: "+this.address);
       orderDetails.setFont(new Font("Bernard MT Condensed", Font.LAYOUT_LEFT_TO_RIGHT, 20));
       orderDetails.setBackground(null);
       
       
       JPanel panel2 = new JPanel();
       		 panel2.add(title);
             panel2.add(panel);
             panel2.add(orderDetails);
             
       
       this.setTitle("E-Commerce System");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setIconImage(logo.getImage());
       this.getContentPane().setBackground(Color.WHITE);
       this.setResizable(false);
       this.setLayout(new BorderLayout());       
       this.add(panel2, BorderLayout.SOUTH);       
       this.setVisible(true);
       this.add(page4, BorderLayout.CENTER);
       this.pack();

   }
}