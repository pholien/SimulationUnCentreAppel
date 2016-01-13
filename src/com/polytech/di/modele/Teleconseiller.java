package com.polytech.di.modele;

public class Teleconseiller {
	private int id;
	private int type;//0 repondre appel telephonique,1 appel couriel
	private int tempsDispo;
	
	public Teleconseiller(int id,int type,int temps){
		this.setId(id);
		this.setType(type);
		this.setTempsDispo(temps);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getTempsDispo() {
		return tempsDispo;
	}

	public void setTempsDispo(int tempsDispo) {
		this.tempsDispo = tempsDispo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
