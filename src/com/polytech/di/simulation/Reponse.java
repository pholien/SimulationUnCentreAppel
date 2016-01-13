package com.polytech.di.simulation;

import java.util.ArrayList;

import com.polytech.di.modele.Teleconseiller;

public class Reponse extends Thread {
	private ListeAttente liste;
	public int nombreTele = 2;
	public int nombreCour = 8;
	public int nbConseiller = 10;
	public int nombreTeleMax = 5;
	public ArrayList<Teleconseiller> listeConseiller;

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

	public void run() {
		while (liste.getTime() < 14400) {
			// il y a plus de telephone en attents que teleconseilleur
			// int nbTeleTraiter=0;
			for (int i = 0; i < nbConseiller; i++) {
				Teleconseiller conseiller = listeConseiller.get(i);
				try {
					if (conseiller.getTempsDispo() <= liste.getTime()) {
						if (conseiller.getType() == 0) {
							if (liste.listeTelephone.size() != 0) {
								int duree;

								duree = liste.telephoneRepondre();

								conseiller.setTempsDispo(conseiller.getTempsDispo() + duree);
							} else {
								conseiller.setType(1);
								int duree = liste.courierRepondre();
								conseiller.setTempsDispo(conseiller.getTempsDispo() + duree);
								nombreTele--;
								nombreCour++;
							}
						} else {
							if (liste.listeTelephone.size() >= nombreTele && nombreTele < nombreTeleMax) {

								conseiller.setType(0);
								int duree = liste.telephoneRepondre();
								conseiller.setTempsDispo(conseiller.getTempsDispo() + duree);
								nombreTele++;
								nombreCour--;
							} else {
								int duree = liste.courierRepondre();
								conseiller.setTempsDispo(conseiller.getTempsDispo() + duree);
							}

						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}
