package doctolib.com.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import doctolib.com.api.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TokenService {

    @Value("${api.security.token.secret}") //variavel disponivel no application.properties
    private String secret;

    public String newToken(User user) {
        try {
            var algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("API doctolib")
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .withExpiresAt(dateTimeExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error during the generation a new token", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API doctolib")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT invalid or expirated!");
        }
    }

    private Instant dateTimeExpiration() {
        return LocalDateTime.now()
                .plusHours(2)
                .atZone(ZoneId.of("Europe/Paris"))
                .toInstant();
    }
}
