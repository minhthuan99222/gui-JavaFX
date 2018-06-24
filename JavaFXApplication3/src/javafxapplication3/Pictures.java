/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

/**
 *
 * @author Minh Thuan
 */
class Pictures {
    String path1;
    String path2;
    String path3;
    String path4;
    
    public Pictures(String path1, String path2, String path3, String path4){
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
        this.path4 = path4;
    }
    
    public Pictures(String path1, String path2, String path3){
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
    }
    
    public Pictures(String path1, String path2){
        this.path1 = path1;
        this.path2 = path2;
        
    }
    
    public Pictures(String path1){
        this.path1 = path1;
    }
    
    public void setPath1(String path){
        this.path1 = path;
    }
    
    public String getPath1(){
        return this.path1;
    }
            
    public void setPath2(String path){
        this.path2 = path;
    }
    
    public String getPath2(){
        return this.path2;
    }
    
    public void setPath3(String path){
        this.path3 = path;
    }
    
    public String getPath3(){
        return this.path3;
    }
    
    public void setPath4(String path){
        this.path4 = path;
    }
    
    public String getPath4(){
        return this.path4;
    }
}
