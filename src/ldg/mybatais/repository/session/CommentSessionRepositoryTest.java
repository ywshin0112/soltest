package ldg.mybatais.repository.session;

import java.util.Calendar;
import java.util.Date;

import ldg.mybatis.model.Comment;

public class CommentSessionRepositoryTest {

	public static void main(String[] args) {
		
		
		// delete
		
		Long commentNo = 3L;
		CommentSessionRepository commentSessionRepository = new CommentSessionRepository();
		Comment comment = new Comment();
		comment.setCommentNo(commentNo);
		int result = commentSessionRepository.deleteComment(commentNo);
		System.out.println(result);
		
		
		// update
		
//		Long commentNo = 5L;
//		String commentContent = "수정 test";
//		
//		
//		CommentSessionRepository commentSessionRepository = new CommentSessionRepository();
//		Comment comment = new Comment();
//		comment.setCommentNo(commentNo);
//		comment.setCommentContent(commentContent);
//		
//		int result = commentSessionRepository.updateComment(comment);
//		System.out.println(result);

		
		
		
		//insert
		
//		Long commentNo = 5L;
//		String userId = "fromm0";
//		Date regDate = Calendar.getInstance().getTime();
//		String commentContent = "test";
//		
//		
//		CommentSessionRepository commentSessionRepository = new CommentSessionRepository();
//		Comment comment = new Comment();
//		comment.setCommentNo(commentNo);
//		comment.setUserId(userId);
//		comment.setCommentContent(commentContent);
//		comment.setRegDate(regDate);
//		
//		int result = commentSessionRepository.insertComment(comment);
//		System.out.println(result);
//		
		

		
		// select 
		
//		Long commentNo = 3L;
//		CommentSessionRepository commentSessionRepository = new CommentSessionRepository();
//		Comment comment = commentSessionRepository.selectCommentByPrimaryKey(commentNo);
//		System.out.println(comment);
	}
	
}
