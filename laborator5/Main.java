package com.company;

public class Main {

    public static void main(String[] args) {
	Main app=new Main();
	app.createSave();
	app.loadView();
    }

    private void createSave()
    {
        Catalog catalog=new Catalog("Java Resources", "c:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }

    private void loadView() {
        Catalog catalog = CatalogUtil.load("c:/java/catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }

}

