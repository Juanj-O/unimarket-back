package co.edu.uniquindio.proyecto.seguridad.modelo;

import co.edu.uniquindio.proyecto.modelo.Moderador;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private String username, password;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(Object user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(user instanceof Usuario){
            Usuario usuario = (Usuario) user;
            System.out.println(usuario);
            authorities.add( new SimpleGrantedAuthority("CLIENTE") );
            return new UserDetailsImpl(((Usuario) user).getEmail(),
                    ((Usuario) user).getContrasena(), authorities);
        }else if(user instanceof Moderador){
            Moderador moderador = (Moderador) user;
            authorities.add( new SimpleGrantedAuthority("MODERADOR") );
            return new UserDetailsImpl(((Moderador) user).getCorreo(),
                    ((Moderador) user).getContraseña(), authorities);
        }
        return null;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
