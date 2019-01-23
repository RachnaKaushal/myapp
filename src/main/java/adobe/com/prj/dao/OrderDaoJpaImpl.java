/**
 * 
 */
package adobe.com.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import adobe.com.prj.entity.Order;

/**
 * @author rakausha
 *
 */
@Repository
public class OrderDaoJpaImpl implements OrderDao {

	/* (non-Javadoc)
	 * @see adobe.com.prj.dao.OrderDao#getOrders()
	 */
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		TypedQuery<Order> query = em.createQuery("FROM Order", Order.class); // this is equivalent to slect o from order o here Order in query should be class that is case sensitive with first character in caps
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see adobe.com.prj.dao.OrderDao#placeOrder(adobe.com.prj.entity.Order)
	 */
	@Override
	public void placeOrder(Order order) {
		// TODO Auto-generated method stub
		em.persist(order);
	}

}
