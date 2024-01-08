package jiedai_app.controller;

import jiedai_app.pojo.*;
import jiedai_app.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
public class LoanController {
    @Autowired
    private LoanService loanService;
    @PostMapping("/api/loan/create")
    public Result createLoan(@RequestBody Loan loan){
        loanService.createLoan(loan);
        return Result.success("创建申请成功");
    }
    @GetMapping("/api/loan/list")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNo,@RequestParam(defaultValue = "10")  Integer pageSize){
        PageBean pageBean = loanService.page(pageNo,pageSize);
        return Result.success(pageBean);
    }
    @PutMapping("/api/loan/update")
    public Result updateLoan(@RequestBody Loan loan){
        loanService.updateLoan(loan.getName(),loan.getSex(),loan.getId());
        return Result.success("更新成功");
    }
    @DeleteMapping("/api/loan/delete/{id}")
    public Result deleteLoan(@PathVariable int id){
        loanService.deleteLoan(id);
        return Result.success("删除成功");
    }
    @PostMapping("/api/loan/submitToApprove")
    public Result submit(@RequestBody Loan loan){
        Map map = loanService.submit(loan.getId());
        return Result.success(map);
    }
    @GetMapping("/api/approve/first/list")
    public Result queryList(@RequestParam Integer pageNo,@RequestParam Integer pageSize){
        Map map = loanService.queryList(pageNo,pageSize);
        return Result.success(map);
    }
    @PostMapping("/api/approve/first/{flag}")
    public Result approveFirst(@PathVariable String flag, @RequestBody FirApp data){
        Map map = loanService.approveFirst(flag, data);
        return  Result.success(map);
    }
    @GetMapping("/api/approve/end/list")
    public Result queryEndList(@RequestParam Integer pageNo,@RequestParam Integer pageSize){
        Map map = loanService.queryEndList(pageNo,pageSize);
        return Result.success(map);
    }
    @PostMapping("/api/approve/end/{flag}")
    public Result approveEnd(@PathVariable String flag, @RequestBody FirApp data){
        Map map = loanService.approveEnd(flag, data);
        return  Result.success(map);
    }
    @GetMapping("/api/contract/list")
    public Result contractList(@RequestParam Integer pageNo,@RequestParam Integer pageSize){
        Map map = loanService.contractList(pageNo,pageSize);
        return Result.success(map);
    }
    @PostMapping("/api/contract/createFile")
    public Result generateContract(@RequestBody Loan loan){
        loanService.generateContract(loan);
        System.out.println(loan);
        return Result.success("文件创建成功");
    }
}
