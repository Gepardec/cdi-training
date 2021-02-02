package at.gepardec.cditraining;

import org.eclipse.krazo.engine.ViewEngineConfig;
import org.eclipse.krazo.ext.thymeleaf.DefaultTemplateEngineProducer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletContext;

/**
 * With this specialized producer is used to configure the template engine.
 */
@Specializes
public class TemplateEngineProducer extends DefaultTemplateEngineProducer {

    @Inject
    private ServletContext servletContext;

    @Override
    @Produces
    @ViewEngineConfig
    public TemplateEngine getTemplateEngine() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(this.servletContext);
        resolver.setCacheable(false);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        return engine;
    }
}
