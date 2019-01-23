/**
 * 
 */
package adobe.com.prj.dao;
import adobe.com.prj.entity.*;
import java.util.List;

/**
 * @author rakausha
 *
 */
public interface ProductDao {
	void addProduct(Product p);
	List<Product> getProducts();
	Product getProduct(int id);

}
