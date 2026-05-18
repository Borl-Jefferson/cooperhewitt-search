package org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto;

public class ChResult{
    String date = "unset ";
    String title = " unset ";
    String desc = "unset ";

    /*public ChResult(String date, String title, String desc){
        this.date=date;
        this.title=title;
        this.desc=desc;
    }*/

    public String getDate(){
        return date;
    }
    public String getTitle(){
        return title;
    }
    public String getDesc(){
        return desc;
    }

    public void setDate(String in){
        date = in;
    }
    public void setTitle(String in){
        title = in;
    }
    public void setDesc(String in){
        desc = in;
    }
}