package swingy.model.artifact;

import swingy.enums.EArtifact;


public class Artifact {
    EArtifact type;
    private String name;
    private int bonus;

        public Artifact(EArtifact type, String name, int bonus) {
        this.type = type;
        this.bonus = bonus;
    }
}