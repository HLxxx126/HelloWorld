package com.hspedu.chapter25.dao_.test;

import com.hspedu.chapter25.dao_.dao.ActorDAO;
import com.hspedu.chapter25.dao_.dormain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class TestDAO {
    //测试ActorDAO对actor表的crud操作
    @Test
    public void testActorDAO(){
        ActorDAO actorDAO = new ActorDAO();
        //1.查询
        List<Actor> actors =
                actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("------查询结果------");
        for (Actor actor :actors) {
            System.out.println(actor);
        }
        //2.查询单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 1);
        System.out.println("------查询单行结果------");
        System.out.println(actor);
        //3.查询单行单列
        Object o = actorDAO.queryScalar("select * from actor where id = ?", 1);
        System.out.println("------查询单行单列值------");
        System.out.println(o);
        //4.dml操作 insert,update,delete
        int update = actorDAO.update
                ("insert into actor values(null,'张无忌','男','2000-11-11','112')");
        System.out.println(update > 0 ? "执行成功" : "执行没有影响" );
    }
}
