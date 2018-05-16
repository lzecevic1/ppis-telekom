package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.User;
import ba.unsa.etf.ppis.telekom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public User checkLoginData(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

}
