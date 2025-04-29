


public class SideMeal extends Food {//child of food
    private String portionSize;//determine the size of the portion
    public SideMeal(String name, double price, String portionSize)
    {
        super(name,price,"Side Meal");//calls the super constructer
        this.portionSize=portionSize;//insilaise
    }
    public String getportionSize()//getter
    {
        return portionSize;
    }
    public void displayItem() //it will print the items
    {
        System.out.println(name + "      " + price + " SAR (" + portionSize + " Side Meal)");
    }
    }

