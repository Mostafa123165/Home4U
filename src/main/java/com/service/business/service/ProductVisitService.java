package com.service.business.service;

import com.service.business.model.Product;
import com.service.business.model.ProductVisit;
import com.service.business.repository.ProductVisitRepository;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductVisitService  {

    private final ProductVisitRepository productVisitRepository;
    private final UserService userService;
    private final ProductService productService;

    @Transactional
    public void recordVisit(Long productId) {
        User user = userService.getCurrentUser();
        Product product = productService.findById(productId);
        if (!productVisitRepository.existsByProductIdAndUserId(productId, user.getId())) {
            ProductVisit visit = new ProductVisit(product,user);
            productVisitRepository.save(visit);
        }
    }
}

