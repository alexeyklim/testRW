package config;

import ru.qatools.properties.Property;

public interface BaseConfig {

    @Property("rocketwash.user")
    String getUser();

    @Property("rocketwash.password")
    String getPassword();


}
