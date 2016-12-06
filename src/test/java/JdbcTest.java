package test.java;

import org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by jsdgw on 11/26/16.
 */
public class JdbcTest {

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;


    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource ds = ctx.getBean(DataSource.class);
        System.out.println(ds.getConnection());
    }

    @Test
    public void testUpdate() {
        String sql = "insert into user_table (user_id, user_nickname, registration_date) values('U0000000001', 'HyunA', '2016-11-27 22:13:05');";
        jdbcTemplate.execute(sql);
        System.out.println("----------------------finished-----------------------");
    }
}
