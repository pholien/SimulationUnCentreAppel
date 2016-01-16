package com.polytech.di.simulation;

public class CourielArriver {
	private ListeAttente liste;
	//private int time;
	private int lastTime=0;
	public CourielArriver(ListeAttente liste){
		this.liste=liste;
	}
	public int expentialRandom(int t){
		double z=Math.random();
		
		return (int)(-t*(Math.log(z)))+1;
	}
	
	public void runCouriel(int time){
		
		//System.out.println("couriel arrive! "+time);
		if(time<14400){
			try {
				if(time<3600 && time==lastTime){
					liste.courielArriver();
					lastTime=time+this.expentialRandom(30);
				}
				if(time>=3600 && time==lastTime){
					liste.courielArriver();
					lastTime=time+this.expentialRandom(300);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
