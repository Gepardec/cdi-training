package at.gepardec.training.cdi.advanced.registrar;

public class EventData {

    public final String id;

    public final boolean fail;

    private EventData(String id, boolean fail) {
        this.fail = fail;
        this.id = id;
    }

    public static EventData of(String id, boolean fail) {
        return new EventData(id, fail);
    }
}
