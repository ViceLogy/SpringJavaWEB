package com.example.javaspring.dtoe;

import com.example.javaspring.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    @ApiModelProperty(notes = "id for found from DB", required = true )
    @NotBlank
    private Long id;

    @ApiModelProperty(notes = "New data order", required = true)
    @NotBlank
    private Order order;
}
