plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	id("io.swagger.core.v3.swagger-gradle-plugin") version "2.2.20"
	id("com.diffplug.spotless") version "6.25.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.liquibase:liquibase-core")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation ("org.springframework.boot:spring-boot-starter-security")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
	implementation("org.springframework.boot:spring-boot-starter-tomcat:1.2.1.RELEASE")

	implementation("com.github.database-rider:rider-core:1.41.1")
	implementation("com.github.database-rider:rider-spring:1.41.1")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
	implementation("org.springframework.boot:spring-boot-starter-webflux:3.2.3")
	implementation("com.nimbusds:nimbus-jose-jwt:9.37")
	implementation("io.jsonwebtoken:jjwt-api:0.12.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")
	implementation("org.springdoc:springdoc-openapi-ui:1.7.0")



//	implementation("io.hypersistence:hypersistence-utils-hibernate-55:3.7.3")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.testcontainers:postgresql:1.19.4")
	testImplementation("org.testcontainers:junit-jupiter:1.19.4")
	testImplementation("org.wiremock:wiremock:3.4.1")
	implementation("org.wiremock.integrations.testcontainers:wiremock-testcontainers-module:1.0-alpha-13")




	testCompileOnly("org.projectlombok:lombok")
	testAnnotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.security:spring-security-test")

}

spotless {
	java {
		importOrder()
		removeUnusedImports()
		eclipse()

		indentWithSpaces()
		endWithNewline()
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
