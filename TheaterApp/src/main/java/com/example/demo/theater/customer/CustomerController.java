package com.example.demo.theater.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/theater")
public class CustomerController {

    @Autowired
    private CustomerDaoService service;

    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers() {
        return service.findAll();
    }

    @GetMapping("/customers/{c_No}")
    public Optional<Customer> retrieveCustomers(@PathVariable Integer c_No) {
        return service.findById(c_No);
    }

    @GetMapping("/customers/login")
    public String checkedLogin(@RequestParam String id, String passwd){
        return service.checkedCustomer(id,passwd);
    }



    @PostMapping("/customers/register")
    public Customer newCustomers(@RequestBody Customer customer) {
        return service.save(customer);
    }




//    @PutMapping("/customers/{id}")
//    public Customer replaceCustomers(@RequestBody Customer newCustomer,
//                                     @PathVariable Integer id) {
//        return customerRepository.findById(id)
//                .map(customer -> {
//                    customer.setC_id(newCustomer.getC_id());
//                    customer.setC_Pw(newCustomer.getC_Pw());
//                    customer.setC_Name(newCustomer.getC_Name());
//                    customer.setC_Nikname(newCustomer.getC_Nikname());
//                    customer.setC_Phone(newCustomer.getC_Phone());
//                    customer.setC_Address(newCustomer.getC_Address());
//                    customer.setC_Total(newCustomer.getC_Total());
//                    customer.setC_Point(newCustomer.getC_Point());
//                    customer.setC_Profile(newCustomer.getC_Profile());
//                    return customerRepository.save(customer);
//                })
//                .orElseGet(() -> {
//                    newCustomer.setC_No(id);
//                    return customerRepository.save(newCustomer);
//                });
//    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomers(@PathVariable Integer id) {
        return service.deleteById(id);
    }


}
