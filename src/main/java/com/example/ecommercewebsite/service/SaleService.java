package com.example.ecommercewebsite.service;

import com.example.ecommercewebsite.dao.SaleRepository;
import com.example.ecommercewebsite.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> findAllOrders() {
        return (List<Sale>) saleRepository.findAll();
    }

    public Sale placeOrder(Sale sale) {
        return saleRepository.save(sale);
    }

}
