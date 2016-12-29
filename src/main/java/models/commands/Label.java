package models.commands;

import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_label")
public class Label extends Instruction{

    @Column(name = "key")
    public String key;

    @Column(name = "value")
    public String value;

    public Label(Snapshot snapshot, String key, String value) {
        super();
        //  this.snapshot = snapshot;
        this.key= key;
        this.value=value;
    }
}
