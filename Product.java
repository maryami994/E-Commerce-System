package e_commerce;

class Product{
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
