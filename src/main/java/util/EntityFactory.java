package util;

import ru.cleverec.entity.ProcessDelay;
import ru.cleverec.entity.Request;

public class EntityFactory {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 199;
    private static final int MAX_DELAY = 1999;

    public EntityFactory(){
    }

    public ProcessDelay createProcessDelay(){
        return new ProcessDelay(generateDelay());
    }

    public Request createRequest(){
        return new Request(generateRequest());
    }

    private int generateRequest(){
        return MIN_VALUE + (int)(Math.random() * ((MAX_VALUE - MIN_VALUE) + 1));
    }

    private int generateDelay(){
        return MIN_VALUE + (int)(Math.random() * ((MAX_DELAY - MIN_VALUE) + 1));
    }

}
