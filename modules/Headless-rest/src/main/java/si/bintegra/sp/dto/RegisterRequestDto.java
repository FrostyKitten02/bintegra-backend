package si.bintegra.sp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDto {
    private String email;
    private String password;
    private String repeatPassword;

    private Boolean male;

    private String firstName;
    private String lastName;

    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
}
