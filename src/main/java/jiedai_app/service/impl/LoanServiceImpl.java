package jiedai_app.service.impl;

import jiedai_app.mapper.LoanMapper;
import jiedai_app.pojo.FirApp;
import jiedai_app.pojo.Loan;
import jiedai_app.pojo.PageBean;
import jiedai_app.pojo.PageOption;
import jiedai_app.service.LoanService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanMapper loanMapper;
    public void createLoan(Loan loan){
        loanMapper.createLoan(loan);
    }
    public PageBean page(Integer pageNo,Integer pageSize){
        int count = loanMapper.count();
        Integer start =(pageNo-1)*pageSize;
        List<Loan> list = loanMapper.page(start, pageSize);
        Map<String,List> map=new HashMap<>();
        map.put("data",list);
        int pages = (count/pageSize)+1;
        PageBean pageBean =new PageBean(count,pages,pageSize.toString(),map);
        return pageBean;
    }
    public void updateLoan(String name,String sex,int id){
        loanMapper.updateLoan(name,sex,id);
    }
    public void deleteLoan(int id){
        loanMapper.deleteLoan(id);
    }
    public Map submit(int id){
        Map<String,Object> map =new HashMap<>();
        map.put("info","提交成功");
        map.put("from",0);
        map.put("to",1);
        loanMapper.submit(id);
        return map;
    }
    public Map queryList(Integer pageNo,Integer pageSize){
        Integer start =(pageNo-1)*pageSize;
        int count1 = loanMapper.count1();
        int pages = (count1/pageSize)+1;
        Map<String,Object> map =new HashMap<>();
        Map<String,Object> map1 =new HashMap<>();
        List<Loan> list = loanMapper.queryList(start, pageSize);
        map1.put("data",list);
        map.put("data",map1);
        map.put("rows",count1);
        map.put("pages",pages);
        return map;
    }
    public Map approveFirst(String flag, FirApp data){
        Map<String,Object> map = new HashMap<>();
        if (flag.equals("pass")){
            loanMapper.approvePass(data.getLoanId());
            map.put("info","更新审批状态成功");
            map.put("from",1);
            map.put("to",2);
        } else if (flag.equals("reject")){
            loanMapper.approveReject(data.getLoanId());
            map.put("info","更新审批状态失败");
            map.put("from",1);
            map.put("to",3);
        } else {
            loanMapper.approveFirst(data.getLoanId());
            map.put("info","出错了");
            map.put("from",1);
            map.put("to",7);
        }
        return  map;
    }
    public Map queryEndList(Integer pageNo,Integer pageSize){
        Integer start =(pageNo-1)*pageSize;
        int count1 = loanMapper.count2();
        int pages = (count1/pageSize)+1;
        Map<String,Object> map =new HashMap<>();
        Map<String,Object> map1 =new HashMap<>();
        List<Loan> list = loanMapper.queryEndList(start, pageSize);
        map1.put("data",list);
        map.put("data",map1);
        map.put("rows",count1);
        map.put("pages",pages);
        return map;
    }
    public Map approveEnd(String flag, FirApp data){
        Map<String,Object> map = new HashMap<>();
        if (flag.equals("pass")){
            loanMapper.approveEndPass(data.getLoanId());
            map.put("info","更新审批状态成功");
            map.put("from",4);
            map.put("to",5);
        } else if (flag.equals("reject")){
            loanMapper.approveEndReject(data.getLoanId());
            map.put("info","更新审批状态失败");
            map.put("from",4);
            map.put("to",6);
        } else {
            loanMapper.approveEnd(data.getLoanId());
            map.put("info","出错了");
            map.put("from",4);
            map.put("to",7);
        }
        return  map;
    }
    public Map contractList(Integer pageNo,Integer pageSize){
        Integer start =(pageNo-1)*pageSize;
        int count1 = loanMapper.count3();
        int pages = (count1/pageSize)+1;
        Map<String,Object> map =new HashMap<>();
        Map<String,Object> map1 =new HashMap<>();
        List<Loan> list = loanMapper.contractList(start, pageSize);
        map1.put("data",list);
        map.put("data",map1);
        map.put("rows",count1);
        map.put("pages",pages);
        return map;
    }
    public void generateContract(Loan loan){
        loanMapper.generateContract(loan.getId());
    }
}
