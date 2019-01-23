package adobe.com.prj;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import adobe.com.prj.dao.CustomerDaoJpaImpl;
import adobe.com.prj.dao.ProductDaoJpaImpl;
import adobe.com.prj.entity.Customer;
import adobe.com.prj.entity.Product;
import adobe.com.prj.service.OrderService;

public class TestClient {
	public static void main(String args[])
	{
		//ApplicationContext ctx = new ClassPatchXMLApplicationContext("app.xml") this tells to load things from xml based
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(OrderService.class);
		ctx.register(ProductDaoJpaImpl.class);
		ctx.register(AppConfig.class);
		ctx.register(CustomerDaoJpaImpl.class);
		ctx.refresh();
		//we are registering and telling this is an annotated class and registering the annotated resources
		
		OrderService service = ctx.getBean("orderService",OrderService.class); // only first character will be lower case
		Customer c = new Customer("xyz@gmail.com","xyz"); //product id = 0  at backend we are incrementing it automatically
		service.addCustomer(c);
		//giving id on own will confuse the persistance and exception will be raised there
		
		List<Customer> products = service.getCustomers();
		for(Customer prd : products)
		{
			System.out.println(prd.getFirstName());
		}
		
	}

}
