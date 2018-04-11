package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.User;
import ba.unsa.etf.ppis.telekom.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserRepository> {
}
