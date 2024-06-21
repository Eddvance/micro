package com.mycompany.invoise.customer.api;


import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.customer.repository.CustomerRepositoryInterface;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("customer")
public class CustomerResource {

    public CustomerRepositoryInterface getCustomerRepository() {
        return customerRepository;
    }
    private final CustomerRepositoryInterface customerRepository;

    public CustomerResource(CustomerRepositoryInterface customerRepository) {
        this.customerRepository = customerRepository;

    }

    @GetMapping("{id}")
    public Customer get(@PathVariable("id") Long id) {
        System.out.println("La méthode displayInvoice get Invoice a été invoquée"+id);
        return customerRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /*@GetMapping("create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        //vous pourriez même supprimer l'annotation @ModelAttribute si vous ne comptez
        //pas donner un identifiant personnalisé au backing bean
        return "invoice-create-form";
    }*/
}