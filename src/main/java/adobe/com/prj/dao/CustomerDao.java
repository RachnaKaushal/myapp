package adobe.com.prj.dao;

import java.util.List;

import adobe.com.prj.entity.Customer;
import adobe.com.prj.entity.Product;

public interface CustomerDao {
	void addCustomer(Customer c);
	List<Customer> getCustomers();
	Customer getCustomer(String id);
}
