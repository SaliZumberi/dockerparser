package models.commands;

import models.Snapshot;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_maintainer")
public class Maintainer extends Instruction{

    @Column(name = "maintainername")
    public String maintainername;

    public Maintainer(Snapshot snapshot, String maintainername) {
        super();
         this.maintainername  =maintainername;
    }

    public Maintainer() {
    }
}
