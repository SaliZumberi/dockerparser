package models.commands;

import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_healthcheck")
public class Healthcheck extends Instruction{
    @Column(name = "options_params", nullable = false)
    String optionsBeforeInstructions;

    @Column(name = "instruction", nullable = false)
    public String instruction;

    @Column(name = "instruction_params", nullable = false)
    public String allParams;

    public Healthcheck(Snapshot snapshot, String instruction, String allParams) {
        super();
        //this.snapshot = snapshot;
        this.instruction =instruction;
        this.allParams=allParams;
    }

    public Healthcheck(String optionsBeforeInstructions) {
        super();
        this.optionsBeforeInstructions =optionsBeforeInstructions;
    }

    public Healthcheck(Snapshot snapshot, String instruction, String optionsBeforeInstructions, String allParams) {
        super();
       // this.snapshot = snapshot;
        this.instruction =instruction;
        this.optionsBeforeInstructions =optionsBeforeInstructions;
        this.allParams=allParams;
    }

    public Healthcheck() {
    }
}

