package com.springpaasservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

   @RequestMapping(value = "/")
   public String index() {
      return "index";
   }

   // questo è solo un commento
}
