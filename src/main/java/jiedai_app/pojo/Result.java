package jiedai_app.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    public Integer code;
    private Object data;

    public static Result success(){return new Result(20000,null);}
    public static Result success(Object data){return new Result(20000,data);}
    public static Result error(String msg){return new Result(0,msg);}
    public static Result logout(){return new Result(603,"退出成功");}

}
