package com.snr.javaweb.entity;

import java.util.Date;

public class Member {
   private String id;
   private String pwd;
   private String name;
   private String email;
   private String nickname;

   public Member(String id, String pwd, String name, String email,String nickname) {
      super();
      this.id = id;
      this.pwd = pwd;
      this.name = name;
      this.email = email;
      this.nickname = nickname;
   }
   
   

   public Member() {
      super();
      
   }



   public String getId() {
      return id;
   }



   public void setId(String id) {
      this.id = id;
   }



   public String getPwd() {
      return pwd;
   }



   public void setPwd(String pwd) {
      this.pwd = pwd;
   }



   public String getName() {
      return name;
   }



   public void setName(String name) {
      this.name = name;
   }




   public String getEmail() {
      return email;
   }



   public void setEmail(String email) {
      this.email = email;
   }



public String getNickname() {
	return nickname;
}



public void setNickname(String nickname) {
	this.nickname = nickname;
}

}