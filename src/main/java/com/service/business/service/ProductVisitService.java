package com.service.business.service;

import com.service.business.model.Product;
import com.service.business.model.ProductVisit;
import com.service.business.repository.ProductVisitRepository;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductVisitService  {

    private final ProductVisitRepository productVisitRepository;
    private final UserService userService;
    private ProductService productService;

    @Transactional
    public void recordVisit(Long productId) {
        User user = userService.getCurrentUser();
        Product product = productService.findById(productId);
        productVisitRepository.deleteTheLastVisitByUserId(user.getId(), productId);
        ProductVisit visit = new ProductVisit(product,user);
        productVisitRepository.save(visit);
    }

    public List<Long> getProductIdsVisitedByUserId(Long userId) {
        return productVisitRepository.getProductIdsVisitedByUserId(userId);
    }

    @Autowired
    @Lazy
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}

