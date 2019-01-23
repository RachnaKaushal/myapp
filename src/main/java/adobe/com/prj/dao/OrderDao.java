package adobe.com.prj.dao;
import adobe.com.prj.entity.Order;
import java.util.List;

public interface OrderDao {
	List<Order> getOrders();
	void placeOrder(Order order);
}
