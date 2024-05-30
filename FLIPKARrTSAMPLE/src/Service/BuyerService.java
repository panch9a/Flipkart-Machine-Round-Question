package Service;

import java.util.ArrayList;

public class BuyerService {

   public static ArrayList<String> buyerList=new ArrayList<String>();

    public void addBuyer(String buyerName){
       buyerList.add(buyerName);
    }

}
