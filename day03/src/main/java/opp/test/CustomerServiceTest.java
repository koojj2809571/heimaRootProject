package opp.test;

import opp.domain.Customer;
import opp.serviceImpl.CustomerServiceImpl;
import opp.util.CommonUtil;

import java.util.List;

public class CustomerServiceTest {
    public static void main(String[] args) {
        CustomerServiceImpl service = new CustomerServiceImpl();
        List<Customer> list = service.findAllCustomer();
        for (Customer customer : list){
            CommonUtil.printString(customer);
        }
    }
}
