package com.example.andrew.ufafarfor13;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Andrew on 12.09.2016.
 */
@Root(name="shop")
public class Shop {

    @ElementList(name="categories", type=CategoryMap.class)
    public List<CategoryMap> categorieS;

    @ElementList( name="offers", type=Offer.class)
    public List<Offer> offers;

    public List<CategoryMap> getCategorieS() {
        return categorieS;
    }

    public void setCategorieS(List<CategoryMap> categorieS) {
        this.categorieS = categorieS;
    }


    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }


}