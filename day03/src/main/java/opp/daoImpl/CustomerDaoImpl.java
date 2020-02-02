package opp.daoImpl;

import opp.dao.CustomerDao;
import opp.domain.Customer;
import opp.util.MyBatisUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 客户的持久层实现类
 *
 * @author zhy
 */
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> findAllCustomer() {
        return MyBatisUtil.getCurrentSession().selectList("test.findAllCustomer");
    }

    @Override
    public void saveCustomer(Customer customer) {
        MyBatisUtil.getCurrentSession().insert("test.saveCustomer", customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        MyBatisUtil.getCurrentSession().delete("test.deleteCustomer", customer.getCus_id());
    }

    @Override
    public void updateCustomer(Customer customer) {
        MyBatisUtil.getCurrentSession().update("test.updateCustomer", customer);
    }

    @Override
    public Customer findCustomerById(Long cusId) {
        return MyBatisUtil.getCurrentSession().selectOne("test.findCustomerById", cusId);
    }

}
