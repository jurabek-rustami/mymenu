package mimsoft.io.lemenu.dish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DishDto {
    private Long menuId;
    private String name;
    private String image;
    private String description;
    private BigDecimal costPrice;
}
