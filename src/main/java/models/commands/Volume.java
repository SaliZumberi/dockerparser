package models.commands;

import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */

@Entity
@Table(name = "df_volume")
public class Volume extends Instruction{

    @ManyToOne
    @JoinColumn(name ="SNAP_ID")
    Snapshot snapshot;

    @Column(name = "value")
    public String value;

    public Volume(Snapshot snapshot, String match) {
        super();
        //  this.snapshot = snapshot;
        this.value = match;
    }

    public Volume() {
    }
}
