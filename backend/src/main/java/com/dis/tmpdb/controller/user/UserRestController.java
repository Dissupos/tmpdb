package com.dis.tmpdb.controller.user;

import com.dis.tmpdb.config.security.jwt.JwtTokenUtil;
import com.dis.tmpdb.config.security.jwt.JwtUser;
import com.dis.tmpdb.help.RestApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@RestApiController
public class UserRestController {

    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    public UserRestController(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<JwtUser> getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        return ResponseEntity.ok((JwtUser) userDetailsService.loadUserByUsername(username));
    }
}
