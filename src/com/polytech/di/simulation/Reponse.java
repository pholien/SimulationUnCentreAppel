package com.polytech.di.simulation;

import java.util.ArrayList;

import com.polytech.di.modele.Teleconseiller;

public class Reponse {
	private ListeAttente liste;
	public int nombreTele = 4;
	public int nombreCour = 10;
	public int nbConseiller = 14;
	public int nombreTeleMax = 5;
	public ArrayList<Teleconseiller> listeConseiller;
	//public int time;
	public Reponse(ListeAttente liste) {
		this.liste = liste;
		this.listeConseiller = new ArrayList<Teleconseiller>(nbConseiller);
		for (int i = 0; i < nombreTele; i++) {
			Teleconseiller conseiller = new Teleconseiller(i + 1, 0, 0);
			listeConseiller.add(conseiller);
		}
		for (int i = nombreTele; i < nbConseiller; i++) {
			Teleconseiller conseiller = new Teleconseiller(i + 1, 1, 0);
			listeConseiller.add(conseiller);
		}

	}
	public void output(){
		System.out.println("le nombre de teleconseiller au telephone est "+nombreTele);
		System.out.println("le nombre de teleconseiller au couriel est "+nombreCour);
		System.out.println("le nombre de teleconseiller au telephone maximun est "+nombreTeleMax);

	}

	public void runReponse(int time) {
		if(time < 14400) {
			// il y a plus de telephone en attents que teleconseilleur
			// int nbTeleTraiter=0;
			//System.out.println("reponse ! "+time);
			for (int i = 0; i < nbConseiller; i++) {
				Teleconseiller conseiller = listeConseiller.get(i);
				//System.out.println("reponse conseiller "+conseiller.getId());
				//System.out.println("reponse conseiller dip"+conseiller.getTempsDispo());
				try {
					if (conseiller.getTempsDispo() <= time) {
						
						if (conseiller.getType() == 0) {
							if (liste.listeTelephone.size() != 0) {
								//repondre le telephone
								int duree;
								duree = liste.telephoneRepondre();
								conseiller.setTempsDispo(time + duree+1);
							} else {
								conseiller.setType(1);
								int duree = liste.courierRepondre();
								conseiller.setTempsDispo(time + duree+1);
								nombreTele--;
								nombreCour++;
							}
						} else {
							if (liste.listeTelephone.size() >= nombreTele && nombreTele < nombreTeleMax) {
								//System.out.println("reponse conseiller type"+conseiller.getType());
								conseiller.setType(0);								
								int duree = liste.telephoneRepondre();
								conseiller.setTempsDispo(time + duree+1);
								nombreTele++;
								nombreCour--;
							} else {
								int duree = liste.courierRepondre();
								conseiller.setTempsDispo(time + duree+1);
							}

						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			//System.out.println("reponse ! testtest");
		}

	}

}
