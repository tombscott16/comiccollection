package comiccollection;

public final class ComicBookSeries {

    public String seriesName;
    public String volumes;
    public String issues;

    public ComicBookSeries(String seriesName, String volumes, String issues) {
        setSeriesName(seriesName);
        setVolumes(volumes);
        setIssues(issues);
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

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }
}
