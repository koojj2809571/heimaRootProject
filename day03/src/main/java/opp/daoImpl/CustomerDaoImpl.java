package opp.daoImpl;

import opp.dao.CustomerDao;
import opp.domain.Customer;
import opp.util.CommonUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 客户的持久层实现类
 * @author zhy
 *
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> findAllCustomer() {
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = factory.openSession();
			return sqlSession.selectList("test.findAllCustomer");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sqlSession != null){
				sqlSession.close();
			}
		}
	}

	@Override
	public void saveCustomer(Customer customer) {
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = factory.openSession();
			sqlSession.insert("test.saveCustomer",customer);
			sqlSession.commit();
			CommonUtil.printString(customer.getCus_id());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sqlSession != null){
				sqlSession.close();
			}
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = factory.openSession();
			sqlSession.delete("test.deleteCustomer",customer.getCus_id());
			sqlSession.commit();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sqlSession != null){
				sqlSession.close();
			}
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = factory.openSession();
			sqlSession.update("test.updateCustomer",customer);
			sqlSession.commit();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public Customer findCustomerById(Long cusId) {
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = factory.openSession();
			return sqlSession.selectOne("test.findCustomerById",cusId);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sqlSession != null){
				sqlSession.close();
			}
		}
	}

}
