package recipe.model;

import java.sql.Timestamp;

public class RecipeVO {

	private int idx_li;
	private int un_mem;
	private int wnum_li;
	private String nn_mem;
	private String category_li;
	private String wsubject_li;
	private String tag_li;
	private String thumb_li;
	private String wcontent_li;
	private String reply_li;
	private Timestamp date_li;
	private int readcount_li;
	
	public int getIdx_li() {
		return idx_li;
	}
	public void setIdx_li(int idx_li) {
		this.idx_li = idx_li;
	}
	public int getUn_mem() {
		return un_mem;
	}
	public void setUn_mem(int un_mem) {
		this.un_mem = un_mem;
	}
	public int getWnum_li() {
		return wnum_li;
	}
	public void setWnum_li(int wnum_li) {
		this.wnum_li = wnum_li;
	}
	public String getNn_mem() {
		return nn_mem;
	}
	public void setNn_mem(String nn_mem) {
		this.nn_mem = nn_mem;
	}
	public String getCategory_li() {
		return category_li;
	}
	public void setCategory_li(String category_li) {
		this.category_li = category_li;
	}
	public String getWsubject_li() {
		return wsubject_li;
	}
	public void setWsubject_li(String wsubject_li) {
		this.wsubject_li = wsubject_li;
	}
	public String getTag_li() {
		return tag_li;
	}
	public void setTag_li(String tag_li) {
		this.tag_li = tag_li;
	}
	public String getThumb_li() {
		return thumb_li;
	}
	public void setThumb_li(String thumb_li) {
		this.thumb_li = thumb_li;
	}
	public String getWcontent_li() {
		return wcontent_li;
	}
	public void setWcontent_li(String wcontent_li) {
		this.wcontent_li = wcontent_li;
	}
	public String getReply_li() {
		return reply_li;
	}
	public void setReply_li(String reply_li) {
		this.reply_li = reply_li;
	}
	public Timestamp getDate_li() {
		return date_li;
	}
	public void setDate_li(Timestamp date_li) {
		this.date_li = date_li;
	}
	public int getReadcount_li() {
		return readcount_li;
	}
	public void setReadcount_li(int readcount_li) {
		this.readcount_li = readcount_li;
	}
	
}
