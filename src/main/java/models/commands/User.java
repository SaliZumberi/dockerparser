package models.commands;

import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_user")
public class User extends Instruction{

    @ManyToOne
    @JoinColumn(name ="SNAP_ID")
    Snapshot snapshot;

    @Column(name = "username")
    public String username;

    public User(Snapshot snapshot, String username) {
        super();
        // this.snapshot = snapshot;
        this.username = username;
    }

    public User() {
    }
}
