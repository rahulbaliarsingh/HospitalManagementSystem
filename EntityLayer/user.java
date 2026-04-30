package EntityLayer;

public class user {
	private int UId;
	private static String UName;
	private String Email;
	private String Password;
	private String Utype;
	public int getUId() {
		return UId;
	}
	public void setUId(int uId) {
		UId = uId;
	}
	public static String getUName() {
		return UName;
	}
	public static void setUName(String uName) {
		UName = uName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUtype() {
		return Utype;
	}
	public void setUtype(String utype) {
		Utype = utype;
	}

}
