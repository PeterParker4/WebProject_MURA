package vo;

// ������������ �����Ҽ� �ִ� Ŭ����.
public class ActionForward 
{
	private String path;
	private boolean redirect;
	
<<<<<<< HEAD
	public ActionForward(String path, boolean redirect) {
=======
	public ActionForward(String path, boolean redirect) 
	{
>>>>>>> refs/remotes/origin/soom
		this.path = path; this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
}