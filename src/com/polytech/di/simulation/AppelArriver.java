package com.polytech.di.simulation;

public class AppelArriver{

	private ListeAttente liste;
	//private int time;
	private int lastTime=0;
	public AppelArriver(ListeAttente liste) {
		this.liste = liste;
	}
	public int expentialRandom(int t){
		double z=Math.random();
		
		return (int)(-t*(Math.log(z)))+1;
	}

	public void runAppel(int time) {
		if(time<14400){
			//System.out.println("appel arrive! "+time);
			try {
				if(time < 3600 && time == lastTime) {
					liste.telephoneArriver();
					lastTime=time+this.expentialRandom(300);
				}
				if(time >= 3600 && time < 10800 && time==lastTime) {
					liste.telephoneArriver();
					lastTime=time+this.expentialRandom(60);
				}
				if(time >= 10800 && time ==lastTime) {
					liste.telephoneArriver();
					lastTime=time+this.expentialRandom(600);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
