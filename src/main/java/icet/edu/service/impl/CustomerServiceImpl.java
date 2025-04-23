package icet.edu.service.impl;

import icet.edu.dto.Customer;
import icet.edu.entity.CustomerEntity;
import icet.edu.repository.CustomerRepository;
import icet.edu.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class CustomerServiceImpl  implements CustomerService {


    final CustomerRepository repository;
    final ModelMapper mapper;


    @Override
    public void addCustomer(Customer customer) {
        // Generate Unique Order ID
//        String customerId = "CUS" + UUID.randomUUID().toString().substring(0, 4);
//        customer.setID(customerId);



        repository.save(mapper.map( customer, CustomerEntity.class));
    }


    @Override
    public List<Customer> getCustomers() {
        List<CustomerEntity> all = repository.findAll();
        List<Customer> list=new ArrayList<>();

        all.forEach(CustomerEntity->{
            list.add(mapper.map(CustomerEntity,Customer.class));
        });

        return list;

    }

    @Override
    public void deleteCustomer(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Customer with ID " + id + " not found");
        }

    }

    @Override
    public void updateCustomer(Customer customer) {

        repository.save(mapper.map( customer,CustomerEntity.class));
    }

    @Override
    public Customer searchCustomer(Integer id) {

        return mapper.map(repository.findById(id), Customer.class);



    }

    @Override
    public List<Customer> searchByName(String name) {
        List<CustomerEntity> searchByName =repository.findByName(name);
        List<Customer> customerList =new ArrayList<>();

        searchByName.forEach(customer -> {

            customerList.add(mapper.map(customer,Customer.class));
        });
        return customerList;
    }

    @Override
    public List<Integer> getCustomerIds() {
        List<Integer> customerIds = new ArrayList<>();
        repository.findAll().forEach(customer -> {
            customerIds.add(Math.toIntExact((customer.getID())));
        });
        return customerIds;
    }


}
