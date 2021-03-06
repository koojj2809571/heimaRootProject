package opp.serviceImpl;

import opp.dao.CustomerDao;
import opp.domain.Customer;
import opp.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * 客户的业务层实现类
 *
 * @author zhy
 * <p>
 * 事务控制在业务层的
 */

/*****此类中我们使用抽取的思想，但是仍然会有很多重复代码*/
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDao.deleteCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public Customer findCustomerById(Long cusId) {
        return customerDao.findCustomerById(cusId);
    }

}
