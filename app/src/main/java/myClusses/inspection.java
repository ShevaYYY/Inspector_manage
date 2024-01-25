package myClusses;

import java.time.LocalDate;
import java.util.Date;

public class inspection {
    private person inspector;
    private object object;
    private Date date_of_inspection;
    private Date date_of_implementation;
    private String is_planned;
    private result result;


    public inspection(person inspector, object object, Date date_of_implementation, Date date_of_inspection, String is_planned, result result){
        this.inspector = inspector;
        this.object = object;
        this.date_of_implementation = date_of_implementation;
        this.date_of_inspection = date_of_inspection;
        this.is_planned = is_planned;
        this.result=result;
    }
    public inspection(){}
    //public inspection(person user,object object, Date currentDate, Date date, boolean is_planned, result result){}

    public person getInspector() {
        return inspector;
    }

    public void setInspector(person inspector) {
        this.inspector = inspector;
    }

    public myClusses.object getObject() {
        return object;
    }

    public void setObject(myClusses.object object) {
        this.object = object;
    }

    public Date getDate_of_inspection() {
        return date_of_inspection;
    }

    public void setDate_of_inspection(Date date_of_inspection) {
        this.date_of_inspection = date_of_inspection;
    }

    public Date getDate_of_implementation() {
        return date_of_implementation;
    }

    public void setDate_of_implementation(Date date_of_implementation) {
        this.date_of_implementation = date_of_implementation;
    }

    public String isIs_planned() {
        return is_planned;
    }

    public void setIs_planned(String is_planned) {
        this.is_planned = is_planned;
    }

    public myClusses.result getResult() {
        return result;
    }

    public void setResult(myClusses.result result) {
        this.result = result;
    }
    /*public person getInspector(){
        return inspector;
    }
    public object getObject(){
        return object;
    }
    public Date getDate_of_inspection(){
        return date_of_inspection;
    }
    public Date getDate_of_implementation(){
        return date_of_implementation;
    }
    public Boolean getIsPlanned(){
        return is_planned;
    }
    public void setDate_of_implementation(Date date_of_implementation){
        this.date_of_implementation = date_of_implementation;
    }

    public result getResult() {
        return result;
    }

    public void setResult(result result) {
        this.result = result;
    }*/
}
