package API;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;

public class Configuration {

    /*
    * Установка парсера данных по умолчанию. Стандартный парсер - JSON
    * */
    public static void initializeRestAssuredSettings() {
        RestAssured.defaultParser = Parser.JSON;
    }

    /**
     * Устанавливает настройки для запроса на игнорирование неподтверждённых SSL
     * сертификатов Без этой настройки тесты откажутся работать с API
     */
    public static RequestSpecification getRequestSpec() {
        initializeRestAssuredSettings();

        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.setRelaxedHTTPSValidation();

        RequestSpecification spec = specBuilder.build();

        return spec;
    }
}