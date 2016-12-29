package models.commands;

import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */

@Entity
@Table(name = "df_add")
public class Add extends Instruction{

    @Column(name = "source")
    public String source;

    @Column(name = "destination")
    public String destination;

    public Add(Snapshot snapshot, String source, String destinatation) {
        super();
       // this.snapshot = snapshot;
        this.source = source;
        this.destination=destinatation;

    }

    public Add() {
    }
}
