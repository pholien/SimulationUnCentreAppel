package com.polytech.di.simulation;

import java.util.concurrent.LinkedBlockingQueue;

import com.polytech.di.modele.Couriel;
import com.polytech.di.modele.Telephone;

public class ListeAttente {
	public LinkedBlockingQueue<Couriel> listeCouriel=new LinkedBlockingQueue<Couriel>();
	public LinkedBlockingQueue<Telephone> listeTelephone=new LinkedBlockingQueue<Telephone>();
	
	private int time=0;
	private int nbCouriel=0;
	private int nbTelephone=0;
	public ListeAttente(){
		//entre 20-80 couriel arrivent durant la nuit.
		nbCouriel=(int) Math.round(Math.random()*60+20);
		for(int i=0;i<nbCouriel;i++){
			Couriel c=new Couriel(i+1,time);
			listeCouriel.add(c);
			System.out.println("couriel "+c.getId()+" arrive!");
		}
		System.out.println("initialisation fini!");
		
	}
	public void courielArriver() throws InterruptedException{
		Couriel c=new Couriel(++nbCouriel,time);
		listeCouriel.put(c);	
		System.out.println("couriel "+c.getId()+" arrive!");
	}
	
	public void telephoneArriver() throws InterruptedException{
		Telephone t=new Telephone(++nbTelephone,time);
		listeTelephone.put(t);
		System.out.println("telephone "+t.getId()+" arrive!");
	}
	public int courierRepondre() throws InterruptedException{
		Couriel c=listeCouriel.take();
		c.setTempsReponse(time);
		System.out.println("couriel "+c.getId()+" reponse");
		return c.getDuree();
	}
	public int telephoneRepondre() throws InterruptedException{
		Telephone t=listeTelephone.take();
		t.setTempsReponse(time);
		System.out.println("telephone "+t.getId()+" reponse!");
		return t.getDuree();		
	}
	public synchronized int getTime(){
		return this.time;
	}
	public synchronized void setTime(int t){
		this.time=t;
	}

}
