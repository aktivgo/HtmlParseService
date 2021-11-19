package kirovportal;

import model.News;
import org.jetbrains.annotations.NotNull;
import parser.OnNewDataHandler;

import java.util.ArrayList;

public class NewDataNews implements OnNewDataHandler<ArrayList<News>> {

    @Override
    public void onNewData(Object sender, @NotNull ArrayList<News> args) {
        for (News news : args) {
            System.out.println(news);
        }
    }
}