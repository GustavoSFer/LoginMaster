package br.com.fernandes.enums;

public enum RoleUser {
	ADMINISTRADOR(1),
	USUARIO(2);
	
	private final int code;
	
	RoleUser(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static RoleUser fromCode(int code) {
		for (RoleUser role : RoleUser.values()) {
			if (role.getCode() == code) {
				return role;
			}
		}
		throw new IllegalArgumentException("Code inválido: " + code);
	}
}
