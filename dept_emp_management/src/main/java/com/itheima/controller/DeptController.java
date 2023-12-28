package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("全ての部門データを検索します");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
@DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("IDに基づいて部門{}を削除します",id);
        deptService.delete(id);
        return Result.success();
    }
@PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新しい部門:{}情報を追加します",dept);
        deptService.add(dept);
        return Result.success();
    }
@GetMapping("{id}")
    public Result search(@PathVariable Integer id){
        log.info("IDに基づいて部門{}のデータを検索します",id);
        Dept dept = deptService.search(id);
        return Result.success(dept);
    }

@PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("IDに基づいて部門{}のデータを修正する",dept);
        deptService.update(dept);
        return Result.success();
    }
}
