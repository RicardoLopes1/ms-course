package br.com.rlopes.hrapigatewayzuul.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final JwtTokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] publicPaths = { "/hr-oauth/oauth/token" };
        String[] operatorPaths = { "/hr-worker/**" };
        String[] adminPaths = { "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**" };

        http.authorizeRequests()
            .antMatchers(publicPaths).permitAll()
            .antMatchers(HttpMethod.GET, operatorPaths).hasAnyRole("OPERATOR", "ADMIN")
            .antMatchers(adminPaths).hasRole("ADMIN")
            .anyRequest().authenticated();
    }
}
