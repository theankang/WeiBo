//import com.theankang.dao.TopicDAO;
//import com.theankang.model.Topic;
//import org.hibernate.Session;
//import com.theankang.model.Message;
//import com.theankang.model.User;
//import com.theankang.service.RegisterService;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import com.theankang.dao.UserDAO;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by jsdgw on 11/29/16.
// */
//
//public class DAOImplTest {
//
//    private ApplicationContext ctx = null;
//    private RegisterService registerService = null;
//    private Session session;
//
//    {
//        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        registerService = ctx.getBean(RegisterService.class);
//    }
//
//    @Test
//    /*
//     * Success
//     */
//    public void testAddUser(){
//
//        User user = new User("U0000000002", "Cube Entertainment", new Timestamp(new Date().getTime()));
//        registerService.Register(user);
//
//    }
//
//    @Test
//    public void testUpdateUser() {
//        User user = new User("U0000000002", "Cube Entertainment", new Timestamp(new Date().getTime()));
//        //user.setUserNickname("JYP");
//        System.out.println(user.getUserNickname());
//        registerService.Register(user);
//    }
//
//    @Test
//    public void testDeleteUser(){
//        User user = new User("U0000000002", "Cube Entertainment", new Timestamp(new Date().getTime()));
//        registerService.Register(user);
//    }
//
//    @Test
//    public void testFindUserById() {
//        String userId = "U0000000001";
//        User user = registerService.findUser(userId);
//        System.out.println(user.toString());
//    }
//
//    @Test
//    public void testFindUserByNickname() {
//        UserDAO userDao = null;
//        String userNickname = "HyunA";
//        User user =  userDao.findUserByNickName(userNickname);
//        System.out.println(user.toString());
//    }
//
//    @Test
//    public void testFindAllMessage() {
//        User user =  new User();
//        user.setUserId("U0000000001");
//        List<Message> list = registerService.findAllMessageService(user);
//        System.out.println(list.toString());
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void testFindAllTopic() {
//        List<Topic> topicList = registerService.findAllTopic();
//        for(Topic t: topicList) {
//            System.out.println(t.toString());
//        }
//    }
//
//    @Test
//    public void testFindCommentById() {
//
//    }
//
//}
