package Service;

import java.util.ArrayList;

public class SellerService {

    static ArrayList<String> sellerList=new ArrayList<String>();

    public void addSeller(String sellerName){
        sellerList.add(sellerName);
    }

}
