package ba.unsa.etf.ppis.telekom;

import ba.unsa.etf.ppis.telekom.models.Role;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.models.TelekomService;
import ba.unsa.etf.ppis.telekom.models.User;
import ba.unsa.etf.ppis.telekom.services.RoleService;
import ba.unsa.etf.ppis.telekom.services.ServiceForTelekomService;
import ba.unsa.etf.ppis.telekom.services.SupplierService;
import ba.unsa.etf.ppis.telekom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class DbLoader implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ServiceForTelekomService serviceForTelekomService;
    @Autowired
    private SupplierService supplierService;

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
            User user = new User("admin", password, hashedPassword, "admin@telekom.ba",
                    "1111-1111-1111", User.Gender.MALE, role);
            userService.save(user);

            role = roleService.find("SERVICER");
            user = new User("servicer", password, hashedPassword, "servicer@telekom.ba",
                    "1111-1111-1111", User.Gender.MALE, role);
            userService.save(user);

            role = roleService.find("SUPPLIER");
            user = new User("supplier", password,hashedPassword, "supplier@telekom.ba",
                    "1111-1111-1111", User.Gender.FEMALE, role);
            userService.save(user);
        }
        if (serviceForTelekomService.count() == 0) {
            TelekomService telekomService = new TelekomService(TelekomService.ServiceType.CABLE_TV,
                    "Usluge kablovske televizije - ponuda od preko 100 kanala odlicnog kvaliteta",
                    "Emir Dzamkic", new BigDecimal(59),
                    TelekomService.ServicePriority.MISSION_CRITICAL, "Kablovska televizija");
            serviceForTelekomService.save(telekomService);

            telekomService = new TelekomService(TelekomService.ServiceType.iNTERNET,
                    "Usluge pristupa internetu uz brzine download-a do 200 Mb/s",
                    "Bojana Maric", new BigDecimal(32), TelekomService.ServicePriority.MISSION_CRITICAL,
                    "Internet");
            serviceForTelekomService.save(telekomService);

            telekomService = new TelekomService(TelekomService.ServiceType.TELEPHONY,
                    "Usluge fiksne telefonije uz besplatne pozive unutar BiH te najpovoljnije cijene za pozvie prema" +
                            " inostranstvu", "Jozo Peric", new BigDecimal(26), TelekomService.ServicePriority.MISSION_CRITICAL,
                    "Fiksna telefonija");
            serviceForTelekomService.save(telekomService);

            telekomService = new TelekomService(TelekomService.ServiceType.TELEPHONY,
                    "Usluge mobilne telefonije", "Jozo Peric", new BigDecimal(26),
                    TelekomService.ServicePriority.MISSION_CRITICAL,"Mobilna telefonija");
            serviceForTelekomService.save(telekomService);
        }
        if (supplierService.count() == 0) {
            Supplier supplier = new Supplier();
            supplier.setName("Imtec doo");
            supplier.setAddress("Zmaja od bosne 43");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Mobilni_uredjaji);
            supplierService.save(supplier);

            supplier = new Supplier();
            supplier.setName("Cisco");
            supplier.setAddress("Mozart street, Vienna, AUS");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Ostalo);
            supplierService.save(supplier);

            supplier = new Supplier();
            supplier.setName("Feniks");
            supplier.setAddress("Odobasina 77");
            supplier.setStatus(Supplier.SupplierStatus.Neaktivan);
            supplier.setCategory(Supplier.SupplierCategory.Telefonija);
            supplierService.save(supplier);

            supplier = new Supplier();
            supplier.setName("Localhost Oprema");
            supplier.setAddress("Titova 34");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Mrezna_oprema);
            supplierService.save(supplier);
        }
    }
}
