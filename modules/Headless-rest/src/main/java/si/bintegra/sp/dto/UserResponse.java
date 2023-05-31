package si.bintegra.sp.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Boolean success;
    private UserDto user;
}
