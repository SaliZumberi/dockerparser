package models.commands;

import models.Snapshot;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
public class StopSignal extends Instruction{
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    Snapshot snapshot;

    @Column(name = "signal")
    public String signal;

    public StopSignal(Snapshot snapshot, String signal) {
        super();
        //   this.snapshot = snapshot;
        this.signal = signal;
    }


    public StopSignal() {
    }
}
