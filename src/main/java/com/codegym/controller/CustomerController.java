package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customers/list")
    public ModelAndView showListCustomer() {
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        List<Customer> customers = customerService.displayAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customers/create")
    public ModelAndView showCreateCustomerForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/customers/create")
    public ModelAndView createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.createCustomer(customer);
        redirectAttributes.addFlashAttribute("success", "Create customer successfully!");
        return new ModelAndView("redirect:/customers/list");
    }

    @GetMapping("/customers/edit/{id}")
    public ModelAndView showEditCustomerForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        Customer customer = customerService.findCustomerById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("customers/edit/{id}")
    public ModelAndView editCustomer(@PathVariable int id, @ModelAttribute Customer customer) {
        customerService.editCustomerById(id, customer);
        return new ModelAndView("redirect:/customers/list");
    }

    @GetMapping("/customers/delete/{id}")
    public ModelAndView showDeleteCustomerForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/customer/delete");
        Customer customer = customerService.findCustomerById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/customers/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable int id,RedirectAttributes redirectAttributes) {
        customerService.deleteCustomerById(id);
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return new ModelAndView("redirect:/customers/list");
    }

    @GetMapping("/customers/{id}")
    public ModelAndView showCustomerDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/customer/view");
        Customer customer = customerService.findCustomerById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }


}
