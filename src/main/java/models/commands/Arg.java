package models.commands;


import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_arg")
public class Arg extends Instruction{

    @Column(name = "arg")
    public String arg;

    @Column(name = "current", nullable = false)
    public boolean current;

    public Arg(Snapshot snapshot, String arg) {
        super();
        //this.snapshot =snapshot;
        this.arg = arg;
    }

    public Arg() {
    }
}
