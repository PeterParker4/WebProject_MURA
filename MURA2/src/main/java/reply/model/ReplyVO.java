package reply.model;

import java.sql.Timestamp;

public class ReplyVO {
	
	private int idx_reply; // ��� ��ȣ
	private int board_reply; // �Խñ� ��ȣ
	private int mem_reply; // ��� �ۼ��� ȸ����ȣ
	private String nn_reply; // ��� �ۼ��� �г���
	private Timestamp date_reply; // ��� �ۼ���
	private String content_reply; // ��� ����
	
	
	public int getIdx_reply() {
		return idx_reply;
	}
	public void setIdx_reply(int idx_reply) {
		this.idx_reply = idx_reply;
	}
	public int getBoard_reply() {
		return board_reply;
	}
	public void setBoard_reply(int board_reply) {
		this.board_reply = board_reply;
	}
	public int getMem_reply() {
		return mem_reply;
	}
	public void setMem_reply(int mem_reply) {
		this.mem_reply = mem_reply;
	}
	public String getNn_reply() {
		return nn_reply;
	}
	public void setNn_reply(String nn_reply) {
		this.nn_reply = nn_reply;
	}
	public Timestamp getDate_reply() {
		return date_reply;
	}
	public void setDate_reply(Timestamp date_reply) {
		this.date_reply = date_reply;
	}
	public String getContent_reply() {
		return content_reply;
	}
	public void setContent_reply(String content_reply) {
		this.content_reply = content_reply;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [idx_reply=" + idx_reply + ", board_reply=" + board_reply + ", mem_reply=" + mem_reply
				+ ", nn_reply=" + nn_reply + ", date_reply=" + date_reply + ", content_reply=" + content_reply +"]";
	}
	
	
	

}
