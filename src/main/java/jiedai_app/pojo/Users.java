package jiedai_app.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private String username;
    private String password;
    private String role;
    private LocalDateTime regTime;
    private String creator;
}
