package com.example.apiGatewayService.config;

import com.example.apiGatewayService.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder)
    {
        return builder.routes().route(r->r.path("/api/request/**")
                        .uri("http://localhost:8081/"))

                .route(i->i.path("/api/inventory/**")
                        .uri("http://localhost:8082/"))

                .route(a->a.path("/api/admin/**")
                        .uri("http://localhost:8083/"))

                .route(s->s.path("/api/v1/**")
                        .uri("http://localhost:8084/"))

                .route(u1->u1.path("/api/user/**")
                        //.uri("lb://USER-SERVICE"))
                        .uri("http://localhost:8085"))

                .route(u->u.path("/api/userAuthentication/**")
                        .uri("http://localhost:8086/"))

                .route(f->f.path("/api/user/users/**")
                        .uri("http://localhost:8087/"))

                .route(o->o.path("/api/user/**")
                        .uri("http://localhost:8088/"))

                .route(m->m.path("/api/user/admin/**")
                        //.uri("lb://restuarant-management-service"))
                        .uri("http://localhost:8090/"))

                .build();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBeanUser()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(new JwtFilter());

        filterRegistrationBean.addUrlPatterns("/api/user/users/getUserProfile/*");

//        filterRegistrationBean.addUrlPatterns("/api/user/admin/*");

        return filterRegistrationBean;
    }

//    @Bean
//    public FilterRegistrationBean filterRegistrationBeanAdmin()
//    {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
//
//        filterRegistrationBean.setFilter(new JwtFilter());
//
//        filterRegistrationBean.addUrlPatterns("/api/user/admin/*");
//
//        return filterRegistrationBean;
//    }
}
