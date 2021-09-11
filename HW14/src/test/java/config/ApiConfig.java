package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:${configFilePath}/file.properties.txt",
        "classpath:api-prod.properties"
})
public interface ApiConfig extends Config {
  @Key("url")
  String getBaseUrl();

  @Key("token")
  String getToken();
}