package com.example.andrew.ufafarfor13;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root (name= "yml_catalog")
public class Yml_Catalog {

    @Attribute( name="date")
    public String date;

    @Element (name="shop", type=Shop.class)
    public Shop shop;



    public void setDate(String date)
    {
        this.date = date;
    }
    public String getDate() {
        return date;
    }




    public void setShop(Shop shop) {
        this.shop = shop;
    }
    public Shop getShop() {
        return shop;
    }



}



