package com.sena.disocc.seguridad;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sena.disocc.service.CustomUserDetail;

@Component
public class LogginSuccessHnadler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		CustomUserDetail userDetails= (CustomUserDetail) authentication.getPrincipal();
		
		String redirectURL = request.getContextPath();

		  if (userDetails.hasRol("Admin")) {
	            redirectURL = "Dashboard/admin";
	        } else if (userDetails.hasRol("User")) {
	            redirectURL = "Dashboard/usuario";
	        } 
	         
	        response.sendRedirect(redirectURL);
	}
	

	
}
