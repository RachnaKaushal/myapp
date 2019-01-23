package adobe.com.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import adobe.com.prj.entity.Customer;
import adobe.com.prj.entity.Product;

@Repository
public class CustomerDaoJpaImpl implements CustomerDao{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void addCustomer(Customer c) {
		// TODO Auto-generated method stub
		em.persist(c);
		
	}

	@Override
	public List<Customer> getCustomers() {
		TypedQuery<Customer> query= em.createQuery("Select c FROM Customer c", Customer.class);	
		return query.getResultList();
	}

	@Override
	public Customer getCustomer(String id) {
		// TODO Auto-generated method stub
		return em.find(Customer.class,id);
	}

}
