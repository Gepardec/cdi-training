package at.gepardec.cditraining;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Util {

    private Util() {
    }

    public static List<String> namesWithInstanceId(Collection<Object> object) {
        return object.stream().map(Util::nameWithInstanceId).collect(Collectors.toList());
    }

    public static String nameWithInstanceId(Object object) {
        Objects.requireNonNull(object, "Cannot build the 'nameWithHashcode' with a null instance");
        return object.toString().replace(object.getClass().getPackageName() + ".", "");
    }

    public static String nameWithoutProxy(Object object) {
        Objects.requireNonNull(object, "Cannot build the 'nameWithHashcode' with a null instance");
        return cleanupProxyInClassname(object.getClass().getSimpleName());
    }

    private static String cleanupProxyInClassname(String classname) {
        return classname.replace("$Proxy$_$$_WeldClientProxy", "");
    }
}
