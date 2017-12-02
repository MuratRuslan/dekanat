package kg.kgiai.dekanat.rest_api.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ANONYMOUS, ADMIN, USER;


    @Override
    public String getAuthority() {
        return this.name();
    }
}
