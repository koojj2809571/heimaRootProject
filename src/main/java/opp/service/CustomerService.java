package opp.service;

import opp.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomer();

    void saveCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer findCustomerById(Long cusId);
}
