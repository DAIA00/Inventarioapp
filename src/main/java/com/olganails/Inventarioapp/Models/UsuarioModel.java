package com.olganails.Inventarioapp.Models;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "usuarios")
@Data
public class UsuarioModel implements UserDetails{
    @Id
    private String id;

    private String username;
    private String password;
    private String tipoUsuario; // Puedes usar roles (ADMIN, USER, etc.) o cualquier otra lógica que prefieras

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Puedes implementar esta función si decides usar roles y permisos específicos
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
