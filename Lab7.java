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

        // Scanner for menu-driven interface
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Product");
            System.out.println("3. Add Order");
            System.out.println("4. Display Customers");
            System.out.println("5. Display Products");
            System.out.println("6. Display Orders");
            System.out.println("7. Sort Customers by Loyalty Points");
            System.out.println("8. Sort Products by Price");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Customer
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.next();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.next();
                    System.out.print("Enter Loyalty Points: ");
                    int loyaltyPoints = scanner.nextInt();
                    customers.add(new Customer(customerId, customerName, loyaltyPoints));
                    customerMap.put(customerId, new Customer(customerId, customerName, loyaltyPoints));
                    break;
                case 2:
                    // Add Product
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.next();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.next();
                    System.out.print("Enter Product Price: ");
                    double productPrice = scanner.nextDouble();
                    products.add(new Product(productId, productName, productPrice));
                    productMap.put(productId, new Product(productId, productName, productPrice));
                    break;
                case 3:
                    // Add Order
                    System.out.print("Enter Order ID: ");
                    String orderId = scanner.next();
                    System.out.print("Enter Customer ID: ");
                    String orderCustomerId = scanner.next();
                    System.out.print("Enter Product IDs (comma separated): ");
                    scanner.nextLine(); // consume the newline character
                    String productIdsInput = scanner.nextLine();
                    List<String> orderProductIds = Arrays.asList(productIdsInput.split(","));
                    System.out.print("Enter Delivery Date: ");
                    String deliveryDate = scanner.next();
                    orders.add(new Order(orderId, orderCustomerId, orderProductIds, deliveryDate));
                    break;
                case 4:
                    // Display Customers
                    System.out.println("Customers:");
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                case 5:
                    // Display Products
                    System.out.println("Products:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 6:
                    // Display Orders
                    System.out.println("Orders:");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;
                case 7:
                    // Sort and Display Customers by Loyalty Points
                    sortedCustomers.clear();
                    sortedCustomers.addAll(customers);
                    System.out.println("Sorted Customers by Loyalty Points:");
                    for (Customer customer : sortedCustomers) {
                        System.out.println(customer);
                    }
                    break;
                case 8:
                    // Sort and Display Products by Price
                    sortedProducts.clear();
                    sortedProducts.addAll(products);
                    System.out.println("Sorted Products by Price:");
                    for (Product product : sortedProducts) {
                        System.out.println(product);
                    }
                    break;
                case 9:
                    // Exit
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}