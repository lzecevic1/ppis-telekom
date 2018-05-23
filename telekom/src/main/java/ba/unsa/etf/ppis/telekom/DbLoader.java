package ba.unsa.etf.ppis.telekom;

import ba.unsa.etf.ppis.telekom.models.*;
import ba.unsa.etf.ppis.telekom.models.Package;
import ba.unsa.etf.ppis.telekom.services.*;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
    private PackageService packageService;
    @Autowired
    private ServiceForTelekomService serviceForTelekomService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private RatingService ratingService;

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
        if (packageService.count() == 0) {
            Package p= new Package("DUO Grande","Paket ukljucuje 178 TV kanala, 26 HD kanala. \n " +
                    "BESPLATNE NAPREDNE FUNKCIJE:\n" +
                    "\n" +
                    "Prezentacija broja pozivatelja\n" +
                    "Poziv na čekanju\n" +
                    "Brzo biranje\n" +
                    "Preusmjeravanje poziva na drugi broj",  new BigDecimal(39.99));
            packageService.save(p);
            Package p1= new Package("TRIO Grande Silver","Paket ukljucuje 205 TV kanala, 38 HD kanala i" +
                    " 77 radio kanala \n BESPLATNE NAPREDNE FUNKCIJE:\n" +
                    "HBO paket \n" +
                    "Prezentacija broja pozivatelja\n" +
                    "Poziv na čekanju\n" +
                    "Brzo biranje\n" +
                    "Preusmjeravanje poziva na drugi broj",  new BigDecimal(49.99));
            packageService.save(p1);
            Package p2= new Package("TRIO Grande Gold","Paket ukljucuje 302 TV kanala, 55 HD kanala i" +
                    " 77 radio kanala \n BESPLATNE NAPREDNE FUNKCIJE:\n" +
                    "HBO paket \n" +
                    "Prezentacija broja pozivatelja\n" +
                    "Poziv na čekanju\n" +
                    "Brzo biranje\n" +
                    "Preusmjeravanje poziva na drugi broj",  new BigDecimal(59.99));
            packageService.save(p2);
        }
        if (userService.count() == 0) {

            // Password of all users is pw = password
            Role role = roleService.find("ADMIN");
            Map encoders = new HashMap<>();
            String password = "password";
            User user = new User("admin", password, "admin@telekom.ba",
                    "1111-1111-1111", User.Gender.MALE, role);
            userService.save(user);

            role = roleService.find("SERVICER");
            user = new User("servicer", password, "servicer@telekom.ba",
                    "1111-1111-1111", User.Gender.MALE, role);
            userService.save(user);

            role = roleService.find("SUPPLIER");
            user = new User("supplier", password, "supplier@telekom.ba",
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
            Rating rating = new Rating();
            rating.setDescription("Test");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(3.0f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Test 2");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(5.0f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            supplier = new Supplier();
            supplier.setName("Cisco");
            supplier.setAddress("Mozart street, Vienna, AUS");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Ostalo);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Test 3");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(1.0f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            supplier = new Supplier();
            supplier.setName("Feniks");
            supplier.setAddress("Odobasina 77");
            supplier.setStatus(Supplier.SupplierStatus.Neaktivan);
            supplier.setCategory(Supplier.SupplierCategory.Telefonija);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Test 4");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.0f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            supplier = new Supplier();
            supplier.setName("Localhost Oprema");
            supplier.setAddress("Titova 34");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Mrezna_oprema);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Test 5");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(2.5f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
        }
    }
}
