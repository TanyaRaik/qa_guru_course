package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {
  public static CredentialsConfig credentials =
          ConfigFactory.create(CredentialsConfig.class, System.getProperties());
}