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


    public Arg(String arg) {
        super();
        this.arg = arg;
    }

    public Arg() {
    }
}
