package com.nc.postgresql_crud.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInput {
    @NotNull
    @NotBlank(message = "commentFrom is mandatory")
    private String commentFrom;
    @NotNull
    @NotBlank(message = "commentTo is mandatory")
    private String commentTo;
    @NotNull
    @NotBlank(message = "message is mandatory")
    private String message;

    public UserInput(String commentFrom, String commentTo, String message) {
        this.commentFrom = commentFrom;
        this.commentTo = commentTo;
        this.message = message;
    }
}
