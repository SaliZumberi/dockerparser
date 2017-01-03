package models.commands;

import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_onbuild")
public class OnBuild extends Instruction{
    @Column(name = "instruction", nullable = false)
    public String instruction;

    @Column(name = "instruction_params", nullable = false)
    public String allParams;

    public OnBuild(Snapshot snapshot, String instruction, String allParams) {
        super();
    //   this.snapshot = snapshot;
        this.instruction =instruction;
        this.allParams=allParams;
    }

    public OnBuild() {

    }
}