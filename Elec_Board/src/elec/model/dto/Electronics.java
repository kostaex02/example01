package elec.model.dto;

public class Electronics {
	String modelNum;
	String modelName;
	int price;
	String description;
	String password;
	String writeday;
	int readnum;
	String fName;
	int fSize;
	
	public Electronics(){}
	
	public Electronics(String modelNum,String modelName){
		this.modelNum = modelNum;
		this.modelName = modelName;
	}
	
	public Electronics(String modelNum, String modelName, int price, String description, String password){
		this.modelNum = modelNum;
		this.modelName = modelName;
		this.price = price;
		this.description = description;
		this.password = password;
	}
	
	public Electronics(String modelNum, String modelName, int price, String description, String password, String writeday,
			int readnum, String fName, int fSize){
		this.modelNum = modelNum;
		this.modelName = modelName;
		this.price = price;
		this.description = description;
		this.password = password;
		this.writeday = writeday;
		this.readnum = readnum;
		this.fName = fName;
		this.fSize = fSize;
	}

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadnum() {
		return readnum;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getfSize() {
		return fSize;
	}

	public void setfSize(int fSize) {
		this.fSize = fSize;
	}
}
