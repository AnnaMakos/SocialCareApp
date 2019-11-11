package com.annamakos.socialcare.security.configuration;

import com.annamakos.socialcare.security.service.UsersDetailsService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@NoArgsConstructor
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UsersDetailsService usersDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = getJwt(httpServletRequest);
        System.out.println(token);
        if(token != null && jwtProvider.validateToken(token)){
            System.out.println("cokolwiek");
            String username = jwtProvider.getUsernameFromToken(token);
            UserDetails userDetails = usersDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
            authenticationToken.setDetails((new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getJwt(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            return authHeader.replace("Bearer ", "");
        }
        return null;
    }
}
