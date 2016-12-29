package models.commands;

import models.Snapshot;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_healthcheck")
public class Healthcheck extends Instruction{

    @ElementCollection
    @CollectionTable(name="option_params", joinColumns=@JoinColumn(name="RUN_ID"))
    @Column(name="option_params")
    List<String> optionsBeforeInstructions = new ArrayList<>();


    public Healthcheck(Snapshot snapshot,Instruction instruction) {
        super();
        //   this.snapshot = snapshot;
       // this.healthInstruction =instruction;
    }

    public Healthcheck(List<String> optionsBeforeInstructions) {
        super();
        this.optionsBeforeInstructions =optionsBeforeInstructions;
    }

    public Healthcheck(Snapshot snapshot, Instruction instruction, List<String> optionsBeforeInstructions) {
        super();
        //   this.snapshot = snapshot;
       // this.healthInstruction =instruction;
        this.optionsBeforeInstructions =optionsBeforeInstructions;
    }

    public Healthcheck() {
    }
}
