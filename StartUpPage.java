package e_commerce;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.border.Border;


public class StartUpPage extends JFrame implements ActionListener{
	JButton start;
	JLabel intro;
	ImageIcon logo;
	JTextField customerID, customerName, cAddress;
	String name,address;
	int ID;
	
	
	StartUpPage(){
		
		
		 logo =new ImageIcon("e-c.png");
		 Border logoBorder =BorderFactory.createLineBorder(Color.ORANGE,10);
		
		 intro=new JLabel();
		 intro.setText("Welcome to E-Commerce System! "+"\n"
				 		+" please enter your :");
		 intro.setIcon(logo);
		 intro.setHorizontalTextPosition(JLabel.CENTER);
		 intro.setVerticalTextPosition(JLabel.BOTTOM);
		 intro.setIconTextGap(-100);
		 intro.setFont(new Font("Bernard MT Condensed", Font.BOLD, 30));
		 intro.setBorder(logoBorder);
		 intro.setHorizontalAlignment(JLabel.CENTER);
		 intro.setVerticalAlignment(JLabel.CENTER);
		 intro.setBounds(100, 100, 150, 150);
		

		 customerName= new JTextField();
		 customerID= new JTextField();
		 cAddress=new JTextField();
		 
		 customerName.setText("Name");
		 cAddress.setText("Address");
		 customerID.setText("ID");
		 
		 customerName.setPreferredSize(new Dimension(250,40));		 
		 customerID.setPreferredSize(new Dimension(250,40));		 
		 cAddress.setPreferredSize(new Dimension(250,40));

		 
		 start= new JButton("Start Shopping ->");
		 start.addActionListener(this);
		
        JPanel textBoxPanel = new JPanel();
        textBoxPanel.add(customerID);
        textBoxPanel.add(customerName);
        textBoxPanel.add(cAddress);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(textBoxPanel);
        buttonPanel.add(start);
        
		this.setTitle("E-Commerce System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		this.getContentPane().setBackground(Color.WHITE);
		this.setResizable(false);		
		this.setLayout(new BorderLayout());
		this.add(intro, BorderLayout.CENTER);       
        this.add(buttonPanel, BorderLayout.SOUTH);
  		this.setSize(500, 600);
        this.setVisible(true); 
        this.pack();
		

        
    }
    public void actionPerformed(ActionEvent e){
    	
        if(e.getSource()==start){
        	
        	
           	if(customerID.getText().equals("ID")) {
        	    JOptionPane.showMessageDialog(this, "please make sure to enter your ID Correctly",
        	                                  "Hint!", JOptionPane.INFORMATION_MESSAGE);
        	}if(customerName.getText().equals("Hint!")) {
        	    JOptionPane.showMessageDialog(this, "please make sure to enter your name",
        	                                  "error", JOptionPane.INFORMATION_MESSAGE);
        	}if(cAddress.getText().equals("Address")) {
        		JOptionPane.showMessageDialog(this, "please make sure to enter your Address",
                        "Hint!", JOptionPane.INFORMATION_MESSAGE);
        	}else {  
        		name=customerName.getText();
            	address=cAddress.getText();
            	ID=Math.abs(Integer.parseInt(customerID.getText()));
        	 new Items(this.address,this.name,this.ID);
        	 this.dispose();
        	}
        	
        
       }
    }
}
