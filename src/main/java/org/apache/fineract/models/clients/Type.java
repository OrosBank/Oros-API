package org.apache.fineract.models.clients;

public class Type {
	private Integer id;
    private String code;
    private String value;
    
    public Type() {
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", value=" + value +
                '}';
    }

}
