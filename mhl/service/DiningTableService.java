package mhl.service;

import mhl.dao.DiningTableDAO;
import mhl.domain.DiningTable;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class DiningTableService {
    //定义一个DiningTableDAO对象
    private DiningTableDAO diningTableDAO = new DiningTableDAO();
    //返回所有餐桌信息
    public List<DiningTable> List(){
        List<DiningTable> diningTables =
                diningTableDAO.queryMulti("select id,state from diningTable", DiningTable.class);
        return diningTables;
    }
    //根据id，查询对应的餐桌DiningTable对象，如果返回为空，代表餐桌不存在
    public DiningTable getDiningTableById(int id){
        return (DiningTable) diningTableDAO.querySingle("select * from diningTable where id = ?", DiningTable.class,id);
    }
    //如果餐桌可以预定，调用方法，对其状态进行更新（包括预定人的信息）
    public boolean orderDiningTable(int id,String orderName,String orderTel ){
        int update = diningTableDAO.update
                ("update diningTable set state = '已经预定',orderName=?, orderTel=? where id=?",
                        orderName, orderTel,id);
        return update > 0;
    }
    //需要提供一个方法 更新餐桌状态
    public boolean updateDiningTableState(int id,String state){
        int update = diningTableDAO.update("update diningTable set state=? where id=?", state, id);
        return update > 0;
    }
    //提供方法，将指定的餐桌设置为空闲状态
    public boolean updateDiningTableToFree(int id,String state){
        int update = diningTableDAO.update("update diningTable set state=?,orderName=' ',orderTel=' ' where id=?", state, id);
        return update > 0;
    }
}
