package ar.uba.fi.distribuidos1.jtierno.security;

import java.util.List;
import java.util.stream.Collectors;

import ar.uba.fi.distribuidos1.jtierno.security.model.Authority;
import ar.uba.fi.distribuidos1.jtierno.security.model.SecurityUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(SecurityUser user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
