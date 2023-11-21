package DBPKG.login;

public class LoginVO {
	String custname;
	String pwd;
	

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "LoginVO [custname=" + custname + ", pwd=" + pwd + "]";
	}
}
