package parser;

import model.OnlineStore;

import java.util.ArrayList;

public class NewDataOnlineStore implements OnNewDataHandler<ArrayList<OnlineStore>> {

    @Override
    public void onNewData(Object sender, ArrayList<OnlineStore> args) {
        for (OnlineStore onlineStore : args) {
            System.out.println(onlineStore);
        }
    }
}