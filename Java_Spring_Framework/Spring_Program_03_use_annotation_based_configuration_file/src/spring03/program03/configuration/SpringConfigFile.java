package spring03.program03.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring03.program03.beans")
public class SpringConfigFile {
    // Annotation based configuration file ma pan java ke pachhi xml file banavvi pade (ahi java file)
    // aaya spring beans objecct banav vana nathi java Configuration file (Spring_Program_02... project) ni jem
}
