package com.polytech.di.simulation;




public class Simulation {
	
	public static void main(String[] args) {
		ListeAttente liste=new ListeAttente();
		int time=0;
		AppelArriver appel=new AppelArriver(liste);
		CourielArriver couriel=new CourielArriver(liste);
		Reponse reponse=new Reponse(liste);
		
		
		while(time<14400){
			appel.runAppel(time);
			couriel.runCouriel(time);
			reponse.runReponse(time);
			liste.setTime(++time);
		}
		
		
		

	}

}
