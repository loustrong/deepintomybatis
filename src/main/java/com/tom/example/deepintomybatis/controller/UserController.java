package com.tom.example.deepintomybatis.controller;

import com.tom.example.deepintomybatis.controller.utils.DynamicSQLTest;
import com.tom.example.deepintomybatis.controller.utils.ManyToManyTest;
import com.tom.example.deepintomybatis.controller.utils.OneToManyTest;
import com.tom.example.deepintomybatis.controller.utils.ProcedureTest;
import com.tom.example.deepintomybatis.dao.PersonDao;
import com.tom.example.deepintomybatis.entity.*;
import com.tom.example.deepintomybatis.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * UserController
 *
 * @author Tom on 2021/1/8
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @RequestMapping(value={"/getUser"})
    @ResponseBody
    public User getUser(HttpServletRequest request){
        return userService.getUserById(Integer.valueOf(request.getParameter("id")));
    }

    @RequestMapping(value={"/insertUser"})
    @ResponseBody
    public String insertUser(HttpServletRequest request){
        int maxId = userService.getMaxId();
//        int nextId = maxId + 1;
//        User user = new User(nextId,"guest", 33,"M");
        User user = new User("guest", 33,"M");
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.getMapper();
        sqlSession.insert("com.tom.example.deepintomybatis.dao.UserDao.save", user);
        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/saveUser"})
    @ResponseBody
    public String saveUser(HttpServletRequest request){

        User user = new User("jack", 33,"M");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("com.tom.example.deepintomybatis.dao.UserDao.saveUser", user);
        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/modifyUser"})
    @ResponseBody
    public String modifyUser(HttpServletRequest request){

//        User user = new User("jack", 33,"M");
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.insert("com.tom.example.deepintomybatis.dao.UserDao.saveUser", user);

        User user = sqlSession.selectOne("com.tom.example.deepintomybatis.dao.UserDao.getUserById",1);
        // 修改User对象的属性值
        user.setUserName("Tom");;
        user.setAge(25);
        // 修改User对象
        sqlSession.update("com.tom.example.deepintomybatis.dao.UserDao.modifyUser", user);

        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/removeUser"})
    @ResponseBody
    public String removeUser(HttpServletRequest request){

        int maxId = userService.getMaxId();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("com.tom.example.deepintomybatis.dao.UserDao.removeUser", maxId);
        sqlSession.commit();
        return "ok";
    }


    @RequestMapping(value={"/selectUserMap"})
    @ResponseBody
    public List selectUserMap(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 查询TB_USER表所有数据返回List集合,集合中的每个元素都是一个Map
        List<Map<String,Object>> list
                = sqlSession.selectList("com.tom.example.deepintomybatis.dao.UserDao.selectUserMap");
        // 遍历List集合，打印每一个Map对象
        list.forEach(row -> System.out.println(row));
        // 提交事务
        sqlSession.commit();
        return list;
    }
    //
    @RequestMapping(value={"/resultMap"})
    @ResponseBody
    public List resultMap(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 查询TB_USER表所有数据返回List集合,集合中的每个元素都是一个Map
        List<User2> user_list
                = sqlSession.selectList("com.tom.example.deepintomybatis.dao.User2Dao.selectUser2");
        // 遍历List集合，打印每一个Map对象
        user_list.forEach(user2 -> System.out.println(user2));
        // 提交事务
        sqlSession.commit();
        return user_list;
    }
    // selectStudent
    @RequestMapping(value={"/selectStudentResultMap"})
    @ResponseBody
    public List selectStudentResultMap(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 查询TB_USER表所有数据返回List集合,集合中的每个元素都是一个Student对象
        List<Student> student_list
                = sqlSession.selectList("com.tom.example.deepintomybatis.dao.UserDao.selectStudent");
        // 遍历List集合，打印每一个Student对象，该对象包含关联的Clazz对象
        student_list.forEach(stu -> System.out.println(stu));
        // 提交事务
        // 提交事务
        sqlSession.commit();
        return student_list;
    }


    // selectClazz
    @RequestMapping(value={"/selectClazz"})
    @ResponseBody
    public List selectClazz(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 查询TB_CLAZZ表所有数据返回List集合,集合中的每个元素都是一个Clazz对象
        List<Clazz> clazz_list
                = sqlSession.selectList("com.tom.example.deepintomybatis.dao.UserDao.selectClazz");
        // 遍历List集合，打印每一个Clazz对象和该Clazz关联的所有Student对象
        for(Clazz clazz : clazz_list){
            System.out.println(clazz);
            List<Student> student_list = clazz.getStudents();
            for(Student stu : student_list){
                System.out.println(stu.getId() + " " + stu.getName() + " " + stu.getSex() + " " + stu.getAge());
            }
        }
        // 提交事务
        sqlSession.commit();
        return clazz_list;
    }

    @RequestMapping(value={"/oneToOne"})
    @ResponseBody
    public String oneToOne(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得mapper接口的代理对象
        PersonDao pm = sqlSession.getMapper(PersonDao.class);
        // 直接调用接口的方法，查询id为1的Peson数据
        Person p = pm.selectPersonById(1);
        // 打印Peson对象
        System.out.println(p);
        // 打印Person对象关联的Card对象
        System.out.println(p.getCard());
        // 提交事务
        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/oneToMany"})
    @ResponseBody
    public String oneToMany(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        OneToManyTest t = new OneToManyTest();
        t.testSelectClazzById(sqlSession);
        System.out.println("=======================================================================");
        t.testSelectStudentById(sqlSession);
        // 提交事务
        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/manyToMany"})
    @ResponseBody
    public String manyToMany(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ManyToManyTest t = new ManyToManyTest();
        // 根据用户id查询用户，测试一对多
        t.testSelectUserById(sqlSession);
        System.out.println("------------------------------------------------------------------");
        // 根据订单id查询订单，测试多对多
        t.testSelectOrderById(sqlSession);
        // 提交事务
        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/dynamicSql"})
    @ResponseBody
    public String dynamicSql(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        DynamicSQLTest t = new DynamicSQLTest();

        t.testSelectEmployeeByIdLike(sqlSession);
        t.testSelectEmployeeByLoginLike(sqlSession);
        t.testSelectEmployeeChoose(sqlSession);

        // 没有使用where元素，如果没有传入state参数，会导致执行失败 的例子
        //  t.testFindEmployeeLike(sqlSession);

        t.testSelectEmployeeLike(sqlSession);
        t.testUpdateEmployeeIfNecessary(sqlSession);
        t.testSelectEmployeeIn(sqlSession);
        t.testSelectEmployeeLikeName(sqlSession);
        // 提交事务
        sqlSession.commit();
        return "ok";
    }
    @RequestMapping(value={"/callProcedure"})
    @ResponseBody
    public String callProcedure(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProcedureTest t = new ProcedureTest();
//         测试插入数据
			t.testSaveUser(sqlSession);
//         测试查询所有数据
			t.testSelectUser(sqlSession);
//         测试根据id查询对应的数据
			t.testSelectUserById(sqlSession);
//         测试修改数据
			t.testModifyUser(sqlSession);
        // 测试删除数据
        t.testRemoveUser(sqlSession);
        // 提交事务
        sqlSession.commit();
        return "ok";
    }



    @RequestMapping(value={"/transaction"})
    @ResponseBody
    public String transaction(HttpServletRequest request) throws Exception {
        userService.removeUser();
        return "ok";
    }
}
