package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.User;
import ba.unsa.etf.ppis.telekom.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

public class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String FIELD_NAME_TOKEN = "jwt";
    static final String FIELD_NAME_ROLE = "role";
    static final String FIELD_NAME_USERNAME = "username";
    static final String HEADER_STRING = "Authorization";
    private static UserRepository userRepository;
    private static Logger logger = Logger.getLogger(TokenAuthenticationService.class.getName());

    public static User findUserByToken(String token) {
        String username = parseJwt(token);

        if (username == null) {
            return null;
        }

        return userRepository.findByUsername(username);
    }

    public static String parseJwt(String token) {
        if (token != null) {
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
        }

        return null;
    }

    public static void addAuthentication(HttpServletRequest req,
                                         HttpServletResponse res, String username) throws IOException {
        if (userRepository == null) {
            ServletContext servletContext = req.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            userRepository = webApplicationContext.getBean(UserRepository.class);
        }
        User user = userRepository.findByUsername(username);
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                .add(FIELD_NAME_USERNAME, username)
                .add(FIELD_NAME_TOKEN, JWT)
                .add(FIELD_NAME_ROLE, user.getRole().getName());

        JsonObject responseObj = objectBuilder.build();
        logger.info(responseObj.toString());
        res.getWriter().write(responseObj.toString());
    }

    public static Authentication getAuthentication(HttpServletRequest request) {

        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        userRepository = webApplicationContext.getBean(UserRepository.class);

        logger.info("JWT: " + request.getHeader(HEADER_STRING));

        String userReq = parseJwt(request.getHeader(HEADER_STRING));

        User user = userRepository.findByUsername(userReq);

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (user != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        } else {
            userReq = null;
        }

        return userReq != null ? new UsernamePasswordAuthenticationToken(userReq, null, grantedAuthorities) : null;
    }

}
