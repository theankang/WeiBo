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
        cxt = new ClassPathXmlApplicationContext("beans.xml");

    }

    @Test
    public void test() {

        //1. ����һ�� SessionFactory ����
        SessionFactory sessionFactory = null;

        //1). ���� Configuration ����: ��Ӧ hibernate �Ļ���������Ϣ�� �����ϵӳ����Ϣ
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);

        //4.0 ֮ǰ��������
        //sessionFactory = configuration.buildSessionFactory();

        //4.x ����������
        //ServiceRegistry serviceRegistry =
        //new ServiceRegistryBuilder().applySettings(configuration.getProperties())
        //        .buildServiceRegistry();

        //5.x �е�API������
        //2). ����һ�� ServiceRegistry ����: hibernate 4.x ����ӵĶ���
        //hibernate ���κ����úͷ�����Ҫ�ڸö�����ע��������Ч.
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();

        //3).
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        //2. ����һ�� Session ����
        Session session = sessionFactory.openSession();

        //3. ��������
        Transaction transaction = session.beginTransaction();

        //4. ִ�б������
        //User user = new User("U0000000002", "Cube Entertainment", new Timestamp(new Date().getTime()));
        User user = new User();
        UserDAO userDao = null;
        userDao.addUser(user);


        //5. �ύ����
        transaction.commit();

        //6. �ر� Session
        session.close();

        //7. �ر� SessionFactory ����
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
