import com.theankang.dao.UserDAO;
import com.theankang.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by jsdgw on 11/28/16.
 */
public class HibernateTest {

    private ApplicationContext cxt = null;

    {
        cxt = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

    @Test
    public void test() {

        //1. 创建一个 SessionFactory 对象
        SessionFactory sessionFactory = null;

        //1). 创建 Configuration 对象: 对应 hibernate 的基本配置信息和 对象关系映射信息
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);

        //4.0 之前这样创建
        //sessionFactory = configuration.buildSessionFactory();

        //4.x 中这样创建
        //ServiceRegistry serviceRegistry =
        //new ServiceRegistryBuilder().applySettings(configuration.getProperties())
        //        .buildServiceRegistry();

        //5.x 中的API叕改了
        //2). 创建一个 ServiceRegistry 对象: hibernate 4.x 新添加的对象
        //hibernate 的任何配置和服务都需要在该对象中注册后才能有效.
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();

        //3).
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        //2. 创建一个 Session 对象
        Session session = sessionFactory.openSession();

        //3. 开启事务
        Transaction transaction = session.beginTransaction();

        //4. 执行保存操作
        //User user = new User("U0000000002", "Cube Entertainment", new Timestamp(new Date().getTime()));
        User user = new User();
        UserDAO userDao = null;
        userDao.addUser(user);


        //5. 提交事务
        transaction.commit();

        //6. 关闭 Session
        session.close();

        //7. 关闭 SessionFactory 对象
        sessionFactory.close();
    }

    /*
     * This method is used for creating tables
     */
    @Test
    public void testAnnotation() throws SQLException {
        DataSource ds = cxt.getBean(DataSource.class);
        System.out.println(ds.getConnection());
    }


}
