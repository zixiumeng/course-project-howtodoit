package todoSystem;

public class Project extends Folder {

    public Project(String name, boolean renameable) {
        super(name, renameable);
    }
    public String getprojectname() {
        return super.getName();
    }
}
