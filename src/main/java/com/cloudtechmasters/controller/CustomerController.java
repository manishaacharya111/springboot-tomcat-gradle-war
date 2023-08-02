package com.cloudtechmasters.controller;

import com.cloudtechmasters.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    //create a customer
    @PostMapping("/createnewcustomer")
    public  String createNewCustomer(@RequestBody Customer customer){
        return "customer created";
    }


    //list all customers
    @GetMapping("/listallcustomers")
    public List<Customer> getAllCustomers(){
        System.out.println("getAllCustomers is called by /getAllCustomers endpoint")
        return Arrays.asList(new Customer("vamsi","001","INDIA","AP","retail"));
    }

}
