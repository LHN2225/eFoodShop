package com.example.restaurantorder.Service.Impl;

import com.example.restaurantorder.DTO.CartInfoDTO;
import com.example.restaurantorder.DTO.OrderDTO;
import com.example.restaurantorder.DTO.OrderRequestDTO;
import com.example.restaurantorder.Entity.Cart;
import com.example.restaurantorder.Entity.Order;
import com.example.restaurantorder.Repository.CartRepository;
import com.example.restaurantorder.Repository.OrderRepository;
import com.example.restaurantorder.Service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(CartRepository cartRepository, OrderRepository orderRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderDTO createOrder(OrderRequestDTO orderRequestDTO) {
        // Lấy cart có id được cung cấp từ database
        Cart cart = cartRepository.findById(orderRequestDTO.getCartId())
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        // Cập nhật isDeleted của cart thành true
        cart.setIsDeleted(Boolean.TRUE);
        cartRepository.save(cart);

        // Tạo mới đơn hàng với các giá trị được cung cấp và giá trị mặc định cho shipperId và shippingStatus
        if(orderRepository.findByCartId(orderRequestDTO.getCartId()).size()>=1){
            return null;
        }
        Order order = new Order();
        order.setCartId(orderRequestDTO.getCartId());
        order.setAddress(orderRequestDTO.getAddress());
        order.setShippingStatus("pending");
        order.setShipperId(null);
        order.setIsDeleted(Boolean.FALSE);

        // Lưu đơn hàng vào database
        order = orderRepository.save(order);

        // Ánh xạ dữ liệu từ Order sang OrderDTO và trả về kết quả
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCartId(order.getCartId());
        orderDTO.setAddress(order.getAddress());
        orderDTO.setShipperId(order.getShipperId());
        orderDTO.setShippingStatus(order.getShippingStatus());
        return orderDTO;
    }

    @Override
    public OrderDTO findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        OrderDTO orderResponse = new OrderDTO();
        orderResponse.setId(order.get().getId());
        orderResponse.setCartId(order.get().getCartId());
        orderResponse.setAddress(order.get().getAddress());
        orderResponse.setShipperId(order.get().getShipperId());
        orderResponse.setShippingStatus(order.get().getShippingStatus());
        return orderResponse;
    }

    @Override
    public List<CartInfoDTO> findFoodByCartId(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        List<CartInfoDTO> foods = cartRepository.findCartInfoByCartId(order.get().getCartId());
        return foods;
    }
}