package com.galka.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    public EmailService emailService;

    /*curl
    -v
    -d '{"to":"michalgalka84@gmail.com", "subject":"email test", "message":"message body"}'
    -H "Content-Type: application/json; charset=utf-8"
    -X POST http://localhost:8080/api/send

    // requires to enable access to less secure apps https://myaccount.google.com/lesssecureapps on emailtestmgg@gmail.com
*/
    @PostMapping("/send")
    public ResponseEntity<Message> send(@RequestBody Message message) {
        emailService.send(message);
        return ResponseEntity.ok(message);
    }

    // curl  -X GET http://localhost:8080/api/status
    @GetMapping("/status")
    public String status() {
        return "status OK";
    }


}
