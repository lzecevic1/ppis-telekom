package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.User;
import ba.unsa.etf.ppis.telekom.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService extends BaseService<User, UserRepository> implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("User " + s + "is not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(User user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (user != null) {
            authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        }
        return authorities;
    }
}
