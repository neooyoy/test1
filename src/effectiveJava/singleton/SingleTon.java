package effectiveJava.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingleTon implements Serializable {
    public static final SingleTon INSTANCE = new SingleTon();

    private SingleTon() {
    }

    static class SubSingleTon {
        private static final SubSingleTon subINSTANCE = new SubSingleTon();

        private SubSingleTon() {
        }

        public SubSingleTon getInstance() {
            return subINSTANCE;
        }
    }

    //readResolve method to preserve sinlgeton property
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}