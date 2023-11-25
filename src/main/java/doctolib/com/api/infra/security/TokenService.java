package doctolib.com.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import doctolib.com.api.domain.user.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String newToken(User user) {
        try {
            var algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("API doctolib")
                    .withSubject(user.getLogin())
                    .withExpiresAt(dateTimeExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error during the generation a new token", exception);
        }
    }

    private Instant dateTimeExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
