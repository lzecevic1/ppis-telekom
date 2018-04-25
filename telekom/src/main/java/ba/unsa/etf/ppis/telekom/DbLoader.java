package ba.unsa.etf.ppis.telekom;

import ba.unsa.etf.ppis.telekom.models.Role;
import ba.unsa.etf.ppis.telekom.models.User;
import ba.unsa.etf.ppis.telekom.services.RoleService;
import ba.unsa.etf.ppis.telekom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DbLoader implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        if (roleService.count() == 0) {
            Role role = new Role();
            role.setName("ADMIN");
            roleService.save(role);
            role = new Role();
            role.setName("SERVICER");
            roleService.save(role);
            role = new Role();
            role.setName("SUPPLIER");
            roleService.save(role);
        }
        if (userService.count() == 0) {

            // Password of all users is pw = password
            Role role = roleService.find("ADMIN");
            Map encoders = new HashMap<>();
            encoders.put("bcrypt", new BCryptPasswordEncoder());
            PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt",encoders);
            String password = "password";
            String hashedPassword = passwordEncoder.encode(password);//"{bcrypt}$2a$10$O11zZDjYUaHT7Vc3v5jAH.2rA8mOgR//Wfyt5kC0vDFhBm4MuThae"
            User user = new User("admin", password, hashedPassword, "admin@telekom.ba", "1111-1111-1111", User.Gender.MALE, role);
            userService.save(user);

            role = roleService.find("SERVICER");
            user = new User("servicer", password, hashedPassword, "servicer@telekom.ba", "1111-1111-1111", User.Gender.MALE, role);
            userService.save(user);

            role = roleService.find("SUPPLIER");
            user = new User("supplier", password,hashedPassword, "supplier@telekom.ba", "1111-1111-1111", User.Gender.FEMALE, role);
            userService.save(user);
        }
    }
}
