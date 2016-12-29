package models.commands;

import models.Snapshot;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_from")
public class From extends Instruction implements Serializable {

    @Column(name = "imagename", nullable = false)
    public String imagename ="" ;

    @Column(name = "imageVersionNumber")
    public double imageVersionNumber;

    @Column(name = "imageVersionString")
    public String imageVersionString  ="";

    @Column(name = "digest")
    public String digest  ="";

    public From(Snapshot snapshot, String imagename) {
        //  this.snapshot = snapshot;
        this.imagename = imagename;
    }

    public From(Snapshot snapshot, String imagename, double imageVersionNumber) {
        //  this.snapshot = snapshot;
        this.imagename = imagename;
        this.imageVersionNumber = imageVersionNumber;

    }

    public From(Snapshot snapshot, String imagename, String digest, String what) {
        //   this.snapshot = snapshot;
        this.imagename = imagename;

        if (what.equals("diggest")) {
            this.digest = digest;
        } else {
            this.imageVersionString = digest;
        }

    }

    public From() {
    }
}
