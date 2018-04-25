package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.Role;
import ba.unsa.etf.ppis.telekom.services.RoleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController extends BaseController<Role, RoleService>  {
}
