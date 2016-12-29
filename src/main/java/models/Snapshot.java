package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotify.docker.client.DockerCertificateException;
import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.messages.ImageSearchResult;
import models.commands.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by salizumberi-laptop on 18.11.2016.
 */
@Entity
@Table(name = "snapshot")
public class Snapshot {

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    public From from;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "snapshot", orphanRemoval = true)
    public List<ChangedFile> filesChangedWithinCommit = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<Run> runs = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<Label> labels = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<Env> envs = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<Expose> exposes = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<Add> adds = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<Copy> copies = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<Volume> volumes = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<User> users = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<WorkDir> workDirs = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<Arg> args = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<Comment> comments = new ArrayList<>();

    //TODO: repair instruction !!!
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "snapshot", orphanRemoval = true)
    public List<OnBuild> onBuilds = new ArrayList<>();

    //TODO: repair instruction !!!
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "snapshot", orphanRemoval = true)
    @PrimaryKeyJoinColumn
    public Healthcheck healthCheck;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    public EntryPoint entryPoint;


    public void setNewAndOldDiff(Diff oldDiff,Diff newDiff) {
        if(oldDiff !=null){
            this.diffs.add(oldDiff);
        }
        if(newDiff !=null){
            this.diffs.add(newDiff);
        }
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="SNAP_DIFF",
            joinColumns={@JoinColumn(name="SNAP_ID")},
            inverseJoinColumns={@JoinColumn(name="DIFF_ID")})
    private Set<Diff> diffs = new HashSet<Diff>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "snapshot", orphanRemoval = true)
    @PrimaryKeyJoinColumn
    public Cmd cmd;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "snapshot", orphanRemoval = true)
    @PrimaryKeyJoinColumn
    public StopSignal stopSignals;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "snapshot", orphanRemoval = true)
    @PrimaryKeyJoinColumn
    public Maintainer maintainer;


}
