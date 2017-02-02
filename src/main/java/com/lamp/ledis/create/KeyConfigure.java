package com.lamp.ledis.create;

public class KeyConfigure {

	private String prefix;	
	
	private String keyName;
	
	private String keyType;
	
	private String keyMethodName;
	
	private AmsTypeReference atr;

	
	
	
	public KeyConfigure(String prefix, String keyName, String keyType, String keyMethodName, AmsTypeReference atr) {
		super( ) ;
		this.prefix = prefix ;
		this.keyName = keyName ;
		this.keyType = keyType ;
		this.keyMethodName = keyMethodName ;
		this.atr = atr ;
	}

	public String getPrefix ( ) {
		return prefix ;
	}

	public void setPrefix ( String prefix ) {
		this.prefix = prefix ;
	}

	public String getKeyName ( ) {
		return keyName ;
	}

	public void setKeyName ( String keyName ) {
		this.keyName = keyName ;
	}

	public String getKeyType ( ) {
		return keyType ;
	}

	public void setKeyType ( String keyType ) {
		this.keyType = keyType ;
	}

	public String getKeyMethodName ( ) {
		return keyMethodName ;
	}

	public void setKeyMethodName ( String keyMethodName ) {
		this.keyMethodName = keyMethodName ;
	}

	public AmsTypeReference getAtr ( ) {
		return atr ;
	}

	public void setAtr ( AmsTypeReference atr ) {
		this.atr = atr ;
	}
	
	
}
