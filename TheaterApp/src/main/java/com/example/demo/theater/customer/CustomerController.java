package com.example.demo.theater.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@RestController
@RequestMapping("/theater")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<EntityModel<Customer>> retrieveCustomer(@PathVariable Integer c_No){
        Customer customer = customerRepository.getById(c_No);

        EntityModel entityModel = EntityModel.of(customer);

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllCustomers());
        entityModel.add(linkTo.withRel("all-users"));


        if(customer == null){
            throw new CustomerNotFoundException(String.format("ID[%s] is not Found",c_No));
        }

        return ResponseEntity.ok(entityModel);
    }
}
