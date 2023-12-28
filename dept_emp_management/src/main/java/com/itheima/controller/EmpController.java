package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
//        if (page == null) page = 1;
//        if (pageSize == null) pageSize =10;
        log.info("ページング検索,パラメータ:{}{}{}{}{}{}", page, pageSize,name,gender,begin,end);
        PageBean pageBean = empService.page(page, pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("番号に基づいて従業員{}情報を削除する",ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("従業員情報を追加する{}",emp);
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getByID(@PathVariable Integer id){
        log.info("番号に基づいて従業員{}情報を表示する",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("従業員{}情報を修正する",emp.getId());
        empService.update(emp);

        return Result.success();
    }
}
