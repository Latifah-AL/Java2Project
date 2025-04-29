


public class Drink extends MenuItem {
    
    //indcates wether the drink is cold or hot
    private boolean isCold;
    
    //constractor for the Drink 
    public Drink(String name, double price, boolean isCold ){
       super(name,price);
        this.isCold=isCold;
    }
    //if the drink is cold return true , if its hot return false
    public boolean getIsCold() {
        return isCold;
    }
    
    
    @Override
    public void displayItem(){
        String coldORhot =isCold?"Cold":"Hot";
        System.out.println(name+"      "+price+" SAR"+" ("+coldORhot+" Drink) ");
    }
    

           
}
