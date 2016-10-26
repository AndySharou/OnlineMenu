package com.example.andrew.ufafarfor13;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

import java.util.Map;

/**
 * Created by Andrew on 12.09.2016.
 */
@Root (name = "offer")
public class Offer {

    @Attribute(required=false, name = "id")
    public int id;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Element(required=false, name = "url")
    public String url;

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


    @Element(required=false, name = "name")
    public String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Element(required=false, name = "price")
    public String price;

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }


    @Element(required=false, name = "description")
    public String description;

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    @Element(required=false, name = "picture")
    public String picture;

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }


    @Element(required=false, name = "categoryId")
    public String categoryId;

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }


    @ElementMap(required=false, entry="param", key="name", attribute=true, inline=true)
    public Map<String, String> param;

    public void setMapParam (Map<String, String> param)
    {
        this.param = param;
    }

    public Map<String, String> getMapParam() {
        return param;
    }



}
