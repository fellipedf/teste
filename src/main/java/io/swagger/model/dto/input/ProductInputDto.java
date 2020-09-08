package io.swagger.model.dto.input;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductInputDto {

    @ApiModelProperty(readOnly = true, value = "Unique identifier")
    private String id;

    @ApiModelProperty(required = true, value = "Product name")
    @NotNull(message = "Preenchimento obrigatório")
    @Length(max = 500, message = "O tamanho máximo deve ser de 500 caracteres")
    private String name;

    @ApiModelProperty(required = true, value = "Product value")
    @NotNull(message = "Preenchimento obrigatório")
    @Valid
    @DecimalMin(value = "0")
    private BigDecimal value;

    public ProductInputDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
