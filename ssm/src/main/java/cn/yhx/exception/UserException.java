package cn.yhx.exception;

public class UserException extends Exception {
    //�쳣��Ϣ
	public String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserException(String message){
		super(message);
		this.message=message;
	}
	

}
