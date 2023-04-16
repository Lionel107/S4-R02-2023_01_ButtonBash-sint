package implement;

import java.util.*;

public class RecupStat {
    public String AfficheClassement(ArrayList<StatJoueur> stats) {

        Map<String, Integer> scoresTotaux = new HashMap<>();
        for (StatJoueur stat : stats) {

            ArrayList<Joueur> classement = stat.getClassement();
            for (Joueur joueur : classement) {
                String nomJoueur = joueur.getNom();
                int score = joueur.getScore();

                scoresTotaux.put(nomJoueur, scoresTotaux.getOrDefault(nomJoueur, 0) + score);
            }
        }

        List<Map.Entry<String, Integer>> joueurs = new ArrayList<>(scoresTotaux.entrySet());
        joueurs.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        StringBuilder sb = new StringBuilder();
        sb.append("Classement :\n");
        for (int i = 0; i < joueurs.size(); i++) {
            sb.append(i + 1).append(". ").append(joueurs.get(i).getKey()).append(" : ").append(joueurs.get(i).getValue()).append(" points\n");
        }

        return sb.toString();
    }

    public String AfficheTop3(ArrayList<StatJoueur> stats) {

        Map<String, Integer> scoresTotaux = new HashMap<>();


        for (StatJoueur stat : stats) {

            ArrayList<Joueur> classement = stat.getClassement();


            for (Joueur joueur : classement) {
                String nomJoueur = joueur.getNom();
                int score = joueur.getScore();


                scoresTotaux.put(nomJoueur, scoresTotaux.getOrDefault(nomJoueur, 0) + score);
            }
        }


        List<Map.Entry<String, Integer>> joueurs = new ArrayList<>(scoresTotaux.entrySet());


        joueurs.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));


        StringBuilder sb = new StringBuilder();
        sb.append("Top 3 :\n");
        for (int i = 0; i < Math.min(3, joueurs.size()); i++) {
            sb.append(joueurs.get(i).getKey()).append("\n");
        }

        return sb.toString();
    }
    public String StatToString(StatJoueur stat) {
        StringBuilder sb = new StringBuilder();

        sb.append("Statistiques de ").append(stat.getNom()).append(" :\n");

        if (stat.getNbParties() == 0) {
            sb.append(stat.getNom()).append(" n'a pas encore joué.\n");
        } else {
            sb.append(stat.getNbParties()).append(" parties jouées\n");
            sb.append(stat.getNbBonnesReponses()).append(" bonnes réponses sur ").append(stat.getNbQuestions()).append("\n");
            sb.append("Moyenne générale : ").append(stat.getNoteMoyenne()).append("/10\n");
            sb.append("Durée moyenne : ").append(stat.getDureeMoyenne()).append("\n");
            sb.append("5 dernières parties jouées :\n");


            ArrayList<Partie> dernieresParties = stat.getDernieresParties();

            for (int i = 0; i < dernieresParties.size(); i++) {
                Partie partie = dernieresParties.get(i);
                sb.append(i + 1).append(". ").append(partie.getNote()).append("/10 en ").append(partie.getDuree()).append("\n");
            }
        }

        return sb.toString();
    }



}
