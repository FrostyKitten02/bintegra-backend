package si.bintegra.sp.dto.response;

import lombok.Data;
import si.bintegra.sp.dto.UserDto;

@Data
public class UserResponse {
    private Boolean success;
    private UserDto user;
}
