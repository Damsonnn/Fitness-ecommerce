package com.damcio.shop.service.impl;

import com.damcio.shop.model.Customer;
import com.damcio.shop.repository.CustomerRepository;
import com.damcio.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).get();
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return updatedCustomer;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
