package comiccollection;

public final class ComicBookSeries {

    public String seriesName;
    public String volumes;

    public ComicBookSeries(String seriesName, String volumes) {
        setSeriesName(seriesName);
        setVolumes(volumes);
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
    
    public String getVolumes() {
        return volumes;
    }
    
    public void setVolumes(String volumes) {
        this.volumes = volumes;
    }
}
