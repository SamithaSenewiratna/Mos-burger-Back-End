package icet.edu.service;

import icet.edu.dto.Customer;

import java.util.List;

public interface CustomerService {
    public  void addCustomer(Customer customer);


    public List<Customer> getCustomers();

    void deleteCustomer(Integer id);

    void updateCustomer(Customer customer);

    Customer searchCustomer(Integer id);

    List<Customer> searchByName(String name);


    List<Integer> getCustomerIds();
}
