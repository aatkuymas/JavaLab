import java.util.Comparator;

public class SortByLoyaltyPoints implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c1.loyaltyPoints, c2.loyaltyPoints);
    }
}
