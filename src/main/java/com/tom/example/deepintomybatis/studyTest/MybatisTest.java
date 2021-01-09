package com.tom.example.deepintomybatis.studyTest;

import com.tom.example.deepintomybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * MybatisTest
 *
 * @author Tom on 2021/1/9
 */
public class MybatisTest {
    public static void main(String[] args) {
        SqlSession sqlSesion = null;
        try(// 读取mybatis-config.xml文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            ){
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSesion = sqlSessionFactory.openSession();
            // 创建user对象
            User user = new User(1,"ligang",26,"F");
            //插入数据
            sqlSesion.insert("com.tom.example.deepintomybatis.dao.UserDao.save", user);
            sqlSesion.commit();
        }catch (Exception e){
            sqlSesion.rollback();
            e.printStackTrace();
        }finally {
            try{
                if(sqlSesion != null) sqlSesion.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
