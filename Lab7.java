import java.util.*;



// Customer Class
class Customer {
    protected String id;
    protected String name;
    protected int loyaltyPoints;

    public Customer(String id, String name, int loyaltyPoints) {
        this.id = id;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    public void updateDetails(String name, int loyaltyPoints) {
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{id='" + id + "', name='" + name + "', loyaltyPoints=" + loyaltyPoints + "}";
    }
}

// Product Class
class Product {
    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void updateDetails(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', price=" + price + "}";
    }
}

// Order Class
class Order {
    protected String orderId;
    protected String customerId;
    protected List<String> productIds;
    protected String deliveryDate;

    public Order(String orderId, String customerId, List<String> productIds, String deliveryDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productIds = productIds;
        this.deliveryDate = deliveryDate;
    }

    public void updateOrder(List<String> productIds, String deliveryDate) {
        this.productIds = productIds;
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{orderId='" + orderId + "', customerId='" + customerId + "', productIds=" + productIds + ", deliveryDate='" + deliveryDate + "'}";
    }
}


public class Lab7 {
    public static void main(String[] args) {
        // ArrayLists to store data
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        // HashMap for quick retrieval
        HashMap<String, Customer> customerMap = new HashMap<>();
        HashMap<String, Product> productMap = new HashMap<>();

        // Adding Customers
        Customer c1 = new Customer("C001", "Alice", 100);
        Customer c2 = new Customer("C002", "Bob", 150);
        customers.add(c1);
        customers.add(c2);
        customerMap.put(c1.id, c1);
        customerMap.put(c2.id, c2);

        // Adding Products
        Product p1 = new Product("P001", "Laptop", 800.00);
        Product p2 = new Product("P002", "Phone", 500.00);
        products.add(p1);
        products.add(p2);
        productMap.put(p1.id, p1);
        productMap.put(p2.id, p2);

        // HashSet for unique products
        HashSet<String> uniqueProductSet = new HashSet<>();
        uniqueProductSet.add(p1.id);
        uniqueProductSet.add(p2.id);

        // Adding Orders
        Order o1 = new Order("O001", c1.id, new ArrayList<>(uniqueProductSet), "2024-12-20");
        orders.add(o1);

        // TreeSet for sorted products and customers
        TreeSet<Product> sortedProducts = new TreeSet<>(new SortByPrice());
        sortedProducts.addAll(products);

        TreeSet<Customer> sortedCustomers = new TreeSet<>(new SortByLoyaltyPoints());
        sortedCustomers.addAll(customers);

        // Display Data
        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println("\nProducts:");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("\nOrders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.println("\nSorted Products by Price:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }

        System.out.println("\nSorted Customers by Loyalty Points:");
        for (Customer customer : sortedCustomers) {
            System.out.println(customer);
        }
    }
}
