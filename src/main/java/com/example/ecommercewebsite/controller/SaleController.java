package com.example.ecommercewebsite.controller;

import com.example.ecommercewebsite.model.Sale;
import com.example.ecommercewebsite.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/info")
    public List<Sale> getAllOrders() {

        try {

            List<Sale> saleList = saleService.findAllOrders();
            return saleList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/place-order")
    public ResponseEntity<Boolean> placeOrder(@RequestBody Sale sale) {
        try {
            saleService.placeOrder(sale);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
