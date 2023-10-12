package mhl.service;

import mhl.dao.BasicDAO;
import mhl.dao.BillDAO;
import mhl.dao.MultiTableDAO;
import mhl.domain.Bill;
import mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * @author HLxxx
 * @version 1.0
 */
public class BillService {
    private BillDAO billDAO = new BillDAO();
    private MultiTableDAO multiTableDAO = new MultiTableDAO();
    //定义MenuService
    private MenuService menuService = new MenuService();
    //定义diningTableService属性
    private DiningTableService diningTableService = new DiningTableService();

    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        //生成一个账单号，UUID
        String billID = UUID.randomUUID().toString();
        //将账单生成到bill表
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')", billID, menuId, nums,
                menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
        if (update <= 0) {
            return false;
        }
        //更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");
    }

    //返回所有账单，提供给view调用
    public List<Bill> list() {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }
    //返回所有账单并带有菜品名和价格，提供给view调用
    public List<MultiTableBean> list2() {
        return multiTableDAO.queryMulti("select bill.*, name,price from bill,menu where bill.menuId = menu.id",MultiTableBean.class);
    }

    //查看某个餐桌是否有未结账账单
    public boolean hasPayBillByDiningTableId(int diningTableId) {
        Bill bill = (Bill) billDAO.querySingle("select * from bill where diningTableId=? and state = '未结账' limit 0,1", Bill.class, diningTableId);
        return bill != null;
    }

    //完成结账（如果餐桌存在，并且该餐桌有未结账的账单）
    public boolean payBill(int diningTableId, String payMode) {
        //1.修改bill表
        int update = billDAO.update("update bill set state=? where diningTableId=? and state='未结账'", payMode, diningTableId);
        if (update < 0) {
            return false;
        }
        //2.修改diningTable表
        if (!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
            return false;
        }
        return true;
    }
}
