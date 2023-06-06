package si.bintegra.sp.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private Boolean isConsultant;
}
