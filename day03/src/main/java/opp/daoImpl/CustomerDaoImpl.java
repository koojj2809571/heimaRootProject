package opp.daoImpl;

import opp.dao.CustomerDao;
import opp.domain.Customer;
import opp.util.HibernateUtil;

import java.util.List;

/**
 * 客户的持久层实现类
 * @author zhy
 *
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> findAllCustomer() {
		return HibernateUtil.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public void saveCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().delete(findCustomerById(customer.getCus_id()));
	}

	@Override
	public void updateCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().update(customer);
	}

	@Override
	public Customer findCustomerById(Long cusId) {
		return HibernateUtil.getCurrentSession().get(Customer.class,cusId);
	}

}
