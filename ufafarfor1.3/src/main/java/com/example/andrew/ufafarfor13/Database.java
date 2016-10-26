package com.example.andrew.ufafarfor13;

/**
 * Created by Andrew on 15.09.2016.
 */
public class Database {

    public Yml_Catalog yml_catalog;


    public static Database getInstance() {
        return Holder.HOLDER_INSTANCE;
    }
    private static class Holder {
        public static final Database HOLDER_INSTANCE = new Database();
    }

    private Database (){

    }

    public void setCatalog(Yml_Catalog yml_catalog) {
        this.yml_catalog = yml_catalog;
    }

    public Yml_Catalog getCatalog() {
        return yml_catalog;
    }




}
