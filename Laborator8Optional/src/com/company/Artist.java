package com.company;

public class Artist {
    private int idArtist;
    private String nameArtist;
    private String country;

    public Artist(String name, String country)
    {
        this.nameArtist=name;
        this.country=country;
    }

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
