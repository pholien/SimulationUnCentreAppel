package com.polytech.di.modele;



public class Couriel {
	private int id;
	private int tempsArrive;
	private int tempsReponse;
	private int duree;
	
	public Couriel(int id, int tempsArrive){
		this.setId(id);
		
		this.tempsArrive=tempsArrive;
		this.duree=(int) Math.round(Math.random()*240+180);
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
