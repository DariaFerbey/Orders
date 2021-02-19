package com.ciklum.orders.controller;

import com.ciklum.orders.model.Product;
import com.ciklum.orders.model.ProductsStatus;
import com.ciklum.orders.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/create")
    public String create( Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("statuses", ProductsStatus.values());
        return "create-product";
    }

    @PostMapping("/create")
    public String create(Model model,
                         @Validated @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("statuses", ProductsStatus.values());
            return "create-product";
        }

        product.setCreatedAt(LocalDateTime.now());
        productService.create(product);
        return "redirect:/products/all";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        productService.delete(id);
        return "redirect:/products/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products-info";
    }
}
