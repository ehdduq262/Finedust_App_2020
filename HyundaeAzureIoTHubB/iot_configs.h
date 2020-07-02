
#ifndef IOT_CONFIGS_H
  #define IOT_CONFIGS_H
  #define IOT_CONFIG_WIFI_SSID            "iPhone"
  #define IOT_CONFIG_WIFI_PASSWORD        "great!q2w"
  #define IOT_CONFIG_CONNECTION_STRING    "HostName=sillaGYM.azure-devices.net;DeviceId=gym;SharedAccessKey=57rIc0wIZekY3tC7GE2Xg1mSw6e6B+YdrxrfIut6l3M="
  #define DEVICE_ID                       "gym"


  int    i_CO2, i_tVOC;
  int    i_pm1_0, i_pm1_0MIN, i_pm1_0MAX;
  int    i_pm2_5, i_pm2_5MIN, i_pm2_5MAX;
  int    i_pm10, i_pm10MIN, i_pm10MAX;
  float  f_tempC, f_humiP, f_pressure, f_latitudeA, f_longitudeA;

  #define PinA                  4
  
  #define IOT_CONFIG_MQTT
  // #define IOT_CONFIG_HTTP
#endif /* IOT_CONFIGS_H */
