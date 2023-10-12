package mhl.service;

import mhl.dao.MenuDAO;
import mhl.domain.Menu;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 * 完成对menu表的各种操作
 */
public class MenuService {
    //定义MenuDAO属性
    private MenuDAO menuDAO = new MenuDAO();
    //返回所有菜品，给界面使用
    public List<Menu>list(){
        return menuDAO.queryMulti("select * from menu",Menu.class);
    }
    //需要方法，根据ID，返回menu对象
    public Menu getMenuById(int id){
        return (Menu) menuDAO.querySingle("select * from menu where id = ?",Menu.class,id);
    }
}
