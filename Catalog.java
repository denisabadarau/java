package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable{
    private String name;
    private String path;
    private List<Document> documents= new ArrayList<>();

    public Catalog(String name,String path)
    {
        this.name=name;
        this.path=path;
    }
    /*getters and setters*/
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    public List<Document> getDocuments() {
        return documents;
    }

    public void add(Document doc)
    {
        documents.add(doc);
    }
    //functia cauta in documents documentul care are id-ul dat ca argument
    public Document findById(String id)
    {
        for(Document d : documents)
            if(d.getId()==id)
                return d;

            return null; //daca nu exista documentul cu id-ul id
    }

}




