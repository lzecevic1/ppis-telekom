package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.User;
import ba.unsa.etf.ppis.telekom.services.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController<User, UserService>  {
}
