package opp.test;

import opp.config.SpringConfiguration;
import opp.domain.Customer;
import opp.service.CustomerService;
import opp.util.CommonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class CustomerServiceTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CustomerService service = (CustomerService) context.getBean("customerService");
        List<Customer> list = service.findAllCustomer();
        for (Customer customer : list){
            CommonUtil.printString(customer);
        }
    }
}
