package com.nc.postgresql_crud.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse<T> {
    private HttpStatus httpStatus;
    private String message;
    private T payload;


    public static <T> UserResponse<T> ok()
    {
        UserResponse<T> userResponse=new UserResponse();
        userResponse.setMessage("Ok");
        userResponse.setHttpStatus(HttpStatus.OK);
        return userResponse;
    }
}
