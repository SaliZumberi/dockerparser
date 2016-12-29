package models.commands;

import models.Snapshot;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_cmd")
public class Cmd extends Instruction{

    @Column(name = "executable")
    public String executable;

    @ElementCollection
    @CollectionTable(name="cmd_params", joinColumns=@JoinColumn(name="RUN_ID"))
    @Column(name="cmd_params")
    public List<String> params;


    public Cmd(Snapshot snapshot, String executable, List<String> params) {
        //    this.snapshot = snapshot;
        this.executable=executable;
        this.params=params;
    }

    public Cmd() {
    }
}
