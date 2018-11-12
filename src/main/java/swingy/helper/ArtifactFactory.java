package swingy.helper;

import swingy.enums.EArtifact;
import swingy.model.artifact.Artifact;

public class ArtifactFactory {

    public static Artifact newArtifact(EArtifact type, String name, int value)
    {
        switch (type)
        {
            case HELM:
                return new Artifact(EArtifact.HELM, name, value);
            case ARMOR:
                return new Artifact(EArtifact.ARMOR, name, value);
            case WEAPON:
                return new Artifact(EArtifact.WEAPON, name, value);
        }
        return (null);
    }
}
