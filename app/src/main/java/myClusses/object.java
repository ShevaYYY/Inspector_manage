package myClusses;

public class object {
    String title;
    String state;
    String city;
    String street;
    String building;
    public object(String title, String state, String city, String street,String building){
        this.title = title;
        this.state = state;
        this.city = city;
        this.street = street;
        this.building=building;
    }
    public object(){}
    public String getTitle(){
        return title;
    }
    public String getState(){
        return state;
    }
    public String getCity(){
        return city;
    }
    public String getStreet(){
        return street;
    }
    public String getBuilding() {return building;}

}
