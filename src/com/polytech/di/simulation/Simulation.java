package com.polytech.di.simulation;

import java.util.PriorityQueue;
import java.util.Random;

import com.polytech.di.modele.Couriel;
import com.polytech.di.modele.Telephone;


public class Simulation {
	
	public static void main(String[] args) {
		ListeAttente liste=new ListeAttente();
		
		AppelArriver appel=new AppelArriver(liste);
		CourielArriver couriel=new CourielArriver(liste);
		Reponse reponse=new Reponse(liste);
		
		appel.start();
		couriel.start();
		reponse.start();
		while(liste.getTime()<14400){
			liste.setTime(liste.getTime()+1);
		}
		
		

	}

}
