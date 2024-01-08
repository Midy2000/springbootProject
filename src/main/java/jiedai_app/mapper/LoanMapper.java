package jiedai_app.mapper;

import jiedai_app.pojo.Loan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoanMapper {
    @Insert("INSERT INTO loan_input(id, name, birthday, sex, identityCard, marriage, education, address1, address2, phone, mobilePhone, company, trade, position, address3, companyType, companyEmail, companyPhone, income, contact, contactName, contactPhone, contact2, contact2Name, contact2Phone, contact2Dep, contact2Pos, remark, status) VALUES(" +
            "#{id},#{name},#{birthday},#{sex},#{identityCard},#{marriage},#{education},#{address1},#{address2},#{phone},#{mobilePhone},#{company},#{trade},#{position},#{address3},#{companyType},#{companyEmail},#{companyPhone},#{income},#{contact},#{contactName},#{contactPhone},#{contact2},#{contact2Name},#{contact2Phone},#{contact2Dep},#{contact2Pos},#{remark},#{status})")
    public void createLoan(Loan loan);
    @Select("select count(*)from loan_input")
    public int count();
    @Select("select * from loan_input limit #{start}, #{pageSize}")
    public List<Loan> page(@Param("start") Integer start,@Param("pageSize") Integer pageSize);
    @Update("update loan_input set name=#{name},sex=#{sex} where id=#{id}")
    void updateLoan(@Param("name") String name,@Param("sex") String sex,@Param("id") int id);
    @Delete("delete from loan_input where id=#{id}")
    void deleteLoan(int id);
    @Update("update loan_input set status=1 where id=#{id}")
    void submit(int id);
    @Select("select count(*) from loan_input where status =1")
    public  int count1();

    @Select("select *from loan_input where status=1 limit #{start},#{pageSize}")
    List<Loan> queryList(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
    @Update("update loan_input set status=2 where id=#{data}")
    void approvePass(int data);
    @Update("update loan_input set status=3 where id=#{data}")
    void approveReject(int data);
    @Update("update loan_input set status=7 where id=#{data}")
    void approveFirst(int data);

    @Select("select count(*) from loan_input where status =2")
    public  int count2();
    @Select("select * from loan_input where status=2 limit #{start}, #{pageSize}")
    List<Loan> queryEndList(@Param("start") Integer start,@Param("pageSize") Integer pageSize);
    @Update("update loan_input set status=5 where id=#{data}")
    void approveEndPass(int data);
    @Update("update loan_input set status=6 where id=#{data}")
    void approveEndReject(int data);
    @Update("update loan_input set status=7 where id=#{data}")
    void approveEnd(int data);

    @Select("select count(*) from loan_input where status =5")
    public int count3();
    @Select("select * from loan_input where status=5 limit #{start}, #{pageSize}")
    List<Loan> contractList(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    @Update("update loan_input set status=7 where id=#{id}")
    void generateContract(int id);
}
