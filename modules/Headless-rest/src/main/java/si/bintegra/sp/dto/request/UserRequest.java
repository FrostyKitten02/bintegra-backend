package si.bintegra.sp.dto.request;

import lombok.Data;
import si.bintegra.sp.dto.request.LoginRequestDto;
import si.bintegra.sp.dto.request.RegisterRequestDto;

@Data
public class UserRequest {
    private LoginRequestDto loginRequest;
    private RegisterRequestDto registerRequest;
}
