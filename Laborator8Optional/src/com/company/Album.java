package com.company;

import java.util.Random;

public class Album {
    private int idAlbum;
    private String nameAlbum;
    private int idArtist;
    private int releaseYear;

    public Album(){ }

    public Album(String name, int idArtist, int year)
    {
        this.nameAlbum=name;
        this.idArtist=idArtist;
        this.releaseYear=year;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void generateRandomAlbum()
    {
        AlbumsController contr=new AlbumsController();
        this.idAlbum=contr.getIdAlbum()+1;
        contr.increaseIdAlbum();

        //pun intr-un array string mai multe nume de albume
        String[] names={"Where you are", "Hence the love is here", "Sher mon cher", "Listen to your heart", "Under your stars", "City lights", "Basic peculiar", "Work", "Believable", "Traditional change", "Let him go", "Fly high", "Hope you ll be there", "Follow the music", "Be yourself", "Look at the moon", "Beautiful mornings", "Say my name", "Smile and leave"};
        Random rnd=new Random(names.length);
        this.nameAlbum=names[rnd.nextInt()];

        //artist_id
        ArtistController contr1=new ArtistController();
        int artistNr=contr1.getIdArtist();
        Random rnd1=new Random();
        this.idArtist=rnd1.nextInt(artistNr)+1;

       //year
        Random rnd2=new Random();
        this.releaseYear=1970+rnd2.nextInt(50);

    }
}
