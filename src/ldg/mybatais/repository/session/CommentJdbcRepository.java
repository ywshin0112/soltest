package ldg.mybatais.repository.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ldg.mybatis.model.Comment;



public class CommentJdbcRepository {
   private Connection getConnection() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
      } catch (Exception e) {
         throw new IllegalStateException(e);
      }
   }
   
   public Comment selectCommentByPrimarykey(Long commentNo) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      try {
         conn = this.getConnection();
         StringBuilder sql = new StringBuilder("");
         sql.append("select comment_no, user_id, comment_content, reg_date");
         sql.append("from comment");
         sql.append("where comment_no=?");
         stmt = conn.prepareStatement(sql.toString());
         stmt.setLong(1,commentNo);
         rs = stmt.executeQuery();
         
         if(rs.next()) {
            Comment comment = new Comment();
            comment.setCommentNo(rs.getLong("comment_no"));
            comment.setUserId(rs.getString("user_id"));
            comment.setCommentContent(rs.getString("comment_content"));
            comment.setRegDate(rs.getDate("reg_date"));
            return comment;
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            rs.close();
         } catch (Exception e2) {
         }
         try {
            stmt.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
         try {
            conn.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
      return null;
   }
   
   public List<Comment> selectCommentByCondition(Map<String, Object> condition){
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      List<Comment> comments = new ArrayList<Comment>();
      
      try {
         conn = this.getConnection();
         
         StringBuilder sql = new StringBuilder("");
         sql.append("select comment_no, user_id, comment_content, reg_date");
         sql.append("from comment");
         if(condition.get("commentNo") != null) {
            sql.append("where comment_no = ? ");
         }
         stmt = conn.prepareStatement(sql.toString());
         if(condition.get("commentNo") != null) {
            stmt.setLong(1, Long.valueOf((String) condition.get("commentNo) + ")));
         }
         rs = stmt.executeQuery();
         
         if(rs.next()) {
            Comment comment = new Comment();
            comment.setCommentNo(rs.getLong("comment_no"));
            comment.setUserId(rs.getString("user_id"));
            comment.setCommentContent(rs.getString("comment_content"));
            comment.setRegDate(rs.getDate("reg_date"));
            comments.add(comment);
            }
      } catch (Exception e) {
          e.printStackTrace();
      }finally {
         try {
            rs.close();
         } catch (Exception e2) {
         }
         try {
            stmt.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
         try {
            conn.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
      return comments;
   }
   
   public Integer insertComment(Comment comment) {
      Connection conn = null;
      PreparedStatement stmt = null;
      
      try {
         conn = this.getConnection();
         
         StringBuilder sql = new StringBuilder("");
         sql.append("insert into comment(comment_no, user_id, comment_content, reg_date)");
         sql.append("value(?,?,?,?)");
         
         
         
         stmt = conn.prepareStatement(sql.toString());
         stmt.setLong(1, comment.getCommentNo());
         
         stmt.setString(2, comment.getUserId());
         stmt.setString(3, comment.getCommentContent());
         stmt.setDate(4, new java.sql.Date(comment.getRegDate().getTime()));
         
         return stmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            stmt.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
         try {
            conn.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
      return null;
      
   }
   
   public Integer updateComment(Comment comment) {
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      
	      try {
	         conn = this.getConnection();
	         
	         StringBuilder sql = new StringBuilder("");
	         sql.append("UPDATE comment SET ");
	         sql.append(" comment_content = ? ");
	         sql.append("WHERE comment_no = ? ");
	         stmt = conn.prepareStatement(sql.toString());
	         stmt.setString(1, comment.getCommentContent());
	         stmt.setLong(2, comment.getCommentNo());	         	         
	         return stmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            stmt.close();
	         } catch (Exception e2) {
	            // TODO: handle exception
	         }
	         try {
	            conn.close();
	         } catch (Exception e2) {
	            // TODO: handle exception
	         }
	      }
	      return null;
	      
	   }
   
   public Integer deleteComment(Long commentNo) {
      Connection conn = null;
      PreparedStatement stmt = null;
      
      try {
         conn = this.getConnection();
         
         StringBuilder sql = new StringBuilder("");
         sql.append("delete from comment");
         sql.append("where comment_no = ?");
         
         
         stmt = conn.prepareStatement(sql.toString());
         stmt.setLong(1, commentNo);
         return stmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            stmt.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
         try {
            conn.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
      return null;
   }
}