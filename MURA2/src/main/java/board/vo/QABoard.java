package board.vo;

import java.sql.Timestamp;

public class QABoard {
	
	private int un_mem;
	private int idx_qt;
	private int wnum_qt;
	private String nn_mem;
	private String wsubject_qt;
	private String wcontent_qt;
	private String reply_qt;
	private Timestamp date_qt;
	
	
	public int getUn_mem() {
		return un_mem;
	}
	public void setUn_mem(int un_mem) {
		this.un_mem = un_mem;
	}
	public int getIdx_qt() {
		return idx_qt;
	}
	public void setIdx_qt(int idx_qt) {
		this.idx_qt = idx_qt;
	}
	public int getWnum_qt() {
		return wnum_qt;
	}
	public void setWnum_qt(int wnum_qt) {
		this.wnum_qt = wnum_qt;
	}
	public String getNn_mem() {
		return nn_mem;
	}
	public void setNn_mem(String nn_mem) {
		this.nn_mem = nn_mem;
	}
	public String getWsubject_qt() {
		return wsubject_qt;
	}
	public void setWsubject_qt(String wsubject_qt) {
		this.wsubject_qt = wsubject_qt;
	}
	public String getWcontent_qt() {
		return wcontent_qt;
	}
	public void setWcontent_qt(String wcontent_qt) {
		this.wcontent_qt = wcontent_qt;
	}
	public String getReply_qt() {
		return reply_qt;
	}
	public void setReply_qt(String reply_qt) {
		this.reply_qt = reply_qt;
	}
	public Timestamp getDate_qt() {
		return date_qt;
	}
	public void setDate_qt(Timestamp date_qt) {
		this.date_qt = date_qt;
	}
	

}
