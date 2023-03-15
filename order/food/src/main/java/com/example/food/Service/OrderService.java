package com.example.food.Service;

import com.example.food.DTO.OrderDTO;
import com.example.food.DTO.OrderInfoDTO;
import com.example.food.Entity.Cart;
import com.example.food.Entity.FoodCart;
import com.example.food.Entity.Order;
import com.example.food.Repository.CartRepository;
import com.example.food.Repository.FoodCartRepository;
import com.example.food.Repository.OrderRepository;
import com.example.food.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private FoodCartRepository foodCartRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public OrderDTO createOrder(Long cartId) {
        // Tìm kiếm cart từ cartId
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null || cart.getIsDeleted().equalsIgnoreCase("deleted")) {
            throw new RuntimeException("Cart not found or deleted");
        }

        // Lấy danh sách food cart của cart
        List<FoodCart> foodCarts = foodCartRepository.findByCartId(cartId);

        // Tính tổng giá trị đơn hàng
        Float total = 0f;
        for (FoodCart foodCart : foodCarts) {
            total += foodCart.getFoodQuantity() * foodCart.getFixedPrice();
        }

        // Tạo mới đơn hàng
        Order order = new Order();
        order.setCart(cart);
        order.setShippingStatus("pending");
        order.setTotal(total);
        orderRepository.save(order);

        // Cập nhật trạng thái giỏ hàng
        cart.setIsDeleted("deleted");
        cartRepository.save(cart);

        // Tạo đối tượng DTO để trả về cho client
        OrderDTO orderDTO = new OrderDTO(order.getOrderId(), cartId, order.getShipperId(), total, order.getShippingStatus());
        return orderDTO;
    }

    public List<OrderInfoDTO> getOrderByCustomerId(Long customerId) {
        return orderRepository.getOrderByCustomerId(customerId);
    }
}