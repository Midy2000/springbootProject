package jiedai_app.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private int rows;
    private int pages;
    private String size;
    private Map data;

}
