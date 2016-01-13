package com.polytech.di.simulation;

public class CourielArriver extends Thread{
	private ListeAttente liste;
	private int time;
	public CourielArriver(ListeAttente liste){
		this.liste=liste;
	}
	
	public void run(){
		
		
		while((time=liste.getTime())<14400){
			try {
				if(time<3600 && time%30==0){
					liste.courielArriver();
				}
				if(time>=3600 && time%300==0){
					liste.courielArriver();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
