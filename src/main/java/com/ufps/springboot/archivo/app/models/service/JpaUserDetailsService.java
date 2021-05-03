package com.ufps.springboot.archivo.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.ufps.springboot.archivo.app.models.dao.IUsuarioDao;
import com.ufps.springboot.archivo.app.models.entities.Rol;
import com.ufps.springboot.archivo.app.models.entities.Usuario;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired 
	private IUsuarioDao usuarioDao;
	
	private Logger logger= LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Usuario usuario = usuarioDao.findByUsername(username);
			
			if (usuario==null) {
				logger.error("Error login: No existe el usuario '"+username+"'");
				throw new UsernameNotFoundException("Username  "+ username+" No Existe");
			}
			
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			
			for (Rol rol : usuario.getRoles()) {
				logger.info("Rol: ".concat(rol.getAuthority()));
				authorities.add(new SimpleGrantedAuthority(rol.getAuthority()));
				
				
			}
			
			if (authorities.isEmpty()) {
				logger.error("Error login: '"+username+"' No tiene roles Asignados");
				throw new UsernameNotFoundException("Error login: '" +username+ "' No tiene roles Asignados");
			}
			
			
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnable(), true, true, true, authorities);
	}

}
