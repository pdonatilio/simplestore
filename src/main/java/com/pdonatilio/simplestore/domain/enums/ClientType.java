package com.pdonatilio.simplestore.domain.enums;

public enum ClientType {
	
	INDIVIDUAL(1,"Individual"),
	CORPORATION(2,"Corporation");

	private int cod;
	private String description;
	
	private ClientType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (ClientType x : ClientType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid ID: "+ cod);
	}
	
}
