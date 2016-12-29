package models.commands;

import models.Snapshot;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_entrypoint")
public class EntryPoint extends Instruction{

    @Column(name = "arg")
    public String executable;

    @ElementCollection
    @CollectionTable(name="entrypoints_params", joinColumns=@JoinColumn(name="ENTRYPOINT_ID"))
    @Column(name="entrypoints_params")
    public List<String> params;

    public EntryPoint(Snapshot snapshot,String executable, List<String> params) {
        super();
        // this.snapshot = snapshot;
        this.executable=executable;
        this.params = params;

        String allParams = "";
        for(String p: params){
            allParams +=p;
        }
    }

    public EntryPoint() {
    }
}
