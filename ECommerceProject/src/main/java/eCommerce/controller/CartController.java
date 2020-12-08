package eCommerce.controller;

import java.util.Map;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import eCommerce.service.ProductService;
import eCommerce.service.UserService;

@Controller
@ControllerAdvice
public class CartController {
  @Autowired
  ProductService productService;

  @Autowired
  UserService userService;

  @ModelAttribute("loggedInUser")
  public User loggedInUser() {
  	  // fill this portion in
  }

  @ModelAttribute("cart")
  public Map<Product, Integer> cart() {
      // fill this portion in
  }
}