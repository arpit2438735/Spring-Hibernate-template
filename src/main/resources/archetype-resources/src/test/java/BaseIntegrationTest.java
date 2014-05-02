#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )



import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import com.stmicro.eot.persistence.IDataAccessObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:hibernate-config.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public abstract class BaseIntegrationTest
{
	@Autowired
	private IDataAccessObject dao;
	
	@Test
	public void testContextLoading()
	{
		Assert.assertNotNull(this.dao);
	}
	/**
	 * Example of Writing Test case
	 *	public void saveorUpdateDao(Object model)
	 *	{
	 *		dao.saveOrUpdate(model);
	 *	}
	 *	
	 *	public <T> Collection<T> loadAllDao(Class<T> C)
	 *	{
	 *		return dao.loadAll(C);
	 *	}
	*/
}