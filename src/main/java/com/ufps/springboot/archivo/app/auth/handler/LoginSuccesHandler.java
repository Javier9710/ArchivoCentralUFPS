package com.ufps.springboot.archivo.app.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;


@Component
public class LoginSuccesHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		SessionFlashMapManager flashMapManager = new SessionFlashMapManager();
		
        FlashMap flashMap = new FlashMap();
        
        flashMap.put("success", "Hola "+authentication.getName()+", Ha Iniciado Sesion con Exito!");
        
        flashMapManager.saveOutputFlashMap(flashMap, request, response);
        
        if (authentication!=null) {
        	logger.info("El Usuario'"+ authentication.getName() +"' ha iniciado sesion con exito");
			
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	

}
