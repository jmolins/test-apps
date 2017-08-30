package com.binality;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class RestEasyClient {
  public static void main(String[] args) {

    UserDto user = new UserDto(MyConfig.USER_FIRSTNAME, MyConfig.USER_LASTNANME,
        MyConfig.USER_EMAIL, MyConfig.USER_PASSWORD);
    try {
      ResteasyClient client = new ResteasyClientBuilder().build();
      ResteasyWebTarget target = client.target(MyConfig.REST_CLIENT_ENDPOINT);
      Entity<UserDto> entity = Entity.entity(user, MediaType.APPLICATION_JSON);
      Response response = target.request().post(entity);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }
      System.out.println("Server response : \n");
      System.out.println(response.readEntity(String.class));
      response.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
