package com.mypackage.demoApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "street cant be empty")
    @Column(name="street")
    private String street;

    @NotBlank(message = "city ant be empty")
    @Column(name="city")
    private String city;

    @NotNull
    @NotBlank(message = "provide country please")
    @Column(name="country")
    private String country;

    public Address(){

    }
    public Address(String street,String city,String country){
        super();
        this.street=street;
        this.city=city;
        this.country=country;
            }

         public void setId(Long id){
            this.id=id;
         }   
         public Long getId(){
            return id;
         }
         public void setStreet(String street){
           this.street=street;
         }
         public String getStreet(){
            return street;
         }
         public void setCity(String city){
            this.city=city;
         }
         public String getCity(){
            return city;
         }
         public void setCountry(String country){
            this.country=country;
         }
         public String getCountry (){
            return country;
         }
    

    
}
