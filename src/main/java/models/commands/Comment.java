package models.commands;

import models.Snapshot;

import javax.persistence.*;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */

@Entity
@Table(name = "df_comment")
public class Comment extends Instruction{

    @Column(name = "instruction")
    public String instructionAfter;

    @Column(name = "comment", nullable = false)
    public String comment;

    public Comment(Snapshot snapshot, String instructionAfter, String comment) {
        super();
        //   this.snapshot = snapshot;
        this.instructionAfter = instructionAfter;
        if (comment.length() > 250){
            this.comment = comment.substring(0, 250) + "...";
        }else{
            this.comment = comment;
        }
    }
    public Comment() {
    }
}
