import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.util.Locale;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>(
                "digits",    //name of our parameter
                "\\d*",     //regular expression to receive only digits
                Integer.class,     //type to wich we need convert
                (String s) -> Integer.parseInt(s)));

        typeRegistry.defineParameterType(new ParameterType<>(
                "(method)",
                "GET|POST|PUT|DELETE|PATCH",
                String.class,
                (String s) -> s));
    }
}
