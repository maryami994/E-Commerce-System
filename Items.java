package e_commerce;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;

public class Items extends JFrame implements ActionListener {
	public int nProducts;
	JTextField nProductsIN;
	JButton next;
	ImageIcon logo;
	JLabel page2;
	String name,address;
	int ID;
	
	int getNProducts() {
		return nProducts;
	}
	
	Items(String address,String name, int ID){
		 
		 this.address=address;
		 this.name=name;
		 this.ID=ID;
		 
		 logo =new ImageIcon("e-c.png");
		 Border logoBorder =BorderFactory.createLineBorder(Color.ORANGE,10);
		 
		 page2= new JLabel();
	    	page2.setText("please enter the number of products you're willing to add to your cart:");
	    	page2.setIcon(logo);
	    	page2.setHorizontalTextPosition(JLabel.CENTER);
	    	page2.setVerticalTextPosition(JLabel.BOTTOM);
	    	page2.setIconTextGap(-100);
	    	page2.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
	    	page2.setBorder(logoBorder);
	    	page2.setHorizontalAlignment(JLabel.CENTER);
	    	page2.setVerticalAlignment(JLabel.CENTER);
	    	page2.setBounds(100, 100, 150, 150);
		 
	    	
		nProductsIN = new JTextField();
		nProductsIN.setPreferredSize(new Dimension(250,40));
		
		
		next = new JButton("Start adding to cart->");
		next.addActionListener(this);
		
		JPanel bottomPanel = new JPanel();
        bottomPanel.add(nProductsIN);
        bottomPanel.add(next);
		
		this.setTitle("E-Commerce System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		this.getContentPane().setBackground(Color.WHITE);		
		this.setResizable(false);
		this.setLayout(new BorderLayout());	
        this.setVisible(true); 
        this.add(page2,BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.pack();
		
	}
	public void actionPerformed(ActionEvent e){
        if(e.getSource()==next){
        	nProducts=Math.abs(Integer.parseInt(nProductsIN.getText()));
        	new Window2(this.getNProducts(),this.address,this.name,this.ID);
        	
        	this.dispose();
        	
        }
    }

}
