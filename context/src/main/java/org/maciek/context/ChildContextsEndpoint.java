package org.maciek.context;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
@Endpoint(id = "child-contexts")
public class ChildContextsEndpoint {

//    @ReadOperation
//    public Map<Long, Map<String, Object>> contexts() {
//
//        return ContextApplication.contextMap.entrySet()
//                .stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        entry -> getProperties(entry.getKey())
//                ));
//    }
//
//    private Map<String, Object> getProperties(Long contextId) {
//
//        var context = ContextApplication.contextMap.get(contextId);
//
//        var propertySource =
//                (MapPropertySource) context
//                        .getEnvironment()
//                        .getPropertySources()
//                        .get("context-" + contextId);
//
//        return propertySource.getSource();
//    }
}
