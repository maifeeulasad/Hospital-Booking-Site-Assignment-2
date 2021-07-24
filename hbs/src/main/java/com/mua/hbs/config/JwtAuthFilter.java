package com.mua.hbs.config;

import com.mua.hbs.model.LoginCredential;
import com.mua.hbs.model.UserPrincipal;
import com.mua.hbs.property.Properties;
import com.mua.hbs.provider.JwtTokenProvider;
import com.mua.hbs.repository.LoginCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JwtAuthFilter extends BasicAuthenticationFilter {

    @Autowired
    private LoginCredentialRepository loginCredentialRepo;

    @Autowired
    private JwtTokenProvider tokenProvider;

    public JwtAuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(Properties.headerString);
        if (header == null || !header.startsWith(Properties.tokenPrefix)) {
            chain.doFilter(request, response);
            return;
        }
        Authentication authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(Properties.headerString)
                .replace(Properties.tokenPrefix, "");

        if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
            String username = tokenProvider.getUserNameFromJWT(token);

            if (username != null) {
                List<LoginCredential> loginCredentials = loginCredentialRepo.findByUsername(username);
                if (loginCredentials!=null && loginCredentials.size()!=0) {
                    UserPrincipal principal = new UserPrincipal(loginCredentials.get(0));
                    return new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
                }
            }
            return null;
        }
        return null;
    }

}