package ba.unsa.etf.ppis.telekom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {

    public ResponseEntity resolveOptionsRequests() {
        return ResponseEntity.ok(true);
    }

}
