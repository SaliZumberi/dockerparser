package models.commands;

import models.Snapshot;
import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_expose")
public class Expose extends Instruction{

    @Column(name = "port")
    public long port;


    public Expose(Snapshot snapshot, String port) {
        super();
        //    this.snapshot = snapshot;
        String p = port.replaceAll("[^0-9]+", " ");
        this.port = Integer.parseInt(p);
}

    public Expose() {
    }
}
