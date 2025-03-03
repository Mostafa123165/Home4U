    package com.service.business.dto;

    import lombok.Getter;
    import lombok.Setter;
    import org.hibernate.validator.constraints.Range;

    import java.util.List;

    @Getter @Setter
    public class ProductCardDto {
        private Long id;
        private String name;
        private String type;
        private double price;
        private double stockAmount;
        private double length;
        private double width;
        private double height;
        @Range(min = 0, max = 5)
        private double rate;
        private List<ColorDto> colors;
        private String imagePath;
    }
