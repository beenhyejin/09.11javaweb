package com.snr.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.snr.javaweb.dao.MemberDao;
import com.snr.javaweb.dao.MemberRoleDao;
import com.snr.javaweb.entity.Member;
import com.snr.javaweb.entity.NoticeView;

public class JdbcMemberDao implements MemberDao {
   
   @Override
   public Member get(String id) {
      Member member = null;
      
      String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
      String sql = "SELECT * FROM Member WHERE id=?";
      
      // jdbc ����̹� �ε�
      try {
         Class.forName("com.mysql.jdbc.Driver");

         // ���� /����
         Connection con = DriverManager.getConnection(url, "sist", "cclass");

         // ����
         PreparedStatement st = con.prepareStatement(sql);
         st.setString(1, id);

         // ��� ��������
         ResultSet rs = st.executeQuery();

         if(rs.next()) {
            member = new Member(
                  rs.getString("id"), 
                  rs.getString("pwd"), 
                  rs.getString("name"), 
                  rs.getString("gender"), 
                  rs.getString("birthday"), 
                  rs.getString("phone"), 
                  rs.getString("email"));
         }

         rs.close();
         st.close();
         con.close();

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return member;
   }

   @Override
   public int insert(String id, String pwd, String name, String phone, String email) {
      
      return insert(new Member(id, pwd, name, null, null, phone, email));
   }

   @Override
   public int insert(Member member) {
      
      int result = 0;
      String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
      String sql = "insert into Member(id, pwd, name, gender, birthday, phone, email) values(?,?,?,?,?,?,?)";
      
      // jdbc ����̹� �ε�
      try {
         Class.forName("com.mysql.jdbc.Driver");

         // ���� /����
         Connection con = DriverManager.getConnection(url, "sist", "cclass");

         // ����
         PreparedStatement st = con.prepareStatement(sql);
         st.setString(1, member.getId());
         st.setString(2, member.getPwd());
         st.setString(3, member.getName());
         st.setString(4, member.getGender());
         st.setString(5, member.getBirthday());
         st.setString(6, member.getPhone());
         st.setString(7, member.getEmail());

         result = st.executeUpdate();
         
         st.close();
         con.close();

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return result;
   }


}