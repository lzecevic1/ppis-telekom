package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.User;
import ba.unsa.etf.ppis.telekom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    static Logger logger = Logger.getLogger(CustomUserDetailsService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("CUSTOM USER DETAILS SERVICE");

        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username " + username +" not found");
        }

        logger.info("LOAD USER BY USERNAME VIA CUSTOM USER DETAILS SERVICE\n"
                + user.getUsername() + " " + user.getPassword() + " " +  getGrantedAuthorities(user)
                + "/" + user.getRole().getName());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getHashedPassword(), getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(User user) {

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(user.getRole() != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        }
        return grantedAuthorities;
    }
}
