package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:web-${remote}.properties"
})
public interface WebConfig extends Config {
  @Key("url")
  @DefaultValue("https://github.com")
  String getBaseUrl();

  @Key("browser")
  @DefaultValue("CHROME")
  String getNameBrowser();

  @Key("version")
  String getVersionBrowser();

  @Key("is_remote")
  @DefaultValue("true")
  Boolean isRemote();
}