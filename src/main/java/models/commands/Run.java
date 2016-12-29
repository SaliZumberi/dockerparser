package models.commands;


import models.Snapshot;

import javax.persistence.*;
import java.util.List;

/**
 * Created by salizumberi-laptop on 01.11.2016.
 */
@Entity
@Table(name = "df_run")
public class Run extends Instruction{

    @Column(name = "executable")
    public String executable;

    @ElementCollection
    @CollectionTable(name="run_params", joinColumns=@JoinColumn(name="RUN_ID"))
    @Column(name="run_params")
    public List<String> params;

    public Run(Snapshot snapshot,String executable, List<String> params) {
        //this.snapshot = snapshot;
        this.executable=executable;
        this.params= params;

        String allParams = "";
        for(String p: params){
            allParams +=p;
        }
    }

    public Run() {
    }
}
