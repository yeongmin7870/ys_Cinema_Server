package com.example.demo.theater.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/theater")
public class CustomerController {

    @Autowired
    private CustomerDaoService service;

    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers() {
        return service.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer retrieveCustomers(@PathVariable String customerId) {
        Customer customer = service.findById(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException(String.format("ID [%s] not found", customerId));
        }

        return customer;

    }

    @GetMapping("/customers/login")
    public String checkedLogin(@RequestParam String id, String passwd) {
        return service.checkedCustomer(id, passwd);
    }

    // 회원가입
    @PostMapping("/customers")
    public ResponseEntity<Customer> newCustomers(@RequestBody Customer newCustomer) {
        Customer customer = service.findById(newCustomer.getCustomerId());


        if (customer == null) {
            service.save(newCustomer);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newCustomer.getCustomerId())
                    .toUri();
            return ResponseEntity.created(location).build();

        } else {
            throw new CustomerNotFoundException(String.format("ID [%s] already exist", customer.getCustomerId()));
        }
    }


    @PutMapping("/customers/{id}")
    public Customer replaceCustomers(@RequestBody Customer newCustomer,
                                     @PathVariable String id) {

        Customer updateCustomer = service.updateCustomer(newCustomer, id);
        if (updateCustomer == null) {
            throw new CustomerNotFoundException(String.format("ID [%s] Not Found ", id));
        }

        return updateCustomer;
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomers(@PathVariable String id) {
        service.deleteCustomer(id);
    }


}
