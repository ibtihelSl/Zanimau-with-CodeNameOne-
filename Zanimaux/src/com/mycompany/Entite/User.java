/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;
/**
 *
 * @author wister
 */
public class User {

    /**
     *
     */
    
   public static int connectedUser;
    private int id;
    private String username;
    private String email;
    private String password;
    private String roles;



    public User() {
    }

    public User(int id) {
        this.id = id;
    }
    
 

    public User(int id, String username,String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

  
    
    
    public User(String username,String password){
    this.username=username;
    this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }
    

    public void setUsername(String username) {
        this.username = username;
    }
    




    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String email, String password, String roles){
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
    
  

    public static int getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(int connectedUser) {
        User.connectedUser = connectedUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
        
  
    

   
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
          
    
}
