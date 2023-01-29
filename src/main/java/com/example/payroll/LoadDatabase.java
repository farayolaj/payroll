package com.example.payroll;

import com.example.payroll.employee.Employee;
import com.example.payroll.employee.EmployeeRepository;
import com.example.payroll.order.Order;
import com.example.payroll.order.OrderRepository;
import com.example.payroll.order.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Bagginss", "burglar"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "thief"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", OrderStatus.COMPLETED));
            orderRepository.save(new Order("iPhone", OrderStatus.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
