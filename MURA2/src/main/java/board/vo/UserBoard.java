package board.vo;

import java.sql.Timestamp;

public class UserBoard {
	
	private int un_mem;
	private int idx_ut;
	private int wnum_ut;
	private String nn_mem;
	private String tag_ut;
	private String wsubject_ut;
	private String wcontent_ut;
	private String reply_ut;
	private Timestamp date_ut;
	
	
	public int getUn_mem() {
		return un_mem;
	}
	public void setUn_mem(int un_mem) {
		this.un_mem = un_mem;
	}
	public int getIdx_ut() {
		return idx_ut;
	}
	public void setIdx_ut(int idx_ut) {
		this.idx_ut = idx_ut;
	}
	public int getWnum_ut() {
		return wnum_ut;
	}
	public void setWnum_ut(int wnum_ut) {
		this.wnum_ut = wnum_ut;
	}
	public String getNn_mem() {
		return nn_mem;
	}
	public void setNn_mem(String nn_mem) {
		this.nn_mem = nn_mem;
	}
	public String getTag_ut() {
		return tag_ut;
	}
	public void setTag_ut(String tag_ut) {
		this.tag_ut = tag_ut;
	}
	public String getWsubject_ut() {
		return wsubject_ut;
	}
	public void setWsubject_ut(String wsubject_ut) {
		this.wsubject_ut = wsubject_ut;
	}
	public String getWcontent_ut() {
		return wcontent_ut;
	}
	public void setWcontent_ut(String wcontent_ut) {
		this.wcontent_ut = wcontent_ut;
	}
	public String getReply_ut() {
		return reply_ut;
	}
	public void setReply_ut(String reply_ut) {
		this.reply_ut = reply_ut;
	}
	public Timestamp getDate_ut() {
		return date_ut;
	}
	public void setDate_ut(Timestamp date_ut) {
		this.date_ut = date_ut;
	}
	
	

}
