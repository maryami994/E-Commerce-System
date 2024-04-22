/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecommercesystem;
import java.util.Scanner;

/**
 *
 * @author marya
 */
public class EcommerceSystem {

    public static void main(String[] args) {
        ElectronicProduct phone =new ElectronicProduct("Samsung",1,1,599.9f,"Smartphone");
        ClothingProduct tShirt=new ClothingProduct("medium","cotton",2,19.99f,"T-shirt");
        BookProduct book=new BookProduct("O'Reilly","X Publicatiions",3,39.99f,"oop");
        Scanner in =new Scanner(System.in);
        System.out.println("""
                           welcome to E_Commerce System! 
                           please enter you ID:""");
        int c_Id=in.nextInt();
        in.nextLine();
        System.out.println("please enter your name:");
        String name=in.nextLine();
        System.out.println("please enter your address:");
        String address=in.nextLine();
        customer customer1=new customer(name, address,c_Id);
        System.out.println("How many products do you want to order?");
        int nProducts=in.nextInt();
        cart cart1=new cart(c_Id, nProducts);
            for(int i=0;i<cart1.getnProducts();i++){
                System.out.println("""
                               which product would you like to add?
                                1-Smartphone, 2-T-Shirt, 3-OOP""");
                int choice=in.nextInt();
                switch(choice){
                    case 1:cart1.addProduct(phone);
                        break;
                    case 2:cart1.addProduct(tShirt);
                        break;
                    case 3:cart1.addProduct(book);
                        break;
                    default:
                        System.out.println("invalid number choice");
                        i--;
                }
            }    
 
        boolean flag1;
        do{
        flag1=false;
        System.out.println("you're total is"+cart1.calculateprice()+"$"+
                            "\n would you like to place an order? 1-yes, 2-no, any other number to end shopping");
        int decision=in.nextInt();
        switch (decision) {
            case 1:
                Order order = cart1.placeOrder(1, c_Id);
                    order.setTotalPrice(cart1);
                    order.printOrderInfo(); 
                    System.out.println("delivery info:\n"+
                            "Name:"+customer1.getName()+"\n"+
                            "Address:"+customer1.getAddress());
            break;
            case 2:
                flag1=true;
                System.out.println("""
                                    Do you want to delete an item in your cart?
                                    1-yes, 2- no""");
                int decision2=in.nextInt();
                boolean flag2;
                do{
                    flag2=false;
                if(decision2==1){
                    System.out.println("""
                                        please enter the product you want to delete:
                                        1-Smartphone, 2-T-Shirt, 3-OOP""");
                    int decision3=in.nextInt();/////
                    switch(decision3){
                        case 1 :
                                if(cart1.inTheOrder(phone)){
                                cart1.removeProduct(cart1.getProducts(),phone);
                                cart1.calculateprice();
                                }else{
                                    System.out.println("product is not in the cart!");
                                    flag2=true;
                                }
                                break;
                        case 2:
                                if(cart1.inTheOrder(tShirt)){
                                cart1.removeProduct(cart1.getProducts(),tShirt);
                                cart1.calculateprice();
                                }else{
                                    System.out.println("product is not in the cart!");
                                    flag2=true;
                                }
                                break;
                        case 3 :
                                if(cart1.inTheOrder(book)){
                                cart1.removeProduct(cart1.getProducts(),book);
                                cart1.calculateprice();
                                }else{
                                    System.out.println("product is not in the cart!");
                                    flag2=true;
                                }
                                break;
                        default: System.out.println("invalid number choice");
                                 flag2=true;
                    }
                }
                }while(flag2);
                    System.out.println("""
                                        Do you want to add another product?
                                        1-yes, 2-no""");
                    int decision4=in.nextInt();
                    if(decision4==1){
                        boolean flag3;
                    do{
                        flag3=false;
                        System.out.println("""
                                            which product would you like to add?
                                            1-Smartphone, 2-T-Shirt, 3-OOP""");
                        int choice=in.nextInt();
                        switch(choice){
                            case 1: cart1.addProduct2(cart1.getProducts(),phone);
                                      cart1.calculateprice();
                                      break;
                            case 2 :  cart1.addProduct2(cart1.getProducts(),tShirt);
                                      cart1.calculateprice();
                                      break;
                            case 3 :  cart1.addProduct2(cart1.getProducts(),book);
                                      cart1.calculateprice();
                                      break;
                            default : System.out.println("invalid number choice, please enter a proper number.");
                                      flag3=true;
                        }
                    }while(flag3);
                    }
                break;
                 default:
                    System.out.println("we'll be waiting for your return!");
                    break;
        }
        }while(flag1);
    }
}
