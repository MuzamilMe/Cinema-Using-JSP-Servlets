package POJO;

public class Movies {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public int getAvailabletickets() {
        return Availabletickets;
    }

    public void setAvailabletickets(int availabletickets) {
        Availabletickets = availabletickets;
    }

    int id=0;
    String Name;
    String ReleaseDate;
    int Availabletickets;
}
