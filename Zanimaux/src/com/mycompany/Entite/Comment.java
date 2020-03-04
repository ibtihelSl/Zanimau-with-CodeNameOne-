/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.Entities;


/**
 *
 * @author ci
 */
public class Comment {
    public int id;
    public int article_id;
    public int user_id;
    public String message;
   public String emailUser;

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", article_id=" + article_id + ", user_id=" + user_id + ", message=" + message + ", emailUser=" + emailUser + '}';
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Comment() {
    }

    public Comment(int id, int article_id, int user_id, String message, String emailUser) {
        this.id = id;
        this.article_id = article_id;
        this.user_id = user_id;
        this.message = message;
        this.emailUser=emailUser;
    }
    
      public Comment(int article_id, int user_id, String message,String emailUser) {
       
        this.article_id = article_id;
        this.user_id = user_id;
        this.message = message;
                this.emailUser=emailUser;

    }
    
      public Comment(int id, int article_id, int user_id, String message) {
        this.id = id;
        this.article_id = article_id;
        this.user_id = user_id;
        this.message = message;

    }
      public Comment(int article_id, int user_id, String message) {
        this.article_id = article_id;
        this.user_id = user_id;
        this.message = message;
    
    }
     public Comment(int article_id, String message) {
        this.article_id = article_id;
        this.message = message;
    
    }
    
          
                public Comment(String message) {
     
        this.message = message;
      
    }
                
     
}
