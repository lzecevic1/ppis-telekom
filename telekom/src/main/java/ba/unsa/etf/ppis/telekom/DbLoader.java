package ba.unsa.etf.ppis.telekom;

import ba.unsa.etf.ppis.telekom.models.*;
import ba.unsa.etf.ppis.telekom.models.Package;
import ba.unsa.etf.ppis.telekom.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private ProductService productService;
    @Autowired
    private ContractService contractService;

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
            Package p = new Package("DUO Grande","Paket uključuje 178 TV kanala, 26 HD kanala. \n " +
                    "BESPLATNE NAPREDNE FUNKCIJE:\n" +
                    "\n" +
                    "Prezentacija broja pozivatelja\n" +
                    "Poziv na čekanju\n" +
                    "Brzo biranje\n" +
                    "Preusmjeravanje poziva na drugi broj",  new BigDecimal(39.99));
            packageService.save(p);
            Package p1 = new Package("TRIO Grande Silver","Paket uključuje 205 TV kanala, 38 HD kanala i" +
                    " 77 radio kanala \n BESPLATNE NAPREDNE FUNKCIJE:\n" +
                    "HBO paket \n" +
                    "Prezentacija broja pozivatelja\n" +
                    "Poziv na čekanju\n" +
                    "Brzo biranje\n" +
                    "Preusmjeravanje poziva na drugi broj",  new BigDecimal(49.99));
            packageService.save(p1);
            Package p2 = new Package("TRIO Grande Gold","Paket uključuje 302 TV kanala, 55 HD kanala i" +
                    " 77 radio kanala \n BESPLATNE NAPREDNE FUNKCIJE:\n" +
                    "HBO paket \n" +
                    "Prezentacija broja pozivatelja\n" +
                    "Poziv na čekanju\n" +
                    "Brzo biranje\n" +
                    "Preusmjeravanje poziva na drugi broj",  new BigDecimal(70));
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
                    "Usluge kablovske televizije - ponuda od preko 100 kanala odličnog kvaliteta",
                    "Vedad Mulić", new BigDecimal(34.99),
                    TelekomService.ServicePriority.MISSION_CRITICAL, "Kablovska televizija");
            serviceForTelekomService.save(telekomService);

            telekomService = new TelekomService(TelekomService.ServiceType.iNTERNET,
                    "Usluge pristupa internetu uz brzine downloada do 200 Mb/s",
                    "Adna Karkelja", new BigDecimal(39.99), TelekomService.ServicePriority.MISSION_CRITICAL,
                    "Internet");
            serviceForTelekomService.save(telekomService);

            telekomService = new TelekomService(TelekomService.ServiceType.TELEPHONY,
                    "Usluge fiksne telefonije uz besplatne pozive unutar BiH, te najpovoljnije cijene za pozive prema" +
                            " inostranstvu", "Edin Begić", new BigDecimal(16.99), TelekomService.ServicePriority.MISSION_CRITICAL,
                    "Fiksna telefonija");
            serviceForTelekomService.save(telekomService);

            telekomService = new TelekomService(TelekomService.ServiceType.TELEPHONY,
                    "Usluge mobilne telefonije", "Edin Begić", new BigDecimal(25),
                    TelekomService.ServicePriority.MISSION_CRITICAL,"Mobilna telefonija");
            serviceForTelekomService.save(telekomService);
        }
        if (supplierService.count() == 0) {

            // DOBAVLJACI
            // Kategorija: Mobilni uredjaji
            Supplier supplierImtec = new Supplier();
            supplierImtec.setName("IMTEC d.o.o.");
            supplierImtec.setAddress("Zmaja od bosne 43");
            supplierImtec.setStatus(Supplier.SupplierStatus.Aktivan);
            supplierImtec.setCategory(Supplier.SupplierCategory.Mobilni_uredjaji);
            supplierService.save(supplierImtec);
            Rating rating = new Rating();
            rating.setDescription("Rating Imtec");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.0f);
            rating.setSupplier(supplierImtec);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Imtec");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(5.0f);
            rating.setSupplier(supplierImtec);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Imtec");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(4.6f);
            rating.setSupplier(supplierImtec);
            ratingService.save(rating);

            Supplier supplierDigitalCity = new Supplier();
            supplierDigitalCity.setName("Digital City");
            supplierDigitalCity.setAddress("Milana Preloga 2");
            supplierDigitalCity.setStatus(Supplier.SupplierStatus.Aktivan);
            supplierDigitalCity.setCategory(Supplier.SupplierCategory.Mobilni_uredjaji);
            supplierService.save(supplierDigitalCity);
            rating.setDescription("Rating Digital City");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.0f);
            rating.setSupplier(supplierDigitalCity);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Digital City");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(3.3f);
            rating.setSupplier(supplierDigitalCity);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Digital City");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(4.0f);
            rating.setSupplier(supplierDigitalCity);
            ratingService.save(rating);

            Supplier supplierMobilMedia = new Supplier();
            supplierMobilMedia.setName("Mobil Media shop");
            supplierMobilMedia.setAddress("Džemala Bijedića 34");
            supplierMobilMedia.setStatus(Supplier.SupplierStatus.Aktivan);
            supplierMobilMedia.setCategory(Supplier.SupplierCategory.Mobilni_uredjaji);
            supplierService.save(supplierMobilMedia);
            rating.setDescription("Rating Mobil Media shop");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(3.7f);
            rating.setSupplier(supplierMobilMedia);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Mobil Media shop");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(3.9f);
            rating.setSupplier(supplierMobilMedia);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Mobil Media shop");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(4.1f);
            rating.setSupplier(supplierMobilMedia);
            ratingService.save(rating);


            Product product = new Product();
            product.setCategory(Product.ProductCategory.DEVICE);
            product.setName("Računari");
            product.setPrice(new BigDecimal(200));

            //Kategorija: Telefonija
            Supplier supplier = new Supplier();
            supplier.setName("Feniks d.o.o.");
            supplier.setAddress("Odobašina 77");
            supplier.setStatus(Supplier.SupplierStatus.Neaktivan);
            supplier.setCategory(Supplier.SupplierCategory.Telefonija);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Rating Feniks");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(3.2f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Feniks");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(4.5f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Feniks");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(3.9f);
            rating.setSupplier(supplier);
            ratingService.save(rating);


            supplier = new Supplier();
            supplier.setName("Univerzalno");
            supplier.setAddress("Zmaja od Bosne b.b.");
            supplier.setStatus(Supplier.SupplierStatus.Neaktivan);
            supplier.setCategory(Supplier.SupplierCategory.Telefonija);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Rating Univerzalno");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(5.0f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            Supplier supplierGigaset = new Supplier();
            supplierGigaset.setName("Gigaset");
            supplierGigaset.setAddress("Hasana Brkića 55s");
            supplierGigaset.setStatus(Supplier.SupplierStatus.Neaktivan);
            supplierGigaset.setCategory(Supplier.SupplierCategory.Telefonija);
            supplierService.save(supplierGigaset);
            rating = new Rating();
            rating.setDescription("Rating Gigaset");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(3.7f);
            rating.setSupplier(supplierGigaset);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Gigaset");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(4.9f);
            rating.setSupplier(supplierGigaset);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Gigaset");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(2.9f);
            rating.setSupplier(supplierGigaset);
            ratingService.save(rating);

            //Kategorija: Mrežna oprema
            Supplier supplierLocalhost = new Supplier();
            supplierLocalhost.setName("Mrežna oprema Localhost");
            supplierLocalhost.setAddress("Titova 34");
            supplierLocalhost.setStatus(Supplier.SupplierStatus.Aktivan);
            supplierLocalhost.setCategory(Supplier.SupplierCategory.Mrezna_oprema);
            supplierService.save(supplierLocalhost);
            rating = new Rating();
            rating.setDescription("Rating Localhost");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.9f);
            rating.setSupplier(supplierLocalhost);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Localhost");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(3.8f);
            rating.setSupplier(supplierLocalhost);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Localhost");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(4.4f);
            rating.setSupplier(supplierLocalhost);
            ratingService.save(rating);

            supplier = new Supplier();
            supplier.setName("UNI-EXPERT");
            supplier.setAddress("Kranjčevićeva 39");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Mrezna_oprema);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Rating UNI-EXPERT");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.5f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            supplier = new Supplier();
            supplier.setName("Terabajt d.o.o.");
            supplier.setAddress("Terezije b.b.");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Mrezna_oprema);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Rating Terabajt");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.0f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Terabajt");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(3.0f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Terabajt");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(4.1f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            // Kategorija: Ostalo
            Supplier supplierCisco = new Supplier();
            supplierCisco.setName("Cisco");
            supplierCisco.setAddress("Mozart street, Vienna, AUS");
            supplierCisco.setStatus(Supplier.SupplierStatus.Aktivan);
            supplierCisco.setCategory(Supplier.SupplierCategory.Ostalo);
            supplierService.save(supplierCisco);
            rating = new Rating();
            rating.setDescription("Rating Cisco");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.9f);
            rating.setSupplier(supplierCisco);
            ratingService.save(rating);

            supplier = new Supplier();
            supplier.setName("Comms Express");
            supplier.setAddress("Angel Street, London, UK");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Ostalo);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Rating Comms Express");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.3f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Comms Express");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(3.9f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Rating Comms Express");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(4.1f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            supplier = new Supplier();
            supplier.setName("Tesco Mobile");
            supplier.setAddress("Clink Street, London, UK");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Ostalo);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Rating Tesco Mobile");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.5f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            Supplier supplierEl = new Supplier();
            supplierEl.setName("Elektroprivreda BIH");
            supplierEl.setAddress("Zmaja od Bosne 49");
            supplierEl.setStatus(Supplier.SupplierStatus.Aktivan);
            supplierEl.setCategory(Supplier.SupplierCategory.Ostalo);
            supplierService.save(supplierEl);
            rating = new Rating();
            rating.setDescription("Ocjena - komunikacija");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.6f);
            rating.setSupplier(supplierEl);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Ocjena - brzina");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(5.0f);
            rating.setSupplier(supplierEl);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Ocjena - kvalitet");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(4.8f);
            rating.setSupplier(supplierEl);
            ratingService.save(rating);

            supplier = new Supplier();
            supplier.setName("MH Elektroprivreda");
            supplier.setAddress("Vojvode Stepe Stepanovića, Trebinje 89101");
            supplier.setStatus(Supplier.SupplierStatus.Neaktivan);
            supplier.setCategory(Supplier.SupplierCategory.Ostalo);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Nezadovoljavajuca komunikacija");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(2f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Ocjena - brzina");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(4.4f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Ocjena - kvalitet");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(4.0f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            supplier = new Supplier();
            supplier.setName("Elektroprivreda HZ HB");
            supplier.setAddress(" Dr. Mile Budaka, Mostar");
            supplier.setStatus(Supplier.SupplierStatus.Aktivan);
            supplier.setCategory(Supplier.SupplierCategory.Ostalo);
            supplierService.save(supplier);
            rating = new Rating();
            rating.setDescription("Isporuka usluga zadovoljavajucom brzinom");
            rating.setRatingType(Rating.RatingType.DELIVERY_SPEED);
            rating.setRating(3.5f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Ocjena - komunikacija");
            rating.setRatingType(Rating.RatingType.COMMUNICATION);
            rating.setRating(4.0f);
            rating.setSupplier(supplier);
            ratingService.save(rating);
            rating = new Rating();
            rating.setDescription("Ocjena - kvalitet");
            rating.setRatingType(Rating.RatingType.QUALITY);
            rating.setRating(4.2f);
            rating.setSupplier(supplier);
            ratingService.save(rating);

            // UGOVORI
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Contract contractMobile = new Contract(
                    dateFormat.parse("01/03/2018"),
                    dateFormat.parse("01/04/2018"),
                    new BigDecimal(10000),
                    "Zmaja od Bosne b.b.",
                    dateFormat.parse("01/04/2018"),
                    dateFormat.parse("01/04/2018"),
                    "Adna Karkelja",
                    supplierImtec,
                    true);
            contractService.save(contractMobile);

            Contract contractTelefonija = new Contract(
                    dateFormat.parse("12/06/2018"),
                    dateFormat.parse("30/06/2018"),
                    new BigDecimal(25000),
                    "Zmaja od Bosne b.b.",
                    dateFormat.parse("30/06/2018"),
                    dateFormat.parse("30/06/2018"),
                    "Vedad Mulic",
                    supplierGigaset,
                    true);
            contractService.save(contractTelefonija);

            Contract contractMreznaOprema = new Contract(
                    dateFormat.parse("01/05/2018"),
                    dateFormat.parse("01/07/2018"),
                    new BigDecimal(25000),
                    "Zmaja od Bosne b.b.",
                    dateFormat.parse("01/07/2018"),
                    dateFormat.parse("01/07/2018"),
                    "Edin Begic",
                    supplierLocalhost,
                    true);
            contractService.save(contractMreznaOprema);

            Contract contractOstalo = new Contract(
                    dateFormat.parse("01/05/2017"),
                    dateFormat.parse("01/07/2017"),
                    new BigDecimal(25000),
                    "Zmaja od Bosne b.b.",
                    dateFormat.parse("01/07/2017"),
                    dateFormat.parse("01/07/2017"),
                    "Edin Begic",
                    supplierCisco,
                    false);
            contractService.save(contractOstalo);

            contractOstalo = new Contract(
                    dateFormat.parse("01/05/2017"),
                    dateFormat.parse("01/07/2019"),
                    new BigDecimal(120000),
                    "Zmaja od Bosne b.b.",
                    dateFormat.parse("01/07/2017"),
                    dateFormat.parse("01/07/2018"),
                    "Marko Radovanovic",
                    supplierEl,
                    true);
            contractService.save(contractOstalo);
        }
    }
}
