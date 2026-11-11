package org.maciek.context;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contexts")
public class ContextController {
//    @GetMapping
//    public Map<Long, Map<String, Object>> getAllContexts() {
//        return ContextApplication.contextMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        entry -> getProperties(entry.getKey()),
//                        (existing, replacement) -> existing,
//                        LinkedHashMap::new
//                ));
//    }
//
//    @GetMapping("/{contextId}")
//    public ResponseEntity<Map<String, Object>> getContext(
//            @PathVariable Long contextId
//    ) {
//        if (!ContextApplication.contextMap.containsKey(contextId)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(getProperties(contextId));
//    }
//
//    @PutMapping("/{contextId}/properties")
//    public ResponseEntity<Map<String, Object>> updateProperties(
//            @PathVariable Long contextId,
//            @RequestBody UpdatePropertiesRequest request
//    ) {
//        ConfigurableApplicationContext context =
//                ContextApplication.contextMap.get(contextId);
//
//        if (context == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        MapPropertySource propertySource =
//                (MapPropertySource) context
//                        .getEnvironment()
//                        .getPropertySources()
//                        .get("context-" + contextId);
//
//        if (propertySource == null) {
//            return ResponseEntity.internalServerError().build();
//        }
//
//        propertySource.getSource().putAll(request.properties());
//
//        return ResponseEntity.ok(
//                Map.of(
//                        "contextId", contextId,
//                        "updatedProperties", request.properties()
//                )
//        );
//    }
//
//    private Map<String, Object> getProperties(Long contextId) {
//        var context = ContextApplication.contextMap.get(contextId);
//
//        var propertySource =
//                (MapPropertySource) context
//                        .getEnvironment()
//                        .getPropertySources()
//                        .get("context-" + contextId);
//
//        return propertySource.getSource()
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (existing, replacement) -> existing,
//                        LinkedHashMap::new
//                ));
//    }
//
//    public record UpdatePropertiesRequest(
//            Map<String, Boolean> properties
//    ) {
//    }
}
