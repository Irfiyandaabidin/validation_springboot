package com.techno.springbootdasar.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class PathMatchingConfigurationAdapter (
        val requestInterceptor: RequestInterceptor,
        val loginInterceptor: LoginInterceptor
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/v1/api/auth/login")
        registry.addInterceptor(requestInterceptor).addPathPatterns("/v1/api/auth/login")
    }
}