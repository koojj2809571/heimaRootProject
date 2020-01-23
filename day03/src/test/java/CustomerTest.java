import opp.domain.Customer;
import opp.serviceImpl.CustomerServiceImpl;
import opp.util.CommonUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerTest {

    @Test
    public void testFindAllCustomer() {
        CustomerServiceImpl service = new CustomerServiceImpl();
        List<Customer> list = service.findAllCustomer();
        for (Customer customer : list) {
            CommonUtil.printString(customer);
        }
    }

    @Test
    public void testFindCustomerById() {
        CustomerServiceImpl service = new CustomerServiceImpl();
        Customer customer = service.findCustomerById( 3L);
        CommonUtil.printString(customer.toString());
    }

    @Test
    public void testSaveCustomer() {
        CustomerServiceImpl service = new CustomerServiceImpl();
        Customer customer = new Customer();
        customer.setCus_name("上海仪电");
        service.saveCustomer(customer);
    }

    @Test
    public void testDeleteCustomer() {
        CustomerServiceImpl service = new CustomerServiceImpl();
        Customer customer = new Customer();
        customer.setCus_id(98L);
        service.deleteCustomer(customer);
    }

    @Test
    public void testUpdateCustomer() {
        CustomerServiceImpl service = new CustomerServiceImpl();
        Customer customer = service.findCustomerById(99L);
        customer.setCus_address("上海");
        customer.setCus_source("12");
        customer.setCus_level("34");
        customer.setCus_industry("IT外包");
        customer.setCus_phone("13648823227");
        CommonUtil.printString(customer);
        service.updateCustomer(customer);
    }
}
