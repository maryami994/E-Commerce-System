/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommercesystem;

/**
 *
 * @author marya
 */
class Product {
    private int productId;
    private float price;
    private String name;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = Math.abs(productId);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = Math.abs(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
    }
    
    public Product (int productId, float price, String name) {
        this.productId = Math.abs(productId);
        this.price = Math.abs(price);
        this.name = name;
    }

    @Override
    public String toString() {
        return  " Product name=" + name  + ", price=" + price +"$";
    }
    
    
}
class ElectronicProduct extends Product{
    private String brand;
    private int warrantyPeriod;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }

    public ElectronicProduct(String brand, int warrantyPeriod) {
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public ElectronicProduct(String brand, int warrantyPeriod, int productId, float price, String name) {
        super(productId, price, name);
        this.brand = brand;
        this.warrantyPeriod = Math.abs(productId);
    }
    
}
class ClothingProduct extends Product{
    private String size;
    private String fabric;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public ClothingProduct(String size, String fabric) {
        this.size = size;
        this.fabric = fabric;
    }

    public ClothingProduct(String size, String fabric, int productId, float price, String name) {
        super(productId, price, name);
        this.size = size;
        this.fabric = fabric;
    }
}

class BookProduct extends Product{
    private String author;
    private String publisher;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BookProduct(String author, String publisher) {
        this.author = author;
        this.publisher = publisher;
    }

    public BookProduct(String author, String publisher, int productId, float price, String name) {
        super(productId, price, name);
        this.author = author;
        this.publisher = publisher;
    }
}

class customerId{
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public customerId() {
    }

    public customerId(int costumerId) {
        this.customerId = Math.abs(customerId);
    }

}

class customer extends customerId{
    private String name;
    private String address;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public customer() {
    }

    public customer(String name, String address, int customerId) {
        super(customerId);
        this.name = name;
        this.address = address;
    }

}

class cart extends customerId{
    private int nProducts;
    private Product [] products;
    private int counter;

    public cart() {
        counter=0;
    }

    public cart( int customerId, int nProducts) {
        super(customerId);
        this.nProducts=Math.abs(nProducts);
        this.products=new Product[this.nProducts];
        counter=0;
    }
       
    public int getnProducts() {
        return nProducts;
    }

    public void setnProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    
    public Product[] getProducts() {
        return products;
    }
    
    public void addProduct(Product product){
        if(counter<nProducts){
            products[counter]= product;
            counter ++;
        }else
            System.out.println("cart is full");
    }
    public Product[] addProduct2(Product[]products,Product product){
         Product [] products2=new Product[products.length+1];
         int i;
         for(i=0;i<products.length;i++){
             products2[i]=products[i];
            }
            products2[i]=product;
            setProducts(products2);
            setnProducts(products2.length);
         return getProducts();
    }
    public Product[] removeProduct(Product[]products,Product product) {//////////////
        if (products == null || products.length == 0) {
            return products;
        }else{
        Product [] products2=new Product[products.length-1];
        int j=0;
        boolean found=false;
        for(int i=0;i<products.length;i++){
            if(!found&&products[i]==product){
                found=true;
            }else{
                products2[j]=products[i];
                j++;
            }
        }
        setProducts(products2);
        setnProducts(products2.length);
        return products2;
        }
   }

    public boolean inTheOrder(Product product){
        for(Product i:products){
            if(i!=null && i.getName().equals(product.getName()) && i.getProductId()==product.getProductId())
                return true;
        }
        return false;
    }
    public float calculateprice(){
        float sum =0;
        for(Product i:products){
            if(i!=null)
           sum+= i.getPrice();
        }
        return sum;
    }
    public Order placeOrder(int oId , int customerId){
        Order order=new Order(oId,products,customerId);
        return order;      
    }
    
}

class Order extends cart{
    private int orderId;
    private float totalPrice;
    
    public Order() {
    }
    
    public Order(int orderId, Product[]products, int customerId) {
        super.setCustomerId(customerId);
        this.orderId = orderId;
        super.setProducts(products);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(cart cart) {
        this.totalPrice = cart.calculateprice();
    }
    
    public void printOrderInfo(){
        System.out.println("here's your order summary");
        System.out.println("Order Id: "+ getOrderId());
        System.out.println("Customer Id: "+ getCustomerId() );
        System.out.println("products details:");
        for(Product i: getProducts()){
            System.out.println(i.toString());
        }
        System.out.println("Total order price: "+ getTotalPrice() +"$");
        
    }    
}
