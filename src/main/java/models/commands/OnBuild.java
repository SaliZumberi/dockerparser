package models.commands;

import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_onbuild")
public class OnBuild extends Instruction{

    public OnBuild(Snapshot snapshot, Instruction instruction) {
        super();
        //    this.snapshot = snapshot;
       // this.instruction = instruction;
    }

    public OnBuild() {
    }
}
