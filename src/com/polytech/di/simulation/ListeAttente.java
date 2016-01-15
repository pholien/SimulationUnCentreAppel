package com.polytech.di.simulation;

import java.util.concurrent.LinkedBlockingQueue;

import com.polytech.di.modele.Couriel;
import com.polytech.di.modele.Telephone;

public class ListeAttente {
	public LinkedBlockingQueue<Couriel> listeCouriel = new LinkedBlockingQueue<Couriel>();
	public LinkedBlockingQueue<Telephone> listeTelephone = new LinkedBlockingQueue<Telephone>();

	private int time = 0;
	private int nbCouriel = 0;
	private int nbTelephone = 0;
	private int tempsAttendC=0;
	private int tempsAttendT=0;
			
	public ListeAttente() {
		// entre 20-80 couriel arrivent durant la nuit.
		nbCouriel = (int) Math.round(Math.random() * 60 + 20);
		for (int i = 0; i < nbCouriel; i++) {
			Couriel c = new Couriel(i + 1, time);
			listeCouriel.add(c);
			//System.out.println("couriel " + c.getId() + " arrive!");
		}
		System.out.println("initialisation fini! ajoute "+nbCouriel+" couriels");

	}

	public void courielArriver() throws InterruptedException {
		Couriel c = new Couriel(++nbCouriel, time);
		listeCouriel.put(c);
		//System.out.println("couriel " + c.getId() + " arrive!");
	}

	public void telephoneArriver() throws InterruptedException {
		Telephone t = new Telephone(++nbTelephone, time);
		listeTelephone.put(t);
		//System.out.println("telephone " + t.getId() + " arrive!");
	}

	public int courierRepondre() throws InterruptedException {
		Couriel c;

		c = listeCouriel.take();
		c.setTempsReponse(time);
		//System.out.println("couriel " + c.getId() + " reponse");
		tempsAttendC+=time-c.getTempsArrive();
		return c.getDuree();

	}

	public int telephoneRepondre() throws InterruptedException {
		Telephone t;
		t= listeTelephone.take();
		t.setTempsReponse(time);
		//System.out.println("telephone " + t.getId() + " reponse!");
		tempsAttendT+=time-t.getTempsArrive();
		return t.getDuree();
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int t) {
		this.time = t;
	}
	public void output(){
		System.out.println("nombre de courriels non traités "+listeCouriel.size());
		System.out.println("nombre de telephones non traités "+listeTelephone.size());

		System.out.println("temps d’attente des clients au téléphone "+tempsAttendT/(nbTelephone-listeTelephone.size()));
		System.out.println("délai de réponse aux courriel  "+tempsAttendC/(nbCouriel-listeCouriel.size()));

		
	}

}
