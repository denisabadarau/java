package com.company;

import java.util.Random;

public class Artist {
    private int idArtist;
    private String nameArtist;
    private String country;

    public Artist(){ }

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

    /*functia prin care generez un artist random si il inserez in baza de date*/
    public void generateRandomArtists()
    {
        ArtistController contr=new ArtistController();
        this.idArtist=contr.getIdArtist() + 1;
        contr.increaseIdArtist();

        //pun intr-un array string mai multe nume de persoane
        String[] name={"Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", "Mark", "Nathan", "Otto", "Paul", "Peter", "Roger", "Roger", "Steve", "Thomas", "Tim", "Ty", "Victor", "Walter"};
        //pentru a avea un nume random, ma voi folosi de o valoare random
        Random rnd=new Random(name.length);
        this.nameArtist=name[rnd.nextInt()]; //in acest mod in nameArtist voi avea un nume random din array

        //pun intr-un array string mai multe nume de tari
        String[] countries={ "Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua &amp; Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia &amp; Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Cape Verde","Cayman Islands","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cruise Ship","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti"};
        Random rnd1=new Random(countries.length);
        this.country=countries[rnd1.nextInt()];

        contr.insertArtist(this);
    }

}
