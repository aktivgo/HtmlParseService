package google;

import model.Image;
import org.jetbrains.annotations.NotNull;
import parser.OnNewDataHandler;

import java.util.ArrayList;

public class NewDataGoogleImage implements OnNewDataHandler<ArrayList<Image>> {

    @Override
    public void onNewData(Object sender, @NotNull ArrayList<Image> args) {
        for (Image googleImage : args) {
            System.out.println(googleImage);
        }
    }
}