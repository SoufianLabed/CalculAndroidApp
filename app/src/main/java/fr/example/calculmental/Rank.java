package fr.example.calculmental;


public class Rank {
    private int id;
    private String Pseudo;
    private String Point;
    private String Niveau;

    public Rank(int id, String Pseudo, String Point, String Niveau) {
        this.setId(id);
        this.setPseudo(Pseudo);
        this.setPoint(Point);
        this.setNiveau(Niveau);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    public String getPoint() {
        return Point;
    }

    public void setPoint(String point) {
        Point = point;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String niveau) {
        Niveau = niveau;
    }


    @Override
    public String toString() {
        return Pseudo + " | " + Point + " | " + Niveau + " | " ;
    }
}
