package com.example.controller;

import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService cs;

    @RequestMapping(path = "feedCustomerData")
    public  void setDataInDB(){

        cs.saveCustomerData();
    }
}
