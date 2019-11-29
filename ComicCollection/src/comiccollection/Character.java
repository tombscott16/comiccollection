package comiccollection;

import java.util.ArrayList;

public class Character extends ComicCollection {

    public ArrayList getSeries(String characterName) {

        ArrayList<String> seriesNames = new ArrayList();

        for (ComicBookSeries comicBookSeries : comicBookSeries) {
            if (comicBookSeries.getSeriesName().contains(characterName)) {
                seriesNames.add(comicBookSeries.getSeriesName());
            }
        }

        return seriesNames;
    }
    
    public int getVolumes(String seriesName) {
        
        int volumes = 0;
        for (ComicBookSeries comicBookSeries : comicBookSeries) {
            if (seriesName.contains(comicBookSeries.getSeriesName())) {
                volumes = Integer.parseInt(comicBookSeries.getVolumes());
            }
        }        
        return volumes;
    }

    public String getIssues(String seriesName, String volume) {

        String issues = "";
        for (ComicBookSeries comicBookSeries: comicBookSeries) {
            if (seriesName.equals(comicBookSeries.getSeriesName())) {
                String[] volumesAndIssues = comicBookSeries.getIssues().split(";");
                for (String volumeAndIssues: volumesAndIssues) {
                    if (volumeAndIssues.split(":")[0].equals(volume)) {
                        issues = volumeAndIssues.split(":")[1];
                    };
                }
            }
        }
        return issues;
    }
}
