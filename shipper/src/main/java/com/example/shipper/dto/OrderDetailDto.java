package com.example.shipper.dto;

import lombok.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    @NonNull
    private Long orderId;

    @NonNull
    private String address;

    @NonNull
    private String customerFullname;

    @NonNull
    private String customerPhone;

    @NonNull
    private String shipperFullname;

    private List<OrderDetailFoodDto> foods;
}
