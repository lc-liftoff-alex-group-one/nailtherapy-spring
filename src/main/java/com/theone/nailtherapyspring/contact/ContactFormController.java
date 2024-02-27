package com.theone.nailtherapyspring.contact;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;



@Controller
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("contactForm")
@RequestMapping("/api/v1/ContactForm")
public class ContactFormController {

  @Autowired
  private ContactFormRepository contactFormRepository;

//  using react to display the form.
//  @GetMapping("ContactForm")
//    public String displayForm(Model model){
//      model.addAttribute("title", "Get In Touch");
//      model.addAttribute(new ContactForm());
//      return ;
//  }
//@CrossOrigin(origins = "http://localhost:3000")
  @PostMapping()
    public ResponseEntity<String> processContactForm(@Valid @RequestBody ContactForm newContactForm, Errors errors){
     if (errors.hasErrors()){
       return new ResponseEntity<String>("Form Invalid", HttpStatus.BAD_REQUEST);
     }
     contactFormRepository.save(newContactForm);
     return ResponseEntity.ok("");//this return the status code that everything is ok, 200


    }
  }

//}
