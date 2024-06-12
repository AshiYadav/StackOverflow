import java.time.Instant;

public class Tag {
    private  int id;
    private String keyTag;

    private Instant time;

    public Tag(int id, String keyTag, Instant time) {
        this.id = id;
        this.keyTag = keyTag;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyTag() {
        return keyTag;
    }

    public void setKeyTag(String keyTag) {
        this.keyTag = keyTag;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }
}
