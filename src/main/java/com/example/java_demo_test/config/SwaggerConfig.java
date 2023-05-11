//package com.example.java_demo_test.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration	// 和spring 說此 class 為配置類
//@EnableOpenApi // 啟用swagger
//@EnableWebMvc	// 引入DelegatingWebMvcConfiguration配置類, 並啟用springMVC
//public class SwaggerConfig {
//	
//	// 顯示在前端(網頁)的訊息
//	private ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
//			.title("java_demo_test Restful API") // 標題
//			.description("java_demo_test API") // 說明
//			.termsOfServiceUrl("urn:tos") // 服務條款網址, 默認(urn:tos)
//			.contact(new Contact("DEFAULT", "", "")) // 聯絡人
//			.license("Apache 2.0")
//			.version("v3")
//			.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.txt").build();
//
//	@Bean
//	public Docket api() {
//		
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(DEFAULT_API_INFO)
//				.select()									// Controller端的路徑位置
//				.apis(RequestHandlerSelectors.basePackage("com.example.java_demo_test.controller"))
//				.paths(PathSelectors.any())
//				.build();
//	}
//	
//}
