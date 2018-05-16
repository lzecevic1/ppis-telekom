package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.controllers.dto.LoginRequestDTO;
import ba.unsa.etf.ppis.telekom.controllers.dto.LoginResponseDTO;
import ba.unsa.etf.ppis.telekom.models.User;
import ba.unsa.etf.ppis.telekom.services.JwtService;
import ba.unsa.etf.ppis.telekom.services.LoginService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    public @ResponseBody ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        try {
            User user = loginService.checkLoginData(request.getUsername(), request.getPassword());

            if (user != null) {
                user.setPassword(null);
                String token = JwtService.issueToken(true,true);

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new LoginResponseDTO(user, token));
            }
            else {
                throw new ServiceException("");
            }

        }
        catch (ServiceException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponseDTO("Incorrect username or password!"));
        }
    }

}
