import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Definition {
    public static final Comparator<Definition> BY_DEFINITION = comparing(Definition::getDefinition);

    public static final Comparator<Definition> BY_ID = comparing(Definition::getId);

    private final String id;
    private final String definition;

    public Definition(final String id, final String definition){
        this.id = id;
        this.definition = definition;
    }


    public String getId()
    {
        return id;
    }

    public String getDefinition()
    {
        return definition;
    }
}
