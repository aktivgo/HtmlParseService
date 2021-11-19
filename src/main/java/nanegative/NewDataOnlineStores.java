package nanegative;

import model.OnlineStore;
import org.jetbrains.annotations.NotNull;
import parser.OnNewDataHandler;

import java.util.ArrayList;

public class NewDataOnlineStores implements OnNewDataHandler<ArrayList<OnlineStore>> {

    @Override
    public void onNewData(@NotNull Object sender, @NotNull ArrayList<OnlineStore> args) {
        for (OnlineStore onlineStore : args) {
            System.out.println(onlineStore);
        }
    }
}