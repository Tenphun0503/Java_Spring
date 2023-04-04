/**
 * SpringConfig.java
 * Created on Apr 03, 2023, 6:35 PM
 * Author: Ten Phun
 */
package demo.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


// For Spring Bean Scanning, exclude Controller Annotation.
// Or you can just specify needed bean
// Or edit createRootApplicationContext() in ServletContainerInitConfig
@Configuration
@ComponentScan(value="demo"/*, excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = Controller.class
    )*/
)
public class SpringConfig {
}
