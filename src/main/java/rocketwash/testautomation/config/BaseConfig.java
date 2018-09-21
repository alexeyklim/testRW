package rocketwash.testautomation.config;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("rocketwash.properties")
public interface BaseConfig {

    @Property("rocketwash.user")
    String getUser();

    @Property("rocketwash.password")
    String getPassword();


}
