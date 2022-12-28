package io.github.danilodantas.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.select()
				.apis( RequestHandlerSelectors
						.basePackage("io.github.danilodantas.rest.controller"))
				.paths(PathSelectors.any())
				.build()
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Vendas API")
				.description("Api do projeto de vendas")
				.version("1.0")
				.contact(contact())
				.build();
	}
	
	private Contact contact() {
		return new Contact("Danilo Dantas"
				, "http://github.com/Danilo-Dantas"
				, "danilodantasofc@gmail.com");
	}
	
	public ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}
	
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth())
				.forPaths(PathSelectors.any()).build();
	}
	
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope(
				"global", "acessEverything");
		AuthorizationScope[] scopes = new AuthorizationScope[1];
		scopes[0] = authorizationScope;
		SecurityReference reference = new SecurityReference("JWT", scopes);
		List<SecurityReference> auths = new ArrayList<>();
		auths.add(reference);
		return auths;
	}
}
