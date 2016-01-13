package com.polytech.di.simulation;

public class AppelArriver extends Thread {

	private ListeAttente liste;
	private int time;

	public AppelArriver(ListeAttente liste) {
		this.liste = liste;
	}

	public void run() {
		while((time=liste.getTime())<14400){
			try {
				if(time < 3600 && time % 300 == 0) {
					liste.telephoneArriver();
				}
				if(time >= 3600 && time < 10800 && time % 60 == 0) {
					liste.telephoneArriver();
				}
				if(time >= 10800 && time % 600 == 0) {
					liste.telephoneArriver();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
