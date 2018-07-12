package comiccollection;

import java.util.ArrayList;

public class Spiderman extends ComicCollection {

    public ArrayList getSeries() {

        ArrayList<String> seriesNames = new ArrayList();

        for (ComicBookSeries comicBookSerie : comicBookSeries) {
            if (comicBookSerie.getSeriesName().contains("Spider-Man")) {
                seriesNames.add(comicBookSerie.getSeriesName());
            }
        }

        return seriesNames;
    }
}
