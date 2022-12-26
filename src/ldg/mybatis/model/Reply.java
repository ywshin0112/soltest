package ldg.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable{
	private Long replyNo;
	private Long commentNo;
	private String userId;
	private String replyContent;
	private Date regDate;
	public Long getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(Long replyNo) {
		this.replyNo = replyNo;
	}
	public Long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", commentNo=" + commentNo + ", userId=" + userId + ", replyContent="
				+ replyContent + ", regDate=" + regDate + "]";
	}
	

}
