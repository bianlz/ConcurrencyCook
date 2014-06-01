package Test_5.test_1;

import java.util.ArrayList;
import java.util.List;

public class ProductListGenerator {
	public List<Product> generator(int size){
		List<Product> ret = new ArrayList<Product>();
		for(int i=0 ;i<size;i++){
			Product product = new Product();
			product.setName("Product "+i);
			product.setPrice(10);
			ret.add(product);
		}
		return ret;
	}
}
