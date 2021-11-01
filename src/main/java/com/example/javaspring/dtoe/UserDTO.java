package com.example.javaspring.dtoe;

import com.example.javaspring.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    @ApiModelProperty(notes = "id for found from DB ", required = true)
    @NotBlank
    private Long id;

    @ApiModelProperty(notes = "New user date, the object does not need an id", required = true)
    @NotBlank
    private User user;
}
