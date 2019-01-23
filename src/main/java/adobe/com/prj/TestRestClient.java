package adobe.com.prj;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import adobe.com.prj.entity.Product;

public class TestRestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product> response
		  = restTemplate.getForEntity("http://localhost:8080/api/products/6", Product.class);//for this uri convert to product obj and give back a result
		Product p = response.getBody();
		System.out.println(p.getName());
		
		RestTemplate restTemplate2 = new RestTemplate();
		 
		HttpEntity<Product> request = new HttpEntity<>(new Product(0,"a",100,100));
		Product prd = restTemplate2.postForObject("http://localhost:8080/api/products", request, Product.class);
		//sending an object to the rest template
		System.out.println(prd.getName());
	}

}
