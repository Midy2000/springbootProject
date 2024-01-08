package jiedai_app.service;

import jiedai_app.pojo.FirApp;
import jiedai_app.pojo.Loan;
import jiedai_app.pojo.PageBean;
import jiedai_app.pojo.PageOption;

import java.util.Map;

public interface LoanService {
    void createLoan(Loan loan);

    PageBean page(Integer pageNo, Integer pageSize);

    void updateLoan(String name, String sex, int id);

    void deleteLoan(int id);

    Map submit(int id);

    Map queryList(Integer pageNo,Integer pageSize);

    Map approveFirst(String flag, FirApp data);

    Map queryEndList(Integer pageNo,Integer pageSize);

    Map approveEnd(String flag, FirApp data);

    Map contractList(Integer pageNo,Integer pageSize);

    void generateContract(Loan loan);
}
