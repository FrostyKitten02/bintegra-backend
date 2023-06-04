package si.bintegra.sp.dto;

import lombok.Data;

@Data
public class UserRequest {
    private LoginRequestDto loginRequest;
    private RegisterRequestDto registerRequest;
}
