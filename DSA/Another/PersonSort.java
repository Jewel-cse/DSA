package Another;

public class PersonSort {
    //@@@ sort persons according to there name, if names are
    //same then , sort by id
    private String name;
    private int id;

    public PersonSort(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
