package com.polytech.di.simulation;




public class Simulation {
	
	public static void main(String[] args) {
		ListeAttente liste=new ListeAttente();
		int time=0;
		AppelArriver appel=new AppelArriver(liste);
		CourielArriver couriel=new CourielArriver(liste);
		Reponse reponse=new Reponse(liste);
		System.out.println("Au debut --------------------------");
		reponse.output();
		
		while(time<14400){
			//System.out.println("similation "+time);
			appel.runAppel(time);
			couriel.runCouriel(time);
			reponse.runReponse(time);
			liste.setTime(++time);
		}
		
		
		liste.output();
		System.out.println("A la fin --------------------------");

		reponse.output();
		
		/*for(int i=0;i<10;i++){
			double z=Math.random();
			
			System.out.println((int)(-300*(Math.log(z)))+1); 
		}*/
		

	}

}
