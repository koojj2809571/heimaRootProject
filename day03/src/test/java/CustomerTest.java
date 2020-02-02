import opp.config.SpringConfiguration;
import opp.domain.Customer;
import opp.service.CustomerService;
import opp.util.CommonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class CustomerTest {

    private ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    private CustomerService service = (CustomerService) context.getBean("customerService");

    @Test
    public void testFindAllCustomer() {
        List<Customer> list = service.findAllCustomer();
        for (Customer customer : list) {
            CommonUtil.printString(customer);
        }
    }

    @Test
    public void testFindCustomerById() {
        Customer customer = service.findCustomerById( 3L);
        CommonUtil.printString(customer.toString());
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setCus_name("上海仪电");
        service.saveCustomer(customer);
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer();
        customer.setCus_id(99L);
        service.deleteCustomer(customer);
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = service.findCustomerById(101L);
        customer.setCus_address("上海");
        customer.setCus_source("12");
        customer.setCus_level("34");
        customer.setCus_industry("IT外包");
        customer.setCus_phone("13648823227");
        CommonUtil.printString(customer);
        service.updateCustomer(customer);
    }
}
