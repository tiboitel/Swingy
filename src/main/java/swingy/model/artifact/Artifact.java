package swingy.model.artifact;

import lombok.Getter;
import lombok.Setter;
import swingy.enums.EArtifact;

@Getter
@Setter
public class Artifact {
    EArtifact type;
    private String name;
    private int bonus;

        public Artifact(EArtifact type, String name, int bonus) {
        this.type = type;
        this.name = name;
        this.bonus = bonus;
    }
}