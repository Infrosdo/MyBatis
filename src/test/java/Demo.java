import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import priv.huke.pojo.User;

import java.io.IOException;
import java.io.InputStream;

public class Demo {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void createSqlSessionFactory() throws IOException {
        // 配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "e");
    }

    // 根据 id查询用户信息
    @Test
    public void testSaveUser() {
        // 数据库会话实例
        SqlSession sqlSession = null;
        try {
            // 创建数据库会话实例sqlSession
            sqlSession = sqlSessionFactory.openSession();
            User user = new User();
            user.setName("张小明");
            user.setAge(45);
            int result = sqlSession.insert("user.insert", user);
            sqlSession.commit();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void testGenerateKey() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setName("张小明");
        user.setAge(45);
        int result = sqlSession.insert("user.generateKey", user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testFindUserById() {
        // 数据库会话实例
        SqlSession sqlSession = null;
        try {
            // 创建数据库会话实例sqlSession
            sqlSession = sqlSessionFactory.openSession();
            // 查询单个记录，根据用户id查询用户信息
            User user = sqlSession.selectOne("user.consSelect", 12);
            // 输出用户信息
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
