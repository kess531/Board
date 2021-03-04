import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {

	@Autowired
	private DataSource ds;
	private SqlSessionFactory sqlFactory;
	
	@org.junit.Test
	public void test() throws Exception{
		try(Connection conn = ds.getConnection()) {
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void factoryTest() {
		System.out.println(sqlFactory);
	}
	
	@org.junit.Test
	public void sessionTest() throws Exception{
		try(SqlSession session = sqlFactory.openSession()) {
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
