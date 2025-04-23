package icet.edu.controller;

import icet.edu.dto.Customer;

import icet.edu.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/customer")
public class customerController {

    final CustomerService service;

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
    }


    @GetMapping("/allcustomers")
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }

    @GetMapping("/allCustomerIds")
    public List<Integer> getCustomerIds(){
        return service.getCustomerIds();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id){

        service.deleteCustomer(id);

    }
    @PutMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer){
        service.updateCustomer(customer);

    }

    @GetMapping("/searchById/{id}")

    public Customer searchCustomer(@PathVariable Integer id){
        return service.searchCustomer(id);

    }

    @GetMapping("/searchByName/{name}")
    public List<Customer> searchByName(@PathVariable String name) {

        return service.searchByName(name);
    }




}
