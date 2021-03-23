package top.netapp.myactiviti.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

/**
 * @author freesopen
 */
@Configuration
class WebConfig : WebMvcConfigurationSupport() {
    public override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
        registry.addResourceHandler("/**").addResourceLocations("classpath:/public/")
        super.addResourceHandlers(registry)
    }

//    override fun addViewControllers(registry: ViewControllerRegistry) {
//        registry.addRedirectViewController("/", "/index.html")
//        super.addViewControllers(registry)
//    }

//    override fun addCorsMappings(registry: CorsRegistry) {
////        super.addCorsMappings(registry)
//        registry.addMapping("/**")
//            .allowedOrigins("/*")
//            .allowCredentials(true)
//            .allowedMethods("GET", "POST", "PUT", "DELETE")
//    }
}