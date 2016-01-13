package com.polytech.di.modele;

public class Telephone {
	private int id;
	private int tempsArrive;
	private int tempsReponse;
	private int duree;
	
	public Telephone(int id, int tempsArrive){
		this.setId(id);
		this.tempsArrive=tempsArrive;
		this.duree=(int)(Math.random())+5;
	}
	public int getTempsArrive(){
		return tempsArrive;
	}
	public int getTempsReponse(){
		return tempsReponse;
	}
	public void setTempsReponse(int t){
		this.tempsReponse=t;
	}
	public int getDuree(){
		return duree;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
