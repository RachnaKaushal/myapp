package adobe.com.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import adobe.com.prj.entity.Customer;
import adobe.com.prj.entity.Product;
import adobe.com.prj.service.OrderService;

@RestController
public class CustomerController {

	@Autowired
	private OrderService orderservice;
	
	@RequestMapping(value="customers", method= RequestMethod.GET)
	public @ResponseBody List<Customer> getCustomers(){
		return orderservice.getCustomers();
	}
	
	@RequestMapping(value="customers/{id}",method=RequestMethod.GET)
	public @ResponseBody Customer getCustomer(@PathVariable("id")String id) {
		return orderservice.getCustomer(id);		
	}
	
	@RequestMapping(value="customers",method=RequestMethod.POST)
	public ResponseEntity<Customer> addProduct(@RequestBody Customer p){
		orderservice.addCustomer(p);
		return new ResponseEntity<Customer>(p,HttpStatus.CREATED);
	}
}
