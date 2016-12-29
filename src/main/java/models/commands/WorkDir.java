package models.commands;

import models.Snapshot;
import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
public class WorkDir extends Instruction{
    @Column(name = "path")
    public String path;

    public WorkDir(Snapshot snapshot, String path) {
        super();
        //   this.snapshot = snapshot;
        this.path= path;
    }

    public WorkDir() {
    }
}
