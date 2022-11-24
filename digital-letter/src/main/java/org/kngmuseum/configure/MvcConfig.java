package org.kngmuseum.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

//	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
//			"classpath:/resources/", "classpath:/static/", "classpath:/public/", "classpath:/images/" };
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);

	// registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
	// }

}
