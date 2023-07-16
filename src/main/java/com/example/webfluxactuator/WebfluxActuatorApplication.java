package com.example.webfluxactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.jmx.annotation.JmxEndpoint;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class WebfluxActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxActuatorApplication.class, args);
	}
}



//Custom Endpoints
record CustomHealth(String status){}
@Component
@WebEndpoint(id = "custom-endpoint", enableByDefault = true)
@JmxEndpoint(id = "custom-endpoint", enableByDefault = true)
//@Endpoint(id = "custom-endpoint", enableByDefault = true)
class CustomHealthEndPoint {
	//"http://localhost:8080/actuator/custom-endpoint"
	@ReadOperation
	public CustomHealth health() {
		return new CustomHealth("OK");
	}

	//"http://localhost:8080/actuator/custom-endpoint/{name}"
	@WriteOperation
	public void writeOperation(@Selector String name) {
		//perform write operation
	}

	//"http://localhost:8080/actuator/custom-endpoint/{name}"
	@DeleteOperation
	public void deleteOperation(@Selector String name){
		//delete operation
	}
}