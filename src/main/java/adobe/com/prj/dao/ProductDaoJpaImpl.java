/**
 * 
 */
package adobe.com.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import adobe.com.prj.entity.Product;

/**
 * @author rakausha
 *if multiple implementation give name to it
 */
@Repository
public class ProductDaoJpaImpl implements ProductDao {

	//repository will make an object with name of class with first character as lowercase
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		em.persist(p);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		TypedQuery<Product> query= em.createQuery("Select p FROM Product p", Product.class);	
				return query.getResultList();
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return em.find(Product.class, id);
	}
	

}
