package com.binality;

public class UserDto {

  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private String locale;

  public UserDto(String firstname, String lastname, String email, String password) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.locale = "en";
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }

  public String getLocale() {
    return locale;
  }

  public String getPassword() {
    return password;
  }
}
