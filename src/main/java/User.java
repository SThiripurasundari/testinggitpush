public class User {

    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Error1");

        } else {
            if (name.length() < 3) {
                throw new IllegalArgumentException("Error2");
            }
        }
        this.name = name;
    }
}
