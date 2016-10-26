package com.example.andrew.ufafarfor13;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

import java.util.Map;


@Root(name = "categories")
public class CategoryMap {

    @ElementMap(required=false, entry="category", key="id", attribute=true, inline=true)
    public Map<String, String> category_map;


    public void setCategory_map (Map<String, String> category_map)
    {
        this.category_map = category_map;
    }

    public Map<String, String> getCategory_map() {
        return category_map;
    }




}
