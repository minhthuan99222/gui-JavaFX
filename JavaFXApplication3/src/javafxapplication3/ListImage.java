/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Minh Thuan
 */
public class ListImage {
    private ObjectProperty pictures = new SimpleObjectProperty();
    
    public ListImage(Pictures pics){
        setPictures(pics);
    }
    
    public void setPictures(Pictures pics){
        pictures.set(pics);
    }
    
    public Object getListImage(){
        return pictures.get();
    }
    
    public ObjectProperty picturesProperty(){
        return pictures;
    }
}
