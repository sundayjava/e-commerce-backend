package com.ecom.backend.controller;

import com.ecom.backend.dao.request.CreateProductRequest;
import com.ecom.backend.dao.response.ApiResponse;
import com.ecom.backend.exception.ProductException;
import com.ecom.backend.model.Product;
import com.ecom.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> createNewProductHandler(@RequestBody CreateProductRequest productRequest){
        Product product = productService.createProduct(productRequest);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws ProductException {
        productService.deleteProduct(productId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Product deleted successfully");
        res.setStatus(true);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProduct(){
        List<Product> products = productService.findAllProduct();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @PutMapping("/{productId}/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product req, @PathVariable Long productId) throws ProductException {
        Product product = productService.updateProduct(productId,req);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] req){
        for (CreateProductRequest product:req){
            productService.createProduct(product);
        }

        ApiResponse res = new ApiResponse();
        res.setMessage("Product Created Successfully");
        res.setStatus(true);

        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }
}
