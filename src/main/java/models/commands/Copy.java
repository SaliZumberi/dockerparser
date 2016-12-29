package models.commands;


import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_copy")
public class Copy extends Instruction{

    @Column(name = "source")
    public String source;

    @Column(name = "destination")
    public String destination;

    public Copy(Snapshot snapshot, String source, String destinatation) {
        super();
        this.source = source;
        //  this.snapshot = snapshot;
        this.destination=destinatation;

    }

    public Copy() {
    }
}
