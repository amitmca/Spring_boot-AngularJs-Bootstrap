package br.com.webapi.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;

public class TokenFilter  extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String header = req.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")){
			throw new ServletException("token inexiste ou invalido");
		}
		
		String token =header.substring(7);//extraindo o token sem o bearer
		try {
			Jwts.parser().setSigningKey("cafe").parseClaimsJws(token).getBody();
			chain.doFilter(request, response);
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"não tem autorização");
		}
		
		
		 
		
	}

}
